package test.cn.com.dhcc.fzep.topo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.SiteEquipmentListService;
import cn.com.dhcc.fzep.topo.service.impl.SiteEquipmentListServiceImpl;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;

public class SiteEquipmentListServiceTest {

	private SiteEquipmentListService srv = new SiteEquipmentListServiceImpl();
	@Test
	public void testGetEquipmentListBySiteId() {
		String siteId = "1";
		List<EquipmentVO> list = srv.getEquipmentListBySiteId(siteId);
		System.out.println(list);
		assertEquals(list!=null, true);
		for (EquipmentVO aEquipment : list) {
			if("class cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch".equals(aEquipment.getType())){
				System.out.println(aEquipment);
			}
		}
	}
	//@Test
	public void testGetSiteInfoById() {
		String siteId = "2";
		Site site = srv.getSiteInfoById(siteId);
		System.out.println(site);
		assertEquals(site!=null, true);
	}

}
