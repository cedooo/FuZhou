package zdy.common;

/**
 * @function  转发操作集合
 * @author zdy
 * @createDate 2014-07-01
 * @lastUpdateDate 2014-08-01
 * @version 2.0
 */
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 每一个用户请求转发的集合操作 主要包括：成功操作、失败操作、权限不足操作和异常操作四个
 */
public class Forward implements Serializable {
	/** UID（用于JAVA版本控制） */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 操作被禁止（权限不足或请求资源不合法）
	 * @param 【HttpServletRequest】（request请求集合）
	 * @param 【HttpServletResponse】（response转向集合）
	 * @param 【String】（forbidPage要转发的权限不足页面）
	 * @param 【String】（backPage页面“返回”操作）
	 * @throws 【IOException】
	 * @throws 【ServletException】 
	 */
	public void actionForbid(HttpServletRequest request,
			HttpServletResponse response, String forbidMessage,
			String forbidPage, String backPage) throws ServletException, IOException {
		/** 权限不足页面的提示信息 */
		request.setAttribute(Message.FORBIDMESSAGE, forbidMessage);
		/** 权限不足页面的返回操作 */
		request.setAttribute(Constant.BACKPAGE, backPage);
		/** 转发权限不足页面 */
		request.getRequestDispatcher(forbidPage).forward(request, response);
	}

	/**
	 * 
	 * 服务器异常（服务端异常、数据库挂掉等）
	 * @param 【HttpServletRequest】（request请求集合）
	 * @param 【HttpServletResponse】（response转向集合）
	 * @param 【String】（exceptionPage要转发的异常页面）
	 * @param 【String】（backPage页面“返回”操作）
	 * @throws 【IOException】
	 * @throws 【ServletException】 
	 */
	public void actionException(HttpServletRequest request,
			HttpServletResponse response, String exceptionMessage,
			String exceptionPage, String backPage) throws ServletException, IOException {
		/** 异常页面的提示信息 */
		request.setAttribute(Message.EXCEPTIONMESSAGE, exceptionMessage);
		/** 异常页面的返回操作 */
		request.setAttribute(Constant.BACKPAGE, backPage);
		/** 转发异常页面 */
		request.getRequestDispatcher(exceptionPage).forward(request,response);
	}

	/**
	 * 
	 * 失败操作页面（权限足够）
	 * @param 【HttpServletRequest】（request请求集合）
	 * @param 【HttpServletResponse】（response转向集合）
	 * @param 【String】（errorPage要转发的失败页面）
	 * @param 【String】（backPage页面“返回”操作）
	 * @throws 【IOException】
	 * @throws 【ServletException】 
	 */
	public void actionError(HttpServletRequest request,
			HttpServletResponse response, String errorMessage,
			String errorPage, String backPage) throws ServletException, IOException {
		/** 错误页面的提示信息 */
		request.setAttribute(Message.ERRORMESSAGE, errorMessage);
		/** 错误页面的返回操作 */
		request.setAttribute(Constant.BACKPAGE, backPage);
		/** 转发错误页面 */
		request.getRequestDispatcher(errorPage).forward(request, response);
	}

	/**
	 * 
	 * 成功操作页面
	 * @param 【HttpServletRequest】（request请求集合）
	 * @param 【HttpServletResponse】（response转向集合）
	 * @param 【String】（successPage要转发的成功页面）
	 * @param 【String】（backPage页面“返回”操作）
	 * @throws 【IOException】
	 * @throws 【ServletException】 
	 */
	public void actionSuccess(HttpServletRequest request,
			HttpServletResponse response, String successMessage,
			String successPage, String backPage) throws ServletException, IOException {
		/** 成功页面的提示信息 */
		request.setAttribute(Message.SUCCESSMESSAGE, successPage);
		/** 成功页面的返回操作 */
		request.setAttribute(Constant.BACKPAGE, backPage);
			/** 转发成功页面 */
		request.getRequestDispatcher(successPage).forward(request, response);
	}
}
