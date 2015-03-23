package zdy.model;

/**
 * @function 基础--纤芯数量
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */

public class A_FiberCoreNumber extends TemplateBeen {
	/** 业务主键 */
	private String fiberCoreNumberId;
	/** 纤芯名称 */
	private String fiberCoreNumberName;
	/** 所属光缆 */
	private String cableId;
	/** 是否使用 */
	private String isUsed;
	/** 是否跳转 */
	private String isJump;
	/** 业务类型 */
	private String bizType;
	/** 站点起始端连接情况 */
	private String startConnections;
	/** 站点目的端连接情况 */
	private String endConnections;
	/** 收发情况 */
	private String transceiver;

	/**
	 * @return the fiberCoreNumberId
	 */
	public String getFiberCoreNumberId() {
		return fiberCoreNumberId;
	}
	/**
	 * @param fiberCoreNumberId the fiberCoreNumberId to set
	 */
	public void setFiberCoreNumberId(String fiberCoreNumberId) {
		this.fiberCoreNumberId = fiberCoreNumberId;
	}
	/**
	 * @return the fiberCoreNumberName
	 */
	public String getFiberCoreNumberName() {
		return fiberCoreNumberName;
	}
	/**
	 * @param fiberCoreNumberName the fiberCoreNumberName to set
	 */
	public void setFiberCoreNumberName(String fiberCoreNumberName) {
		this.fiberCoreNumberName = fiberCoreNumberName;
	}
	/**
	 * @return the cableId
	 */
	public String getCableId() {
		return cableId;
	}
	/**
	 * @param cableId the cableId to set
	 */
	public void setCableId(String cableId) {
		this.cableId = cableId;
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
	 * @return the startConnections
	 */
	public String getStartConnections() {
		return startConnections;
	}
	/**
	 * @param startConnections the startConnections to set
	 */
	public void setStartConnections(String startConnections) {
		this.startConnections = startConnections;
	}
	/**
	 * @return the endConnections
	 */
	public String getEndConnections() {
		return endConnections;
	}
	/**
	 * @param endConnections the endConnections to set
	 */
	public void setEndConnections(String endConnections) {
		this.endConnections = endConnections;
	}
	/**
	 * @return the transceiver
	 */
	public String getTransceiver() {
		return transceiver;
	}
	/**
	 * @param transceiver the transceiver to set
	 */
	public void setTransceiver(String transceiver) {
		this.transceiver = transceiver;
	}

}
