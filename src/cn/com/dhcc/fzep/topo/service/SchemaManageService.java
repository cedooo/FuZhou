package cn.com.dhcc.fzep.topo.service;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.SchemaTreeNode;
/**
 * 视图管理-分级树service
 * @author cedo
 *
 */
public interface SchemaManageService {
	/**
	 * 得到根节点集合
	 * @return
	 */
	public List<SchemaTreeNode> getRootNode();
	/**
	 * 通过站点ID得到视图ID
	 * @param siteID
	 * @return
	 */
	public List<Schema> getListSchemaBySiteID(String siteID);
	/**
	 * 得到自定义图
	 * @return
	 */
	public List<Schema> getListCustomerSchema();
	/**
	 * 根据视图ID删除视图
	 * @param schemaID 视图ID
	 * @return
	 */
	public boolean deleteSchema(String schemaID);
	/**
	 * 得到视图简要信息
	 * @param schemaID 视图ID
	 * @return
	 */
	public Schema getSchemaBriefInfo(String schemaID);
	/**
	 * 保存视图基本信息
	 * @param json
	 * @return
	 */
	public boolean saveSchemaBriefInfo(String json);
	
	/**
	 * 通过区域ID得到关键设备视图ID
	 * @param areId 区域ID
	 * @return
	 */
	public Schema getSchemaBriefInfoByAreaId(String areId);
	/**
	 * 添加一个视图
	 * @param schema
	 * @return
	 */
	public boolean addSchema(Schema schema);
	/**
	 * 设置默认视图
	 * @param schema 默认视图对象
	 * @return 设置成功返回true，否则返回false
	 */
	public boolean setDefaultSchema(Schema schema);
}
