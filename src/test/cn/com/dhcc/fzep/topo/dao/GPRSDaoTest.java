package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.GPRSDao;
import cn.com.dhcc.fzep.topo.pojo.GPRS;

public class GPRSDaoTest {
	
	private GPRSDao dao = new GPRSDao();
	@Test
	public void testGetGPRSByID() {
		String id = "1";
		GPRS gprs = dao.getGPRSByID(id);
		assertEquals(gprs!=null, true);
		System.out.println(gprs);
	}

}
