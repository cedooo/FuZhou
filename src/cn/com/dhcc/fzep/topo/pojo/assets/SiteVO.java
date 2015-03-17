package cn.com.dhcc.fzep.topo.pojo.assets;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.vo.EquipmentVO;

public class SiteVO extends Site {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9208661973682853658L;
	private List<Cable> listCable = null;
	private List<EquipmentVO> listEquip = null;
	private String connectionJSON = null;
	
	private List<FiberCoreNumber> listFCN = null;
	
	public SiteVO(Site site){
		this.siteId = site.getSiteId();
		this.siteName = site.getSiteName();
		this.AreaId = site.getAreaId();
		this.siteAdress = site.getSiteAdress();
		this.connactName = site.getConnactName();
		this.connactNumber = site.getConnactNumber();
		this.delFlg = site.getDelFlg();
		this.descp = site.getDescp();
	}
	
	public List<Cable> getListCable() {
		return listCable;
	}
	public void setListCable(List<Cable> listCable) {
		this.listCable = listCable;
	}
	public List<EquipmentVO> getListEquip() {
		return listEquip;
	}
	public void setListEquip(List<EquipmentVO> listEquip) {
		this.listEquip = listEquip;
	}
	public String getConnectionJSON() {
		return connectionJSON;
	}
	public void setConnectionJSON(String connectionJSON) {
		this.connectionJSON = connectionJSON;
	}

	public List<FiberCoreNumber> getListFCN() {
		return listFCN;
	}

	public void setListFCN(List<FiberCoreNumber> listFCN) {
		this.listFCN = listFCN;
	}

	@Override
	public String toString() {
		return "SiteVO [listCable=" + listCable + ", listEquip=" + listEquip
				+ ", connectionJSON=" + connectionJSON + ", listFCN=" + listFCN
				+ "]";
	}

}
