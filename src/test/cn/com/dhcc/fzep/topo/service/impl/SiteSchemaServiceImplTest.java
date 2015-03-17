package test.cn.com.dhcc.fzep.topo.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.common.SiteRelation;
import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.impl.SiteSchemaServiceImpl;

public class SiteSchemaServiceImplTest {
	SiteSchemaServiceImpl srvImpl = new SiteSchemaServiceImpl();
	//@Test
	public void testGetSchemaByAreaName() {
		String areaName = "台江辖区";
		Schema schema = srvImpl.getSchemaByAreaName(areaName);
		System.out.println(schema);
		assertEquals(schema!=null, true);
	}
	//@Test
	public void testGetListByCondition() {
		SearchSite searchSite = new SearchSite();
		Page page = new Page();
		page.setCurPage(2);
		page.setNumPerPage(2);
		searchSite.setAreaName("台江区");
		searchSite.setPage(page);
		List<Site> listSite = srvImpl.getListByCondition(searchSite);
		assertEquals(listSite!=null, true);
		System.out.println(listSite);
	}
	//@Test
	public void testGetPage() {
		SearchSite searchSite = new SearchSite();
		Page page = new Page();
		page.setCurPage(2);
		page.setNumPerPage(6);
		page.setTotalPage(3);
		searchSite.setAreaName("台江区");
		searchSite.setPage(page);
		
		searchSite.setKeyWord("站");
		searchSite.setSearchField("siteName");
		
		Page pageUpdated = srvImpl.getPage(searchSite);
		assertEquals(pageUpdated.getTotalRecords()>0, true);
		System.out.println(pageUpdated);
	}
	//@Test
	public void testGetRelationSchemaBySiteName(){
		String siteName = "站点1";
		int degree = 2;
		//int type = 0;   //所有
		SiteRelation siteR = srvImpl.getSiteRelationBySiteName(siteName, degree);
		System.out.println("目标" + siteR.getCenter());
		System.out.println("一层目标 " + siteR.getLevelOneSite().size() +  " 个：" + siteR.getLevelOneSite());
		System.out.println("2层:" + siteR.getLevelTwoSite());
		System.out.println("光缆 " + siteR.getListCable().size() +  " 个：" + siteR.getListCable());
	}
}
