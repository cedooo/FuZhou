package cn.com.dhcc.fzep.topo.service.impl;

import java.util.List;

import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.dao.FiberCoreNumberDao;
import cn.com.dhcc.fzep.topo.dao.SiteDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteAssetsRelations;
import cn.com.dhcc.fzep.topo.pojo.assets.SiteVO;
import cn.com.dhcc.fzep.topo.service.AssetsRelationService;
import cn.com.dhcc.fzep.topo.service.SiteEquipmentListService;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;

public class AssetsRelationServiceImpl implements AssetsRelationService {

	@Override
	public SiteAssetsRelations siteAssetsRelations(Site _siteOne, Site _siteTwo) {
		SiteDao siteDao = new SiteDao();
		Site siteOne = siteDao.getSiteBySiteId(_siteOne.getSiteId());
		Site siteTwo = siteDao.getSiteBySiteId(_siteTwo.getSiteId());
		if(siteOne!=null&&siteTwo!=null){
			SiteAssetsRelations siteAssetsRelations = new SiteAssetsRelations();
			SiteVO siteOneVO = new SiteVO(siteOne);
			SiteVO siteTwoVO = new SiteVO(siteTwo);
			/*
			 * 得到站点光缆列表
			 */
			/*
			CableDao cableDao = new CableDao();
			List<Cable> listOneCable = cableDao.listCable(siteOneVO.getSiteId());
			List<Cable> listTwoCable = cableDao.listCable(siteTwoVO.getSiteId());
			siteOneVO.setListCable(listOneCable);
			siteTwoVO.setListCable(listTwoCable);
			*/
			/*
			 * 得到站点设备（光缆除外）列表
			 */
			SiteEquipmentListService siteEquipServ = new SiteEquipmentListServiceImpl();
			List<EquipmentVO> siteOneEquipVOList = siteEquipServ.getEquipmentListBySiteId(siteOneVO.getSiteId());
			List<EquipmentVO> siteTwoEquipVOList = siteEquipServ.getEquipmentListBySiteId(siteTwoVO.getSiteId());
			siteOneVO.setListEquip(siteOneEquipVOList);
			siteTwoVO.setListEquip(siteTwoEquipVOList);
			
			FiberCoreNumberDao fcnDao = new FiberCoreNumberDao();
			List<FiberCoreNumber> listSiteOneFCN = fcnDao.listFiberCNBySiteId(siteOneVO.getSiteId());
			List<FiberCoreNumber> listSiteTwoFCN = fcnDao.listFiberCNBySiteId(siteTwoVO.getSiteId());
			siteOneVO.setListFCN(listSiteOneFCN);
			siteTwoVO.setListFCN(listSiteTwoFCN);
			
			siteAssetsRelations.setSiteOne(siteOneVO);
			siteAssetsRelations.setSiteTwo(siteTwoVO);
//System.out.println("站点资产关系：" + siteAssetsRelations);
			return siteAssetsRelations;
		}
		return null;
	}
	/**
	 * 根据站点ID得到站点对象
	 * @param siteId 站点ID
	 * @return 站点对象
	 */
	public Site siteInfo(String siteId){
		SiteDao siteDao = new SiteDao();
		Site siteOne = siteDao.getSiteBySiteId(siteId);
		return siteOne;
		
	}
	/**
	 * 得到站点光缆 纤芯集合
	 * @param siteId 站点ID
	 * @return 纤芯集合
	 */
	public List<FiberCoreNumber> listFCN(String siteId){
		FiberCoreNumberDao fcnDao = new FiberCoreNumberDao();
		List<FiberCoreNumber> listSiteOneFCN = fcnDao.listFiberCNBySiteId(siteId);
//System.out.println(listSiteOneFCN);
		return listSiteOneFCN;
	}
	@Override
	public List<Cable> listCable(String site1Id, String site2Id) {
		CableDao cableDao = new CableDao();
		List<Cable> listOneCable = cableDao.relationCableList(site1Id, site2Id);
		return listOneCable;
	}

}
