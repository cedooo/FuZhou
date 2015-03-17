package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.OLT;

public class OLTDao {

	public List<OLT> listOLT(String siteId){
		List<OLT> oltList = new ArrayList<OLT>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_olt " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " )  +
									"LIMIT 1000 ");
			while (results.next()) {
				String oltId = results.getString("oltId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String lookbackLocation = results.getString("lookbackLocation");
				String oSPFNumber = results.getString("oSPFNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String oltName = results.getString("oltName");
				
				OLT olt = new OLT();
				olt.setSiteId(siteId);
				olt.setOltId(oltId);
				olt.setProjectId(projectId);
				olt.setManufacturersId(manufacturersId);
				olt.setoSPFNumber(oSPFNumber);
				olt.setInstallationSite(installationSite);
				olt.setTypeSpecification(typeSpecification);
				olt.setConstructionUnitId(constructionUnitId);
				olt.setRunTime(runTime);
				olt.setVlanId(vlanId);
				olt.setLookbackLocation(lookbackLocation);
				olt.setVpnNumber(vpnNumber);
				olt.setDelFlg(delFlg);
				olt.setDescp(descp);
				olt.setOltName(oltName);
				oltList.add(olt);
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
		return oltList;
	}
	
	public OLT getOLT(String oltId){
		OLT olt = null;
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_olt where oltId ='" + oltId + "' LIMIT 1 ");
			while (results.next()) {
				String siteId = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String lookbackLocation = results.getString("lookbackLocation");
				String oSPFNumber = results.getString("oSPFNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String oltName = results.getString("oltName");
				
				olt = new OLT();
				olt.setSiteId(siteId);
				olt.setOltId(oltId);
				olt.setProjectId(projectId);
				olt.setManufacturersId(manufacturersId);
				olt.setoSPFNumber(oSPFNumber);
				olt.setInstallationSite(installationSite);
				olt.setTypeSpecification(typeSpecification);
				olt.setConstructionUnitId(constructionUnitId);
				olt.setRunTime(runTime);
				olt.setVlanId(vlanId);
				olt.setLookbackLocation(lookbackLocation);
				olt.setVpnNumber(vpnNumber);
				olt.setDelFlg(delFlg);
				olt.setDescp(descp);
				olt.setOltName(oltName);
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
		return olt;
	}
	
	public List<OLT> listOLTVO(String siteId){
		List<OLT> oltList = new ArrayList<OLT>();
		DBManager db = new DBManager();
		try {
			String selectSql = 
					" SELECT  oltId, oltName, site.siteName as siteId, project.projectName as projectId, installationSite, " +
					" man.manufacturersName as manufacturersId, typeSpecification, cons.constructionUnitName as constructionUnitId, " +
					" runTime,vlanId, lookbackLocation, ospfNumber, vpnNumber, olt.delFlg, olt.descp " +
					" FROM a_olt olt left join a_site site on olt.siteId = site.siteId "+
					" left join b_project project on olt.projectId = project.projectId "+
					" left join b_manufacturers man on olt.manufacturersId = man.manufacturersId "+
					" left join b_constructionunit cons on olt.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
					" LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(selectSql);
			while (results.next()) {
				String oltId = results.getString("oltId");
				String siteName = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String vlanId = results.getString("vlanId");
				String lookbackLocation = results.getString("lookbackLocation");
				String oSPFNumber = results.getString("ospfNumber");
				String vpnNumber = results.getString("vpnNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String oltName = results.getString("oltName");
				
				OLT olt = new OLT();
				olt.setSiteId(siteName);
				olt.setOltId(oltId);
				olt.setProjectId(projectId);
				olt.setManufacturersId(manufacturersId);
				olt.setoSPFNumber(oSPFNumber);
				olt.setInstallationSite(installationSite);
				olt.setTypeSpecification(typeSpecification);
				olt.setConstructionUnitId(constructionUnitId);
				olt.setRunTime(runTime);
				olt.setVlanId(vlanId);
				olt.setLookbackLocation(lookbackLocation);
				olt.setVpnNumber(vpnNumber);
				olt.setDelFlg(delFlg);
				olt.setDescp(descp);
				olt.setOltName(oltName);
				oltList.add(olt);
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
		return oltList;
	}
}
