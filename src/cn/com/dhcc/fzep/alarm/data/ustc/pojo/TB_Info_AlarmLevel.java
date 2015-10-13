package cn.com.dhcc.fzep.alarm.data.ustc.pojo; 

public class TB_Info_AlarmLevel { 

	private String id;
	private String AlarmLevel;
	private String AlarmLevelName;

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		 this.id = id;
	}
	public String getAlarmLevel(){
		return this.AlarmLevel;
	}
	public void setAlarmLevel(String AlarmLevel){
		 this.AlarmLevel = AlarmLevel;
	}
	public String getAlarmLevelName(){
		return this.AlarmLevelName;
	}
	public void setAlarmLevelName(String AlarmLevelName){
		 this.AlarmLevelName = AlarmLevelName;
	}
}