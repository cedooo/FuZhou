package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.TwoLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;

public class TwoLayerSwitchDaoTest {
	private TwoLayerSwitchDao dao = new TwoLayerSwitchDao();
	@Test
	public void testGetTwoLayerSwitch() {
		String l2SwitchId = "1";
		TwoLayerSwitch l2Swicth = dao.getTwoLayerSwitch(l2SwitchId );
		assertEquals(l2Swicth!=null, true);
		System.out.println(l2Swicth);
	}

}
