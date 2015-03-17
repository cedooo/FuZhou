package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;
import cn.com.dhcc.fzep.topo.pojo.Area;

public class AreaDao {
	public List<Area> getAllAreas(){
		List<Area> areaList = new ArrayList<Area>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT * FROM b_area LIMIT 1000");
			while(results.next()){
				String areaId = results.getString("areaId");
				String areaName = results.getString("areaName");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Area area = new Area();
				area.setAreaId(areaId);
				area.setAreaName(areaName);
				area.setConnactName(connactName);
				area.setConnactNumber(connactNumber);
				area.setDelFlg(delFlg);
				area.setDelFlg(delFlg);
				area.setDescp(descp);
				areaList.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return areaList;
	}
	/**
	 * 根据ID得到区域对象
	 * @param id 区域ID
	 * @return
	 */
	
	public List<Area> getAreaByID(String id) {
		List<Area> areaList = new ArrayList<Area>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT * FROM b_area  where areaId = " + id);
			while(results.next()){
				String areaId = results.getString("areaId");
				String areaName = results.getString("areaName");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Area area = new Area();
				area.setAreaId(areaId);
				area.setAreaName(areaName);
				area.setConnactName(connactName);
				area.setConnactNumber(connactNumber);
				area.setDelFlg(delFlg);
				area.setDescp(descp);
				areaList.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return areaList;
	}

}
