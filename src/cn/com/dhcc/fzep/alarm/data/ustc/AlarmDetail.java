package cn.com.dhcc.fzep.alarm.data.ustc;

public class AlarmDetail {

	private String alarmId;    //告警ID 自增长
	private String devId;    //设备编号
	private String alarmLevel;    //告警级别 如1、2、3、4、5其中1最高
	private String alarmContent;    //告警内容
	private String alarmLocation;    //告警位置 单位KM
	private String alarmTime;    //告警时间
	private String state;    //记录状态 1为有效 0为无效 如删除时置为0
	
	public String getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public String getAlarmLocation() {
		return alarmLocation;
	}
	public void setAlarmLocation(String alarmLocation) {
		this.alarmLocation = alarmLocation;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
