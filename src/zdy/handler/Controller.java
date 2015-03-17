package zdy.handler;

/**
 * @function  请求责任链客户端
 * @author zhangdengyuan
 * @createDate 2014-06-17
 * @lastUpdateDate 2014-06-17
 * @version 1.0
 */

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zdy.common.Constant;

/**
 * @function 责任链客户端 用于处理用户请求 类映射链
 * @author zhangdengyuan
 * @createDate 2014-06-17
 * @lastUpdateDate 2014-11-13
 * @version 2.1
 */
public class Controller extends HttpServlet implements Serializable {

	/** UID（用于JAVA版本控制） */
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	/** 责任链客户端 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		/** 获取manager.xml的地址（类映射xml） */
		Constant.MANAGERPATH = this.getServletContext().getRealPath("/")
				+ "zdy/manager.xml";
		Constant.EXPORTEXCELDIR = this.getServletContext().getRealPath("/")
				+ "zdy/export/";
		Constant.IMPORTEXCELDIR = this.getServletContext().getRealPath("/")
		+ "zdy/download/";
		/** 直接进入URL地址和类映射链（不需要验证用户、角色、工厂、功能），用于用户的登录请求 */
		/** 类映射链（当前请求映射到对应的类、方法） */
		Handler classHandler = new ClassHandler();
		Handler parameterHandler = new ParameterHandler();
		parameterHandler.setHandler(classHandler);
		parameterHandler.handleProccess(request, response);
	}

}
