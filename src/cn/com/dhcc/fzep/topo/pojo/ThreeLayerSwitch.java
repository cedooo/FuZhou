package cn.com.dhcc.fzep.topo.pojo;

/**
 * @author cedo
 *
 */
public class ThreeLayerSwitch extends Equipment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8506146118904047987L;
	//private String switchId = null;
	private String threeLayerSwitchId = null;
	private String siteId = null;
	private String projectId = null;
	private String installationSite = null;
	//private String switchName = null;
	private String threeLayerSwitchName = null;
	//private String manufacturers = null;
	private String manufacturersId = null;
	private String typeSpecification = null;
	//private String constructionUnit = null;
	private String constructionUnitId = null;
	private String runTime = null;
	private String portNumber = null;
	private String flow = null;
	private String vlanId = null;
	private String ip = null;
	private String vlanDescp = null;
	private String delFlg = null;
	private String descp = null;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getInstallationSite() {
		return installationSite;
	}

	public void setInstallationSite(String installationSite) {
		this.installationSite = installationSite;
	}


	public String getManufacturersId() {
		return manufacturersId;
	}

	public void setManufacturersId(String manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	public String getTypeSpecification() {
		return typeSpecification;
	}

	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}


	public String getConstructionUnitId() {
		return constructionUnitId;
	}

	public void setConstructionUnitId(String constructionUnitId) {
		this.constructionUnitId = constructionUnitId;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getVlanDescp() {
		return vlanDescp;
	}

	public void setVlanDescp(String vlanDescp) {
		this.vlanDescp = vlanDescp;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getThreeLayerSwitchId() {
		return threeLayerSwitchId;
	}

	public void setThreeLayerSwitchId(String threeLayerSwitchId) {
		this.threeLayerSwitchId = threeLayerSwitchId;
	}

	public String getThreeLayerSwitchName() {
		return threeLayerSwitchName;
	}

	public void setThreeLayerSwitchName(String threeLayerSwitchName) {
		this.threeLayerSwitchName = threeLayerSwitchName;
	}

	@Override
	public String toString() {
		return "ThreeLayerSwitch [threeLayerSwitchId=" + threeLayerSwitchId
				+ ", siteId=" + siteId + ", projectId=" + projectId
				+ ", installationSite=" + installationSite
				+ ", threeLayerSwitchName=" + threeLayerSwitchName
				+ ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", portNumber=" + portNumber + ", flow=" + flow
				+ ", vlanId=" + vlanId + ", ip=" + ip + ", vlanDescp="
				+ vlanDescp + ", delFlg=" + delFlg + ", descp=" + descp + "]";
	}



}
