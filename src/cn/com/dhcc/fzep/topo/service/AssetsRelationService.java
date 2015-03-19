package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;
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
	/**
	 * 根据站点ID得到站点对象
	 * @param siteId 站点ID
	 * @return 站点对象
	 */
	public Site siteInfo(String siteId);

	/**
	 * 得到站点光缆 纤芯集合
	 * @param siteId 站点ID
	 * @return 纤芯集合
	 */
	public List<FiberCoreNumber> listFCN(String siteId);
}
