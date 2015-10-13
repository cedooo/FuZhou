package cn.com.dhcc.fzep.alarm.data.ustc.pojo; 

public class TB_cfg_device_class { 

	private String ID;
	private String devicetypeid;
	private String devicename;
	private String devicetypename;
	private String port;
	private String remark;
	private String devicedll;
	private String playdll;

	public String getID(){
		return this.ID;
	}
	public void setID(String ID){
		 this.ID = ID;
	}
	public String getDevicetypeid(){
		return this.devicetypeid;
	}
	public void setDevicetypeid(String devicetypeid){
		 this.devicetypeid = devicetypeid;
	}
	public String getDevicename(){
		return this.devicename;
	}
	public void setDevicename(String devicename){
		 this.devicename = devicename;
	}
	public String getDevicetypename(){
		return this.devicetypename;
	}
	public void setDevicetypename(String devicetypename){
		 this.devicetypename = devicetypename;
	}
	public String getPort(){
		return this.port;
	}
	public void setPort(String port){
		 this.port = port;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		 this.remark = remark;
	}
	public String getDevicedll(){
		return this.devicedll;
	}
	public void setDevicedll(String devicedll){
		 this.devicedll = devicedll;
	}
	public String getPlaydll(){
		return this.playdll;
	}
	public void setPlaydll(String playdll){
		 this.playdll = playdll;
	}
}