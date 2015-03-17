package zdy.common;

/**
 * @function  消息集合
 * @author zdy
 * @createDate 2014-06-17
 * @lastUpdateDate 2015-03-12
 * @version 2.1
 */
public class Message {

	/** 全局消息-消息集合 */
	public static final String SUCCESSMESSAGE = "successMessage";
	public static final String ERRORMESSAGE = "errorMessage";
	public static final String FORBIDMESSAGE = "forbidMessage";
	public static final String EXCEPTIONMESSAGE = "exceptionMessage";
	/** 拦截器-信息集合 */
	public static final String ERRORMESSAGE_CLASSHANDLER_NOTFINALHANDLER = "ClassHandler不是最后一个拦截器";
	/** 功能信息集合 */
	public static final String ERRORMESSAGE_COMBOAREAQUERY  = "success:false,message:'操作结果：所属区域下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOSITEQUERY  = "success:false,message:'操作结果：所属站点下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOCABLEQUERY  = "success:false,message:'操作结果：所属光缆下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOCONSTRUCTIONUNITQUERY  = "success:false,message:'操作结果：所属施工单位下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOMANUFACTURERSQUERY  = "success:false,message:'操作结果：所属厂家下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOFIBERQUERY  = "success:false,message:'操作结果：所属光纤下拉框列表查询失败！'";
	public static final String ERRORMESSAGE_COMBOPROJECTQUERY  = "success:false,message:'操作结果：所属项目下拉框列表查询失败！'";
	public static final String SUCCESSMESSAGE_QUERY     = "{success:true,message:'操作结果：查询成功！'}";
	public static final String ERRORMESSAGE_QUERY       = "success:false,message:'操作结果：查询失败！'";
	public static final String SUCCESSMESSAGE_ADD       = "{success:true,message:'操作结果：添加成功！'}";
	public static final String ERRORMESSAGE_ADD         = "success:false,message:'操作结果：添加失败！'";
	public static final String SUCCESSMESSAGE_EFFECTIVE = "{success:true,message:'操作结果：启用成功！'}";
	public static final String ERRORMESSAGE_EFFECTIVE   = "success:false,message:'操作结果：启用失败！'";
	public static final String SUCCESSMESSAGE_INVALID   = "{success:true,message:'操作结果：停用成功！'}";
	public static final String ERRORMESSAGE_INVALID     = "success:false,message:'操作结果：停用失败！'";
	public static final String SUCCESSMESSAGE_DELETE    = "{success:true,message:'操作结果：删除成功！'}";
	public static final String ERRORMESSAGE_DELETE      = "success:false,message:'操作结果：删除失败！'";
	public static final String SUCCESSMESSAGE_UPDATE    = "{success:true,message:'操作结果：更新成功！'}";
	public static final String ERRORMESSAGE_UPDATE      = "success:false,message:'操作结果：更新失败！'";
	public static final String SUCCESSMESSAGE_EXPORT    = "success:true,message:'操作结果：导出成功！'";
	public static final String ERRORMESSAGE_EXPORT      = "success:false,message:'操作结果：导出失败！'";
	public static final String SUCCESSMESSAGE_DOWNLOAD  = "success:true,message:'操作结果：下载成功！'";
	public static final String ERRORMESSAGE_DOWNLOAD    = "success:false,message:'操作结果：下载失败！'";
	public static final String SUCCESSMESSAGE_IMPORT    = "{success:true,message:'操作结果：上传成功！'}";
	public static final String ERRORMESSAGE_IMPORT     = "success:false,message:'操作结果：上传失败！'";
}
