package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.TwoLayerSwitch;

public class TwoLayerSwitchDao {

	public List<TwoLayerSwitch> listTwoLayerSwitch(String siteId){
		List<TwoLayerSwitch> twoLayerSwitchList = new ArrayList<TwoLayerSwitch>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_twolayerswitch " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " ) +
									" LIMIT 1000 ");
			while (results.next()) {
				String twoLayerSwitchId = results.getString("twoLayerSwitchId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String twoLayerSwitchName = results.getString("twoLayerSwitchName");
				String subNetwork = results.getString("subNetwork");
				String debugging = results.getString("debugging");
				String switchType = results.getString("switchType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String VLANID = results.getString("VLANID");
				String portNumber = results.getString("portNumber");
				String flow = results.getString("flow");
				String ownedBusiness = results.getString("ownedBusiness");
				String terminalName = results.getString("terminalName");
				String vlanDescp = results.getString("vlanDescp");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				TwoLayerSwitch twoLayerSwitch = new TwoLayerSwitch();
				twoLayerSwitch.setSiteId(siteId);
				twoLayerSwitch.setTwoLayerSwitchId(twoLayerSwitchId);
				twoLayerSwitch.setProjectId(projectId);
				twoLayerSwitch.setInstallationSite(installationSite);
				twoLayerSwitch.setTwoLayerSwitchName(twoLayerSwitchName);
				twoLayerSwitch.setSubNetwork(subNetwork);
				twoLayerSwitch.setDebugging(debugging);
				twoLayerSwitch.setSwitchType(switchType);
				twoLayerSwitch.setManufacturersId(manufacturersId);
				twoLayerSwitch.setTypeSpecification(typeSpecification);
				twoLayerSwitch.setVLANID(VLANID);
				twoLayerSwitch.setPortNumber(portNumber);
				twoLayerSwitch.setFlow(flow);
				twoLayerSwitch.setOwnedBusiness(ownedBusiness);
				twoLayerSwitch.setTerminalName(terminalName);
				twoLayerSwitch.setVlanDescp(vlanDescp);
				twoLayerSwitch.setConstructionUnitId(constructionUnitId);
				twoLayerSwitch.setRunTime(runTime);
				twoLayerSwitch.setDelFlg(delFlg);
				twoLayerSwitch.setDescp(descp);
				twoLayerSwitchList.add(twoLayerSwitch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return twoLayerSwitchList;
	}
	public TwoLayerSwitch getTwoLayerSwitch(String l2SwitchId){
		TwoLayerSwitch twoLayerSwitch = null;
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_twolayerswitch where switchId ='" + l2SwitchId + "' LIMIT 1 ");
			while (results.next()) {
				String siteId = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String twoLayerSwitchName = results.getString("twoLayerSwitchName");
				String subNetwork = results.getString("subNetwork");
				String debugging = results.getString("debugging");
				String switchType = results.getString("switchType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String VLANID = results.getString("VLANID");
				String portNumber = results.getString("portNumber");
				String flow = results.getString("flow");
				String ownedBusiness = results.getString("ownedBusiness");
				String terminalName = results.getString("terminalName");
				String vlanDescp = results.getString("vlanDescp");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				twoLayerSwitch = new TwoLayerSwitch();
				twoLayerSwitch.setSiteId(siteId);
				twoLayerSwitch.setTwoLayerSwitchId(l2SwitchId);
				twoLayerSwitch.setProjectId(projectId);
				twoLayerSwitch.setInstallationSite(installationSite);
				twoLayerSwitch.setTwoLayerSwitchName(twoLayerSwitchName);
				twoLayerSwitch.setSubNetwork(subNetwork);
				twoLayerSwitch.setDebugging(debugging);
				twoLayerSwitch.setSwitchType(switchType);
				twoLayerSwitch.setManufacturersId(manufacturersId);
				twoLayerSwitch.setTypeSpecification(typeSpecification);
				twoLayerSwitch.setVLANID(VLANID);
				twoLayerSwitch.setPortNumber(portNumber);
				twoLayerSwitch.setFlow(flow);
				twoLayerSwitch.setOwnedBusiness(ownedBusiness);
				twoLayerSwitch.setTerminalName(terminalName);
				twoLayerSwitch.setVlanDescp(vlanDescp);
				twoLayerSwitch.setConstructionUnitId(constructionUnitId);
				twoLayerSwitch.setRunTime(runTime);
				twoLayerSwitch.setDelFlg(delFlg);
				twoLayerSwitch.setDescp(descp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return twoLayerSwitch;
	}
	

	public List<TwoLayerSwitch> listTwoLayerSwitchVO(String siteId){
		List<TwoLayerSwitch> twoLayerSwitchList = new ArrayList<TwoLayerSwitch>();
		DBManager db = new DBManager();
		try {
			String sql = 
				" SELECT  twoLayerSwitchId,	twoLayerSwitchName, 	site.siteName as siteId, 	project.projectName as projectId, " +
					" installationSite, 	subNetwork, 	debugging, 	switchType, 	man.manufacturersName as manufacturersId,  " +
					" typeSpecification, 	vlanId, 	portNumber, 	flow, 	ownedBusiness, 	terminalName,  " +
					" vlanDescp, 	cons.constructionUnitName as constructionUnitId, 	runTime, 	l2switch.delFlg, 	l2switch.descp " +
					" FROM a_twolayerswitch l2switch  left join a_site site on l2switch.siteId = site.siteId " +
					" left join b_project project on l2switch.projectId = project.projectId  " +
					" left join b_manufacturers man on l2switch.manufacturersId = man.manufacturersId " +
					" left join b_constructionunit cons on l2switch.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
					" LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(sql);
			while (results.next()) {
				String twoLayerSwitchId = results.getString("twoLayerSwitchId");
				String siteName = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String twoLayerSwitchName = results.getString("twoLayerSwitchName");
				String subNetwork = results.getString("subNetwork");
				String debugging = results.getString("debugging");
				String switchType = results.getString("switchType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String VLANID = results.getString("VLANID");
				String portNumber = results.getString("portNumber");
				String flow = results.getString("flow");
				String ownedBusiness = results.getString("ownedBusiness");
				String terminalName = results.getString("terminalName");
				String vlanDescp = results.getString("vlanDescp");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				TwoLayerSwitch twoLayerSwitch = new TwoLayerSwitch();
				twoLayerSwitch.setSiteId(siteName);
				twoLayerSwitch.setTwoLayerSwitchId(twoLayerSwitchId);
				twoLayerSwitch.setProjectId(projectId);
				twoLayerSwitch.setInstallationSite(installationSite);
				twoLayerSwitch.setTwoLayerSwitchName(twoLayerSwitchName);
				twoLayerSwitch.setSubNetwork(subNetwork);
				twoLayerSwitch.setDebugging(debugging);
				twoLayerSwitch.setSwitchType(switchType);
				twoLayerSwitch.setManufacturersId(manufacturersId);
				twoLayerSwitch.setTypeSpecification(typeSpecification);
				twoLayerSwitch.setVLANID(VLANID);
				twoLayerSwitch.setPortNumber(portNumber);
				twoLayerSwitch.setFlow(flow);
				twoLayerSwitch.setOwnedBusiness(ownedBusiness);
				twoLayerSwitch.setTerminalName(terminalName);
				twoLayerSwitch.setVlanDescp(vlanDescp);
				twoLayerSwitch.setConstructionUnitId(constructionUnitId);
				twoLayerSwitch.setRunTime(runTime);
				twoLayerSwitch.setDelFlg(delFlg);
				twoLayerSwitch.setDescp(descp);
				twoLayerSwitchList.add(twoLayerSwitch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return twoLayerSwitchList;
	}
}
