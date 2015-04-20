package cn.com.dhcc.fzep.alarm.data.kyland;
/**
 * 东土 告警表POJO
 * @author CeDoo
 *
 */
public class Alarmmgrrm {
	private String alarmId = null;
	private String NodeType = null;
	private String OltId = null;
	private String SlotId = null;
	private String PONIfId = null;
	private String ONUId = null;
	private String RMid = null;
	private String PortType = null;
	private String MonitorEntityId = null;
	private String VCI = null;
	private String VPI = null;
	private String AlarmType = null;
	private String AlarmLevel = null;
	private String AlarmKind = null;
	private String GenTime = null;
	private String ClearTime = null;
	private String AffirmTime = null;
	private String AffirmState = null;
	private String UserIdAffirmer = null;
	private String ReasonForClear = null;
	private String userIdClear = null;
	public String getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}
	public String getNodeType() {
		return NodeType;
	}
	public void setNodeType(String nodeType) {
		NodeType = nodeType;
	}
	public String getOltId() {
		return OltId;
	}
	public void setOltId(String oltId) {
		OltId = oltId;
	}
	public String getSlotId() {
		return SlotId;
	}
	public void setSlotId(String slotId) {
		SlotId = slotId;
	}
	public String getPONIfId() {
		return PONIfId;
	}
	public void setPONIfId(String pONIfId) {
		PONIfId = pONIfId;
	}
	public String getONUId() {
		return ONUId;
	}
	public void setONUId(String oNUId) {
		ONUId = oNUId;
	}
	public String getRMid() {
		return RMid;
	}
	public void setRMid(String rMid) {
		RMid = rMid;
	}
	public String getPortType() {
		return PortType;
	}
	public void setPortType(String portType) {
		PortType = portType;
	}
	public String getMonitorEntityId() {
		return MonitorEntityId;
	}
	public void setMonitorEntityId(String monitorEntityId) {
		MonitorEntityId = monitorEntityId;
	}
	public String getVCI() {
		return VCI;
	}
	public void setVCI(String vCI) {
		VCI = vCI;
	}
	public String getVPI() {
		return VPI;
	}
	public void setVPI(String vPI) {
		VPI = vPI;
	}
	public String getAlarmType() {
		return AlarmType;
	}
	public void setAlarmType(String alarmType) {
		AlarmType = alarmType;
	}
	public String getAlarmLevel() {
		return AlarmLevel;
	}
	public void setAlarmLevel(String alarmLevel) {
		AlarmLevel = alarmLevel;
	}
	public String getAlarmKind() {
		return AlarmKind;
	}
	public void setAlarmKind(String alarmKind) {
		AlarmKind = alarmKind;
	}
	public String getGenTime() {
		return GenTime;
	}
	public void setGenTime(String genTime) {
		GenTime = genTime;
	}
	public String getClearTime() {
		return ClearTime;
	}
	public void setClearTime(String clearTime) {
		ClearTime = clearTime;
	}
	public String getAffirmTime() {
		return AffirmTime;
	}
	public void setAffirmTime(String affirmTime) {
		AffirmTime = affirmTime;
	}
	public String getAffirmState() {
		return AffirmState;
	}
	public void setAffirmState(String affirmState) {
		AffirmState = affirmState;
	}
	public String getUserIdAffirmer() {
		return UserIdAffirmer;
	}
	public void setUserIdAffirmer(String userIdAffirmer) {
		UserIdAffirmer = userIdAffirmer;
	}
	public String getReasonForClear() {
		return ReasonForClear;
	}
	public void setReasonForClear(String reasonForClear) {
		ReasonForClear = reasonForClear;
	}
	public String getUserIdClear() {
		return userIdClear;
	}
	public void setUserIdClear(String userIdClear) {
		this.userIdClear = userIdClear;
	}
	@Override
	public String toString() {
		return "Alarmmgrrm [alarmId=" + alarmId + ", NodeType=" + NodeType
				+ ", OltId=" + OltId + ", SlotId=" + SlotId + ", PONIfId="
				+ PONIfId + ", ONUId=" + ONUId + ", RMid=" + RMid
				+ ", PortType=" + PortType + ", MonitorEntityId="
				+ MonitorEntityId + ", VCI=" + VCI + ", VPI=" + VPI
				+ ", AlarmType=" + AlarmType + ", AlarmLevel=" + AlarmLevel
				+ ", AlarmKind=" + AlarmKind + ", GenTime=" + GenTime
				+ ", ClearTime=" + ClearTime + ", AffirmTime=" + AffirmTime
				+ ", AffirmState=" + AffirmState + ", UserIdAffirmer="
				+ UserIdAffirmer + ", ReasonForClear=" + ReasonForClear
				+ ", userIdClear=" + userIdClear + ", getAlarmId()="
				+ getAlarmId() + ", getNodeType()=" + getNodeType()
				+ ", getOltId()=" + getOltId() + ", getSlotId()=" + getSlotId()
				+ ", getPONIfId()=" + getPONIfId() + ", getONUId()="
				+ getONUId() + ", getRMid()=" + getRMid() + ", getPortType()="
				+ getPortType() + ", getMonitorEntityId()="
				+ getMonitorEntityId() + ", getVCI()=" + getVCI()
				+ ", getVPI()=" + getVPI() + ", getAlarmType()="
				+ getAlarmType() + ", getAlarmLevel()=" + getAlarmLevel()
				+ ", getAlarmKind()=" + getAlarmKind() + ", getGenTime()="
				+ getGenTime() + ", getClearTime()=" + getClearTime()
				+ ", getAffirmTime()=" + getAffirmTime()
				+ ", getAffirmState()=" + getAffirmState()
				+ ", getUserIdAffirmer()=" + getUserIdAffirmer()
				+ ", getReasonForClear()=" + getReasonForClear()
				+ ", getUserIdClear()=" + getUserIdClear() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
