package zdy.dao;

import java.util.Map;

import zdy.model.ConditionDto;
import zdy.model.PageDto;

/**
 * @TemlpateDao 数据操作模板
 * @author zhangdengyuan
 * @createDate 2014-12-05
 * @lastUpdateDate 2014-03-12
 * @version 1.0
 */
public interface TemplateDao {
	/**
	 * 事务操作功能
	 * 
	 * @param String sql（需要被执行的sql语句）
	 * @param DBManager dBManager（数据库连接实例）
	 */
	public void transcationExecute(String sql, DBManager dBManager)
			throws Exception;
	/**
	 * 增加功能
	 * 
	 * @param Object object（需要更新的模型）
	 */
	public void add(Object object) throws Exception;
	/**
	 * 事务增加功能(不包含Id)
	 * 
	 * @param Object object（需要更新的模型）
	 * @param DBManager dBManager（数据库连接实例）
	 */
	public void transcationAdd(Object object, DBManager dBManager)
			throws Exception;
	/**
	 * 事务增加功能(包含Id)
	 * 
	 * @param Object object（需要更新的模型）
	 * @param DBManager dBManager（数据库连接实例）
	 */
	public void transcationAddIncludeId(Object object, DBManager dBManager)
			throws Exception;
	/**
	 * 启用功能（可批量启用）
	 * 
	 * @param String ids（启用的表主键集合）
	 * @param String tableName（表名）
	 */
	public void effective(String ids, String tableName) throws Exception;
	/**
	 * 停止功能（可批量停止）
	 * 
	 * @param String ids（停止的表主键集合）
	 * @param String tableName（表名）
	 */
	public void invalid(String ids, String tableName) throws Exception;
	/**
	 * 删除功能（可批量删除）
	 * 
	 * @param String ids（查询的表主键集合）
	 * @param String tableName（表名）
	 */
	public void delete(String ids, String tableName) throws Exception;

	/**
	 * 事务更新功能(不包含Id)
	 * 
	 * @param Object object（需要更新的模型）
	 * @param DBManager dBManager（数据库连接实例）
	 */
	public void transcationUpdate(Object object, DBManager dBManager)
			throws Exception;
	/**
	 * 更新功能
	 * 
	 * @param Object object（需要更新的模型）
	 */
	public void update(Object object) throws Exception;
	/**
	 * 分页查询功能
	 * 
	 * @param ConditionDto conditionDto（查询条件Dto）
	 * @param PageDto pageDto（分页Dto）
	 * @param String tableName（表名）
	 * @return Map<String, Object>（模型集合列表,beenList和Page）
	 */
	public Map<String, Object> query(ConditionDto conditionDto,
			PageDto pageDto, String tableName) throws Exception;
	/**
	 * 分页联合查询功能
	 * 
	 * @param ConditionDto conditionDto（查询条件Dto）
	 * @param PageDto pageDto（分页Dto）
	 * @param String dtoName（模型Dto）
	 * @param String sql（联合查询的sql语句）
	 * @return Map<String, Object>（模型集合列表,beenList和Page）
	 */
	public Map<String, Object> combinedQuery(ConditionDto conditionDto,
			PageDto pageDto, String dtoName, String sql) throws Exception;
	/**
	 * 查询功能(不分页)
	 * 
	 * @param ConditionDto conditionDto（查询条件Dto）
	 * @param String tableName（表名）
	 * @return Map<String, Object>（模型集合列表,beenList和Page）
	 */
	public Map<String, Object> query(ConditionDto conditionDto, String tableName)
			throws Exception;
	/**
	 * 查询功能(不分页)
	 * 
	 * @param ConditionDto conditionDto（查询条件Dto）
	 * @param String dtoName（模型Dto）
	 * @param String sql（联合查询的sql语句）
	 * @return Map<String, Object>（模型集合列表,beenList和Page）
	 */
	public Map<String, Object> combinedQuery(ConditionDto conditionDto,
			String dtoName, String sql) throws Exception;
	/**
	 * 查询功能(不分页)
	 * 
	 * @param String tableName（表名）
	 * @return Map<String, Object>（模型集合列表,beenList和Page）
	 */
	public Map<String, Object> query(String tableName) throws Exception;
	/**
	 * 统计查询(不分页)
	 * 
	 * @param String sql（要统计查询的sql语句）
	 * @return int（符合的记录数）
	 */
	public int queryForCount(String sql) throws Exception;
}
