package cn.com.dhcc.fzep.alarm.resources;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataResources {
	private static SqlSessionFactory kylandSessionFactory = null;
	private static SqlSessionFactory h3cSessionFactory = null;
	private static SqlSessionFactory ustcSessionFactory = null;
	static{
		String resource = "cn/com/dhcc/fzep/alarm/resources/mybatis-config.xml";
		try {
			kylandSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource), "kyland");
			h3cSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource), "h3c");
			//ustcSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "ustc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getKylandSessionFactory() {
		return kylandSessionFactory;
	}
	public static SqlSessionFactory getH3cSessionFactory() {
		return h3cSessionFactory;
	}
	public static SqlSessionFactory getUstcSessionFactory() {
		return ustcSessionFactory;
	}
	
}
