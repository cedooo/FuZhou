package cn.com.dhcc.fzep.alarm.data.ustc;
/**
 * 科大告警VO
 * @author cedo
 *
 */
public class USTCAlarm {

	private String id;
	private String occourTime;
	private String alarmContent;
	private String level;
	private String equipName;
	private String currentUser;
	private String dealTime;
	private String delUser;
	private String note;
	
	private String state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOccourTime() {
		return occourTime;
	}
	public void setOccourTime(String occourTime) {
		this.occourTime = occourTime;
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
	public String getDelUser() {
		return delUser;
	}
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "USTCAlarm [id=" + id + ", occourTime=" + occourTime
				+ ", alarmContent=" + alarmContent + ", level=" + level
				+ ", equipName=" + equipName + ", currentUser=" + currentUser
				+ ", dealTime=" + dealTime + ", delUser=" + delUser + ", note="
				+ note + "]";
	}
	
}
