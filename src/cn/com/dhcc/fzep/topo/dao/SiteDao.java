package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import zdy.dao.DBManager;
import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.pojo.Site;
public class SiteDao {
	/**
	 * 根据区域ID得到站点对象     因为没做站点分页，弃用
	 * @deprecated 没做站点分页
	 * @param areaId 区域ID
	 * @return
	 */
	public List<Site> getSiteByAreaID(String areaId) {
		List<Site> siteList = new ArrayList<Site>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT * FROM a_site  where AreaId = " + areaId);
			while(results.next()){
				String siteId = results.getString("siteId");
				String siteName = results.getString("siteName");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				siteList.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return siteList;
	}
	/**
	 * 根据区域名称得到站点集合
	 * @param areaName
	 * @return
	 */
	public List<Site> getSiteByAreaName(String areaName) {
		List<Site> siteList = new ArrayList<Site>();
		DBManager db = new DBManager();
		//System.out.println("站点名称" + areaName);
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT site.* " +
					" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
					"  where area.areaName = '" + areaName + "' and site.delFlg = '启用' ");
			while(results.next()){
				String siteId = results.getString("siteId");
				String siteName = results.getString("siteName");
				String areaId = results.getString("AreaId");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				siteList.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return siteList;
	}
	/**
	 * 条件搜索站点集合
	 * @param condition
	 * @return
	 */
	public List<Site> getSiteByCondition(SearchSite condition) {
		List<Site> siteList = new ArrayList<Site>();
		DBManager db = new DBManager();
		Page page = condition.getPage();
		int jump = page.getNumPerPage()*(page.getCurPage()-1);
		String where_case = getWhereCase(condition);
		String exeSQL = "SELECT site.* " +
				" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
				where_case + 
					" order by site.siteId " +
					" limit " + jump + ", " + page.getNumPerPage();
//System.out.println(exeSQL);
		try {
			db.openConnection();
			ResultSet results = db.executeQuery(exeSQL);
			while(results.next()){
				String siteId = results.getString("siteId");
				String siteName = results.getString("siteName");
				String areaId = results.getString("AreaId");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				siteList.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return siteList;
	}
	/**
	 * 得到满足条件的 记录总数
	 * @param condition
	 * @return
	 */
	public int getTotalRecord(SearchSite condition) {
		DBManager db = new DBManager();

		String where_case = getWhereCase(condition);
		
		String exeSQL = "SELECT count(*) as total " +
				" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
				where_case ;
		//System.out.println(exeSQL);
		try {
			db.openConnection();
			ResultSet results = db.executeQuery(exeSQL);
			while(results.next()){
				return results.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	/**
	 * 根据站点名称查找站点对象
	 * @param siteName 站点名称
	 * @return
	 */
	public Site getSiteBySiteName(String siteName) {
		DBManager db = new DBManager();
		//System.out.println("站点名称" + areaName);
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT site.* " +
					" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
					"  where site.siteName = '" + siteName + "'  limit 1");
			while(results.next()){
				String siteId = results.getString("siteId");
				String areaId = results.getString("AreaId");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				return site;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	/**
	 * 根据站点ID得到站点对象
	 * @param siteID
	 * @return
	 */
	public Site getSiteBySiteId(String siteID) {
		DBManager db = new DBManager();
		//System.out.println("站点名称" + areaName);
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("SELECT site.* " +
					" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
					"  where site.siteId = '" + siteID + "' limit 1 ");
			while(results.next()){
				String siteId = results.getString("siteId");
				String areaId = results.getString("AreaId");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				String siteName = results.getString("siteName");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				return site;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	/**
	 * 得到符合条件的站点列表
	 * @param searchCondition 搜索条件
	 * @param siteIds 排除在外的站点ID
	 * @return
	 */
	public Collection<? extends Site> getSiteByConditionNotIn(
			SearchSite searchCondition, List<Integer> siteIds) {
		List<Site> siteList = new ArrayList<Site>();
		Page page = searchCondition.getPage();
		int jump = page.getNumPerPage()*(page.getCurPage()-1);
		String where_case = getWhereCase(searchCondition);
		String exeSQL = "SELECT site.* " +
				" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
				where_case + 
					" order by site.siteId " +
					" limit " + jump + ", " + page.getNumPerPage();
//System.out.println(exeSQL);
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery(exeSQL);
			while(results.next()){
				String siteId = results.getString("siteId");
				String siteName = results.getString("siteName");
				String areaId = results.getString("AreaId");
				String siteAdress = results.getString("siteAdress");
				String connactName = results.getString("connactName");
				String connactNumber = results.getString("connactNumber");
				String delFlg = results.getString("delFlg");
				String descp = results.getString("descp");
				Site site = new Site();
				site.setAreaId(areaId);
				site.setSiteName(siteName);
				site.setConnactName(connactName);
				site.setConnactNumber(connactNumber);
				site.setDelFlg(delFlg);
				site.setDescp(descp);
				site.setSiteAdress(siteAdress);
				site.setSiteId(siteId);
				siteList.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return siteList;
	}
	public int getSiteCountByConditionNotIn(SearchSite searchCondition) {
		String where_case = getWhereCase(searchCondition);
		String exeSQL = "SELECT count(*) as total " +
				" FROM a_site site left join b_area  area on site.AreaId =  area.areaId " +
				where_case ;
//System.out.println(exeSQL);
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery(exeSQL);
			while(results.next()){
				int total = results.getInt("total");
				return total;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	
	
	private String getWhereCase(SearchSite searchCondition){
		String where_case = " where ";
		/*
		 * 是否启用
		 */
		String delCase = " site.delFlg = '启用' ";
		
		where_case += delCase;
		/**
		 * 区域名称
		 */
		String areaNameCase = null;
		if(searchCondition.getAreaName()!=null){
			areaNameCase = " area.areaName = '" + searchCondition.getAreaName() + "' ";
		}
		where_case += (areaNameCase!=null?" and " + areaNameCase:" ");
		/**
		 * 搜索属性范围
		 */
		String scopeCase = null;
		if(searchCondition.getSearchField()!=null && !"".equals(searchCondition.getSearchField())){
			scopeCase = " site." + searchCondition.getSearchField() + " like '%" + searchCondition.getKeyWord() +  "%' ";
		}
		where_case += (scopeCase!=null?" and " + scopeCase:" ");
		/**
		 * 排除在外的
		 */
		String notInCase = null;
		List<Integer> siteIds = searchCondition.getExceptList();
		if(siteIds!=null&& siteIds.size()>0){
			String idStr = "";
			for (int i = 0; i < siteIds.size(); i++) {
				idStr += ((i!=0?",":"") + siteIds.get(i));
			}
			notInCase = " site.siteId not in (" + idStr  +") ";
		}
		where_case += (notInCase!=null?" and " + notInCase:" ");
		/**
		 * 区域ID
		 */
		String areaIdCase = null;
		if(searchCondition.getAreaId()>0){
			areaIdCase = " area.areaId = '" + searchCondition.getAreaId() + "' ";
		}

		where_case += (areaIdCase!=null?" and " + areaIdCase:" ");
		return where_case;
	}
}
