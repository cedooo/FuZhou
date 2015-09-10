package test.cn.com.dhcc.fzep.alarm.service.ustc.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.AlarmDetail;
import cn.com.dhcc.fzep.alarm.data.ustc.USTCAlarm;
import cn.com.dhcc.fzep.alarm.service.ustc.impl.USTCAlarmServiceImpl;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class USTCAlarmServiceImplTest {

	private USTCAlarmServiceImpl srvImpl = new USTCAlarmServiceImpl();
	@Test
	public void testGetAlarm() {
		List<AlarmDetail> list = srvImpl.getAlarm();
		System.out.println(list);
		assertEquals(list!=null, true);
	}
	@Test
	public void testGetUSTCAlarm() {
		USTCAlarmSearchCondition searchCondition = new USTCAlarmSearchCondition();
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(4);
		searchCondition.setPage(page);
		List<USTCAlarm> list = srvImpl.getUSTCAlarm(searchCondition);
		System.out.format("记录数量%s%n", list.size());
		System.out.println(list);
		assertEquals(list!=null, true);
	}

}
