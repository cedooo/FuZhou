package cn.com.dhcc.fzep.topo.pojo;

public class Carrier extends Equipment {
	private String carrierId = null;
	private String siteId = null;
	private String projectId = null;
	private String installationSite = null;
	private String debugging = null;
	private String ip = null;
	//private String manufacturers = null;
	private String manufacturersId = null;
	private String typeSpecification = null;
	//private String constructionUnit = null;
	private String constructionUnitId = null;
	private String runTime = null;
	private String installationLocation = null;
	private String delFlg = null;
	private String descp = null;

	private String carrierName = null;    //添加时间： 2014-11-27 10:19:36
	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
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

	public String getDebugging() {
		return debugging;
	}

	public void setDebugging(String debugging) {
		this.debugging = debugging;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public String getInstallationLocation() {
		return installationLocation;
	}

	public void setInstallationLocation(String installationLocation) {
		this.installationLocation = installationLocation;
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

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getManufacturersId() {
		return manufacturersId;
	}

	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	@Override
	public String toString() {
		return "Carrier [carrierId=" + carrierId + ", siteId=" + siteId
				+ ", projectId=" + projectId + ", installationSite="
				+ installationSite + ", debugging=" + debugging + ", ip=" + ip
				+ ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", installationLocation=" + installationLocation
				+ ", delFlg=" + delFlg + ", descp=" + descp + ", carrierName="
				+ carrierName + "]";
	}

	
	

}
