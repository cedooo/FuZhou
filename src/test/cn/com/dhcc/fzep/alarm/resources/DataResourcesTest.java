package test.cn.com.dhcc.fzep.alarm.resources;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;
import cn.com.dhcc.fzep.alarm.resources.DataResources;

public class DataResourcesTest {

	@Test
	public void testGetKylandSessionFactory() {
		SqlSessionFactory sqlSessionFactory = DataResources.getKylandSessionFactory();
		assertEquals(sqlSessionFactory!=null, true);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		assertEquals(sqlSession!=null, true);
		
		List<Alarmmgrrm> list = sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.getAlarm");
		assertEquals(list!=null, true);
		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void testGetH3cSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUstcSessionFactory() {
		fail("Not yet implemented");
	}

}
