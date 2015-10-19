package cn.com.dhcc.fzep.alarm.data.ustc.vo;

public class User {

	private String ID;
	private String userName;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", userName=" + userName + "]";
	}
	
	
}
