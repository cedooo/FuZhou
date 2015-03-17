package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.CarrierDao;
import cn.com.dhcc.fzep.topo.pojo.Carrier;

public class CarrierDaoTest {
	private CarrierDao dao = new CarrierDao();
	@Test
	public void testGetCarrier() {
		String carrierId = "1";
		Carrier carrier = dao.getCarrier(carrierId);
		assertEquals(carrier!=null, true);
		System.out.println(carrier);
	}

}
