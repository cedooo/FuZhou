package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.ONU;

public class ONUDao {

	public List<ONU> listONU(String siteId){
		List<ONU> onuList = new ArrayList<ONU>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_onu " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " )  +
									" LIMIT 1000 ");
			while (results.next()) {
				String onuId = results.getString("onuId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String ospfNumber = results.getString("ospfNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String onuName = results.getString("onuName");
				
				ONU onu = new ONU();
				onu.setSiteId(siteId);
				onu.setOnuId(onuId);
				onu.setProjectId(projectId);
				onu.setInstallationSite(installationSite);
				onu.setManufacturersId(manufacturersId);
				onu.setTypeSpecification(typeSpecification);
				onu.setConstructionUnitId(constructionUnitId);
				onu.setRunTime(runTime);
				onu.setVlanId(vlanId);
				onu.setOspfNumber(ospfNumber);
				onu.setVpnNumber(vpnNumber);
				onu.setDelFlg(delFlg);
				onu.setDescp(descp);
				onu.setOnuName(onuName);
				onuList.add(onu);
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
		return onuList;
	}
	public ONU getONU(String onuId){
		ONU onu = null;
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_onu where onuId ='" + onuId + "' LIMIT 1 ");
			while (results.next()) {
				String siteId = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String ospfNumber = results.getString("ospfNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String onuName = results.getString("onuName");
				
				onu = new ONU();
				onu.setSiteId(siteId);
				onu.setOnuId(onuId);
				onu.setProjectId(projectId);
				onu.setInstallationSite(installationSite);
				onu.setManufacturersId(manufacturersId);
				onu.setTypeSpecification(typeSpecification);
				onu.setConstructionUnitId(constructionUnitId);
				onu.setRunTime(runTime);
				onu.setVlanId(vlanId);
				onu.setOspfNumber(ospfNumber);
				onu.setVpnNumber(vpnNumber);
				onu.setDelFlg(delFlg);
				onu.setDescp(descp);
				onu.setOnuName(onuName);
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
		return onu;
	}
	
	public List<ONU> listONUVO(String siteId){
		List<ONU> onuList = new ArrayList<ONU>();
		DBManager db = new DBManager();
		try {
			String sql = "SELECT " +
					" onuId,onuName,site.siteName as siteId,project.projectName as projectId "+
					" ,installationSite,man.manufacturersName as manufacturersId,typeSpecification "+
					" ,cons.constructionUnitName as constructionUnitId,runTime,vlanId,ospfNumber,vpnNumber,onu.delFlg,onu.descp "+
					" FROM a_onu onu left join a_site site on onu.siteId = site.siteId "+
					" left join b_project project on onu.projectId = project.projectId  "+
					" left join b_manufacturers man on onu.manufacturersId = man.manufacturersId "+
					" left join b_constructionunit cons on onu.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
									" LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(sql );
			while (results.next()) {
				String onuId = results.getString("onuId");
				String siteName = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String ospfNumber = results.getString("ospfNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String onuName = results.getString("onuName");
				
				ONU onu = new ONU();
				onu.setSiteId(siteName);
				onu.setOnuId(onuId);
				onu.setProjectId(projectId);
				onu.setInstallationSite(installationSite);
				onu.setManufacturersId(manufacturersId);
				onu.setTypeSpecification(typeSpecification);
				onu.setConstructionUnitId(constructionUnitId);
				onu.setRunTime(runTime);
				onu.setVlanId(vlanId);
				onu.setOspfNumber(ospfNumber);
				onu.setVpnNumber(vpnNumber);
				onu.setDelFlg(delFlg);
				onu.setDescp(descp);
				onu.setOnuName(onuName);
				onuList.add(onu);
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
		return onuList;
	}
}
