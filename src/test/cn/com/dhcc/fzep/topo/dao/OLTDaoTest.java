package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.OLTDao;
import cn.com.dhcc.fzep.topo.pojo.OLT;

public class OLTDaoTest {
	private OLTDao dao = new OLTDao();

	@Test
	public void testGetOLT() {
		String oltId = "1";
		OLT olt = dao.getOLT(oltId );
		assertEquals(olt!=null, true);
		System.out.println(olt);
	}

}
