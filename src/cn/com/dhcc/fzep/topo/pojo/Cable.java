package cn.com.dhcc.fzep.topo.pojo;

/**
 * 光缆表 属性
 * 
 * @author cedo 2014-11-24 11:30:08
 * 
 */
public class Cable extends Equipment {
	private String cableId = null;
	private String cableName = null;
	private String cableStartId = null;
	private String cableEndId = null;
	private String cableType = null;
	private String cableLength = null;
	private String fiberId = null;
	private String layingType = null;
	private String runTime = null;
	private String constructionUnitId = null;
	private String delFlg = null;
	private String descp = null;
	private String bizType = null;

	private String isMainRoad = null;
	public String getCableId() {
		return cableId;
	}

	public void setCableId(String cableId) {
		this.cableId = cableId;
	}

	public String getCableName() {
		return cableName;
	}

	public void setCableName(String cableName) {
		this.cableName = cableName;
	}

	public String getCableStartId() {
		return cableStartId;
	}

	public void setCableStartId(String cableStartId) {
		this.cableStartId = cableStartId;
	}

	public String getCableEndId() {
		return cableEndId;
	}

	public void setCableEndId(String cableEndId) {
		this.cableEndId = cableEndId;
	}

	public String getCableType() {
		return cableType;
	}

	public void setCableType(String cableType) {
		this.cableType = cableType;
	}

	public String getCableLength() {
		return cableLength;
	}

	public void setCableLength(String cableLength) {
		this.cableLength = cableLength;
	}

	public String getFiberId() {
		return fiberId;
	}

	public void setFiberId(String fiberId) {
		this.fiberId = fiberId;
	}

	public String getLayingType() {
		return layingType;
	}

	public void setLayingType(String layingType) {
		this.layingType = layingType;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getConstructionUnitId() {
		return constructionUnitId;
	}

	public void setConstructionUnitId(String constructionUnitId) {
		this.constructionUnitId = constructionUnitId;
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

	public String getIsMainRoad() {
		return isMainRoad;
	}

	public void setIsMainRoad(String isMainRoad) {
		this.isMainRoad = isMainRoad;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "Cable [cableId=" + cableId + ", cableName=" + cableName
				+ ", cableStartId=" + cableStartId + ", cableEndId="
				+ cableEndId + ", cableType=" + cableType + ", cableLength="
				+ cableLength + ", fiberId=" + fiberId + ", layingType="
				+ layingType + ", runTime=" + runTime + ", constructionUnitId="
				+ constructionUnitId + ", delFlg=" + delFlg + ", descp="
				+ descp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cableId == null) ? 0 : cableId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cable other = (Cable) obj;
		if (cableId == null) {
			if (other.cableId != null)
				return false;
		} else if (!cableId.equals(other.cableId))
			return false;
		return true;
	}


}