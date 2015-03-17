package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Site;

/**
 * 站点服务接口
 * @author cedo
 *
 */
public interface SiteSearchService {
	/**
	 * 根据分页参数以及区域ID 得到不包含在区域默认视图中的可选站点集合
	 * @param searchCondition 搜索条件
	 * @param schemaId 视图ID
	 * @return 可选站点列表
	 */
	List<Site> avalibleSite(SearchSite searchCondition);
	/**
	 * 得到符合条件的站点总数
	 * @param searchCondition 搜索条件
	 * @return 站点总数
	 */
	Page getPageAvalibleSite(SearchSite searchCondition);
}
