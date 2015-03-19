package cn.com.dhcc.fzep.topo.pojo;

public class GPRS extends Equipment {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7200437156356088876L;
	private String gprsId = null;
	private String siteId = null;
	private String projectId = null;
	private String installationSite = null;
	private String debugging = null;
	private String ip = null;
	private String cardNumber = null;
	private String operators = null;
	private String technologyType = null;
	//private String manufacturers = null;
	private String manufacturersId = null;
	private String typeSpecification = null;
	//private String constructionUnit = null;
	private String constructionUnitId = null;
	private String runTime = null;
	private String delFlg = null;
	private String descp = null;
	
	private String gprsName = null;    //添加时间： 2014-11-27 10:18:23
	public String getGprsId() {
		return gprsId;
	}

	public void setGprsId(String gprsId) {
		this.gprsId = gprsId;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getTechnologyType() {
		return technologyType;
	}

	public void setTechnologyType(String technologyType) {
		this.technologyType = technologyType;
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

	public String getGprsName() {
		return gprsName;
	}

	public void setGprsName(String gprsName) {
		this.gprsName = gprsName;
	}

	public String getManufacturersId() {
		return manufacturersId;
	}

	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	@Override
	public String toString() {
		return "GPRS [gprsId=" + gprsId + ", siteId=" + siteId + ", projectId="
				+ projectId + ", installationSite=" + installationSite
				+ ", debugging=" + debugging + ", ip=" + ip + ", cardNumber="
				+ cardNumber + ", operators=" + operators + ", technologyType="
				+ technologyType + ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", delFlg=" + delFlg + ", descp=" + descp
				+ ", gprsName=" + gprsName + "]";
	}



}
