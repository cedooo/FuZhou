package zdy.model;

/**
 * @function 应用--光缆表
 * @author zhangdengyuan
 * @createDate 2014-12-04
 * @lastUpdateDate 2014-12-04
 * @version 1.0
 */
public class A_Cable extends TemplateBeen {
	/** 业务主键 */
	private String cableId;
	/** 光缆名称 */
	private String cableName;
	/** 是否主干网 */
	private String isMainRoad;
	/** 光缆起点 */
	private String cableStartId;
	/** 光缆终点 */
	private String cableEndId;
	/** 光缆类型 */
	private String cableType;
	/** 光缆长度 */
	private String cableLength;
	/** 纤芯数量 */
	private String fiberId;
	/** 敷设类型 */
	private String layingType;
	/** 投运时间 */
	private String runTime;
	/** 施工单位 */
	private String constructionUnitId;
	/** 业务类型 */
	private String bizType;
	/**
	 * @return the cableId
	 */
	public String getCableId() {
		return cableId;
	}
	/**
	 * @param cableId
	 *            the cableId to set
	 */
	public void setCableId(String cableId) {
		this.cableId = cableId;
	}
	/**
	 * @return the cableName
	 */
	public String getCableName() {
		return cableName;
	}
	/**
	 * @param cableName
	 *            the cableName to set
	 */
	public void setCableName(String cableName) {
		this.cableName = cableName;
	}
	
	/**
	 * @return the isMainRoad
	 */
	public String getIsMainRoad() {
		return isMainRoad;
	}
	/**
	 * @param isMainRoad the isMainRoad to set
	 */
	public void setIsMainRoad(String isMainRoad) {
		this.isMainRoad = isMainRoad;
	}
	/**
	 * @return the cableStartId
	 */
	public String getCableStartId() {
		return cableStartId;
	}
	/**
	 * @param cableStartId
	 *            the cableStartId to set
	 */
	public void setCableStartId(String cableStartId) {
		this.cableStartId = cableStartId;
	}
	/**
	 * @return the cableEndId
	 */
	public String getCableEndId() {
		return cableEndId;
	}
	/**
	 * @param cableEndId
	 *            the cableEndId to set
	 */
	public void setCableEndId(String cableEndId) {
		this.cableEndId = cableEndId;
	}
	/**
	 * @return the cableType
	 */
	public String getCableType() {
		return cableType;
	}
	/**
	 * @param cableType
	 *            the cableType to set
	 */
	public void setCableType(String cableType) {
		this.cableType = cableType;
	}
	/**
	 * @return the cableLength
	 */
	public String getCableLength() {
		return cableLength;
	}
	/**
	 * @param cableLength
	 *            the cableLength to set
	 */
	public void setCableLength(String cableLength) {
		this.cableLength = cableLength;
	}
	/**
	 * @return the fiberId
	 */
	public String getFiberId() {
		return fiberId;
	}
	/**
	 * @param fiberId
	 *            the fiberId to set
	 */
	public void setFiberId(String fiberId) {
		this.fiberId = fiberId;
	}
	/**
	 * @return the layingType
	 */
	public String getLayingType() {
		return layingType;
	}
	/**
	 * @param layingType
	 *            the layingType to set
	 */
	public void setLayingType(String layingType) {
		this.layingType = layingType;
	}
	/**
	 * @return the runTime
	 */
	public String getRunTime() {
		return runTime;
	}
	/**
	 * @param runTime
	 *            the runTime to set
	 */
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
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
	 * @return the bizType
	 */
	public String getBizType() {
		return bizType;
	}
	/**
	 * @param bizType
	 *            the bizType to set
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
}
