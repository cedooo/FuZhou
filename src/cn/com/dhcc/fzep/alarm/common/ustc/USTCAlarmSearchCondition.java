package cn.com.dhcc.fzep.alarm.common.ustc;

import cn.com.dhcc.fzep.topo.common.search.Page;

/**
 * 科大告警搜索条件
 * 
 * @author cedo
 *
 */
public class USTCAlarmSearchCondition {
	private Page page;

	private String alarmLevel = null; // 告警级别
	private String confirmState = null; // 确认状态
	private String startTime = null; // 开始时间
	private String endTime = null; // 截止时间
	private String dealUser = null; // 处理用户

	private String device = null; // 设备

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getConfirmState() {
		return confirmState;
	}

	public void setConfirmState(String confirmState) {
		this.confirmState = confirmState;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDealUser() {
		return dealUser;
	}

	public void setDealUser(String dealUser) {
		this.dealUser = dealUser;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "USTCAlarmSearchCondition [page=" + page + ", alarmLevel="
				+ alarmLevel + ", confirmState=" + confirmState
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", dealUser=" + dealUser + ", device=" + device + "]";
	}

}
