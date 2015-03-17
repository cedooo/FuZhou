package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.ThreeLayerSwitch;

public class ThreeLayerSwitchDao {

	public List<ThreeLayerSwitch> listThreeLayerSwitch(String siteId){
		List<ThreeLayerSwitch> threeLayerSwitchList = new ArrayList<ThreeLayerSwitch>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_threelayerswitch " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " ) +
									"LIMIT 1000 ");
			while (results.next()) {
				String threeLayerSwitchId = results.getString("threeLayerSwitchId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String threeLayerSwitchName = results.getString("threeLayerSwitchName");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String portNumber = results.getString("runTime");
				String flow = results.getString("flow");
				String vlanId = results.getString("vlanId");
				String ip = results.getString("ip");
				String vlanDescp = results.getString("vlanDescp");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				
				ThreeLayerSwitch threeLayerSwitch = new ThreeLayerSwitch();
				threeLayerSwitch.setSiteId(siteId);
				threeLayerSwitch.setThreeLayerSwitchId(threeLayerSwitchId);
				threeLayerSwitch.setProjectId(projectId);
				threeLayerSwitch.setInstallationSite(installationSite);
				threeLayerSwitch.setThreeLayerSwitchName(threeLayerSwitchName);
				threeLayerSwitch.setManufacturersId(manufacturersId);
				threeLayerSwitch.setTypeSpecification(typeSpecification);
				threeLayerSwitch.setConstructionUnitId(constructionUnitId);
				threeLayerSwitch.setRunTime(runTime);
				threeLayerSwitch.setPortNumber(portNumber);
				threeLayerSwitch.setFlow(flow);
				threeLayerSwitch.setVlanId(vlanId);
				threeLayerSwitch.setIp(ip);
				threeLayerSwitch.setVlanDescp(vlanDescp);
				threeLayerSwitch.setDelFlg(delFlg);
				threeLayerSwitch.setDescp(descp);
				threeLayerSwitchList.add(threeLayerSwitch);
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
		return threeLayerSwitchList;
	}
	public ThreeLayerSwitch getThreeLayerSwitch(String l3SwitchId){
		ThreeLayerSwitch threeLayerSwitch = null;
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_threelayerswitch where threeLayerSwitchId ='" + l3SwitchId + "' LIMIT 1 ");
			while (results.next()) {
				String siteId = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String threeLayerSwitchName = results.getString("threeLayerSwitchName");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String portNumber = results.getString("runTime");
				String flow = results.getString("flow");
				String vlanId = results.getString("vlanId");
				String ip = results.getString("ip");
				String vlanDescp = results.getString("vlanDescp");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				
				threeLayerSwitch = new ThreeLayerSwitch();
				threeLayerSwitch.setSiteId(siteId);
				threeLayerSwitch.setThreeLayerSwitchId(l3SwitchId);
				threeLayerSwitch.setProjectId(projectId);
				threeLayerSwitch.setInstallationSite(installationSite);
				threeLayerSwitch.setThreeLayerSwitchName(threeLayerSwitchName);
				threeLayerSwitch.setManufacturersId(manufacturersId);
				threeLayerSwitch.setTypeSpecification(typeSpecification);
				threeLayerSwitch.setConstructionUnitId(constructionUnitId);
				threeLayerSwitch.setRunTime(runTime);
				threeLayerSwitch.setPortNumber(portNumber);
				threeLayerSwitch.setFlow(flow);
				threeLayerSwitch.setVlanId(vlanId);
				threeLayerSwitch.setIp(ip);
				threeLayerSwitch.setVlanDescp(vlanDescp);
				threeLayerSwitch.setDelFlg(delFlg);
				threeLayerSwitch.setDescp(descp);
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
		return threeLayerSwitch;
	}
	
	public List<ThreeLayerSwitch> listThreeLayerSwitchVO(String siteId){
		List<ThreeLayerSwitch> threeLayerSwitchList = new ArrayList<ThreeLayerSwitch>();
		DBManager db = new DBManager();
		try {
			String sql = 
					"SELECT  threeLayerSwitchId,	 threeLayerSwitchName,	 site.siteName as siteId,	 project.projectName as projectId, " + 
					" installationSite,	 man.manufacturersName as manufacturersId,	 typeSpecification, " + 
					" cons.constructionUnitName as constructionUnitId,	 runTime,	 portNumber,	 flow, " + 
					" vlanId,	 ip,	 vlanDescp,	 l3switch.delFlg,	l3switch.descp " + 
					" FROM a_threelayerswitch l3switch  left join a_site site on l3switch.siteId = site.siteId " + 
					" left join b_project project on l3switch.projectId = project.projectId  " + 
					" left join b_manufacturers man on l3switch.manufacturersId = man.manufacturersId " + 
					" left join b_constructionunit cons on l3switch.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
					"LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(sql);
			while (results.next()) {
				String threeLayerSwitchId = results.getString("threeLayerSwitchId");
				String siteName = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String threeLayerSwitchName = results.getString("threeLayerSwitchName");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String portNumber = results.getString("runTime");
				String flow = results.getString("flow");
				String vlanId = results.getString("vlanId");
				String ip = results.getString("ip");
				String vlanDescp = results.getString("vlanDescp");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				
				ThreeLayerSwitch threeLayerSwitch = new ThreeLayerSwitch();
				threeLayerSwitch.setSiteId(siteName);
				threeLayerSwitch.setThreeLayerSwitchId(threeLayerSwitchId);
				threeLayerSwitch.setProjectId(projectId);
				threeLayerSwitch.setInstallationSite(installationSite);
				threeLayerSwitch.setThreeLayerSwitchName(threeLayerSwitchName);
				threeLayerSwitch.setManufacturersId(manufacturersId);
				threeLayerSwitch.setTypeSpecification(typeSpecification);
				threeLayerSwitch.setConstructionUnitId(constructionUnitId);
				threeLayerSwitch.setRunTime(runTime);
				threeLayerSwitch.setPortNumber(portNumber);
				threeLayerSwitch.setFlow(flow);
				threeLayerSwitch.setVlanId(vlanId);
				threeLayerSwitch.setIp(ip);
				threeLayerSwitch.setVlanDescp(vlanDescp);
				threeLayerSwitch.setDelFlg(delFlg);
				threeLayerSwitch.setDescp(descp);
				threeLayerSwitchList.add(threeLayerSwitch);
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
		return threeLayerSwitchList;
	}
}
