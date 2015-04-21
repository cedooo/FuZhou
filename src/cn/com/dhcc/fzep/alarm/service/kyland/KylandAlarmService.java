package cn.com.dhcc.fzep.alarm.service.kyland;

import java.util.List;

import cn.com.dhcc.fzep.alarm.common.AlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;

/**
 * 东土告警服务接口
 * @author CeDoo
 *
 */
public interface KylandAlarmService {
	/**
	 * 得到告警集合
	 * @param condition
	 * @return
	 */
	public List<Alarmmgrrm> listAlarm(AlarmSearchCondition condition);
	
}
