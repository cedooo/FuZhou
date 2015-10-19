package cn.com.dhcc.fzep.alarm.service.ustc.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.CurrentAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.HistoryAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.User;
import cn.com.dhcc.fzep.alarm.resources.DataResources;
import cn.com.dhcc.fzep.alarm.service.ustc.USTCAlarmService;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class USTCAlarmServiceImpl implements USTCAlarmService{

	@Override
	public Page ustcHistoryAlarmPageInfo(USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			Page page = searchCondition.getPage();
			Integer totalRecords = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.ustc.vo.selectTotalHistoryRecords", searchCondition);    //记录总数
			page.setTotalRecords(totalRecords);
			page.updateTotalPage();
			return page;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<HistoryAlarm> ustcHistoryAlarm(
			USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			List<HistoryAlarm> listAlarm = 
					sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.ustc.vo.getUsers", searchCondition);
			return listAlarm;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<User> ustcUsers() {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			List<User> listUsers = 
					sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.ustc.vo.getUsers");
			return listUsers;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<CurrentAlarm> ustcCurrentAlarm(
			USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			List<CurrentAlarm> listAlarm = 
					sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.ustc.vo.getUSTCCurrentAlarm", searchCondition);
			
			return listAlarm;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public Page ustcCurrentAlarmPageInfo(
			USTCAlarmSearchCondition searchCondition) {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			Page page = searchCondition.getPage();
			Integer totalRecords = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.ustc.vo.selectTotalCurrentRecords", searchCondition);    //记录总数
			page.setTotalRecords(totalRecords);
			page.updateTotalPage();
			return page;
		}finally{
			sqlSession.close();
		}
	}


}
