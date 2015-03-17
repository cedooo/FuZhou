package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.Carrier;

public class CarrierDao {
	public List<Carrier> listCarrier(String siteId) {
		List<Carrier> carrierList = new ArrayList<Carrier>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_carrier " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " ) +
									" LIMIT 1000 ");
			while (results.next()) {
				String carrierId = results.getString("carrierId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String installationLocation = results.getString("installationLocation");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String carrierName = results.getString("carrierName");
				
				Carrier carrier = new Carrier();
				carrier.setCarrierId(carrierId);
				carrier.setProjectId(projectId);
				carrier.setInstallationSite(installationSite);
				carrier.setDebugging(debugging);
				carrier.setIp(ip);
				carrier.setManufacturersId(manufacturersId);
				carrier.setTypeSpecification(typeSpecification);
				carrier.setConstructionUnitId(constructionUnitId);
				carrier.setRunTime(runTime);
				carrier.setInstallationLocation(installationLocation);
				carrier.setDelFlg(delFlg);
				carrier.setDescp(descp);
				carrier.setSiteId(siteId);
				carrier.setCarrierName(carrierName);
				carrierList.add(carrier);
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
		return carrierList;
	}
	
	public Carrier getCarrier(String carrierId) {
		Carrier carrier = null;
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_carrier where carrierId ='" + carrierId + "' LIMIT 1 ");
			while (results.next()) {
				String projectId = results.getString("projectId");
				String siteId = results.getString("siteId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String installationLocation = results.getString("installationLocation");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String carrierName = results.getString("carrierName");
				
				carrier = new Carrier();
				carrier.setCarrierId(carrierId);
				carrier.setProjectId(projectId);
				carrier.setInstallationSite(installationSite);
				carrier.setDebugging(debugging);
				carrier.setIp(ip);
				carrier.setManufacturersId(manufacturersId);
				carrier.setTypeSpecification(typeSpecification);
				carrier.setConstructionUnitId(constructionUnitId);
				carrier.setRunTime(runTime);
				carrier.setInstallationLocation(installationLocation);
				carrier.setDelFlg(delFlg);
				carrier.setDescp(descp);
				carrier.setSiteId(siteId);
				carrier.setCarrierName(carrierName);
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
		return carrier;
	}
	
	public List<Carrier> listCarrierVO(String siteId) {
		List<Carrier> carrierList = new ArrayList<Carrier>();
		DBManager db = new DBManager();
		try {
			String sql = 
				" SELECT 	carrierId,carrierName, site.siteName as siteId, project.projectName as projectId, installationSite, " + 
					" debugging, ip, man.manufacturersName as manufacturersId, typeSpecification, cons.constructionUnitName as constructionUnitId, " + 
					" runTime, installationLocation, carrier.delFlg, carrier.descp " + 
					" FROM a_carrier carrier left join a_site site on carrier.siteId = site.siteId " + 
					" left join b_project project on carrier.projectId = project.projectId  " + 
					" left join b_manufacturers man on carrier.manufacturersId = man.manufacturersId " + 
					" left join b_constructionunit cons on carrier.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
					" LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(sql);
			while (results.next()) {
				String carrierId = results.getString("carrierId");
				String siteName = results.getString("siteId");
				String projectId = results.getString("projectId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String installationLocation = results.getString("installationLocation");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String carrierName = results.getString("carrierName");
				
				Carrier carrier = new Carrier();
				carrier.setCarrierId(carrierId);
				carrier.setProjectId(projectId);
				carrier.setInstallationSite(installationSite);
				carrier.setDebugging(debugging);
				carrier.setIp(ip);
				carrier.setManufacturersId(manufacturersId);
				carrier.setTypeSpecification(typeSpecification);
				carrier.setConstructionUnitId(constructionUnitId);
				carrier.setRunTime(runTime);
				carrier.setInstallationLocation(installationLocation);
				carrier.setDelFlg(delFlg);
				carrier.setDescp(descp);
				carrier.setSiteId(siteName);
				carrier.setCarrierName(carrierName);
				carrierList.add(carrier);
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
		return carrierList;
	}
}
