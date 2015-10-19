package cn.com.dhcc.fzep.alarm.service.ustc;

import java.util.List;

import cn.com.dhcc.fzep.alarm.common.ustc.USTCAlarmSearchCondition;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.CurrentAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.HistoryAlarm;
import cn.com.dhcc.fzep.alarm.data.ustc.vo.User;
import cn.com.dhcc.fzep.topo.common.search.Page;

/**
 * 科大告警接口
 * @author cedo
 *
 */
public interface USTCAlarmService {
	/**
	 * 得到科大历史告警分页信息
	 * @return Page对象
	 * @param searchCondition 科大告警搜索条件
	 */
	public Page ustcHistoryAlarmPageInfo(USTCAlarmSearchCondition searchCondition);
	
	/**
	 * 科大历史告警
	 * @param searchCondition
	 * @return
	 */
	public List<HistoryAlarm> ustcHistoryAlarm(USTCAlarmSearchCondition searchCondition);
	/**
	 * 科大用户列表
	 * @return 用户List
	 */
	public List<User> ustcUsers();
	/**
	 * 科大(当前)设备告警
	 * @param searchCondition
	 * @return
	 */
	public List<CurrentAlarm> ustcCurrentAlarm(USTCAlarmSearchCondition searchCondition);
	/**
	 * 得到科大(当前)设备告警分页信息
	 * @return Page对象
	 * @param searchCondition 科大告警搜索条件
	 */
	public Page ustcCurrentAlarmPageInfo(USTCAlarmSearchCondition searchCondition);
}
