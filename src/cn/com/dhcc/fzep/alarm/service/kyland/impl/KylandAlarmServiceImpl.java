package cn.com.dhcc.fzep.alarm.service.kyland.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.fzep.alarm.common.AlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;
import cn.com.dhcc.fzep.alarm.resources.DataResources;
import cn.com.dhcc.fzep.alarm.service.kyland.KylandAlarmService;

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

}
