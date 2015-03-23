package zdy.common;

/**
 * @function 常用方法类
 * @author zdy
 * @createDate 2014-07-01
 * @lastUpdateDate 2014-11-12
 * @version 2.1
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Method {

	/**
	 * 将字符串封装为json格式
	 * 
	 * @param【String】（带封装的json字符串）
	 */
	public static String getJsonFormat(String str) {
		return "{" + str + "}";
	}

	/**
	 * 输出异常信息
	 * 
	 * @param【Exception】（异常类）
	 * @return 【String】
	 */
	public static String getExceptionMessage(Exception e) {
		if (e.toString().contains("Duplicate entry")) {
			return "+'<br/>异常原因：名称重复，因为数据库已经存在了该名称。'";
		} else if (e.toString().contains("Unknown column")) {
			return "+'<br/>异常原因：对应的字段有误，请检查数据库字段是否有更改。'";
		} else if (e.toString().contains("doesn't exist")) {
			return "+'<br/>异常原因：对应的表不存在，请检查数据库字段是否有更改。'";
		} else if (e.toString().contains(
				"com.mysql.jdbc.CommunicationsException")) {
			return "+'<br/>异常原因：连接数据库失败，请检查数据库连接是否正常。'";
		} else {
			return "+'<br/>异常原因：未知错误，请联系系统管理员。'" +
					"+'<br/>"+e.getMessage()+"'";
		}
	}

	/**
	 * 输出异常栈信息
	 * 
	 * @return 【String】
	 */
	public static String getExceptionStackTrace(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		return "\r\n" + stringWriter.toString() + "\r\n";
	}

	/**
	 * 获取当前日期【yyyy-MM-dd HH:mm:ss】
	 * 
	 * @return 【String】（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date).trim();
	}

	/**
	 * 获取当前日期的小时分钟
	 * 
	 * @return 【String】（HH:mm）
	 * @throws ParseException
	 */
	public static String getHM(String str) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df
				.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str))
				.trim();
	}

	/**
	 * 获取当前日期的小时分钟
	 * 
	 * @return 【String】（HH:mm）
	 */
	public static String getCurrentHM() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df.format(date).trim();
	}

	/**
	 * 获取当天指定的日期
	 * 
	 * @param 【int,int,int】(小时，分钟，秒)
	 * @return 【String】（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDate(int hour, int minute, int second) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MINUTE, minute);
		Date date = new Date(cal.getTimeInMillis());
		return format.format(date);
	}

	/**
	 * 判断是否是数字或字母
	 * 
	 * @param 【String】（待检查的字符串）
	 * @return 【boolean】（true|false）
	 */
	public static boolean isNumeric(String str) {
		if (str.matches("-?\\d+(\\.\\d+)?%?")) {
			return true;
		}
		return false;
	}
}
