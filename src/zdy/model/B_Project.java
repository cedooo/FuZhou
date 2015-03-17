package zdy.model;

/**
 * @function 基础--项目表
 * @author zhangdengyuan
 * @createDate 2014-12-02
 * @lastUpdateDate 2014-12-02
 * @version 1.0
 */
public class B_Project extends TemplateBeen {
	/** 业务主键 */
	private String projectId;
	/** 项目名称 */
	private String projectName;
	/** 项目编号 */
	private String projectNumber;
	/** 项目负责人 */
	private String connactName;
	/** 负责人联系电话 */
	private String connactNumber;
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectNumber
	 */
	public String getProjectNumber() {
		return projectNumber;
	}
	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	/**
	 * @return the connactName
	 */
	public String getConnactName() {
		return connactName;
	}
	/**
	 * @param connactName the connactName to set
	 */
	public void setConnactName(String connactName) {
		this.connactName = connactName;
	}
	/**
	 * @return the connactNumber
	 */
	public String getConnactNumber() {
		return connactNumber;
	}
	/**
	 * @param connactNumber the connactNumber to set
	 */
	public void setConnactNumber(String connactNumber) {
		this.connactNumber = connactNumber;
	}

}
