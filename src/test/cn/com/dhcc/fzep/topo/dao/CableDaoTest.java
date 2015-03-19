package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;

public class CableDaoTest {

	private CableDao dao = new CableDao();
	@Test
	public void testListCableVO() {
		String siteId = "1";
		List<Cable> list = dao.listCableVO(siteId);
		System.out.println(list.size());
		System.out.println(list);
		assertEquals(list!=null && list.size()<3,true);
	}

}
