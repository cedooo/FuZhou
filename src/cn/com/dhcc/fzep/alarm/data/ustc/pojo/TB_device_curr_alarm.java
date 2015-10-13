package cn.com.dhcc.fzep.alarm.data.ustc.pojo; 

public class TB_device_curr_alarm { 

	private String ID;
	private String alarmtime;
	private String alarmcont;
	private String alarmlevel;
	private String deviceid;
	private String paramid;
	private String username;
	private String tm;
	private String sendflag;

	public String getID(){
		return this.ID;
	}
	public void setID(String ID){
		 this.ID = ID;
	}
	public String getAlarmtime(){
		return this.alarmtime;
	}
	public void setAlarmtime(String alarmtime){
		 this.alarmtime = alarmtime;
	}
	public String getAlarmcont(){
		return this.alarmcont;
	}
	public void setAlarmcont(String alarmcont){
		 this.alarmcont = alarmcont;
	}
	public String getAlarmlevel(){
		return this.alarmlevel;
	}
	public void setAlarmlevel(String alarmlevel){
		 this.alarmlevel = alarmlevel;
	}
	public String getDeviceid(){
		return this.deviceid;
	}
	public void setDeviceid(String deviceid){
		 this.deviceid = deviceid;
	}
	public String getParamid(){
		return this.paramid;
	}
	public void setParamid(String paramid){
		 this.paramid = paramid;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		 this.username = username;
	}
	public String getTm(){
		return this.tm;
	}
	public void setTm(String tm){
		 this.tm = tm;
	}
	public String getSendflag(){
		return this.sendflag;
	}
	public void setSendflag(String sendflag){
		 this.sendflag = sendflag;
	}
}