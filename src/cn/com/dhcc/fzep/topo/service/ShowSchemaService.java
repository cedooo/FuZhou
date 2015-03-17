package cn.com.dhcc.fzep.topo.service;

import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;

public interface ShowSchemaService {
	/**
	 * 得到schema
	 * @param schemaID 视图ID
	 * @return
	 */
	public Schema getSchema(String schemaID);
	/**
	 * 得到GPRS无线信息
	 * @param gprsID
	 * @return
	 */
	public GPRS getGPRS(String gprsID);
	/**
	 * 得到载波设备信息
	 * @param carrierID
	 * @return
	 */
	public Carrier getCarrier(String carrierID);
	/**
	 * 得到OLT设备信息
	 * @param oltID
	 * @return
	 */
	public OLT getOLT(String oltID);
	/**
	 * 得到ONU设备信息
	 * @param onuID
	 * @return
	 */
	public ONU getONU(String onuID);
	/**
	 * 得到2层交换机设备信息
	 * @param l2ID
	 * @return
	 */
	public TwoLayerSwitch getTwoLayerSwitch(String l2ID);
	/**
	 * 得到3层交换机设备信息
	 * @param l3ID
	 * @return
	 */
	public ThreeLayerSwitch getThreeLayerSwitch(String l3ID);
	
}
