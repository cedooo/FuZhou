package cn.com.dhcc.fzep.topo.pojo.assets;

import java.io.Serializable;

/**
 * 站点资产关系
 * @author cedo
 *
 */
public class SiteAssetsRelations implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3591861632549158223L;
	private SiteVO siteOne = null;
	private SiteVO siteTwo = null;
	public SiteVO getSiteOne() {
		return siteOne;
	}
	public void setSiteOne(SiteVO siteOne) {
		this.siteOne = siteOne;
	}
	public SiteVO getSiteTwo() {
		return siteTwo;
	}
	public void setSiteTwo(SiteVO siteTwo) {
		this.siteTwo = siteTwo;
	}
	@Override
	public String toString() {
		return "SiteAssetsRelations [siteOne=" + siteOne + ", siteTwo="
				+ siteTwo + "]";
	}
	
}
