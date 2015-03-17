package zdy.handler;

/**
 * @function 参数获取映射验证链
 * @author zdy
 * @descp 对带有前缀的参数（首字母必须为大写,必须在zdy.model包下）进行装箱操作，装箱后以前缀名称存入到request的attribute中
 * @createDate 2014-07-01
 * @lastUpdateDate 2014-12-09
 * @version 2.1
 */
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zdy.common.Constant;
import zdy.model.*;

/**
 * 参数获取映射验证链（验证当前用户的请求地址中的类方法） 未取到：给出errorMessage信息并返回登录页面
 * 已取到：进入一下拦截器（不是最后一个拦截器的话）
 */
public class ParameterHandler extends Handler {

	/** UID（用于JAVA版本控制） */
	private static final long serialVersionUID = 1L;

	/**
	 * 请求URL地址验证链
	 * 
	 * @param HttpServletRequest【request】（请求对象）
	 * @param HttpServletResponse【response】（响应对象）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleProccess(HttpServletRequest request,
			HttpServletResponse response) {
		/** 暂存参数的前缀名称（为后面的类反射的遍历用） */
		List<String> classNameList = new ArrayList<String>();
		/** 暂存参数的前缀名称（用于判断该类名称是否存在） */
		Map<String, String> classNameMap = new HashMap<String, String>();
		/** 遍历所有的参数 */
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String paramName = (String) enumeration.nextElement();
			/** 只装箱带有前缀的参数名称 */
			if (!paramName.contains(".")) {
				continue;
			} else {
				/** 处理带参数的前缀名称 */
				String className = paramName.substring(0, paramName
						.indexOf("."));
				/** 判断参数的前缀名称是否第一次出现 */
				if (classNameMap.get(className) == null) {
					classNameList.add(className);
					classNameMap.put(className, className);
				}
			}
		}
		for (String className : classNameList) {
			try {
				/** 类型首字母转换为大写 */
				className = (new StringBuilder()).append(
						Character.toUpperCase(className.charAt(0))).append(
						className.substring(1)).toString();
				/** 实例化类 */
				Class<?> obj = Class.forName(Constant.QUERYPRIFIX
						+ className);
				TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
				/** 限制项：所有的模型参数必须为String类型 */
				for (Method method : templateBeen.getClass().getMethods()) {
					if (method.getName().startsWith("set")) {
						/** 截取set后面的字母 */
						String formatName = method.getName().substring(3,
								method.getName().length());
						/** 首字母小写 */
						formatName = (new StringBuilder()).append(
								Character.toLowerCase(formatName.charAt(0)))
								.append(formatName.substring(1)).toString();
						String paramName = request.getParameter(className + "."
								+ formatName);
						if (paramName == null) {
							continue;
						}
						templateBeen.getClass().getMethod(method.getName(),
								String.class).invoke(templateBeen, paramName);
					}
				};
				/** 将页面的获取参数暂存到request的属性里面【以前缀名称存入】，便于Service的参数获取 */
				request.setAttribute(className, templateBeen);
			} catch (Exception e) {
				/** 出现问题的带前缀参数解析，解析无效。 */
				e.printStackTrace();
			}
		}
		/** 获取到参数后：进入一下拦截器（不是最后一个拦截器的话） */
		if (getHandler() != null) {
			getHandler().handleProccess(request, response);
		}
	}
}
