package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
/**
 * 设备对象查询服务 ，
 * 多个get方法均为：根据设备的ID得到相对应的设备对象
 * @author cedo 2015-02-09 11:35:25
 * 
 */
public interface EquipmentService {
	/*
	 * 下面的多个get方法均为：根据设备的ID得到相对应的设备对象
	 */
	public Cable getCableById(String id);
	public Carrier getCarrierById(String id);
	public GPRS getGPRSById(String id);
	public ONU getONUById(String id);
	public OLT getOLTById(String id);
	public ThreeLayerSwitch getThreeLayerSwitchById(String id);
	public TwoLayerSwitch getTwoLayerSwitchById(String id);
	/**
	 * 得到其中任意两个站点之间的所有光缆对象
	 * @param listSiteId 站点ID数组集合List
	 * @return 光缆对象集合List
	 */
	public List<Cable> getCableBySiteArray(List<Integer> listSiteId);
	/**
	 * 得到光缆展示对象
	 * @param id 光缆ID
	 * @return  光缆VO
	 */
	public Cable getCableVOById(String id);
}
