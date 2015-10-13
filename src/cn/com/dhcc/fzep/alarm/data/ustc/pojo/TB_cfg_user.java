package cn.com.dhcc.fzep.alarm.data.ustc.pojo; 

public class TB_cfg_user { 

	private String ID;
	private String username;
	private String password;
	private String durtime;
	private String rightlevel;
	private String creater;
	private String createtime;
	private String machine;

	public String getID(){
		return this.ID;
	}
	public void setID(String ID){
		 this.ID = ID;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		 this.username = username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		 this.password = password;
	}
	public String getDurtime(){
		return this.durtime;
	}
	public void setDurtime(String durtime){
		 this.durtime = durtime;
	}
	public String getRightlevel(){
		return this.rightlevel;
	}
	public void setRightlevel(String rightlevel){
		 this.rightlevel = rightlevel;
	}
	public String getCreater(){
		return this.creater;
	}
	public void setCreater(String creater){
		 this.creater = creater;
	}
	public String getCreatetime(){
		return this.createtime;
	}
	public void setCreatetime(String createtime){
		 this.createtime = createtime;
	}
	public String getMachine(){
		return this.machine;
	}
	public void setMachine(String machine){
		 this.machine = machine;
	}
}