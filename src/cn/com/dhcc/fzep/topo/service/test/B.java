package cn.com.dhcc.fzep.topo.service.test;

import java.io.Serializable;

public class B implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2920961104111708977L;
	private String bsName = null;

	public String getBsName() {
		return bsName;
	}

	public void setBsName(String bsName) {
		this.bsName = bsName;
	}

	@Override
	public String toString() {
		return "B [bsName=" + bsName + "]";
	}
	
}
