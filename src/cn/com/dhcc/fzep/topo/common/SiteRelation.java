package cn.com.dhcc.fzep.topo.common;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Site;

/**
 * 定义站点之间的关系
 * @author cedo
 *
 */
public class SiteRelation {
	private Site center = null;
	private List<Site> levelOneSite = null;
	private List<Site> levelTwoSite = null;
	private List<Cable> listCable = null;
	
	public Site getCenter() {
		return center;
	}
	public void setCenter(Site center) {
		this.center = center;
	}
	public List<Site> getLevelOneSite() {
		return levelOneSite;
	}
	public void setLevelOneSite(List<Site> levelOneSite) {
		this.levelOneSite = levelOneSite;
	}
	public List<Cable> getListCable() {
		return listCable;
	}
	public void setListCable(List<Cable> listCable) {
		this.listCable = listCable;
	}
	@Override
	public String toString() {
		return "SiteRelation [center=" + center + ", levelOneSite="
				+ levelOneSite + ", listCable=" + listCable + "]";
	}
	public List<Site> getLevelTwoSite() {
		return levelTwoSite;
	}
	public void setLevelTwoSite(List<Site> levelTwoSite) {
		this.levelTwoSite = levelTwoSite;
	}
	
	
}
