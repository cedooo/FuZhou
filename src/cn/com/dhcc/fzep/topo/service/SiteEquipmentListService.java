package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;
/**
 * 站点界面-设备列表service
 * @author cedo
 *
 */
public interface SiteEquipmentListService {
	/**
	 * 根据站点ID得到设备集合
	 * @param id 站点ID
	 * @return
	 */
	public List<EquipmentVO> getEquipmentListBySiteId(String siteId);
	
	/**
	 * 根据站点ID得到站点信息
	 * @param siteId
	 * @return
	 */
	public Site getSiteInfoById(String siteId);
}
