package test.cn.com.dhcc.fzep.topo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.service.EquipmentService;
import cn.com.dhcc.fzep.topo.service.impl.EquipmentServiceImpl;

public class EquipmentServiceTest {
	private  EquipmentService srv = new  EquipmentServiceImpl();
	//@Test
	public void testGetCableBySiteArray() {
		List<Integer> listSiteId = new ArrayList<Integer>();
		listSiteId.add(1);
		listSiteId.add(2);
		listSiteId.add(4);
		listSiteId.add(5);
		listSiteId.add(8);
		List<Cable> listCable = srv.getCableBySiteArray(listSiteId);
		assertEquals(listCable!=null&&listCable.size()>1, true);
		System.out.println("结果个数：" + listCable.size() + "\n" + listCable);
	}
	@Test
	public void testGetCableVOById() {
		String id = "9";
		Cable cable = srv.getCableVOById(id );
		assertEquals(cable!=null, true);
		System.out.println(cable);
	}

}
