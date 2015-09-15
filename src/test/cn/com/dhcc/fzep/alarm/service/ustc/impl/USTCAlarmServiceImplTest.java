package test.cn.com.dhcc.fzep.alarm.service.ustc.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.USTCAlarm;
import cn.com.dhcc.fzep.alarm.service.ustc.impl.USTCAlarmServiceImpl;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class USTCAlarmServiceImplTest {

	private USTCAlarmServiceImpl srvImpl = new USTCAlarmServiceImpl();

	@Test
	public void testGetUSTCAlarm() {
		USTCAlarmSearchCondition searchCondition = new USTCAlarmSearchCondition();
		Page page = new Page();
		page.setCurPage(1);
		page.setNumPerPage(4);
		searchCondition.setPage(page);
		
		searchCondition.setStartTime("2012-02-01");
		searchCondition.setEndTime("2012-03-31");
		
		List<USTCAlarm> list = srvImpl.getUSTCAlarm(searchCondition);
		System.out.format("记录数量%s%n", list.size());
		Page pageR = srvImpl.ustcPageInfo(searchCondition);
		System.out.println("总页数：" + pageR.getTotalPage() + ", 总记录数: " + pageR.getTotalRecords());
		System.out.println(list);
		assertEquals(list!=null, true);
	}

}
