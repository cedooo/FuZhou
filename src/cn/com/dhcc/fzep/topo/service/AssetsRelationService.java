package cn.com.dhcc.fzep.topo.service;

import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteAssetsRelations;

/**
 * 资产关系service interface
 * @author cedo
 *
 */
public interface AssetsRelationService {
	/**
	 * 得到站点资产关系
	 * @return 站点内资产关系
	 */
	public SiteAssetsRelations siteAssetsRelations(Site siteOne, Site siteTwo);
}
