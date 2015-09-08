package test.cn.com.dhcc.fzep.alarm.service.ustc.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.data.ustc.AlarmDetail;
import cn.com.dhcc.fzep.alarm.service.ustc.impl.USTCAlarmServiceImpl;

public class USTCAlarmServiceImplTest {

	private USTCAlarmServiceImpl srvImpl = new USTCAlarmServiceImpl();
	@Test
	public void testGetAlarm() {
		List<AlarmDetail> list = srvImpl.getAlarm();
		System.out.println(list);
		assertEquals(list!=null, true);
	}

}
