package zdy.model;

/**
 * @function 基础--厂家表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class B_Manufacturers extends TemplateBeen {
	/** 业务主键 */
	private String manufacturersId;
	/** 厂家名称 */
	private String manufacturersName;
	/** 厂家负责人 */
	private String connactName;
	/** 负责人联系电话 */
	private String connactNumber;
	/** 厂家地址 */
	private String manufacturersAddress;
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
	 * @return the connactName
	 */
	public String getConnactName() {
		return connactName;
	}
	/**
	 * @param connactName the connactName to set
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
	 * @param connactNumber the connactNumber to set
	 */
	public void setConnactNumber(String connactNumber) {
		this.connactNumber = connactNumber;
	}
	/**
	 * @return the manufacturersAddress
	 */
	public String getManufacturersAddress() {
		return manufacturersAddress;
	}
	/**
	 * @param manufacturersAddress the manufacturersAddress to set
	 */
	public void setManufacturersAddress(String manufacturersAddress) {
		this.manufacturersAddress = manufacturersAddress;
	}

}
