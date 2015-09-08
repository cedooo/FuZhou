package cn.com.dhcc.fzep.alarm.service.ustc.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.dhcc.fzep.alarm.data.ustc.AlarmDetail;
import cn.com.dhcc.fzep.alarm.resources.DataResources;
import cn.com.dhcc.fzep.alarm.service.ustc.USTCAlarmService;

public class USTCAlarmServiceImpl implements USTCAlarmService{

	@Override
	public List<AlarmDetail> getAlarm() {
		SqlSession sqlSession = DataResources.getUstcSessionFactory().openSession();
		try{
			List<AlarmDetail> listAlarm = sqlSession.selectList("cn.com.dhcc.fzep.alarm.data.ustc.getAlarm");
			return listAlarm;
		}finally{
			sqlSession.close();
		}
	}


}
