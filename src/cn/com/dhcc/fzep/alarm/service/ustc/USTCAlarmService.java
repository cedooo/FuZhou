package cn.com.dhcc.fzep.alarm.service.ustc;

import java.util.List;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.AlarmDetail;
import cn.com.dhcc.fzep.alarm.data.ustc.USTCAlarm;

/**
 * 科大告警接口
 * @author cedo
 *
 */
public interface USTCAlarmService {
	/**
	 * 得到告警详情
	 * @return 告警详情
	 */
	public List<AlarmDetail> getAlarm();
	/**
	 * 得到科大告警
	 * @return USTCAlarm告警对象
	 */
	public List<USTCAlarm> getUSTCAlarm(USTCAlarmSearchCondition searchCondition);
	
}
