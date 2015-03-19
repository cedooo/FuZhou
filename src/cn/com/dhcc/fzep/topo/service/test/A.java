package cn.com.dhcc.fzep.topo.service.test;

import java.io.Serializable;

public class A  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8342200414925120302L;
	

	public B b = null;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	private String name = null;
	private int age = -1;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "A [b=" + b + ", name=" + name + ", age=" + age + "]";
	}

	
}
