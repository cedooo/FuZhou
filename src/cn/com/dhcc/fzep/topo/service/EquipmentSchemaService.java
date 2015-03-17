package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Carrier;
import cn.com.dhcc.fzep.topo.pojo.Equipment;
import cn.com.dhcc.fzep.topo.pojo.GPRS;
import cn.com.dhcc.fzep.topo.pojo.OLT;
import cn.com.dhcc.fzep.topo.pojo.ONU;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;
/**
 * @deprecated 还未使用
 * @author cedo
 *
 */
public interface EquipmentSchemaService {
	/**
	 * 通过区域ID得到站点列表
	 * @param areaId 区域ID
	 * @return
	 */
	public List<Equipment> getListBySite(String siteId);
	/**
	 * 通过站点ID得到ONU列表
	 * @param siteId
	 * @return
	 */
	public List<ONU> listONU(String siteId);
	/**
	 * 通过站点ID得到OLT列表
	 * @param siteId
	 * @return
	 */
	public List<OLT> listOLT(String siteId);
	/**
	 * 通过站点ID得到光缆集合
	 * @param siteId
	 * @return
	 */
	public List<Cable> listCable(String siteId);
	/**
	 * 通过站点ID得到载波集合
	 * @param siteId
	 * @return
	 */
	public List<Carrier> listCarrier(String siteId);
	/**
	 * 通过站点ID得到3层交换机集合
	 * @param siteId
	 * @return
	 */
	public List<ThreeLayerSwitch> list3LayerSwitch(String siteId);
	/**
	 * 通过站点ID得到2层交换机集合
	 * @param siteId
	 * @return
	 */
	public List<TwoLayerSwitch> list2LayerSwitch(String siteId);
	/**
	 * 通过站点ID得到GPRS集合
	 * @param siteId
	 * @return
	 */
	public List<GPRS> listGPRS(String siteId);
	
	/**
	 * 保存生成的设备图
	 * @param baseInfo json格式的视图基本数据
	 * @param jsonData 图元数据
	 * @param args 展示图参数(json格式): 视图坐标等参数
	 * @return 成功返回true,否则返回false
	 */
	public boolean saveSchema(String baseInfo, String jsonData, String args);
}
