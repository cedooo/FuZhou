package zdy.model;



/**
 * @function Dto--条件查询
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class ConditionDto extends TemplateBeen{
	/** 条件字段 */
	private String conditionFiled="";
	/** 条件选择 */
	private String conditionConditions="";
	/** 条件值 */
	private String conditionValue="";
	/** 排序字段 */
	private String orderFiled="";
	/** 排序值 */
	private String orderValue="";
	/**
	 * @return the conditionFiled
	 */
	public String getConditionFiled() {
		return conditionFiled;
	}
	/**
	 * @param conditionFiled the conditionFiled to set
	 */
	public void setConditionFiled(String conditionFiled) {
		this.conditionFiled = conditionFiled;
	}
	/**
	 * @return the conditionConditions
	 */
	public String getConditionConditions() {
		return conditionConditions;
	}
	/**
	 * @param conditionConditions the conditionConditions to set
	 */
	public void setConditionConditions(String conditionConditions) {
		this.conditionConditions = conditionConditions;
	}
	/**
	 * @return the conditionValue
	 */
	public String getConditionValue() {
		return conditionValue;
	}
	/**
	 * @param conditionValue the conditionValue to set
	 */
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	/**
	 * @return the orderFiled
	 */
	public String getOrderFiled() {
		return orderFiled;
	}
	/**
	 * @param orderFiled the orderFiled to set
	 */
	public void setOrderFiled(String orderFiled) {
		this.orderFiled = orderFiled;
	}
	/**
	 * @return the orderValue
	 */
	public String getOrderValue() {
		return orderValue;
	}
	/**
	 * @param orderValue the orderValue to set
	 */
	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}
	
	
}
