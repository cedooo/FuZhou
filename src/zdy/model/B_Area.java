package zdy.model;

/**
 * @function 基础--区域表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class B_Area extends TemplateBeen{
	/** 业务主键 */
	private String areaId;
	/** 区域名称 */
	private String areaName;
	/** 区域负责人 */
	private String connactName;
	/** 负责人联系方式 */
	private String connactNumber;
	
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getConnactName() {
		return connactName;
	}
	public void setConnactName(String connactName) {
		this.connactName = connactName;
	}
	public String getConnactNumber() {
		return connactNumber;
	}
	public void setConnactNumber(String connactNumber) {
		this.connactNumber = connactNumber;
	}
}
