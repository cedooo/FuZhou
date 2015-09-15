package cn.com.dhcc.fzep.alarm.common.ustc;

import cn.com.dhcc.fzep.topo.common.search.Page;
/**
 * 科大告警搜索条件
 * @author cedo
 *
 */
public class USTCAlarmSearchCondition {
	private Page page;

	private String alarmLevel = null;    //告警级别
	private String confirmState = null;    //确认状态
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

	
}
