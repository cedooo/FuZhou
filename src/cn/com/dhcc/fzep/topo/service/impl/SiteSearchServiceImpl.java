package cn.com.dhcc.fzep.topo.service.impl;

import java.util.ArrayList;
import java.util.List;




import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.dao.SiteDao;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.SiteSearchService;

public class SiteSearchServiceImpl implements SiteSearchService {

	@Override
	public List<Site> avalibleSite(SearchSite searchCondition) {
		List<Integer> siteIds = new ArrayList<Integer>();
		List<Integer> exceptList = searchCondition.getExceptList();
		if(exceptList!=null){
			for (Integer id : exceptList) {
				siteIds.add(id);
			}
		}
		List<Site> listSite = new ArrayList<Site>();
		SiteDao siteDao = new SiteDao();
		listSite.addAll(siteDao.getSiteByConditionNotIn(searchCondition, siteIds));
		return listSite;
	}

	@Override
	public Page getPageAvalibleSite(SearchSite searchCondition) {
		
		Page page = searchCondition.getPage();
		int totalRecords = new SiteDao().getSiteCountByConditionNotIn(searchCondition);
		int totalPage = (int) Math.ceil(totalRecords*1f / page.getNumPerPage());
		page.setTotalRecords(totalRecords);
		page.setTotalPage(totalPage);
		return page;
	}

}
