package cn.com.dhcc.fzep.alarm.data.ustc.vo;

public class CurrentAlarm {

	private String id ;
	private String occurTime;
	private String alarmContent;
	private String level;
	private String equipName;
	private String currentUser;
	private String dealTime;
	private String dealUser;
	private String note;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealUser() {
		return dealUser;
	}
	public void setDealUser(String dealUser) {
		this.dealUser = dealUser;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "CurrentAlarm [id=" + id + ", occurTime=" + occurTime
				+ ", alarmContent=" + alarmContent + ", level=" + level
				+ ", equipName=" + equipName + ", currentUser=" + currentUser
				+ ", dealTime=" + dealTime + ", dealUser=" + dealUser
				+ ", note=" + note + "]";
	}
	
}
