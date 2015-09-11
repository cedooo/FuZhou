package cn.com.dhcc.fzep.alarm.service.ustc.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.USTCAlarm;
import cn.com.dhcc.fzep.alarm.resources.DataResources;
import cn.com.dhcc.fzep.alarm.service.ustc.USTCAlarmService;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class USTCAlarmServiceImpl implements USTCAlarmService{

	@Override
	public List<USTCAlarm> getUSTCAlarm(USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			List<USTCAlarm> listAlarm = 
					sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.ustc.getUSTCAlarm", searchCondition);
			return listAlarm;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public Page ustcPageInfo(USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			Page page = searchCondition.getPage();
			Integer totalRecords = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.ustc.selectTotalRecords", searchCondition);    //记录总数
			page.setTotalRecords(totalRecords);
			page.updateTotalPage();
			return page;
		}finally{
			sqlSession.close();
		}
	}


}
