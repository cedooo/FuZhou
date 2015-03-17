package zdy.dao.impl;
/**
 * @TemplateDaoImpl  通用的数据操作类
 * @author zhangdengyuan
 * @descp 可以对表进行简单的增、删、改和查功能（不过有一个限制条件，就是必须对表名【包括表名的命名规则{如表字段首字母必须小写}】称和模型名称【都必须继承TemplateBeen】相对应）。
 * @createDate 2014-12-05
 * @lastUpdateDate 2014-12-09
 * @version 1.0
 */

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zdy.common.Constant;
import zdy.dao.DBManager;
import zdy.dao.TemplateDao;
import zdy.model.ConditionDto;
import zdy.model.PageDto;
import zdy.model.TemplateBeen;

public class TemplateDaoImpl implements TemplateDao {
	/** 通过sql进行事务操作*/
	public void transcationExecute(String sql,DBManager dBManager) throws Exception {
		if (sql == null || "".equals(sql)) {
			return;
		}
		dBManager.executeUpdate(sql);
	}
	
	/** 表的增加操作 */
	public void add(Object object) throws Exception {
		if (object == null) {
			return;
		}
		/** 根据命名规则获取表的名称 */
		String tableName = object.getClass().getSimpleName();
		/** 通过表名获取模型名称（因为命名都是有规则的） */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,tableName.length());
		/** 首字母大写 */
		modelName = (new StringBuilder()).append(
				Character.toUpperCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 通过modelName实例化model */
		TemplateBeen templateBeen = (TemplateBeen) object;
		/** 新增的列表集合 */
		List<String> insertKeyList = new ArrayList<String>();
		/** 新增的列表值的集合 */
		List<String> insertValueList = new ArrayList<String>();
		/** 遍历object的方法 */
		for (Method method : templateBeen.getClass().getMethods()) {
			/** 剔除getClass和实例化后model的主键 */
			if (method.getName().startsWith("get")
					&& !"getClass".equals(method.getName())
					&& !method.getName().contains("get" + modelName + "Id")) {
				/** 截取get后面的字母 */
				String formatName = method.getName().substring(3,
						method.getName().length());
				insertKeyList.add(formatName);
				insertValueList.add((String) templateBeen.getClass().getMethod(
						method.getName()).invoke(templateBeen));
			}
		}
		/** 将 insertKey 集合的数据插入到执行语句中 */
		String executeSql = " insert into " + tableName + "(";
		for (String insertKey : insertKeyList) {
			executeSql += insertKey + ",";
		}
		/** 剔除insertKey末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		/** 将 insertValue 集合的数据插入到执行语句中 */
		executeSql += ") values(";
		for (String insertValue : insertValueList) {
			executeSql += "\"" + insertValue + "\",";
		}
		/** 剔除insertVale末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		executeSql += ")";

		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		dBManager.executeUpdate(executeSql);
		dBManager.closeConnection();
	}

	/** 表的增加--事务操作(需要收入输入模型的主键信息) */
	public void transcationAdd(Object object,DBManager dBManager) throws Exception {
		if (object == null||dBManager==null) {
			return;
		}
		/** 根据命名规则获取表的名称 */
		String tableName = object.getClass().getSimpleName();
		/** 通过表名获取模型名称（因为命名都是有规则的） */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母大写 */
		modelName = (new StringBuilder()).append(
				Character.toUpperCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 通过modelName实例化model */
		TemplateBeen templateBeen = (TemplateBeen) object;
		/** 新增的列表集合 */
		List<String> insertKeyList = new ArrayList<String>();
		/** 新增的列表值的集合 */
		List<String> insertValueList = new ArrayList<String>();
		/** 遍历object的方法 */
		for (Method method : templateBeen.getClass().getMethods()) {
			/** 剔除getClass和实例化后model的主键 */
			if (method.getName().startsWith("get")
					&& !"getClass".equals(method.getName())
					&& !method.getName().contains("get" + modelName + "Id")) {
				/** 截取get后面的字母 */
				String formatName = method.getName().substring(3,
						method.getName().length());
				insertKeyList.add(formatName);
				insertValueList.add((String) templateBeen.getClass().getMethod(
						method.getName()).invoke(templateBeen));
			}
		}
		/** 将 insertKey 集合的数据插入到执行语句中 */
		String executeSql = " insert into " + tableName + "(";
		for (String insertKey : insertKeyList) {
			executeSql += insertKey + ",";
		}
		/** 剔除insertKey末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		/** 将 insertValue 集合的数据插入到执行语句中 */
		executeSql += ") values(";
		for (String insertValue : insertValueList) {
			executeSql += "\"" + insertValue + "\",";
		}
		/** 剔除insertVale末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		executeSql += ")";
		/** 建立数据库连接 */
		dBManager.executeUpdate(executeSql);
	}
	
	/** 表的更新-事务操作(需要收入输入模型的主键信息) */
	public void transcationUpdate(Object object,DBManager dBManager) throws Exception {
		if (object == null||dBManager==null) {
			return;
		}
		/** 根据命名规则获取表的名称 */
		String tableName = object.getClass().getSimpleName();
		/** 通过表名获取模型名称（因为命名都是有规则的） */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母大写 */
		modelName = (new StringBuilder()).append(
				Character.toUpperCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 通过modelName实例化model */
		TemplateBeen templateBeen = (TemplateBeen) object;
		/** 更新的列表集合 */
		List<String> updateKeyList = new ArrayList<String>();
		/** 更新的列表值的集合 */
		Map<String, String> updateValueMap = new HashMap<String, String>();
		/** 更新条件的名称 */
		String conditionKey = "get" + modelName + "Id";
		/** 更新条件的值 */
		String conditionValue = "";
		/** 遍历object的方法 */
		for (Method method : templateBeen.getClass().getMethods()) {
			/** 剔除getClass和实例化后model的主键 */
			if (method.getName().startsWith("get")
					&& !"getClass".equals(method.getName())) {

				/** 判断是否为获取更新条件 */
				if (method.getName().contains(conditionKey)) {
					conditionValue = (String) templateBeen.getClass()
							.getMethod(method.getName()).invoke(templateBeen);
					continue;
				}
				/** 截取get后面的字母 */
				String formatName = method.getName().substring(3,
						method.getName().length());
				updateKeyList.add(formatName);
				updateValueMap.put(formatName, (String) templateBeen.getClass()
						.getMethod(method.getName()).invoke(templateBeen));
			}
		}
		/** 将 insertKey 集合的数据插入到执行语句中 */
		String executeSql = " update  " + tableName + " set ";
		for (String updateKey : updateKeyList) {
			executeSql += updateKey + " = \"" + updateValueMap.get(updateKey)
					+ "\",";
		}
		/** 剔除insertKey末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		/** 将 insertValue 集合的数据插入到执行语句中 */
		executeSql += " where " + modelName + "Id" + " like '" + conditionValue
				+ "'";
		dBManager.executeUpdate(executeSql);
	}

	/** 表的增加-事务操作(需要收入输入模型的主键信息) */
	public void transcationAddIncludeId(Object object,DBManager dBManager) throws Exception {
		if (object == null||dBManager==null) {
			return;
		}
		/** 根据命名规则获取表的名称 */
		String tableName = object.getClass().getSimpleName();
		/** 通过表名获取模型名称（因为命名都是有规则的） */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母大写 */
		modelName = (new StringBuilder()).append(
				Character.toUpperCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 通过modelName实例化model */
		TemplateBeen templateBeen = (TemplateBeen) object;
		/** 新增的列表集合 */
		List<String> insertKeyList = new ArrayList<String>();
		/** 新增的列表值的集合 */
		List<String> insertValueList = new ArrayList<String>();
		/** 遍历object的方法 */
		for (Method method : templateBeen.getClass().getMethods()) {
			/** 剔除getClass和实例化后model的主键 */
			if (method.getName().startsWith("get")
					&& !"getClass".equals(method.getName())) {
				/** 截取get后面的字母 */
				String formatName = method.getName().substring(3,
						method.getName().length());
				insertKeyList.add(formatName);
				insertValueList.add((String) templateBeen.getClass().getMethod(
						method.getName()).invoke(templateBeen));
			}
		}
		/** 将 insertKey 集合的数据插入到执行语句中 */
		String executeSql = " insert into " + tableName + "(";
		for (String insertKey : insertKeyList) {
			executeSql += insertKey + ",";
		}
		/** 剔除insertKey末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		/** 将 insertValue 集合的数据插入到执行语句中 */
		executeSql += ") values(";
		for (String insertValue : insertValueList) {
			executeSql += "\"" + insertValue + "\",";
		}
		/** 剔除insertVale末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		executeSql += ")";
		/** 建立数据库连接 */
		dBManager.executeUpdate(executeSql);
	}

	/** 表的启用操作 */
	public void effective(String ids, String tableName) throws Exception {
		if (ids == null || "".equals(ids)) {
			return;
		}
		/** 根据命名规则利用表名获取模型主键 */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母小写 */
		modelName = (new StringBuilder()).append(
				Character.toLowerCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 将表名和模型插入到执行语句中 */
		String executeSql = "update " + tableName + " set delFlg = '启用' where  "
				+ modelName + "Id" + " in (" + ids + ")";
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		dBManager.executeUpdate(executeSql);
		dBManager.closeConnection();
	}
	
	/** 表的停用操作 */
	public void invalid(String ids, String tableName) throws Exception {
		if (ids == null || "".equals(ids)) {
			return;
		}
		/** 根据命名规则利用表名获取模型主键 */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母小写 */
		modelName = (new StringBuilder()).append(
				Character.toLowerCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 将表名和模型插入到执行语句中 */
		String executeSql = "update " + tableName + " set delFlg = '停用' where  "
				+ modelName + "Id" + " in (" + ids + ")";
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		dBManager.executeUpdate(executeSql);
		dBManager.closeConnection();
	}

	/** 表的删除操作 */
	public void delete(String ids, String tableName) throws Exception {
		if (ids == null || "".equals(ids)) {
			return;
		}
		/** 根据命名规则利用表名获取模型主键 */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母小写 */
		modelName = (new StringBuilder()).append(
				Character.toLowerCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 将表名和模型插入到执行语句中 */
		String executeSql = "delete from " + tableName + " where " + modelName
				+ "Id" + " in (" + ids + ")";
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		dBManager.executeUpdate(executeSql);
		dBManager.closeConnection();
	}
	
	/** 表的更新操作 */
	public void update(Object object) throws Exception {
		if (object == null) {
			return;
		}
		/** 根据命名规则获取表的名称 */
		String tableName = object.getClass().getSimpleName();
		/** 通过表名获取模型名称（因为命名都是有规则的） */
		String modelName = tableName.substring(tableName.indexOf("_") + 1,
				tableName.length());
		/** 首字母大写 */
		modelName = (new StringBuilder()).append(
				Character.toUpperCase(modelName.charAt(0))).append(
				modelName.substring(1)).toString();
		/** 通过modelName实例化model */
		TemplateBeen templateBeen = (TemplateBeen) object;
		/** 更新的列表集合 */
		List<String> updateKeyList = new ArrayList<String>();
		/** 更新的列表值的集合 */
		Map<String, String> updateValueMap = new HashMap<String, String>();
		/** 更新条件的名称 */
		String conditionKey = "get" + modelName + "Id";
		/** 更新条件的值 */
		String conditionValue = "";
		/** 遍历object的方法 */
		for (Method method : templateBeen.getClass().getMethods()) {
			/** 剔除getClass和实例化后model的主键 */
			if (method.getName().startsWith("get")
					&& !"getClass".equals(method.getName())) {

				/** 判断是否为获取更新条件 */
				if (method.getName().contains(conditionKey)) {
					conditionValue = (String) templateBeen.getClass()
							.getMethod(method.getName()).invoke(templateBeen);
					continue;
				}
				/** 截取get后面的字母 */
				String formatName = method.getName().substring(3,
						method.getName().length());
				updateKeyList.add(formatName);
				updateValueMap.put(formatName, (String) templateBeen.getClass()
						.getMethod(method.getName()).invoke(templateBeen));
			}
		}
		/** 将 insertKey 集合的数据插入到执行语句中 */
		String executeSql = " update  " + tableName + " set ";
		for (String updateKey : updateKeyList) {
			executeSql += updateKey + " = \"" + updateValueMap.get(updateKey)
					+ "\",";
		}
		/** 剔除insertKey末端插入到执行语句中的的逗号（,） */
		executeSql = executeSql.substring(0, executeSql.length() - 1);
		/** 将 insertValue 集合的数据插入到执行语句中 */
		executeSql += " where " + modelName + "Id" + " like '" + conditionValue
				+ "'";

		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		dBManager.executeUpdate(executeSql);
		dBManager.closeConnection();
	}

	/** 表的查询操作 */
	public Map<String, Object> query(ConditionDto conditionDto,
			PageDto pageDto, String tableName) throws Exception {
		/** 将 conditionDto 集合的数据插入到执行语句中 */
		String executeSql = "select * from " + tableName;
		boolean emptyCondition = true;
		if (conditionDto != null) {
			if(!"".equals(conditionDto.getConditionValue())&&
			   !"".equals(conditionDto.getConditionFiled())&&
			   !"".equals(conditionDto.getConditionConditions())){
					if(conditionDto.getConditionConditions().contains("like")){
						executeSql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " '%"
						  + conditionDto.getConditionValue()+"%'";
					}else{
						executeSql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " '"
						  + conditionDto.getConditionValue()+"'";
					}
			}
			if(!"".equals(conditionDto.getOrderFiled())&&
			   !"".equals(conditionDto.getOrderValue())){
					executeSql += " order by " + conditionDto.getOrderFiled() + " "
								  + conditionDto.getOrderValue();
					emptyCondition = false;
			}
		}
		if(emptyCondition){
			String orderFiled = tableName.substring(tableName.indexOf("_")+1)+"Name";
			executeSql += " order by "+orderFiled+" asc";
		}
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = null;
		queryResultSet = dBManager.executeQuery(executeSql);
		queryResultSet.last();
		/** 获得查询后的列集（单条记录的列集） */
		ResultSetMetaData resultSetMetaData = queryResultSet.getMetaData();
		/** 获得列集的列个数 */
		int columnCount = resultSetMetaData.getColumnCount();
		/** 将列明暂存到columnNameMap中 */
		Map<Integer, String> columnNameMap = new HashMap<Integer, String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNameMap.put(i, resultSetMetaData.getColumnName(i));
		}
		/** 获取查询的总记录数 */
		int rowCount = queryResultSet.getRow();
		/** 更新page的总记录数 */
		if (pageDto == null) {
			pageDto = new PageDto();
		}
		pageDto.setTotalRecord(rowCount);
		/** 判断总记录数是否为空，如果为空就直接返回空数据 */
		if (pageDto.getTotalRecord() < 1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Constant.TOTALCOUNT,0);
			map.put(Constant.BEENLIST, new ArrayList<TemplateBeen>());
			return map;
		}
		/** 设置记录查询的位置 */
		if(pageDto.getStartRecord()<1){
			queryResultSet.beforeFirst();
		}else{
			queryResultSet.absolute(pageDto.getStartRecord());
		}
		/** 将查询的所有记录数暂存到 list */
		List<Map<String, String>> queryResultSetList = new ArrayList<Map<String, String>>();
		int recordCount = 0;
		while (++recordCount <= pageDto.getPerPage() && queryResultSet.next()) {
			/** 遍历所有的记录 */
			Map<String, String> tempMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {
				tempMap.put(columnNameMap.get(i), queryResultSet
						.getString(columnNameMap.get(i)));
			}
			queryResultSetList.add(tempMap);
		}
		queryResultSet.close();
		dBManager.closeConnection();

		Class<?> obj = Class.forName(Constant.QUERYPRIFIX
				+ tableName);
		List<TemplateBeen> templateBeenList = new ArrayList<TemplateBeen>();
		for (Map<String, String> tempMap : queryResultSetList) {
			/** 实例化 templateBeen */
			TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
			/** 遍历object的方法 */
			for (Method method : templateBeen.getClass().getMethods()) {
				if (method.getName().startsWith("set")) {
					/** 截取set后面的字母 */
					String formatName = method.getName().substring(3,
							method.getName().length());
					/** 首字母小写 */
					formatName = (new StringBuilder()).append(
							Character.toLowerCase(formatName.charAt(0)))
							.append(formatName.substring(1)).toString();
					templateBeen.getClass().getMethod(method.getName(),
							String.class).invoke(templateBeen,
							tempMap.get(formatName));
				}
			}
			templateBeenList.add(templateBeen);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTALCOUNT, pageDto.getTotalRecord());
		map.put(Constant.BEENLIST, templateBeenList);
		return map;
	}
	
	/** 表的联合查询操作 */
	public Map<String, Object> combinedQuery(ConditionDto conditionDto,
			PageDto pageDto, String dtoName,String sql) throws Exception {
		/** 将 conditionDto 集合的数据插入到执行语句中 */
		boolean emptyCondition = true;
		if (conditionDto != null) {
			if(!"".equals(conditionDto.getConditionValue())&&
			   !"".equals(conditionDto.getConditionFiled())&&
			   !"".equals(conditionDto.getConditionConditions())){
					if(conditionDto.getConditionConditions().contains("like")){
						sql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \"%"
						  + conditionDto.getConditionValue()+"%\"";
					}else{
						sql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \""
						  + conditionDto.getConditionValue()+"\"";
					}
					emptyCondition = false;
			}
			if(!"".equals(conditionDto.getOrderFiled())&&
			   !"".equals(conditionDto.getOrderValue())){
					sql += " order by " + conditionDto.getOrderFiled() + " "
								  + conditionDto.getOrderValue();
					emptyCondition = false;
			}
			if(emptyCondition){
				String tableName = dtoName.substring(0,dtoName.indexOf("Dto"));
				String orderFiled = tableName.substring(tableName.indexOf("_")+1)+"Name";
				sql += " order by "+orderFiled+" asc";
			}
		}
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = null;
		queryResultSet = dBManager.executeQuery(sql);
		queryResultSet.last();
		/** 获得查询后的列集（单条记录的列集） */
		ResultSetMetaData resultSetMetaData = queryResultSet.getMetaData();
		/** 获得列集的列个数 */
		int columnCount = resultSetMetaData.getColumnCount();
		/** 将列明暂存到columnNameMap中 */
		Map<Integer, String> columnNameMap = new HashMap<Integer, String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNameMap.put(i, resultSetMetaData.getColumnName(i));
		}
		/** 获取查询的总记录数 */
		int rowCount = queryResultSet.getRow();
		/** 更新page的总记录数 */
		if (pageDto == null) {
			pageDto = new PageDto();
		}
		pageDto.setTotalRecord(rowCount);
		/** 判断总记录数是否为空，如果为空就直接返回空数据 */
		if (pageDto.getTotalRecord() < 1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Constant.TOTALCOUNT,0);
			map.put(Constant.BEENLIST, new ArrayList<TemplateBeen>());
			return map;
		}
		/** 设置记录查询的位置 */
		if(pageDto.getStartRecord()<1){
			queryResultSet.beforeFirst();
		}else{
			queryResultSet.absolute(pageDto.getStartRecord());
		}
		/** 将查询的所有记录数暂存到 list */
		List<Map<String, String>> queryResultSetList = new ArrayList<Map<String, String>>();
		int recordCount = 0;
		while (++recordCount <= pageDto.getPerPage() && queryResultSet.next()) {
			/** 遍历所有的记录 */
			Map<String, String> tempMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {
				tempMap.put(columnNameMap.get(i), queryResultSet
						.getString(columnNameMap.get(i)));
			}
			queryResultSetList.add(tempMap);
		}
		queryResultSet.close();
		dBManager.closeConnection();

		Class<?> obj = Class.forName(Constant.QUERYPRIFIX
				+ dtoName);
		List<TemplateBeen> templateBeenList = new ArrayList<TemplateBeen>();
		for (Map<String, String> tempMap : queryResultSetList) {
			/** 实例化 templateBeen */
			TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
			/** 遍历object的方法 */
			for (Method method : templateBeen.getClass().getMethods()) {
				if (method.getName().startsWith("set")) {
					/** 截取set后面的字母 */
					String formatName = method.getName().substring(3,
							method.getName().length());
					/** 首字母小写 */
					formatName = (new StringBuilder()).append(
							Character.toLowerCase(formatName.charAt(0)))
							.append(formatName.substring(1)).toString();
					templateBeen.getClass().getMethod(method.getName(),
							String.class).invoke(templateBeen,
							tempMap.get(formatName));
				}
			}
			templateBeenList.add(templateBeen);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTALCOUNT, pageDto.getTotalRecord());
		map.put(Constant.BEENLIST, templateBeenList);
		return map;
	}

	public Map<String, Object> query(ConditionDto conditionDto,String tableName) throws Exception {
		/** 将 conditionDto 集合的数据插入到执行语句中 */
		String executeSql = "select * from " + tableName;
		boolean emptyCondition = true;
		if (conditionDto != null) {
			if(!"".equals(conditionDto.getConditionValue())&&
			   !"".equals(conditionDto.getConditionFiled())&&
			   !"".equals(conditionDto.getConditionConditions())){
					if(conditionDto.getConditionConditions().contains("like")){
						executeSql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \"%"
						  + conditionDto.getConditionValue()+"%\"";
					}else if(conditionDto.getConditionConditions().contains("in")){
						executeSql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + "("
						  + conditionDto.getConditionValue()+")";
					}else{
						executeSql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \""
						  + conditionDto.getConditionValue()+"\"";
					}
					emptyCondition = false;
			}
			if(!"".equals(conditionDto.getOrderFiled())&&
			   !"".equals(conditionDto.getOrderValue())){
					executeSql += " order by " + conditionDto.getOrderFiled() + " "
								  + conditionDto.getOrderValue();
					emptyCondition = false;
			}
		}
		if(emptyCondition){
			String orderFiled = tableName.substring(tableName.indexOf("_")+1)+"Name";
			executeSql += " order by "+orderFiled+" asc";
		}
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = null;
		queryResultSet = dBManager.executeQuery(executeSql);
		queryResultSet.last();
		/** 获得查询后的列集（单条记录的列集） */
		ResultSetMetaData resultSetMetaData = queryResultSet.getMetaData();
		/** 获得列集的列个数 */
		int columnCount = resultSetMetaData.getColumnCount();
		/** 将列明暂存到columnNameMap中 */
		Map<Integer, String> columnNameMap = new HashMap<Integer, String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNameMap.put(i, resultSetMetaData.getColumnName(i));
		}
		/** 获取查询的总记录数 */
		int rowCount = queryResultSet.getRow();
		/** 判断总记录数是否为空，如果为空就直接返回空数据 */
		if (rowCount < 1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Constant.TOTALCOUNT,0);
			map.put(Constant.BEENLIST, new ArrayList<TemplateBeen>());
			return map;
		}
		queryResultSet.beforeFirst();
		/** 将查询的所有记录数暂存到 list */
		List<Map<String, String>> queryResultSetList = new ArrayList<Map<String, String>>();
		while (queryResultSet.next()) {
			/** 遍历所有的记录 */
			Map<String, String> tempMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {
				tempMap.put(columnNameMap.get(i), queryResultSet
						.getString(columnNameMap.get(i)));
			}
			queryResultSetList.add(tempMap);
		}
		queryResultSet.close();
		dBManager.closeConnection();

		Class<?> obj = Class.forName(Constant.QUERYPRIFIX
				+ tableName);
		List<TemplateBeen> templateBeenList = new ArrayList<TemplateBeen>();
		for (Map<String, String> tempMap : queryResultSetList) {
			/** 实例化 templateBeen */
			TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
			/** 遍历object的方法 */
			for (Method method : templateBeen.getClass().getMethods()) {
				if (method.getName().startsWith("set")) {
					/** 截取set后面的字母 */
					String formatName = method.getName().substring(3,
							method.getName().length());
					/** 首字母小写 */
					formatName = (new StringBuilder()).append(
							Character.toLowerCase(formatName.charAt(0)))
							.append(formatName.substring(1)).toString();
					templateBeen.getClass().getMethod(method.getName(),
							String.class).invoke(templateBeen,
							tempMap.get(formatName));
				}
			}
			templateBeenList.add(templateBeen);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTALCOUNT,rowCount);
		map.put(Constant.BEENLIST, templateBeenList);
		return map;
	}
	
	public Map<String, Object> combinedQuery(ConditionDto conditionDto,
							   String dtoName,String sql) throws Exception {
		/** 将 conditionDto 集合的数据插入到执行语句中 */
		boolean emptyCondition = true;
		if (conditionDto != null) {
			if(!"".equals(conditionDto.getConditionValue())&&
			   !"".equals(conditionDto.getConditionFiled())&&
			   !"".equals(conditionDto.getConditionConditions())){
					if(conditionDto.getConditionConditions().contains("like")){
						sql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \"%"
						  + conditionDto.getConditionValue()+"%\"";
					}else{
						sql += " where " + conditionDto.getConditionFiled() + " "
						  + conditionDto.getConditionConditions() + " \""
						  + conditionDto.getConditionValue()+"\"";
					}
					emptyCondition = false;
			}
			if(!"".equals(conditionDto.getOrderFiled())&&
			   !"".equals(conditionDto.getOrderValue())){
					sql += " order by " + conditionDto.getOrderFiled() + " "
								  + conditionDto.getOrderValue();
					emptyCondition = false;
			}
			if(emptyCondition){
				String tableName = dtoName.substring(0,dtoName.indexOf("Dto"));
				String orderFiled = tableName.substring(tableName.indexOf("_")+1)+"Name";
				sql += " order by "+orderFiled+" asc";
			}
		}
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = null;
		queryResultSet = dBManager.executeQuery(sql);
		queryResultSet.last();
		/** 获得查询后的列集（单条记录的列集） */
		ResultSetMetaData resultSetMetaData = queryResultSet.getMetaData();
		/** 获得列集的列个数 */
		int columnCount = resultSetMetaData.getColumnCount();
		/** 将列明暂存到columnNameMap中 */
		Map<Integer, String> columnNameMap = new HashMap<Integer, String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNameMap.put(i, resultSetMetaData.getColumnName(i));
		}
		/** 获取查询的总记录数 */
		int rowCount = queryResultSet.getRow();
		/** 判断总记录数是否为空，如果为空就直接返回空数据 */
		if (rowCount < 1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Constant.TOTALCOUNT,0);
			map.put(Constant.BEENLIST, new ArrayList<TemplateBeen>());
			return map;
		}
		queryResultSet.beforeFirst();
		/** 将查询的所有记录数暂存到 list */
		List<Map<String, String>> queryResultSetList = new ArrayList<Map<String, String>>();
		while (queryResultSet.next()) {
			/** 遍历所有的记录 */
			Map<String, String> tempMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {
				tempMap.put(columnNameMap.get(i), queryResultSet
						.getString(columnNameMap.get(i)));
			}
			queryResultSetList.add(tempMap);
		}
		queryResultSet.close();
		dBManager.closeConnection();

