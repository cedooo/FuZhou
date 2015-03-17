package cn.com.dhcc.fzep.topo.service.impl;

import cn.com.dhcc.fzep.topo.dao.CarrierDao;
import cn.com.dhcc.fzep.topo.dao.GPRSDao;
import cn.com.dhcc.fzep.topo.dao.OLTDao;
import cn.com.dhcc.fzep.topo.dao.ONUDao;
import cn.com.dhcc.fzep.topo.dao.SchemaDao;
import cn.com.dhcc.fzep.topo.dao.ThreeLayerSwitchDao;
import cn.com.dhcc.fzep.topo.dao.TwoLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.service.ShowSchemaService;

public class ShowSchemaServiceImpl implements ShowSchemaService {

	@Override
	public Schema getSchema(String schemaID) {
		if(schemaID!=null){
			SchemaDao schemaDao = new SchemaDao();
			Schema schema = schemaDao.getSchema(schemaID);
			return schema;
		}else {
			return null;
		}
	}

	@Override
	public GPRS getGPRS(String gprsID) {
		if(gprsID!=null && !"".equals(gprsID)){
			return new GPRSDao().getGPRSByID(gprsID);
		}
		return null;
	}

	@Override
	public Carrier getCarrier(String carrierID) {
		if(carrierID!=null && !"".equals(carrierID)){
			return new CarrierDao().getCarrier(carrierID);
		}
		return null;
	}

	@Override
	public OLT getOLT(String oltID) {
		if(oltID!=null && !"".equals(oltID)){
			return new OLTDao().getOLT(oltID);
		}
		return null;
	}

	@Override
	public ONU getONU(String onuID) {
		if(onuID!=null && !"".equals(onuID)){
			return new ONUDao().getONU(onuID);
		}
		return null;
	}

	@Override
	public TwoLayerSwitch getTwoLayerSwitch(String l2id) {
		if(l2id!=null && !"".equals(l2id)){
			return new TwoLayerSwitchDao().getTwoLayerSwitch(l2id);
		}
		return null;
	}

	@Override
	public ThreeLayerSwitch getThreeLayerSwitch(String l3id) {
		if(l3id!=null && !"".equals(l3id)){
			return new ThreeLayerSwitchDao().getThreeLayerSwitch(l3id);
		}
		return null;
	}

}
