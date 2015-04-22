package cn.com.dhcc.fzep.alarm.common;

import java.util.Arrays;

public class AlarmStatistics {
	/**
	 * 数组：0:全部告警数量，1-4:类型告警数量
	 */
	private int[] statistics = null;
	public int[] getStatistics() {
		return statistics;
	}

	public void setStatistics(int[] statistics) {
		this.statistics = statistics;
	}

	@Override
	public String toString() {
		return "AlarmStatistics [statistics=" + Arrays.toString(statistics)
				+ "]";
	}
	
}