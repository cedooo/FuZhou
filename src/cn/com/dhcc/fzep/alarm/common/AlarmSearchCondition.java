package cn.com.dhcc.fzep.alarm.common;

import cn.com.dhcc.fzep.topo.common.search.Page;
/**
 * 告警搜索/过滤 条件
 * @author cedo
 *
 */
public class AlarmSearchCondition {
	private Page page;

	private String alarmClazz = null;    //告警分类:活动告警/历史告警
	private String alarmType = null;    //告警名称
	private String alarmLevel = null;    //告警级别
	private String confirmState = null;    //确认状态
	private String startTime = null;    //开始时间
	private String endTime = null;   //截止时间
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getAlarmClazz() {
		return alarmClazz;
	}

	public void setAlarmClazz(String alarmClazz) {
		this.alarmClazz = alarmClazz;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
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
	
}
