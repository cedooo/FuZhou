package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.Cable;

public class CableDao {
	/**
	 * 根据站点ID得到光缆列表
	 * @param siteId 站点ID
	 * @return 光缆集合list
	 */
	public List<Cable> listCable(String siteId){
		List<Cable> carrierList = new ArrayList<Cable>();
		DBManager db = new DBManager();
		/**
		String typeStr = ( type==0?"":
			(type==1?"Y":"N") );
		String typeStrSql = " and isMainRoad='" + typeStr + "' ";
		*/
		try {
			db.openConnection();

			String sql = "SELECT * FROM a_cable where delFlg='启用' and ( cableStartId='" + siteId + "' or cableEndId='" + siteId + "' )" +
					"  LIMIT 1000 ";
			ResultSet results = db.executeQuery(sql);
			while (results.next()) {
				String cableId = results.getString("cableId");
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				cable.setCableEndId(cableEndId);
				cable.setCableStartId(cableStartId);
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				carrierList.add(cable);
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

	public Cable getCable(String id) {
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db
					.executeQuery("SELECT * FROM a_cable where cableId='" + id + "' " + " LIMIT 1 ");
			while (results.next()) {
				String cableId = results.getString("cableId");
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				cable.setCableEndId(cableEndId);
				cable.setCableStartId(cableStartId);
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				//System.out.println("通过光缆ID查询光缆信息, 光缆id=" + cableId);
				//System.out.println(cable);
				return cable;
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
		return null;
	}
	

	public List<Cable> listCable(String fId, String sId){
		List<Cable> cableList = new ArrayList<Cable>();
		DBManager db = new DBManager();
		/**
		String typeStr = ( type==0?"":
			(type==1?"Y":"N") );
		String typeStrSql = " and isMainRoad='" + typeStr + "' ";
		*/
		try {
			db.openConnection();
			String sql = "SELECT * FROM a_cable " +
					" where (cableStartId='" + fId + "' and cableEndId='" + sId + "') " +
							"or (cableEndId='" + fId + "' and cableStartId='" + sId + "') " +
					" LIMIT 1000 ";
			ResultSet results = db.executeQuery(sql);
			while (results.next()) {
				String cableId = results.getString("cableId");
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				//String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				cable.setCableEndId(cableEndId);
				cable.setCableStartId(cableStartId);
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				//cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				cableList.add(cable);
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
		return cableList;
	}
	

	/**
	 * 根据站点ID得到光缆列表
	 * @param siteId 站点ID
	 * @return 光缆集合list
	 */
	public List<Cable> listCableVO(String siteId){
		List<Cable> carrierList = new ArrayList<Cable>();
		DBManager db = new DBManager();
		/**
		String typeStr = ( type==0?"":
			(type==1?"Y":"N") );
		String typeStrSql = " and isMainRoad='" + typeStr + "' ";
		*/
		try {
			db.openConnection();
			String sql = " SELECT cableId,cableName,ssite.siteName as cableStartId,esite.siteName as cableEndId,isMainRoad,cableType,cableLength,fiber.fiberName as fiberId, " + 
					" layingType,runTime, cons.constructionUnitName as constructionUnitId,fiber.bizType as bizType,cable.delFlg,cable.descp  " + 
					" FROM a_cable cable left join b_fiber fiber on cable.fiberId = fiber.fiberId " + 
					" left join b_constructionunit cons on cable.constructionUnitId = cons.constructionUnitId " + 
					" left join a_site ssite on cable.cableStartId = ssite.siteId  " + 
					" left join a_site esite on cable.cableEndId = esite.siteId  " + 
				 " WHERE cableStartId='" + siteId + "' or cableEndId='" + siteId + "' " +
					" order by cable.cableId desc " +
					" LIMIT 0,2 ";
			ResultSet results = db.executeQuery(sql);
			while (results.next()) {
				String cableId = results.getString("cableId");
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				
				cable.setCableEndId(cableEndId);
				
				cable.setCableStartId(cableStartId);
				
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				
				
				carrierList.add(cable);
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


	/**
	 * 根据站点ID得到光缆列表
	 * @param cableId 站点ID
	 * @return cableVO
	 */
	public Cable cableVO(String cableId){
		DBManager db = new DBManager();
		try {
			db.openConnection();
			String sql = " SELECT cableId,cableName,ssite.siteName as cableStartId,esite.siteName as cableEndId,isMainRoad,cableType,cableLength,fiber.fiberName as fiberId, " + 
					" layingType,runTime, cons.constructionUnitName as constructionUnitId,fiber.bizType as bizType,cable.delFlg,cable.descp  " + 
					" FROM a_cable cable left join b_fiber fiber on cable.fiberId = fiber.fiberId " + 
					" left join b_constructionunit cons on cable.constructionUnitId = cons.constructionUnitId " + 
					" left join a_site ssite on cable.cableStartId = ssite.siteId  " + 
					" left join a_site esite on cable.cableEndId = esite.siteId  " + 
				 " WHERE cableId='" + cableId + "' " +
					" LIMIT 1";
			ResultSet results = db.executeQuery(sql);
			while (results.next()) {
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				
				cable.setCableEndId(cableEndId);
				
				cable.setCableStartId(cableStartId);
				
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				return cable;				
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
		return null;
	}
	
	public List<Cable> relationCableList(String targetSiteId, String relationSiteId){
		List<Cable> cableList = new ArrayList<Cable>();
		DBManager db = new DBManager();
		/**
		String typeStr = ( type==0?"":
			(type==1?"Y":"N") );
		String typeStrSql = " and isMainRoad='" + typeStr + "' ";
		*/
		try {
			db.openConnection();
			String sql = " SELECT * FROM a_cable " +
					" where (cableStartId='" + targetSiteId + "' and cableEndId='" + relationSiteId + "') " +
							" or (cableEndId='" + targetSiteId + "' and cableStartId='" + relationSiteId + "') " +
					" LIMIT 0,2 ";
			ResultSet results = db.executeQuery(sql);
			while (results.next()) {
				String cableId = results.getString("cableId");
				String cableName = results.getString("cableName");
				String cableStartId = results.getString("cableStartId");
				String cableEndId = results.getString("cableEndId");
				String cableType = results.getString("cableType");
				String cableLength = results.getString("cableLength");
				//String fibreCoreNumber= results.getString("fibreCoreNumber");
				String fiberId= results.getString("fiberId");
				String layingType = results.getString("layingType");
				String runTime= results.getString("runTime");
				String constructionUnitId= results.getString("constructionUnitId");
				//String bizType = results.getString("bizType");
				String delFlg= results.getString("delFlg");
				String descp = results.getString("descp");
				String isMainRoad  = results.getString("isMainRoad");
				Cable cable = new Cable();
				cable.setCableId(cableId);
				cable.setCableName(cableName);
				cable.setCableEndId(cableEndId);
				cable.setCableStartId(cableStartId);
				cable.setCableLength(cableLength);
				cable.setCableType(cableType);
				cable.setFiberId(fiberId);
				cable.setLayingType(layingType);
				cable.setRunTime(runTime);
				cable.setConstructionUnitId(constructionUnitId);
				//cable.setBizType(bizType);
				cable.setDelFlg(delFlg);
				cable.setDescp(descp);
				cable.setIsMainRoad(isMainRoad);
				cableList.add(cable);
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
		return cableList;
	}
}
