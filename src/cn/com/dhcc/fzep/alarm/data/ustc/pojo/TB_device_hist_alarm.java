package cn.com.dhcc.fzep.alarm.data.ustc.pojo; 

public class TB_device_hist_alarm { 

	private String ID;
	private String alarmtime;
	private String alarmcont;
	private String alarmlevel;
	private String deviceid;
	private String username;
	private String processtime;
	private String paramid;
	private String prooprater;
	private String remark;

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
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		 this.username = username;
	}
	public String getProcesstime(){
		return this.processtime;
	}
	public void setProcesstime(String processtime){
		 this.processtime = processtime;
	}
	public String getParamid(){
		return this.paramid;
	}
	public void setParamid(String paramid){
		 this.paramid = paramid;
	}
	public String getProoprater(){
		return this.prooprater;
	}
	public void setProoprater(String prooprater){
		 this.prooprater = prooprater;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		 this.remark = remark;
	}
}