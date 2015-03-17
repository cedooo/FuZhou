package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.ThreeLayerSwitchDao;
import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;

public class ThreeLayerSwitchDaoTest {
	private ThreeLayerSwitchDao dao = new ThreeLayerSwitchDao();
	@Test
	public void testGetThreeLayerSwitch() {
		String l3SwitchId = "1";
		ThreeLayerSwitch l3Swicth = dao.getThreeLayerSwitch(l3SwitchId );
		assertEquals(l3Swicth!=null, true);
		System.out.println(l3Swicth);
	}

}
