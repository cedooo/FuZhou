package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.GPRS;

public class GPRSDao {

	public List<GPRS> listGPRS(String siteId){
		List<GPRS> gprsList = new ArrayList<GPRS>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_gprs " +
							( (siteId==null||"".equals(siteId))?"":" where siteId='" + siteId + "' " )  +
									" LIMIT 1000 ");
			while (results.next()) {
				String gprsId = results.getString("gprsId");
				String projectId = results.getString("gprsId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String cardNumber = results.getString("cardNumber");
				String operators = results.getString("operators");
				String technologyType = results.getString("technologyType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				///String constructionUnit = results.getString("constructionUnit");
				String constructionUnitId = results.getString("constructionUnitId");
				
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String gprsName = results.getString("gprsName");
				GPRS gprs = new GPRS();
				gprs.setSiteId(siteId);
				gprs.setGprsId(gprsId);
				gprs.setProjectId(projectId);
				gprs.setInstallationSite(installationSite);
				gprs.setDebugging(debugging);
				gprs.setIp(ip);
				gprs.setCardNumber(cardNumber);
				gprs.setOperators(operators);
				gprs.setTechnologyType(technologyType);
				gprs.setManufacturersId(manufacturersId);
				gprs.setTypeSpecification(typeSpecification);
				//gprs.setConstructionUnit(constructionUnit);
				gprs.setConstructionUnitId(constructionUnitId);
				gprs.setRunTime(runTime);
				gprs.setDelFlg(delFlg);
				gprs.setDescp(descp);
				gprs.setGprsName(gprsName);
				gprsList.add(gprs);
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
		return gprsList;
	}
	
	public GPRS getGPRSByID(String id){
		GPRS gprs = null;DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_gprs where gprsId ='" + id + "' LIMIT 1");
			while (results.next()) {
				String gprsId = results.getString("gprsId");
				String projectId = results.getString("projectId");
				String siteId = results.getString("siteId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String cardNumber = results.getString("cardNumber");
				String operators = results.getString("operators");
				String technologyType = results.getString("technologyType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				///String constructionUnit = results.getString("constructionUnit");
				String constructionUnitId = results.getString("constructionUnitId");
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String gprsName = results.getString("gprsName");
				gprs = new GPRS();
				gprs.setSiteId(siteId);
				gprs.setGprsId(gprsId);
				gprs.setProjectId(projectId);
				gprs.setInstallationSite(installationSite);
				gprs.setDebugging(debugging);
				gprs.setIp(ip);
				gprs.setCardNumber(cardNumber);
				gprs.setOperators(operators);
				gprs.setTechnologyType(technologyType);
				gprs.setManufacturersId(manufacturersId);
				gprs.setTypeSpecification(typeSpecification);
				gprs.setConstructionUnitId(constructionUnitId);
				gprs.setRunTime(runTime);
				gprs.setDelFlg(delFlg);
				gprs.setDescp(descp);
				gprs.setGprsName(gprsName);
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
		return gprs;
	}
	
	public List<GPRS> listGPRSVO(String siteId){
		List<GPRS> gprsList = new ArrayList<GPRS>();
		DBManager db = new DBManager();
		try {
			String sql = " SELECT " +
					" gprsId,gprsName,site.siteName as siteId,project.projectName as projectId,installationSite,debugging,ip,cardNumber, " +
					" operators,technologyType,man.manufacturersName as manufacturersId,typeSpecification,cons.constructionUnitName as constructionUnitId, " +
					" runTime,gprs.delFlg,gprs.descp " +
					" FROM a_gprs gprs left join a_site site on gprs.siteId = site.siteId " +
					" left join b_project project on gprs.projectId = project.projectId  " +
					" left join b_manufacturers man on gprs.manufacturersId = man.manufacturersId " +
					" left join b_constructionunit cons on gprs.constructionUnitId = cons.constructionUnitId " +
					" where site.siteId = '" + siteId +  "' " + 
							" LIMIT 1000 ";
			db.openConnection();
			ResultSet results = db
					.executeQuery(sql);
			while (results.next()) {
				String gprsId = results.getString("gprsId");
				String siteName = results.getString("siteId");
				String installationSite = results.getString("installationSite");
				String debugging = results.getString("debugging");
				String ip = results.getString("ip");
				String cardNumber = results.getString("cardNumber");
				String operators = results.getString("operators");
				String technologyType = results.getString("technologyType");
				String manufacturersId = results.getString("manufacturersId");
				String typeSpecification = results.getString("typeSpecification");
				///String constructionUnit = results.getString("constructionUnit");
				String constructionUnitId = results.getString("constructionUnitId");
				String projectName = results.getString("projectId");
				
				String runTime = results.getString("runTime");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String gprsName = results.getString("gprsName");
				GPRS gprs = new GPRS();
				gprs.setSiteId(siteName);
				gprs.setGprsId(gprsId);
				gprs.setProjectId(projectName);
				gprs.setInstallationSite(installationSite);
				gprs.setDebugging(debugging);
				gprs.setIp(ip);
				gprs.setCardNumber(cardNumber);
				gprs.setOperators(operators);
				gprs.setTechnologyType(technologyType);
				gprs.setManufacturersId(manufacturersId);
				gprs.setTypeSpecification(typeSpecification);
				//gprs.setConstructionUnit(constructionUnit);
				gprs.setConstructionUnitId(constructionUnitId);
				gprs.setRunTime(runTime);
				gprs.setDelFlg(delFlg);
				gprs.setDescp(descp);
				gprs.setGprsName(gprsName);
				gprsList.add(gprs);
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
		return gprsList;
	}
}
