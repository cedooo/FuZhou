package test.cn.com.dhcc.fzep.topo.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.impl.SiteSearchServiceImpl;

public class SiteServiceImplTest {
	private SiteSearchServiceImpl servImpl = new SiteSearchServiceImpl();
	@Test
	public void testAvalibleSite() {
		SearchSite searchSite = new SearchSite();
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(10);
		searchSite.setPage(page);
		searchSite.setAreaName("晋安区");
		List<Site> listSite = servImpl.avalibleSite(searchSite);
		System.out.println(listSite);
		assertEquals(listSite.size()>=1, true);
	}

}
