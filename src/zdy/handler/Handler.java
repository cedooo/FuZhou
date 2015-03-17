package zdy.handler;

/**
 * @function  验证链
 * @author ZhangDengYuan
 * @createDate 2014-06-17
 * @lastUpdateDate 2014-06-17
 * @version 2.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zdy.common.Forward;


/**
 * 处理器的抽象类（责任链模式的基类）
 * 
 * @author zdy
 */
public abstract class Handler extends Forward  {
	protected Handler handler;

	public abstract void handleProccess(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * handler的取得
	 * 
	 * @return Handler【handler】（handler）
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * handler的设置
	 * 
	 * @param Handler【handler】（handler）
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
