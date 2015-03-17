package cn.com.dhcc.fzep.topo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.dao.CarrierDao;
import cn.com.dhcc.fzep.topo.dao.GPRSDao;
import cn.com.dhcc.fzep.topo.dao.OLTDao;
import cn.com.dhcc.fzep.topo.dao.ONUDao;
import cn.com.dhcc.fzep.topo.dao.SchemaDao;
import cn.com.dhcc.fzep.topo.dao.ThreeLayerSwitchDao;
import cn.com.dhcc.fzep.topo.dao.TwoLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.Equipment;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.service.EquipmentSchemaService;

public class EquipmentSchemaServiceImpl implements EquipmentSchemaService{

	@Override
	public List<Equipment> getListBySite(String siteId) {
		List<Equipment> listEquip = new ArrayList<Equipment>();
		List<Carrier> listCarrier = new CarrierDao().listCarrier(siteId);
		listEquip.addAll(listCarrier);
		return listEquip;
	}

	@Override
	public List<ONU> listONU(String siteId) {
		List<ONU> list = new ArrayList<ONU>();
		if(siteId!=null){
			ONUDao onuDao = new ONUDao();
			list.addAll(onuDao.listONU(siteId));
		}
		return list;
	}

	@Override
	public List<OLT> listOLT(String siteId) {
		List<OLT> list = new ArrayList<OLT>();
		if(siteId!=null){
			OLTDao oltDao = new OLTDao();
			list.addAll(oltDao.listOLT(siteId));
		}
		return list;
	}

	@Override
	public List<Cable> listCable(String siteId) {
		List<Cable> list = new ArrayList<Cable>();
		if(siteId!=null){
			CableDao cableDao = new CableDao();
			list.addAll(cableDao.listCable(siteId));
		}
		return list;
	}

	@Override
	public List<Carrier> listCarrier(String siteId) {
		List<Carrier> list = new ArrayList<Carrier>();
		if(siteId!=null){
			CarrierDao carrierDao = new CarrierDao();
			list.addAll(carrierDao.listCarrier(siteId));
		}
		return list;
	}

	@Override
	public List<ThreeLayerSwitch> list3LayerSwitch(String siteId) {
		List<ThreeLayerSwitch> list = new ArrayList<ThreeLayerSwitch>();
		if(siteId!=null){
			ThreeLayerSwitchDao switchDao = new ThreeLayerSwitchDao();
			list.addAll(switchDao.listThreeLayerSwitch(siteId));
		}
		return list;
	}

	@Override
	public List<TwoLayerSwitch> list2LayerSwitch(String siteId) {
		List<TwoLayerSwitch> list = new ArrayList<TwoLayerSwitch>();
		if(siteId!=null){
			TwoLayerSwitchDao switchDao = new TwoLayerSwitchDao();
			list.addAll(switchDao.listTwoLayerSwitch(siteId));
		}
		return list;
	}

	@Override
	public List<GPRS> listGPRS(String siteId) {
		List<GPRS> list = new ArrayList<GPRS>();
		if(siteId!=null){
			GPRSDao gprsDao = new GPRSDao();
			list.addAll(gprsDao.listGPRS(siteId));
		}
		return list;
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
	@Override
	public boolean saveSchema(String baseInfo, String jsonData, String args) {
		Schema schema = new Schema();
		schema.setSchemaData(jsonData);
		schema.setSchemaArgs(args);
		try {
			JSONObject obj = new JSONObject(baseInfo);

			String schemaId = obj.getString("schemaId");
			String schemaName = obj.getString("schemaName");
			String schemaType = obj.getString("schemaType");
			String schemaNote = obj.getString("schemaNote");
			String areaId = obj.getString("areaId");
			String siteId = obj.getString("siteId");

			schema.setSchemaName(schemaName);
			schema.setSchemaType(schemaType);
			schema.setSchemaNote(schemaNote); 
			schema.setAreaId(areaId);
			schema.setSiteId(siteId);
			SchemaDao schemaDao = new SchemaDao();
			//System.out.println("schemaId = " + schemaId);
			//System.out.println(schema);
			if(schemaId==null|| "".equals(schemaId) || schemaId.equals("null")){
				schema.setSchemaAddTime(sdf.format(new Date()));
				boolean insertSuccess = schemaDao.insertSchema(schema);
				return insertSuccess;
			}else{
				schema.setSchemaId(schemaId);
				boolean updateSuccess = schemaDao.updateSchema(schema);
				return updateSuccess;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

}
