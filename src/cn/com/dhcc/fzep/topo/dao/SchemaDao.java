package cn.com.dhcc.fzep.topo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zdy.dao.DBManager;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.vo.SchemaVO;

public class SchemaDao {
	public boolean insertSchema(Schema schema){
		DBManager db = new DBManager();
		int insertedCount = -1;
		try {
			db.openConnection();
			insertedCount = db.executeUpdate("insert into t_schema(dt_schema_add_time, vc_schema_data, vc_schema_args, vc_schema_name, n_schema_area_id, n_schema_site_id, vc_schema_note)" +
					" values(" +
					" sysdate() , '" + schema.getSchemaData() + "', '" + schema.getSchemaArgs() + "', '" + schema.getSchemaName() + "', " +
					schema.getAreaId() + ", " + schema.getSiteId() + ",  '" + schema.getSchemaNote() + "'" + 
					 ")");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if(insertedCount==1){
			return true;
		}
		return false;
	}
	public boolean updateSchema(Schema schema){
		if(schema.getSchemaId()==null){
			return false;
		}
		DBManager db = new DBManager();
		int updatedCount = -1;
		try {
			db.openConnection();
			updatedCount = db.executeUpdate("update t_schema set vc_schema_data='" 
					 + schema.getSchemaData() + "', vc_schema_args='" + schema.getSchemaArgs() + "', vc_schema_name = '" + schema.getSchemaName() + "' where n_schema_id = '" + schema.getSchemaId() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if(updatedCount==1){
			return true;
		}
		return false;
	}
	/**
	 * 根据视图ID得到视图对象
	 * @param schemaID 视图ID
	 * @return
	 */
	public Schema getSchema(String schemaID){
		if(schemaID==null){
			return null;
		}
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select * from t_schema " +
					" where  dt_schema_del_time is null and n_schema_id = '" + schemaID + "'");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				String n_schema_area_id = results.getString("n_schema_area_id");
				String n_schema_site_id = results.getString("n_schema_site_id");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				schema.setAreaId(n_schema_area_id);
				schema.setSiteId(n_schema_site_id);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	/**
	 * 根据站点ID得到视图列表
	 * @param siteID 站点ID
	 * @return
	 */
	public List<Schema> getListSchemaBySiteID(String siteID){
		if(siteID==null){
			return null;
		}
		List<Schema> list = new  ArrayList<Schema>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select * from t_schema " +
					" where  dt_schema_del_time is null and n_schema_site_id = '" + siteID + "' limit 1000");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				list.add(schema);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}
	/**
	 * 得到所有自定义视图
	 * @return
	 */
	public List<Schema> getListCustomerSchema() {
		List<Schema> list = new  ArrayList<Schema>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select * from t_schema " +
					" where n_schema_site_id is null and  dt_schema_del_time is null  limit 1000");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				list.add(schema);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}
	
	/**
	 * 根据视图ID删除视图
	 * @param schemaID 视图ID
	 * @return
	 */
	public boolean deleteSchema(String schemaID){
		if(schemaID==null){
			return false;
		}
		DBManager db = new DBManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		try {
			db.openConnection();
			int results = db.executeUpdate("update t_schema set dt_schema_del_time = '" + sdf.format(now) +
					"' where dt_schema_del_time is null " +
						"and n_schema_id=" +  schemaID);
			if(results==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
	/**
	 * 得到视图（除视图图元和视图参数外）的简要信息
	 * @param schemaID 视图ID
	 * @return 视图对象s
	 */
	public Schema getBrief(String schemaID) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select n_schema_id,dt_schema_add_time,vc_schema_type,vc_schema_name,vc_schema_note,dt_schema_del_time,vc_is_default " +
					"  from t_schema " +
					" where n_schema_id = '" + schemaID + "' and  dt_schema_del_time is null  limit 1");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_is_default = results.getString("vc_is_default");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setIsDefault(vc_is_default);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	/**
	 * 保存简要信息（除视图图元和视图参数外）
	 * @param schema 视图简要信息
	 * @return 成功返回true，否则返回false
	 */
	public boolean savaBrief(Schema schema) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			int updated = db.executeUpdate("update t_schema set vc_schema_name='" + schema.getSchemaName() + "', vc_schema_note='" + schema.getSchemaNote() + "' " +
					" where n_schema_id = '" + schema.getSchemaId() + "' and  dt_schema_del_time is null ");
			if(updated==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
	

	/**
	 * 得到所有自定义视图
	 * @return
	 */
	public Schema getSchemaByAreaName(String areaName) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select sch.* from t_schema sch left join b_area area on sch.n_schema_area_id = area.areaId " +
					" where  n_schema_area_id is not null and  dt_schema_del_time is null " 
					+ " and area.areaName='" + areaName + "'  " +
					" order by dt_schema_add_time desc limit 1");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	public Schema getBriefByAreaId(String areId) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select n_schema_id,dt_schema_add_time,vc_schema_type,vc_schema_name,vc_schema_note,dt_schema_del_time, vc_is_default " +
					"  from t_schema " +
					" where n_schema_area_id = '" + areId + "' and  dt_schema_del_time is null  limit 1");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_is_default = results.getString("vc_is_default");
				Schema schema = new Schema();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setIsDefault(vc_is_default);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	/**
	 * 设置默认视图
	 * @param schema
	 * @return
	 */
	public boolean setDefaultSchema(Schema schema){
		DBManager db = new DBManager();
		try {
			db.openConnection();
			String setAllToNull = "UPDATE t_schema SET vc_is_default=null WHERE n_schema_id!='" + schema.getSchemaId() + "' ";
			String updateDefault = "UPDATE t_schema SET vc_is_default='Y' WHERE n_schema_id='" + schema.getSchemaId() + "' ";
			int updatedCount = db.executeUpdate(setAllToNull);
			if(updatedCount>=0){
				int updateDefaultCount = db.executeUpdate(updateDefault);
				if(updateDefaultCount==1){
					return true;
				}else{
					return false;
				}
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
	public SchemaVO getDefaultSchemaVO() {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select sch.n_schema_id, sch.dt_schema_add_time,sch.vc_schema_data, sch.dt_schema_del_time,sch.vc_schema_type "
					+ " , sch.vc_schema_name, sch.vc_schema_note, sch.vc_schema_args,sch.n_schema_area_id ,sch.n_schema_site_id, sch.vc_is_default, "
					+ " area.areaName as vc_area_name, site.siteName as vc_site_name "
					+ " from t_schema sch left join b_area area on sch.n_schema_area_id = area.areaId "
					+ " left join a_site site on sch.n_schema_site_id = site.siteId  " +
					" where  dt_schema_del_time is null and vc_is_default='Y' limit 1 ");
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				String n_schema_area_id = results.getString("n_schema_area_id");
				String n_schema_site_id = results.getString("n_schema_site_id");
				String vc_is_default = results.getString("vc_is_default");
				String vc_area_name = results.getString("vc_area_name");
				String vc_site_name = results.getString("vc_site_name");
				SchemaVO schema = new SchemaVO();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				schema.setAreaId(n_schema_area_id);
				schema.setSiteId(n_schema_site_id);
				schema.setIsDefault(vc_is_default);
				schema.setAreaName(vc_area_name);
				schema.setSiteName(vc_site_name);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
	/**
	 * 得到所有自定义视图
	 * @return
	 */
	public SchemaVO getSchemaVOByAreaName(String areaName) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			String querySQL = "select sch.n_schema_id, sch.dt_schema_add_time,sch.vc_schema_data, sch.dt_schema_del_time,sch.vc_schema_type "
					+ " , sch.vc_schema_name, sch.vc_schema_note, sch.vc_schema_args,sch.n_schema_area_id ,sch.n_schema_site_id, sch.vc_is_default, "
					+ " area.areaName as vc_area_name, site.siteName as vc_site_name "
					+ " from t_schema sch left join b_area area on sch.n_schema_area_id = area.areaId "
					+ " left join a_site site on sch.n_schema_site_id = site.siteId  " +
					" where  n_schema_area_id is not null and  dt_schema_del_time is null " 
					+ " and area.areaName='" + areaName + "'  " +
					" order by dt_schema_add_time desc limit 1 ";
			
			ResultSet results = db.executeQuery(querySQL);
			while(results.next()){
				String n_schema_id = results.getString("n_schema_id");
				String dt_schema_add_time = results.getString("dt_schema_add_time");
				String vc_schema_data = results.getString("vc_schema_data");
				String dt_schema_del_time = results.getString("dt_schema_del_time");
				String vc_schema_type = results.getString("vc_schema_type");
				String vc_schema_name = results.getString("vc_schema_name");
				String vc_schema_note = results.getString("vc_schema_note");
				String vc_schema_args = results.getString("vc_schema_args");
				String vc_is_default = results.getString("vc_is_default");
				String n_schema_area_id = results.getString("n_schema_area_id");
				String n_schema_site_id = results.getString("n_schema_site_id");
				String vc_area_name = results.getString("vc_area_name");
				String vc_site_name = results.getString("vc_site_name");
				SchemaVO schema = new SchemaVO();
				schema.setSchemaAddTime(dt_schema_add_time);
				schema.setSchemaData(vc_schema_data);
				schema.setSchemaDelTime(dt_schema_del_time);
				schema.setSchemaId(n_schema_id);
				schema.setSchemaType(vc_schema_type);
				schema.setSchemaName(vc_schema_name);
				schema.setSchemaNote(vc_schema_note);
				schema.setSchemaArgs(vc_schema_args);
				schema.setAreaId(n_schema_area_id);
				schema.setSiteId(n_schema_site_id);
				schema.setIsDefault(vc_is_default);
				schema.setAreaName(vc_area_name);
				schema.setSiteName(vc_site_name);
				return schema;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
}
