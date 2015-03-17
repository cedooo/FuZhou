package zdy.model;

/**
 * @function 基础--光纤表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */

public class B_Fiber extends TemplateBeen {
	/** 业务主键 */
	private String fiberId;
	/** 光纤名称 */
	private String fiberName;
	/** 纤芯数量 */
	private String fiberCoreNumber;
	/** 是否使用 */
	private String isUsed;
	/** 是否跳转 */
	private String isJump;
	/** 业务类型 */
	private String bizType;
	/** 连接情况 */
	private String connections;
	/**
	 * @return the fiberId
	 */
	public String getFiberId() {
		return fiberId;
	}
	/**
	 * @param fiberId the fiberId to set
	 */
	public void setFiberId(String fiberId) {
		this.fiberId = fiberId;
	}
	/**
	 * @return the fiberName
	 */
	public String getFiberName() {
		return fiberName;
	}
	/**
	 * @param fiberName the fiberName to set
	 */
	public void setFiberName(String fiberName) {
		this.fiberName = fiberName;
	}
	/**
	 * @return the fiberCoreNumber
	 */
	public String getFiberCoreNumber() {
		return fiberCoreNumber;
	}
	/**
	 * @param fiberCoreNumber the fiberCoreNumber to set
	 */
	public void setFiberCoreNumber(String fiberCoreNumber) {
		this.fiberCoreNumber = fiberCoreNumber;
	}
	/**
	 * @return the isUsed
	 */
	public String getIsUsed() {
		return isUsed;
	}
	/**
	 * @param isUsed the isUsed to set
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * @return the isJump
	 */
	public String getIsJump() {
		return isJump;
	}
	/**
	 * @param isJump the isJump to set
	 */
	public void setIsJump(String isJump) {
		this.isJump = isJump;
	}
	/**
	 * @return the bizType
	 */
	public String getBizType() {
		return bizType;
	}
	/**
	 * @param bizType the bizType to set
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	/**
	 * @return the connections
	 */
	public String getConnections() {
		return connections;
	}
	/**
	 * @param connections the connections to set
	 */
	public void setConnections(String connections) {
		this.connections = connections;
	}

}