		Class<?> obj = Class.forName(Constant.QUERYPRIFIX
				+ dtoName);
		List<TemplateBeen> templateBeenList = new ArrayList<TemplateBeen>();
		for (Map<String, String> tempMap : queryResultSetList) {
			/** 实例化 templateBeen */
			TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
			/** 遍历object的方法 */
			for (Method method : templateBeen.getClass().getMethods()) {
				if (method.getName().startsWith("set")) {
					/** 截取set后面的字母 */
					String formatName = method.getName().substring(3,
							method.getName().length());
					/** 首字母小写 */
					formatName = (new StringBuilder()).append(
							Character.toLowerCase(formatName.charAt(0)))
							.append(formatName.substring(1)).toString();
					templateBeen.getClass().getMethod(method.getName(),
							String.class).invoke(templateBeen,
							tempMap.get(formatName));
				}
			}
			templateBeenList.add(templateBeen);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTALCOUNT,rowCount);
		map.put(Constant.BEENLIST, templateBeenList);
		return map;
	}
	public Map<String, Object> query(String tableName) throws Exception {
		String executeSql = "select * from " + tableName;
		String orderFiled = tableName.substring(tableName.indexOf("_")+1)+"Name";
		executeSql += " order by "+orderFiled+" asc ";
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = null;
		queryResultSet = dBManager.executeQuery(executeSql);
		/** 获得查询后的列集（单条记录的列集） */
		ResultSetMetaData resultSetMetaData = queryResultSet.getMetaData();
		/** 获得列集的列个数 */
		int columnCount = resultSetMetaData.getColumnCount();
		/** 将列明暂存到columnNameMap中 */
		Map<Integer, String> columnNameMap = new HashMap<Integer, String>();
		for (int i = 1; i <= columnCount; i++) {
			columnNameMap.put(i, resultSetMetaData.getColumnName(i));
		}
		/** 将查询的所有记录数暂存到 list */
		List<Map<String, String>> queryResultSetList = new ArrayList<Map<String, String>>();
		while (queryResultSet.next()) {
			/** 遍历所有的记录 */
			Map<String, String> tempMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {
				tempMap.put(columnNameMap.get(i), queryResultSet
						.getString(columnNameMap.get(i)));
			}
			queryResultSetList.add(tempMap);
		}
		queryResultSet.close();
		dBManager.closeConnection();

		Class<?> obj = Class.forName(Constant.QUERYPRIFIX
				+ tableName);
		List<TemplateBeen> templateBeenList = new ArrayList<TemplateBeen>();
		for (Map<String, String> tempMap : queryResultSetList) {
			/** 实例化 templateBeen */
			TemplateBeen templateBeen = (TemplateBeen) obj.newInstance();
			/** 遍历object的方法 */
			for (Method method : templateBeen.getClass().getMethods()) {
				if (method.getName().startsWith("set")) {
					/** 截取set后面的字母 */
					String formatName = method.getName().substring(3,
							method.getName().length());
					/** 首字母小写 */
					formatName = (new StringBuilder()).append(
							Character.toLowerCase(formatName.charAt(0)))
							.append(formatName.substring(1)).toString();
					templateBeen.getClass().getMethod(method.getName(),
							String.class).invoke(templateBeen,
							tempMap.get(formatName));
				}
			}
			templateBeenList.add(templateBeen);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.BEENLIST, templateBeenList);
		return map;
	}
	
	public int queryForCount(String sql) throws Exception {
		if (sql == null || "".equals(sql)) {
			return 0;
		}
		/** 建立数据库连接 */
		DBManager dBManager = new DBManager();
		dBManager.openConnection();
		ResultSet queryResultSet = dBManager.executeQuery(sql);
		queryResultSet.last();
		Object obj = queryResultSet.getString(1);
		int count =0;
		if(obj != null&&!"".equals(obj)){
			count = Integer.valueOf(queryResultSet.getString(1));
		}
		queryResultSet.close();
		dBManager.closeConnection();
		return count;
	}
}
