package cn.com.dhcc.fzep.topo.service.impl;

import java.util.List;

import cn.com.dhcc.fzep.topo.dao.AreaDao;
import cn.com.dhcc.fzep.topo.pojo.Area;
import cn.com.dhcc.fzep.topo.service.AreaSchemaService;

public class AreaSchemaServiceImpl implements AreaSchemaService{

	@Override
	public List<Area> getAllArea() {
		return new AreaDao().getAllAreas();
	}

	@Override
	public List<Area> getAreaByID(String id) {
		List<Area> list = null;
		if(id!=null){
			list = new AreaDao().getAreaByID(id);
		}
		return list;
	}


}
