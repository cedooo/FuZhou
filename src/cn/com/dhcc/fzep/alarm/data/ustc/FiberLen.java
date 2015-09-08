package cn.com.dhcc.fzep.alarm.data.ustc;

public class FiberLen {

	private String paramId;    //设备Id
	private String devId;    //设备参数Id
	private String fiberLen;    //光纤长度 单位KM
	private String state;    //记录状态 1为有效 0为无效
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getFiberLen() {
		return fiberLen;
	}
	public void setFiberLen(String fiberLen) {
		this.fiberLen = fiberLen;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
