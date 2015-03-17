package test.cn.com.dhcc.fzep.topo.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.Equipment;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.service.impl.EquipmentSchemaServiceImpl;

public class EquipmentSchemaServiceImplTestAll {

	private EquipmentSchemaServiceImpl essi = new EquipmentSchemaServiceImpl();
	private String siteId = "3";

	//@Test
	public void testGetListBySite() {
		List<Equipment> listEquip = essi.getListBySite(siteId);
		System.out.println(listEquip);
	}

	@Test
	public void testListONU() {
		List<ONU> list = essi.listONU(siteId);
		System.out.println(list);
	}

	@Test
	public void testListOLT() {
		List<OLT> list = essi.listOLT(siteId);
		System.out.println(list);
	}

	//@Test
	public void testListCable() {
		List<Cable> list = essi.listCable(siteId);
		System.out.println(list);
	}

	@Test
	public void testListCarrier() {
		List<Carrier> list = essi.listCarrier(siteId);
		System.out.println(list);
	}

	@Test
	public void testList3LayerSwitch() {
		List<ThreeLayerSwitch> list = essi.list3LayerSwitch(siteId);
		System.out.println(list);
	}

	@Test
	public void testList2LayerSwitch() {
		List<TwoLayerSwitch> list = essi.list2LayerSwitch(siteId);
		System.out.println(list);
	}

	@Test
	public void testListGPRS() {
		List<GPRS> list = essi.listGPRS(siteId);
		assertEquals(list!=null, true);
		System.out.println(list);
	}

}
