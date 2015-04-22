package test.cn.com.dhcc.fzep.alarm.service.kyland.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.common.AlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.common.AlarmStatistics;
import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;
import cn.com.dhcc.fzep.alarm.service.kyland.KylandAlarmService;
import cn.com.dhcc.fzep.alarm.service.kyland.impl.KylandAlarmServiceImpl;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class KylandAlarmServiceImplTest {
	
	private KylandAlarmService kylandAlarmServiceImpl = new KylandAlarmServiceImpl();

	@Test
	public void testListAlarm() {
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(30);
		AlarmSearchCondition condition = new AlarmSearchCondition();
		condition.setPage(page);
		
		String alarmLevel = "1";
		condition.setAlarmLevel(alarmLevel);
		String alarmType = "100";
		condition.setAlarmType(alarmType);
		//String confirmState = "0";
		//condition.setConfirmState(confirmState);
		List<Alarmmgrrm> list = kylandAlarmServiceImpl.listAlarm(condition);
		if(list!=null) System.out.println(list.size());
		System.out.println(list);
		assertEquals(list!=null&&list.size()>0, true);
	}
	
	@Test
	public void testPageInfo(){
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(30);
		AlarmSearchCondition condition = new AlarmSearchCondition();
		condition.setPage(page);
		
		String alarmLevel = "1";
		condition.setAlarmLevel(alarmLevel);
		String alarmType = "100";
		condition.setAlarmType(alarmType);
		Page pages = kylandAlarmServiceImpl.pageInfo(condition);
		System.out.println(pages);
		assertEquals(pages!=null&&pages.getTotalPage()>0, true);
	}
	
	@Test
	public void testGetAlarmStatisticsInfo(){
		AlarmStatistics statistics = kylandAlarmServiceImpl.getAlarmStatisticsInfo(null);
		System.out.println(statistics);
	}
}
