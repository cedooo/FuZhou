package cn.com.dhcc.fzep.topo.pojo;

import java.io.Serializable;

/**
 * 站点表 属性
 * @author cedo 2014-11-24 11:30:33
 *
 */
public class Site implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1664658013854061675L;
	protected String siteId = null;
	protected String siteName = null;
	protected String AreaId = null;
	protected String siteAdress = null;
	protected String connactName = null;
	protected String connactNumber = null;
	protected String delFlg = null;
	protected String descp = null;
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getAreaId() {
		return AreaId;
	}
	public void setAreaId(String areaId) {
		AreaId = areaId;
	}
	public String getSiteAdress() {
		return siteAdress;
	}
	public void setSiteAdress(String siteAdress) {
		this.siteAdress = siteAdress;
	}
	public String getConnactName() {
		return connactName;
	}
	public void setConnactName(String connactName) {
		this.connactName = connactName;
	}
	public String getConnactNumber() {
		return connactNumber;
	}
	public void setConnactNumber(String connactNumber) {
		this.connactNumber = connactNumber;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteName=" + siteName
				+ ", AreaId=" + AreaId + ", siteAdress=" + siteAdress
				+ ", connactName=" + connactName + ", connactNumber="
				+ connactNumber + ", delFlg=" + delFlg + ", descp=" + descp
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Site other = (Site) obj;
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId))
			return false;
		return true;
	}
	
	
}
