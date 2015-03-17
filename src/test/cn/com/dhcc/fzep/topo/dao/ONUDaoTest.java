package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.ONUDao;
import cn.com.dhcc.fzep.topo.pojo.ONU;

public class ONUDaoTest {

	private ONUDao dao = new ONUDao();
	@Test
	public void testGetONU() {
		String onuId = "1";
		ONU onu = dao.getONU(onuId );
		assertEquals(onu!=null, true);
		System.out.println(onu);
	}

}
