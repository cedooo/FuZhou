package zdy.model;

/**
 * @function 应用--OLT表
 * @author zhangdengyuan
 * @createDate 2014-12-04
 * @lastUpdateDate 2014-12-04
 * @version 1.0
 */
public class A_OltDto extends TemplateBeen {
	/** 业务主键 */
	private String oltId;
	/** olt名称 */
	private String oltName;
	/** 所属站点 */
	private String siteId;
	/** 站点名称 */
	private String siteName;
	/** 所属项目 */
	private String projectId;
	/** 项目名称 */
	private String projectName;
	/** 安装地址 */
	private String installationSite;
	/** 所属厂家 */
	private String manufacturersId;
	/** 厂家名称*/
	private String manufacturersName;
	/** 型号规格 */
	private String typeSpecification;
	/** 所属施工单位 */
	private String constructionUnitId;
	/** 施工单位名称 */
	private String constructionUnitName;
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
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	 * @return the manufacturersName
	 */
	public String getManufacturersName() {
		return manufacturersName;
	}
	/**
	 * @param manufacturersName the manufacturersName to set
	 */
	public void setManufacturersName(String manufacturersName) {
		this.manufacturersName = manufacturersName;
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
	 * @return the constructionUnitName
	 */
	public String getConstructionUnitName() {
		return constructionUnitName;
	}
	/**
	 * @param constructionUnitName the constructionUnitName to set
	 */
	public void setConstructionUnitName(String constructionUnitName) {
		this.constructionUnitName = constructionUnitName;
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
