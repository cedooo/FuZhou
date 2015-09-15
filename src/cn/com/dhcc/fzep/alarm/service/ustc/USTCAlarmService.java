package cn.com.dhcc.fzep.alarm.service.ustc;

import java.util.List;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.USTCAlarm;
import cn.com.dhcc.fzep.topo.common.search.Page;

/**
 * 科大告警接口
 * @author cedo
 *
 */
public interface USTCAlarmService {
	/**
	 * 得到科大告警
	 * @return USTCAlarm告警对象
	 * @param  searchCondition 科大告警搜索条件
	 */
	public List<USTCAlarm> getUSTCAlarm(USTCAlarmSearchCondition searchCondition);
	/**
	 * 得到科大告警分页信息
	 * @return Page对象
	 * @param searchCondition 科大告警搜索条件
	 */
	public Page ustcPageInfo(USTCAlarmSearchCondition searchCondition);
}
