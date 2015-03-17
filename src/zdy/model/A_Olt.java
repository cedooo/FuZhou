package zdy.model;

/**
 * @function 应用--OLT表
 * @author zhangdengyuan
 * @createDate 2014-12-04
 * @lastUpdateDate 2014-12-04
 * @version 1.0
 */
public class A_Olt extends TemplateBeen {
	/** 业务主键 */
	private String oltId;
	/** 所属站点 */
	private String siteId;
	/** 所属项目 */
	private String projectId;
	/** olt名称 */
	private String oltName;
	/** 安装地点 */
	private String installationSite;
	/** 所属厂家 */
	private String manufacturersId;
	/** 型号规格 */
	private String typeSpecification;
	/** 施工单位 */
	private String constructionUnitId;
	/** 投运时间 */
	private String runTime;
	/** vlanId */
	private String vlanId;
	/** lookback地址 */
	private String lookbackLocation;
	/** ospf进程号 */
	private String ospfNumber;
	/** vpn实例名 */
	private String vpnNumber;
	/**
	 * @return the oltId
	 */
	public String getOltId() {
		return oltId;
	}
	/**
	 * @param oltId the oltId to set
	 */
	public void setOltId(String oltId) {
		this.oltId = oltId;
	}
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the oltName
	 */
	public String getOltName() {
		return oltName;
	}
	/**
	 * @param oltName the oltName to set
	 */
	public void setOltName(String oltName) {
		this.oltName = oltName;
	}
	/**
	 * @return the installationSite
	 */
	public String getInstallationSite() {
		return installationSite;
	}
	/**
	 * @param installationSite the installationSite to set
	 */
	public void setInstallationSite(String installationSite) {
		this.installationSite = installationSite;
	}
	/**
	 * @return the manufacturersId
	 */
	public String getManufacturersId() {
		return manufacturersId;
	}
	/**
	 * @param manufacturersId the manufacturersId to set
	 */
	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}
	/**
	 * @return the typeSpecification
	 */
	public String getTypeSpecification() {
		return typeSpecification;
	}
	/**
	 * @param typeSpecification the typeSpecification to set
	 */
	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}
	/**
	 * @return the constructionUnitId
	 */
	public String getConstructionUnitId() {
		return constructionUnitId;
	}
	/**
	 * @param constructionUnitId the constructionUnitId to set
	 */
	public void setConstructionUnitId(String constructionUnitId) {
		this.constructionUnitId = constructionUnitId;
	}
	/**
	 * @return the runTime
	 */
	public String getRunTime() {
		return runTime;
	}
	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	/**
	 * @return the vlanId
	 */
	public String getVlanId() {
		return vlanId;
	}
	/**
	 * @param vlanId the vlanId to set
	 */
	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}
	/**
	 * @return the lookbackLocation
	 */
	public String getLookbackLocation() {
		return lookbackLocation;
	}
	/**
	 * @param lookbackLocation the lookbackLocation to set
	 */
	public void setLookbackLocation(String lookbackLocation) {
		this.lookbackLocation = lookbackLocation;
	}
	/**
	 * @return the ospfNumber
	 */
	public String getOspfNumber() {
		return ospfNumber;
	}
	/**
	 * @param ospfNumber the ospfNumber to set
	 */
	public void setOspfNumber(String ospfNumber) {
		this.ospfNumber = ospfNumber;
	}
	/**
	 * @return the vpnNumber
	 */
	public String getVpnNumber() {
		return vpnNumber;
	}
	/**
	 * @param vpnNumber the vpnNumber to set
	 */
	public void setVpnNumber(String vpnNumber) {
		this.vpnNumber = vpnNumber;
	}

}
