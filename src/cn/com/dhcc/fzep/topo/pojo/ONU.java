package cn.com.dhcc.fzep.topo.pojo;

public class ONU extends Equipment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8884434385444371860L;
	private String onuId = null;
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
	private String ospfNumber = null;
	private String vpnNumber = null;
	private String delFlg = null;
	private String descp = null;

	private String onuName = null;    //添加时间：2014-11-27 10:19:05
	public String getOnuId() {
		return onuId;
	}

	public void setOnuId(String onuId) {
		this.onuId = onuId;
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

	public String getOspfNumber() {
		return ospfNumber;
	}

	public void setOspfNumber(String ospfNumber) {
		this.ospfNumber = ospfNumber;
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

	public String getOnuName() {
		return onuName;
	}

	public void setOnuName(String onuName) {
		this.onuName = onuName;
	}

	public String getManufacturersId() {
		return manufacturersId;
	}

	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	@Override
	public String toString() {
		return "ONU [onuId=" + onuId + ", siteId=" + siteId + ", projectId="
				+ projectId + ", installationSite=" + installationSite
				+ ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", vlanId=" + vlanId + ", ospfNumber=" + ospfNumber
				+ ", vpnNumber=" + vpnNumber + ", delFlg=" + delFlg
				+ ", descp=" + descp + ", onuName=" + onuName + "]";
	}


}
