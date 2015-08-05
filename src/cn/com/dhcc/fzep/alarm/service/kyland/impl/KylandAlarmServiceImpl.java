package cn.com.dhcc.fzep.alarm.service.kyland.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.fzep.alarm.common.AlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;
import cn.com.dhcc.fzep.alarm.resources.DataResources;
import cn.com.dhcc.fzep.alarm.service.kyland.AlarmStatistics;
import cn.com.dhcc.fzep.alarm.service.kyland.KylandAlarmService;
import cn.com.dhcc.fzep.topo.common.search.Page;

public class KylandAlarmServiceImpl implements KylandAlarmService{

	@Override
	public List<Alarmmgrrm> listAlarm(AlarmSearchCondition condition) {
		SqlSession sqlSession = DataResources.getKylandSessionFactory().openSession();
		try{
			List<Alarmmgrrm> listAlarm = sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.queryAlarm", condition);
			return listAlarm;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public Page pageInfo(AlarmSearchCondition condition) {
		SqlSession sqlSession = DataResources.getKylandSessionFactory().openSession();
		try{
			Page page = condition.getPage();
			Integer totalRecords = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.selectTotalRecords", condition);
			page.setTotalRecords(totalRecords);
			page.updateTotalPage();
			return page;
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public AlarmStatistics getAlarmStatisticsInfo(AlarmSearchCondition condition) {
		SqlSession sqlSession = DataResources.getKylandSessionFactory().openSession();
		try{
			AlarmStatistics stat = new AlarmStatistics();
			int total = 0;
			int lOneCount = 0;
			int lTwoCount = 0;
			int lThreeCount = 0;
			int lFourCount = 0;
			lOneCount = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.countTotal", "1");
			lTwoCount = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.countTotal", "2");
			lThreeCount = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.countTotal", "3");
			lFourCount = sqlSession.selectOne("cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm.countTotal", "4");
			total = lOneCount + lTwoCount + lThreeCount + lFourCount;
			int[] statistics = new int[5];
			statistics[0] = total;
			statistics[1] = lOneCount;
			statistics[2] = lTwoCount;
			statistics[3] = lThreeCount;
			statistics[4] = lFourCount;
			stat.setStatistics(statistics);
			return stat;
		}finally{
			sqlSession.close();
		}
	}

	
}

