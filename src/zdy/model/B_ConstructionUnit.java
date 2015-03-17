package zdy.model;

/**
 * @function 基础--施工单位表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class B_ConstructionUnit extends TemplateBeen {
	/** 业务主键 */
	private String constructionUnitId;
	/** 施工方名称 */
	private String constructionUnitName;
	/** 施工方负责人 */
	private String connactName;
	/** 负责人联系电话 */
	private String connactNumber;
	/** 施工方地址 */
	private String constructionUnitAddress;
	/**
	 * @return the constructionUnitId
	 */
	public String getConstructionUnitId() {
		return constructionUnitId;
	}
	/**
	 * @param constructionUnitId
	 *            the constructionUnitId to set
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
	 * @param constructionUnitName
	 *            the constructionUnitName to set
	 */
	public void setConstructionUnitName(String constructionUnitName) {
		this.constructionUnitName = constructionUnitName;
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
	/**
	 * @return the constructionUnitAddress
	 */
	public String getConstructionUnitAddress() {
		return constructionUnitAddress;
	}
	/**
	 * @param constructionUnitAddress
	 *            the constructionUnitAddress to set
	 */
	public void setConstructionUnitAddress(String constructionUnitAddress) {
		this.constructionUnitAddress = constructionUnitAddress;
	}

}
