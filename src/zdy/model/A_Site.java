package zdy.model;

/**
 * @function 基础--站点表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class A_Site extends TemplateBeen {
	/** 业务主键 */
	private String siteId;
	/** 站点名称 */
	private String siteName;
	/** 所属区域 */
	private String areaId;
	/** 站点地址 */
	private String siteAdress;
	/** 负责人姓名 */
	private String connactName;
	/** 负责人联系方式 */
	private String connactNumber;
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId
	 *            the siteId to set
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
	 * @param siteName
	 *            the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * @return the areaId
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * @return the siteAdress
	 */
	public String getSiteAdress() {
		return siteAdress;
	}
	/**
	 * @param siteAdress
	 *            the siteAdress to set
	 */
	public void setSiteAdress(String siteAdress) {
		this.siteAdress = siteAdress;
	}
	/**
	 * @return the connactName
	 */
	public String getConnactName() {
		return connactName;
	}
	/**
	 * @param connactName
	 *            the connactName to set
	 */
	public void setConnactName(String connactName) {
		this.connactName = connactName;
	}
	/**
	 * @return the connactNumber
	 */
	public String getConnactNumber() {
		return connactNumber;
	}
	/**
	 * @param connactNumber
	 *            the connactNumber to set
	 */
	public void setConnactNumber(String connactNumber) {
		this.connactNumber = connactNumber;
	}

}
