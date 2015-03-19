package cn.com.dhcc.fzep.topo.common;
import cn.com.dhcc.fzep.topo.pojo.*;


public class MTOOLS {
	public static void main(String[] args) {
		Equipment l2Switch = new TwoLayerSwitch();
		System.out.println(l2Switch.getClass().toString());
		Equipment l3Switch = new ThreeLayerSwitch();
		System.out.println(l3Switch.getClass().toString());
		Equipment cable = new Cable();
		System.out.println(cable.getClass().toString());
		Equipment carrier = new Carrier();
		System.out.println(carrier.getClass().toString());
		Equipment gprs = new GPRS();
		System.out.println(gprs.getClass().toString());
		Equipment olt = new OLT();
		System.out.println(olt.getClass().toString());
		Equipment onu = new ONU();
		System.out.println(onu.getClass().toString());
	}
}
