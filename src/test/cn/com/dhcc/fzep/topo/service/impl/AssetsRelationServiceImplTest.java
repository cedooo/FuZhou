package test.cn.com.dhcc.fzep.topo.service.impl;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteAssetsRelations;
import cn.com.dhcc.fzep.topo.service.AssetsRelationService;
import cn.com.dhcc.fzep.topo.service.impl.AssetsRelationServiceImpl;

public class AssetsRelationServiceImplTest {

	private AssetsRelationService srv = new AssetsRelationServiceImpl();
	@Test
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

}
