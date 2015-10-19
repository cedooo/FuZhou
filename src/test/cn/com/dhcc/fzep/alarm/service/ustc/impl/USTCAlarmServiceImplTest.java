package test.cn.com.dhcc.fzep.alarm.service.ustc.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.CurrentAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.HistoryAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.User;
import cn.com.dhcc.fzep.alarm.service.ustc.impl.USTCAlarmServiceImpl;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class USTCAlarmServiceImplTest {

	private USTCAlarmServiceImpl srvImpl = new USTCAlarmServiceImpl();
	
	
	
	@Test 
	public void testUstcHistoryAlarm(){
		USTCAlarmSearchCondition searchCondition = new USTCAlarmSearchCondition();
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(14);
		searchCondition.setPage(page);
		searchCondition.setStartTime("2011-10-19 18:03:31");
		searchCondition.setEndTime("2015-10-19 18:03:31");
		
		searchCondition.setDealUser("zmm");
		Page pager = srvImpl.ustcHistoryAlarmPageInfo(searchCondition);
		System.out.println("总页数："  + pager.getTotalPage() + "记录总数：" + pager.getTotalRecords());
		
		List<HistoryAlarm> list = srvImpl.ustcHistoryAlarm(searchCondition);
		System.out.format("记录数量%s%n", list.size());
		System.out.println(list);
		assertEquals(list!=null, true);
		
	}
	@Test
	public void testGetUser(){
		List<User> listUser = srvImpl.ustcUsers();
		System.out.println(listUser);
	}

	@Test 
	public void testUstcCurrentAlarm(){
		System.out.println("==============================设备当前告警=============================");
		USTCAlarmSearchCondition searchCondition = new USTCAlarmSearchCondition();
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(14);
		searchCondition.setPage(page);
		searchCondition.setStartTime("2011-10-19 18:03:31");
		searchCondition.setEndTime("2015-10-19 18:03:31");
		
		//searchCondition.setDealUser("zmm");
		Page pager = srvImpl.ustcCurrentAlarmPageInfo(searchCondition);
		System.out.println("总页数："  + pager.getTotalPage() + "记录总数：" + pager.getTotalRecords());
		System.out.println("当前页数: " + pager.getCurPage());
		List<CurrentAlarm> list = srvImpl.ustcCurrentAlarm(searchCondition);
		System.out.format("记录数量%s%n", list.size());
		System.out.println(list);
		assertEquals(list!=null, true);
		
	}
	
}
