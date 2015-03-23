package test.cn.com.dhcc.fzep.topo.service.impl;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteAssetsRelations;
import cn.com.dhcc.fzep.topo.service.AssetsRelationService;
import cn.com.dhcc.fzep.topo.service.impl.AssetsRelationServiceImpl;
import cn.com.dhcc.fzep.topo.vo.CableVO;

public class AssetsRelationServiceImplTest {

	private AssetsRelationService srv = new AssetsRelationServiceImpl();
	//@Test
	public void testSiteAssetsRelations() {
		Site siteOne = new Site();
		String siteId = "1";
		siteOne.setSiteId(siteId);
		Site siteTwo = new Site();
		String siteId2 = "2";
		siteTwo.setSiteId(siteId2 );
		SiteAssetsRelations sar = srv.siteAssetsRelations(siteOne, siteTwo);
		System.out.println(sar);
	}
	@Test
	public void testListFCN() {
		String siteId = "1";
		List<FiberCoreNumber> li = srv.listFCN(siteId);
		System.out.println(li);
	}
	@Test
	public void  testListCable(){
		String site1Id = "1";
		String site2Id = "2";
		List<Cable> listCable = srv.listCable(site1Id, site2Id);
		System.out.println(listCable.size());
		System.out.println(listCable);
	}

	@Test
	public void testListCableVO(){
		String targetSiteId = "2";
		String connectSiteId = "1";
		List<CableVO> listVO = srv.listCableVO(targetSiteId, connectSiteId);
		System.out.println(listVO);
	}
}
