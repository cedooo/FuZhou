package zdy.handler;

/**
 * @function 类映射验证链
 * @descp 类映射验证链（验证当前用户的请求地址中的类方法） 未取到：给出errorMessage信息并返回登录页面 已取到：进入一下拦截器（不是最后一个拦截器的话）
 * @author zdy
 * @createDate 2014-07-01
 * @lastUpdateDate 2014-11-13
 * @version 2.1
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import zdy.common.Constant;
import zdy.common.Message;
import zdy.common.Method;
import zdy.common.Page;

import zdy.common.Forward;

/**
 * 类映射验证链（验证当前用户的请求地址中的类方法） 未取到：给出errorMessage信息并返回登录页面 已取到：进入一下拦截器（不是最后一个拦截器的话）
 */
public class ClassHandler extends Handler {

	/** UID（用于JAVA版本控制） */
	private static final long serialVersionUID = 1L;

	/**
	 * 请求URL地址验证链
	 * 
	 * @step （验证是否为最后一个拦截器）->（获取请求方法）->（映射manager.xml）->（返回Controller）
	 * @param HttpServletRequest【request】（请求对象）
	 * @param HttpServletResponse【response】（响应对象）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleProccess(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/** 目前设定请求拦截器为最后一个拦截器 */
			if (getHandler() != null) {
				actionError(request, response,
						Message.ERRORMESSAGE_CLASSHANDLER_NOTFINALHANDLER,
						Page.ERROR, Page.MAINPAGE);
				return;
			}
			/** 设置编码格式 */
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			/** 截取请求的URL地址 */
			String uri = request.getRequestURI();
			String actionStr = uri.substring(uri.lastIndexOf("/") + 1, uri
					.length());
			actionStr = actionStr.replace(Constant.REQUESTPARM, "");
			String[] fliterStr = actionStr.split("!");
			/** 截取类名映射 */
			String manageClass = fliterStr[0];
			String manageMethod = fliterStr[1];
			File inputXml = new File(Constant.MANAGERPATH);
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputXml);
			Element root = document.getRootElement();
			/** 根据manager.xml和请求地址进行匹配并调用（id和name要保持一致） */
			for (Element e : (List<Element>) root.elements("function")) {
				if (manageClass.equals(e.attribute("id").getText())) {
					String className = e.element("class").getText();
					Class<?> obj = Class.forName(className);
					Forward base = (Forward) obj.newInstance();
					base.getClass()
							.getMethod(manageMethod, HttpServletRequest.class,
									HttpServletResponse.class).invoke(base,
									request, response);
					return;
				}
			}
		} catch (Exception e) {
			try {
				actionException(request, response, "异常出现异常了，类控制器接收到了异常->原因是：\n"
						+ Method.getExceptionMessage(e)
						+ Method.getExceptionStackTrace(e), Page.EXCEPTION,
						Page.MAINPAGE);
			} catch (ServletException servletException) {
				servletException.printStackTrace();
			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		}
	}
}
