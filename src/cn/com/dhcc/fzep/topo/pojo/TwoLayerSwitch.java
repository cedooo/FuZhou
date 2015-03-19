package cn.com.dhcc.fzep.topo.pojo;

/**
 * @author cedo
 *
 */
public class TwoLayerSwitch extends Equipment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1396193599301304488L;
	private String twoLayerSwitchId = null;
	private String twoLayerSwitchName = null;
	private String siteId = null;
	private String projectId = null;
	private String installationSite = null;
	private String subNetwork = null;
	private String debugging = null;
	private String switchType = null;
	//private String manufacturers = null;
	private String manufacturersId = null;
	private String typeSpecification = null;
	private String VLANID = null;
	private String portNumber = null;
	private String flow = null;
	private String ownedBusiness = null;
	private String terminalName = null;
	private String vlanDescp = null;    //修改 vLanDescp -> vlanDescp :2014-11-27 10:20:59
	//private String constructionUnit = null;
	private String constructionUnitId = null;
	private String runTime = null;
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


	public String getSubNetwork() {
		return subNetwork;
	}

	public void setSubNetwork(String subNetwork) {
		this.subNetwork = subNetwork;
	}

	public String getDebugging() {
		return debugging;
	}

	public void setDebugging(String debugging) {
		this.debugging = debugging;
	}

	public String getSwitchType() {
		return switchType;
	}

	public void setSwitchType(String switchType) {
		this.switchType = switchType;
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

	public String getVLANID() {
		return VLANID;
	}

	public void setVLANID(String vLANID) {
		VLANID = vLANID;
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

	public String getOwnedBusiness() {
		return ownedBusiness;
	}

	public void setOwnedBusiness(String ownedBusiness) {
		this.ownedBusiness = ownedBusiness;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}


	public String getVlanDescp() {
		return vlanDescp;
	}

	public void setVlanDescp(String vlanDescp) {
		this.vlanDescp = vlanDescp;
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

	public String getTwoLayerSwitchId() {
		return twoLayerSwitchId;
	}

	public void setTwoLayerSwitchId(String twoLayerSwitchId) {
		this.twoLayerSwitchId = twoLayerSwitchId;
	}

	public String getTwoLayerSwitchName() {
		return twoLayerSwitchName;
	}

	public void setTwoLayerSwitchName(String twoLayerSwitchName) {
		this.twoLayerSwitchName = twoLayerSwitchName;
	}

	@Override
	public String toString() {
		return "TwoLayerSwitch [twoLayerSwitchId=" + twoLayerSwitchId
				+ ", twoLayerSwitchName=" + twoLayerSwitchName + ", siteId="
				+ siteId + ", projectId=" + projectId + ", installationSite="
				+ installationSite + ", subNetwork=" + subNetwork
				+ ", debugging=" + debugging + ", switchType=" + switchType
				+ ", manufacturersId=" + manufacturersId
				+ ", typeSpecification=" + typeSpecification + ", VLANID="
				+ VLANID + ", portNumber=" + portNumber + ", flow=" + flow
				+ ", ownedBusiness=" + ownedBusiness + ", terminalName="
				+ terminalName + ", vlanDescp=" + vlanDescp
				+ ", constructionUnitId=" + constructionUnitId + ", runTime="
				+ runTime + ", delFlg=" + delFlg + ", descp=" + descp + "]";
	}


}
