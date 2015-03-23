package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteAssetsRelations;
import cn.com.dhcc.fzep.topo.vo.CableVO;

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
	/**
	 * 得到目标站点的光缆集合
	 * @param site1Id 目标站点ID
	 * @param site2Id 与目标站点相连站点ID
	 * @return 目标站点的光缆集合
	 */
	public List<Cable> listCable(String site1Id, String site2Id);
	/**
	 * 得到光缆VO集合
	 * @param targetSiteId 目标站点ID
	 * @param connectSiteId 与目标站点相连站点ID
	 * @return 光缆VO集合
	 */
	public List<CableVO> listCableVO(String targetSiteId, String connectSiteId);
}
