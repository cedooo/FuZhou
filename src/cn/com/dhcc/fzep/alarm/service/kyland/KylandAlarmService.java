package cn.com.dhcc.fzep.alarm.service.kyland;

import java.util.List;

import cn.com.dhcc.fzep.alarm.common.AlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.kyland.Alarmmgrrm;
import cn.com.dhcc.fzep.topo.common.search.Page;

/**
 * 东土告警服务接口
 * @author CeDoo
 *
 */
public interface KylandAlarmService {
	/**
	 * 得到告警集合
	 * @param condition 搜索条件
	 * @return 告警集合
	 */
	public List<Alarmmgrrm> listAlarm(AlarmSearchCondition condition);
	/**
	 * 得到分页信息
	 * @param condition 搜索条件
	 * @return
	 */
	public Page pageInfo(AlarmSearchCondition condition);
	/**
	 * 得到告警统计信息
	 * @return
	 */
	public AlarmStatistics getAlarmStatisticsInfo(AlarmSearchCondition condition);
}
