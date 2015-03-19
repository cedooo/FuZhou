package cn.com.dhcc.fzep.topo.service.test;

public class TestService {
	public A test1(String aName){
		B b = new B();
		String bsName = "b的名称";
		b.setBsName(bsName );
		A a = new A();
		String name = aName;
		a.setName(name);
		a.setB(b);
		System.out.println(a);
		return a;
	}
}
