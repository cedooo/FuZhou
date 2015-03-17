package cn.com.dhcc.fzep.topo.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.dao.CarrierDao;
import cn.com.dhcc.fzep.topo.dao.GPRSDao;
import cn.com.dhcc.fzep.topo.dao.OLTDao;
import cn.com.dhcc.fzep.topo.dao.ONUDao;
import cn.com.dhcc.fzep.topo.dao.SiteDao;
import cn.com.dhcc.fzep.topo.dao.ThreeLayerSwitchDao;
import cn.com.dhcc.fzep.topo.dao.TwoLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.Equipment;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.service.SiteEquipmentListService;
import cn.com.dhcc.fzep.topo.utils.EquipmentToVO;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;

public class SiteEquipmentListServiceImpl implements SiteEquipmentListService {

	@Override
	public List<EquipmentVO> getEquipmentListBySiteId(String siteId) {
		List<Equipment> listEquip = new ArrayList<Equipment>();
		//GPRS
		GPRSDao gprsDao = new GPRSDao();
		List<GPRS> listGprs = gprsDao.listGPRSVO(siteId);
		listEquip.addAll(listGprs);
		//OLT
		OLTDao oltDao = new OLTDao();
		List<OLT> listOlt = oltDao.listOLTVO(siteId);
		listEquip.addAll(listOlt);
		//载波
		CarrierDao carrierDao = new CarrierDao();
		List<Carrier> listCarrier = carrierDao.listCarrierVO(siteId);
		listEquip.addAll(listCarrier);
		//ONU
		ONUDao onuDao = new ONUDao();
		List<ONU> listOnu = onuDao.listONUVO(siteId);
		listEquip.addAll(listOnu);
		//3层交换机
		ThreeLayerSwitchDao threeDao = new ThreeLayerSwitchDao();
		List<ThreeLayerSwitch> list3Switch = threeDao.listThreeLayerSwitchVO(siteId);
		listEquip.addAll(list3Switch);
		//2层交换机
		TwoLayerSwitchDao twoDao = new TwoLayerSwitchDao();
		List<TwoLayerSwitch> list2Switch = twoDao.listTwoLayerSwitchVO(siteId);
		listEquip.addAll(list2Switch);
		//光缆
		CableDao cableDao = new CableDao();
		List<Cable> listCable = cableDao.listCableVO(siteId);
		listEquip.addAll(listCable);
		
		List<EquipmentVO> listEquipVo = 
				new ArrayList<EquipmentVO>();
		for (Equipment equipment : listEquip) {
			listEquipVo.add(EquipmentToVO.parseToVo(equipment));
		}
		return listEquipVo;
	}

	@Override
	public Site getSiteInfoById(String siteId) {
		Site site = null;
		SiteDao siteDao = new SiteDao();
		site = siteDao.getSiteBySiteId(siteId);
		return site;
	}
	
}
