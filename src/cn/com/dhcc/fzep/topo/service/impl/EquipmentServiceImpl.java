package cn.com.dhcc.fzep.topo.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.dao.CarrierDao;
import cn.com.dhcc.fzep.topo.dao.GPRSDao;
import cn.com.dhcc.fzep.topo.dao.OLTDao;
import cn.com.dhcc.fzep.topo.dao.ONUDao;
import cn.com.dhcc.fzep.topo.dao.ThreeLayerSwitchDao;
import cn.com.dhcc.fzep.topo.dao.TwoLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.service.EquipmentService;

public class EquipmentServiceImpl implements EquipmentService {

	@Override
	public Carrier getCarrierById(String id) {
		return new CarrierDao().getCarrier(id);
	}

	@Override
	public GPRS getGPRSById(String id) {
		return new GPRSDao().getGPRSByID(id);
	}

	@Override
	public ONU getONUById(String id) {
		return new ONUDao().getONU(id);
	}

	@Override
	public OLT getOLTById(String id) {
		return new OLTDao().getOLT(id);
	}

	@Override
	public ThreeLayerSwitch getThreeLayerSwitchById(String id) {
		return new ThreeLayerSwitchDao().getThreeLayerSwitch(id);
	}

	@Override
	public TwoLayerSwitch getTwoLayerSwitchById(String id) {
		return new TwoLayerSwitchDao().getTwoLayerSwitch(id);
	}

	@Override
	public Cable getCableById(String id) {
		return new CableDao().getCable(id);
	}

	@Override
	public List<Cable> getCableBySiteArray(List<Integer> listSiteId) {
		List<Cable> listCable = new ArrayList<Cable>();
		if(listSiteId!=null && listSiteId.size()>1){
			CableDao cableDao = new CableDao();
			for (int i = 0; i < listSiteId.size(); i++) {
				for (int j = i+1; j < listSiteId.size(); j++) {
					String fId=listSiteId.get(i).toString();
					String sId=listSiteId.get(j).toString();
					List<Cable> listCableResult = cableDao.listCable(fId, sId);
					if(listCableResult!=null && listCableResult.size()>0){
						listCable.addAll(listCableResult);
					}
				}
			}
		}else {
			//DO NOTHING
		}
//System.out.println(listSiteId + "\n搜索光缆结果:" + listCable);
		return listCable;
	}

	@Override
	public Cable getCableVOById(String cableId) {
		return new CableDao().cableVO(cableId);
	}

}
