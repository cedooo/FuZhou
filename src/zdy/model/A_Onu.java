package zdy.model;

/**
 * @function 应用--ONU表
 * @author zhangdengyuan
 * @createDate 2014-12-04
 * @lastUpdateDate 2014-12-04
 * @version 1.0
 */
public class A_Onu extends TemplateBeen {
	/** 业务主键 */
	private String onuId;
	/** 所属站点 */
	private String siteId;
	/** 所属项目 */
	private String projectId;
	/** onu名称 */
	private String onuName;
	/** 安装地址 */
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
	/** ospf进程号 */
	private String ospfNumber;
	/** vpn实例 */
	private String vpnNumber;
	/**
	 * @return the onuId
	 */
	public String getOnuId() {
		return onuId;
	}
	/**
	 * @param onuId the onuId to set
	 */
	public void setOnuId(String onuId) {
		this.onuId = onuId;
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
	 * @return the onuName
	 */
	public String getOnuName() {
		return onuName;
	}
	/**
	 * @param onuName the onuName to set
	 */
	public void setOnuName(String onuName) {
		this.onuName = onuName;
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
