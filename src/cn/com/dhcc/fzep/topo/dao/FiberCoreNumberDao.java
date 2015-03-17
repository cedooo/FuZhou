package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;

public class FiberCoreNumberDao {
	/**
	 * 根据光缆ID得到纤芯集合
	 * @param cableId 光缆ID
	 * @return 纤芯集合
	 */
	public List<FiberCoreNumber> listFiberCN(String cableId){
		List<FiberCoreNumber> listFCN= new ArrayList<FiberCoreNumber>();
		DBManager dbManager = new DBManager();
		try {
			dbManager.openConnection();
			StringBuilder sqlQuery = new StringBuilder(
					" select fcn.* from a_fibercorenumber fcn where isUsed = '是' and  cableId = '" + cableId + "' and  connections is not null "
					);
			ResultSet results = dbManager
					.executeQuery(sqlQuery.toString());
			while (results.next()) {
				String fiberCoreNumberId= results.getString("fiberCoreNumberId");
				String fiberCoreNumberName= results.getString("fiberCoreNumberName");
				String isUsed= results.getString("isUsed");
				String isJump= results.getString("isJump");
				String bizType= results.getString("bizType");
				String connections= results.getString("connections");
				String transceiver= results.getString("transceiver");
				String delFlg= results.getString("delFlg");
				String descp= results.getString("descp");
				
				FiberCoreNumber fcn = new FiberCoreNumber();
				fcn.setBizType(bizType);
				fcn.setFiberCoreNumberId(fiberCoreNumberId);
				fcn.setFiberCoreNumberName(fiberCoreNumberName);
				fcn.setIsUsed(isUsed);
				fcn.setIsJump(isJump);
				fcn.setBizType(bizType);
				fcn.setConnections(connections);
				fcn.setTransceiver(transceiver);
				fcn.setDelFlg(delFlg);
				fcn.setDescp(descp);
				fcn.setCableId(cableId);
				
				listFCN.add(fcn);
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
				dbManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listFCN;
	}
	/**
	 * 根据站点ID得到纤芯集合
	 * @param siteId 站点ID
	 * @return 纤芯集合
	 */
	public List<FiberCoreNumber> listFiberCNBySiteId(String siteId){
		List<FiberCoreNumber> listFCN= new ArrayList<FiberCoreNumber>();
		DBManager dbManager = new DBManager();
		try {
			dbManager.openConnection();
			StringBuilder sqlQuery = new StringBuilder(
					" select fcn.* " + 
							" from a_fibercorenumber fcn left join  a_cable cable  on cable.cableId = fcn.cableId " +
							" where fcn.isUsed = '是'  and  fcn.connections is not null and (cable.cableStartId = '" + siteId + "' or cable.cableEndId = '" + siteId + "' ) "
					);
			ResultSet results = dbManager
					.executeQuery(sqlQuery.toString());
			while (results.next()) {
				String fiberCoreNumberId= results.getString("fiberCoreNumberId");
				String fiberCoreNumberName= results.getString("fiberCoreNumberName");
				String isUsed= results.getString("isUsed");
				String isJump= results.getString("isJump");
				String cableId = results.getString("cableId");
				String bizType= results.getString("bizType");
				String connections= results.getString("connections");
				String transceiver= results.getString("transceiver");
				String delFlg= results.getString("delFlg");
				String descp= results.getString("descp");
				
				FiberCoreNumber fcn = new FiberCoreNumber();
				fcn.setBizType(bizType);
				fcn.setFiberCoreNumberId(fiberCoreNumberId);
				fcn.setFiberCoreNumberName(fiberCoreNumberName);
				fcn.setIsUsed(isUsed);
				fcn.setIsJump(isJump);
				fcn.setBizType(bizType);
				fcn.setConnections(connections);
				fcn.setTransceiver(transceiver);
				fcn.setDelFlg(delFlg);
				fcn.setDescp(descp);
				fcn.setCableId(cableId);
				
				listFCN.add(fcn);
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
				dbManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listFCN;
	}
}
