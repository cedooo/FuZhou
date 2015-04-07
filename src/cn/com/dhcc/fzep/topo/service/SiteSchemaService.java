package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.common.SiteRelation;
import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.vo.SchemaVO;

public interface SiteSchemaService {
	/**
	 * 通过区域ID得到站点列表
	 * @param areaId 区域ID
	 * @return
	 */
	public List<Site> getListByArea(String areaId);
	/**
	 * 保存站点视图
	 * @param schema
	 * @return
	 */
	public boolean saveSchema(String baseInfo, String jsonData, String args);
	/**
	 * 根据区名称得到视图ID
	 * 如果有多个，则返回最后添加的视图
	 * @param areaName 区域名称
	 * @return
	 */
	public Schema getSchemaByAreaName(String areaName);

	/**
	 * 根据区域名称得到站点对象集合
	 * @param areaName 站点名称
	 * @return 站点对象集合
	 */
	public List<Site> getListByAreaName(String areaName);
	/**
	 * 根据条件搜索站点列表
	 * @param condition 搜索条件
	 * @return
	 */
	public List<Site> getListByCondition(SearchSite condition);
	/**
	 * 根据条件得到分页信息
	 * @param condition
	 * @return
	 */
	public Page getPage(SearchSite condition);
	/**
	 * 根据站点名称和站点以及关联层数 得到相邻站点的关系图
	 * @param siteName 站点名称
	 * @param degree 关系层数
	 * @return
	 */
	public SiteRelation getSiteRelationBySiteName(String siteName, int degree);

	/**
	 * 得到默认视图
	 * @return 默认视图VO对象
	 */
	public SchemaVO getDefaultSchema();

	/**
	 * 根据区名称得到视图ID
	 * 如果有多个，则返回最后添加的视图
	 * @param areaName 区域名称
	 * @return 视图VO对象
	 */
	public SchemaVO getSchemaVOByAreaName(String areaName);
}
