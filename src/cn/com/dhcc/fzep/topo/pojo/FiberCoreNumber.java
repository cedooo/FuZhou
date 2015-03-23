package cn.com.dhcc.fzep.topo.pojo;

public class FiberCoreNumber {
	private String fiberCoreNumberId = null;
	private String fiberCoreNumberName = null;
	private String cableId = null;
	private String isUsed = null;
	private String isJump = null;
	private String bizType = null;
	//private String connections = null;
	private String startConnections = null;
	private String endConnections = null;
	private String transceiver = null;
	private String delFlg = null;
	private String descp = null;
	public String getFiberCoreNumberId() {
		return fiberCoreNumberId;
	}
	public void setFiberCoreNumberId(String fiberCoreNumberId) {
		this.fiberCoreNumberId = fiberCoreNumberId;
	}
	public String getFiberCoreNumberName() {
		return fiberCoreNumberName;
	}
	public void setFiberCoreNumberName(String fiberCoreNumberName) {
		this.fiberCoreNumberName = fiberCoreNumberName;
	}
	public String getCableId() {
		return cableId;
	}
	public void setCableId(String cableId) {
		this.cableId = cableId;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	public String getIsJump() {
		return isJump;
	}
	public void setIsJump(String isJump) {
		this.isJump = isJump;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getStartConnections() {
		return startConnections;
	}
	public void setStartConnections(String startConnections) {
		this.startConnections = startConnections;
	}
	public String getEndConnections() {
		return endConnections;
	}
	public void setEndConnections(String endConnections) {
		this.endConnections = endConnections;
	}
	public String getTransceiver() {
		return transceiver;
	}
	public void setTransceiver(String transceiver) {
		this.transceiver = transceiver;
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
	
	@Override
	public String toString() {
		return "FiberCoreNumber [fiberCoreNumberId=" + fiberCoreNumberId
				+ ", fiberCoreNumberName=" + fiberCoreNumberName + ", cableId="
				+ cableId + ", isUsed=" + isUsed + ", isJump=" + isJump
				+ ", bizType=" + bizType + ", startConnections="
				+ startConnections + ", endConnections=" + endConnections
				+ ", transceiver=" + transceiver + ", delFlg=" + delFlg
				+ ", descp=" + descp + "]";
	}

}
