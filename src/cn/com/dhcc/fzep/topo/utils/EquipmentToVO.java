package cn.com.dhcc.fzep.topo.utils;

import net.sf.json.JSONObject;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.Equipment;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;

public class EquipmentToVO {
	public static EquipmentVO parseToVo(Equipment equipment){
		EquipmentVO voEquip = new EquipmentVO();
		voEquip.setType(equipment.getClass().toString());
		JSONObject jsonData = JSONObject.fromObject(equipment);
		voEquip.setJsonData(jsonData.toString());
		if(equipment.getClass().equals(Cable.class)){
			Cable cable = (Cable) equipment;
			voEquip.setId(cable.getCableId());
			voEquip.setName(cable.getCableName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_CABLE);
			voEquip.setTypeName("光缆");
		}else if(equipment.getClass().equals(Carrier.class)){
			Carrier carrier = (Carrier) equipment;
			voEquip.setId(carrier.getCarrierId());
			voEquip.setName(carrier.getCarrierName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_CARRIER);
			voEquip.setTypeName("载波");
		}else if(equipment.getClass().equals(GPRS.class)){
			GPRS gprs = (GPRS) equipment;
			voEquip.setId(gprs.getGprsId());
			voEquip.setName(gprs.getGprsName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_GPRS);
			voEquip.setTypeName("GPRS无线");
		}else if(equipment.getClass().equals(ONU.class)){
			ONU onu = (ONU) equipment;
			voEquip.setId(onu.getOnuId());
			voEquip.setName(onu.getOnuName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_ONU);
			voEquip.setTypeName("ONU");
		}else if(equipment.getClass().equals(OLT.class)){
			OLT olt = (OLT) equipment;
			voEquip.setId(olt.getOltId());
			voEquip.setName(olt.getOltName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_OLT);
			voEquip.setTypeName("OLT");
		}else if(equipment.getClass().equals(ThreeLayerSwitch.class)){
			ThreeLayerSwitch l3Switch = (ThreeLayerSwitch) equipment;
			voEquip.setId(l3Switch.getThreeLayerSwitchId());
			voEquip.setName(l3Switch.getThreeLayerSwitchName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_3SWITCH);
			voEquip.setTypeName("三层交换机");
		}else if(equipment.getClass().equals(TwoLayerSwitch.class)){
			TwoLayerSwitch l2Switch = (TwoLayerSwitch) equipment;
			voEquip.setId(l2Switch.getTwoLayerSwitchId());
			voEquip.setName(l2Switch.getTwoLayerSwitchName());
			voEquip.setImg(EquipmentVO.EQUIP_IMG_2SWITCH);
			voEquip.setTypeName("二层交换机");
		}
		return voEquip;
	}
}
