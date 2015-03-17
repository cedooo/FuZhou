package test.cn.com.dhcc.fzep.topo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.impl.SiteSearchServiceImpl;

public class SiteSearchServiceTest {
	private SiteSearchServiceImpl servImpl = new SiteSearchServiceImpl();
	SearchSite searchSite = new SearchSite();
	public SiteSearchServiceTest(){
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(3);
		searchSite.setPage(page);
		searchSite.setAreaName("晋安区");
	}
	@Test
	public void testAvalibleSite() {
		
		List<Site> listSite = servImpl.avalibleSite(searchSite);
		System.out.println(listSite);
		assertEquals(listSite.size()>=1, true);
	}

	@Test
	public void testCsountAvalibleSite() {
		//searchSite.setAreaId(3);
		Page page = servImpl.getPageAvalibleSite(searchSite);
		System.out.println("分页数据:" + page);
		assertEquals(page.getTotalPage()>0, true);
	}
}
