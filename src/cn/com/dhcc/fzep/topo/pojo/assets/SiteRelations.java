package cn.com.dhcc.fzep.topo.pojo.assets;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Site;

public class SiteRelations {
	private List<Site> listSite;
	private List<Cable> listCable;
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	public List<Cable> getListCable() {
		return listCable;
	}
	public void setListCable(List<Cable> listCable) {
		this.listCable = listCable;
	}
	@Override
	public String toString() {
		return "SiteRelations [listSite=" + listSite + ", listCable="
				+ listCable + "]";
	}
	
}
