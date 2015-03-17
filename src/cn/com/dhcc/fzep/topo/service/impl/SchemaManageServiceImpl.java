package cn.com.dhcc.fzep.topo.service.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import cn.com.dhcc.fzep.topo.dao.SchemaDao;
import cn.com.dhcc.fzep.topo.dao.SchemaTreeNodeDao;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.SchemaTreeNode;
import cn.com.dhcc.fzep.topo.service.SchemaManageService;

public class SchemaManageServiceImpl implements SchemaManageService {

	@Override
	public List<SchemaTreeNode> getRootNode() {
		SchemaTreeNodeDao stDao = new SchemaTreeNodeDao();
		return stDao.getRootNode();
	}

	@Override
	public List<Schema> getListSchemaBySiteID(String siteID) {
		if (siteID != null) {
			return new SchemaDao().getListSchemaBySiteID(siteID);
		}
		return null;
	}

	@Override
	public List<Schema> getListCustomerSchema() {
		return new SchemaDao().getListCustomerSchema();
	}

	@Override
	public boolean deleteSchema(String schemaID) {
		if (schemaID != null) {
			return new SchemaDao().deleteSchema(schemaID);
		}
		return false;
	}

	@Override
	public Schema getSchemaBriefInfo(String schemaID) {
		if (schemaID != null) {
			return new SchemaDao().getBrief(schemaID);
		}
		return null;
	}

	@Override
	public boolean saveSchemaBriefInfo(String json) {
		try {
			JSONObject jsonObj = new JSONObject(json);
			String schemaId = jsonObj.getString("schemaId");
			String schemaName = jsonObj.getString("schemaName");
			//String schemaAddTime = jsonObj.getString("schemaAddTime");
			//String schemaData = jsonObj.getString("schemaData");
			//String schemaArgs = jsonObj.getString("schemaArgs");
			//String schemaDelTime = jsonObj.getString("schemaDelTime");
			//String schemaType = jsonObj.getString("schemaType");
			String schemaNote = jsonObj.getString("schemaNote");
			//String areaId = jsonObj.getString("areaId");
			//String siteId = jsonObj.getString("siteId");
			Schema schema = new Schema();
			schema.setSchemaId(schemaId);
			schema.setSchemaName(schemaName);
			schema.setSchemaNote(schemaNote);
			return new SchemaDao().savaBrief(schema);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Schema getSchemaBriefInfoByAreaId(String areId) {
		if (areId != null) {
			return new SchemaDao().getBriefByAreaId(areId);
		}
		return null;
	}

	@Override
	public boolean addSchema(Schema schema) {
		if(schema!=null){
			return new SchemaDao().insertSchema(schema);
		}else{
			return false;
		}
	}

	@Override
	public boolean setDefaultSchema(Schema schema) {
		if(schema!=null){
			return new SchemaDao().setDefaultSchema(schema);
		}else{
			return false;
		}
	}

}
