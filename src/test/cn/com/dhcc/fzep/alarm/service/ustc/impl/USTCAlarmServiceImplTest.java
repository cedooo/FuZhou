package test.cn.com.dhcc.fzep.alarm.service.ustc.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.HistoryAlarm;
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
		searchCondition.setStartTime("1387775417");
		searchCondition.setEndTime("1388455164");
		
		searchCondition.setDealUser("zmm");
		Page pager = srvImpl.ustcHistoryAlarmPageInfo(searchCondition);
		System.out.println("总页数："  + pager.getTotalPage() + "记录总数：" + pager.getTotalRecords());
		
		List<HistoryAlarm> list = srvImpl.ustcHistoryAlarm(searchCondition);
		System.out.format("记录数量%s%n", list.size());
		System.out.println(list);
		assertEquals(list==null, true);
		
		
		
	}
}
