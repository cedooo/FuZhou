package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Area;
/**
 * 区域视图
 * @author cedo
 *
 */
public interface AreaSchemaService {
	/**
	 * 得到所有区域列表
	 * @return
	 */
	public List<Area> getAllArea();
	/**
	 * 得到制定ID的地区信息
	 * @param id 地区ID
	 * @return
	 */
	public List<Area> getAreaByID(String id);
}
