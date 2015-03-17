package cn.com.dhcc.fzep.topo.pojo;

public class OLT extends Equipment {
	private String oltId = null;
	private String siteId = null;
	private String projectId = null;
	private String installationSite = null;
	//private String manufacturers = null;
	private String manufacturersId = null;
	private String typeSpecification = null;
	//private String constructionUnit = null;
	private String constructionUnitId = null;
	private String runTime = null;
	private String vlanId = null;
	private String lookbackLocation = null;
	private String oSPFNumber = null;
	private String vpnNumber = null;
	private String delFlg = null;
	private String descp = null;

	private String oltName = null;    // 添加时间：2014-11-27 10:20:04
	public String getOltId() {
		return oltId;
	}

	public void setOltId(String oltId) {
		this.oltId = oltId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getInstallationSite() {
		return installationSite;
	}

	public void setInstallationSite(String installationSite) {
		this.installationSite = installationSite;
	}

	public String getTypeSpecification() {
		return typeSpecification;
	}

	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}



	public String getConstructionUnitId() {
		return constructionUnitId;
	}

	public void setConstructionUnitId(String constructionUnitId) {
		this.constructionUnitId = constructionUnitId;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

	public String getLookbackLocation() {
		return lookbackLocation;
	}

	public void setLookbackLocation(String lookbackLocation) {
		this.lookbackLocation = lookbackLocation;
	}

	public String getoSPFNumber() {
		return oSPFNumber;
	}

	public void setoSPFNumber(String oSPFNumber) {
		this.oSPFNumber = oSPFNumber;
	}

	public String getVpnNumber() {
		return vpnNumber;
	}

	public void setVpnNumber(String vpnNumber) {
		this.vpnNumber = vpnNumber;
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

	public String getOltName() {
		return oltName;
	}

	public void setOltName(String oltName) {
		this.oltName = oltName;
	}

	public String getManufacturersId() {
		return manufacturersId;
	}

	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	@Override
	public String toString() {
		return "OLT [oltId=" + oltId + ", siteId=" + siteId + ", projectId="
				+ projectId + ", installationSite=" + installationSite
				+ ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", vlanId=" + vlanId + ", lookbackLocation="
				+ lookbackLocation + ", oSPFNumber=" + oSPFNumber
				+ ", vpnNumber=" + vpnNumber + ", delFlg=" + delFlg
				+ ", descp=" + descp + ", oltName=" + oltName + "]";
	}


}
