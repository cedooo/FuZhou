package zdy.common;

/**
 * @function 常量表
 * @author zdy
 * @createDate 2014-07-01
 * @lastUpdateDate 2015-03-12
 * @version 2.1
 */
public final class Constant {
	/** 操作结果 */
	public static final String RESULT = "result";
	/** 成功操作 */
	public static final String SUCCESS = "success";
	/** 失败操作 */
	public static final String FAILED = "failed";
	/** 备注 */
	public static final String DESCP = "descp";
	/** 删除标识 */
	public static final String DELFLG = "delFlg";
	/** 创建时间 */
	public static final String CREATETIME = "createTime";
	/** 最后一次修改时间 */
	public static final String LASTUPDATETIME = "lastUpdateTime";
	/** 实体been */
	public static final String BEEN = "been";
	/** 实体been的集合 */
	public static final String BEENLIST = "beenList";
	/** 总记录数 */
	public static final String TOTALCOUNT = "totalCount";
	/** 返回页 */
	public static final String BACKPAGE = "backPage";
	
	/***************************** 我是分割线 ************************************/
	public static final String IDS = "ids"; 
	public static final String CONDITIONDTO = "ConditionDto";
	public static final String PAGEDTO = "PageDto";
	/** 模型类名和对应的表 */
	public static final String A_CABLE = "A_Cable";
	public static final String A_FIBERCORENUMBER = "A_FiberCoreNumber";
	public static final String A_CARRIER = "A_Carrier";
	public static final String A_GPRS = "A_Gprs";
	public static final String A_OLT = "A_Olt";
	public static final String A_ONU = "A_Onu";
	public static final String A_SITE = "A_Site";
	public static final String A_THREELAYERSWITCH = "A_ThreeLayerSwitch";
	public static final String A_TWOLAYERSWITCH = "A_TwoLayerSwitch";
	public static final String B_AREA = "B_Area";
	public static final String B_CONSTRUCTIONUNIT = "B_ConstructionUnit";
	public static final String B_MANUFACTURERS = "B_Manufacturers";
	public static final String B_FIBER = "B_Fiber";
	public static final String B_PROJECT = "B_Project";
	/** 模型dto */
	public static final String A_CABLEDTO = "A_CableDto";
	public static final String A_FIBERCORENUMBERDTO = "A_FiberCoreNumberDto";
	public static final String A_CARRIERDTO = "A_CarrierDto";
	public static final String A_GPRSDTO = "A_GprsDto";
	public static final String A_OLTDTO = "A_OltDto";
	public static final String A_ONUDTO = "A_OnuDto";
	public static final String A_SITEDTO = "A_SiteDto";
	public static final String A_THREELAYERSWITCHDTO = "A_ThreeLayerSwitchDto";
	public static final String A_TWOLAYERSWITCHDTO = "A_TwoLayerSwitchDto";
	/***************************** 我是分割线 ************************************/
	/** 连接设备类型 */
	public static final String TYPE_CONNECTION_GPRS = "gprs";
	public static final String TYPE_CONNECTION_OLT = "olt";
	public static final String TYPE_CONNECTION_ONU = "onu";
	public static final String TYPE_CONNECTION_CARRIER = "载波";
	public static final String TYPE_CONNECTION_TWOLAYERSWITCH = "二层交换机";
	public static final String TYPE_CONNECTION_THREELAYERSWITCH = "三层交换机";
	/***************************** 我是分割线 ************************************/
	/** manager.xml的位置 */
	public static  String MANAGERPATH = "";
	/** model的前缀 */
	public static  String QUERYPRIFIX = "zdy.model.";
	/** Excel报表导出位置 */
	public static final String EXPORTEXCEL = "exportExcel";
	/** 导出的位置 */
	public static  String EXPORTEXCELDIR = "";
	/** 导入的位置 */
	public static  String IMPORTEXCELDIR = "";
	/** 请求地址的结尾 */
	public static final String REQUESTPARM = ".zdy";
}
