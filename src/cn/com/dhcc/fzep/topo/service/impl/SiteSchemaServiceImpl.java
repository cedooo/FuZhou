package cn.com.dhcc.fzep.topo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.com.dhcc.fzep.topo.common.SiteRelation;
import cn.com.dhcc.fzep.topo.common.search.Page;
import cn.com.dhcc.fzep.topo.common.search.SearchSite;
import cn.com.dhcc.fzep.topo.dao.CableDao;
import cn.com.dhcc.fzep.topo.dao.SchemaDao;
import cn.com.dhcc.fzep.topo.dao.SiteDao;
import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.pojo.Site;
import cn.com.dhcc.fzep.topo.service.SiteSchemaService;
import cn.com.dhcc.fzep.topo.utils.ParametersValidRegex;
import cn.com.dhcc.fzep.topo.vo.SchemaVO;

public class SiteSchemaServiceImpl implements SiteSchemaService {

	@Override
	public List<Site> getListByArea(String areaId) {
		/*if(areaId!=null && !"".equals(areaId)){
			return new SiteDao().getSiteByAreaID(areaId);
		}*/
		return null;
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
	@Override
	public boolean saveSchema(String baseInfo, String jsonData, String args) {
		Schema schema = new Schema();
		schema.setSchemaData(jsonData);
		schema.setSchemaArgs(args);
		try {
			JSONObject obj = new JSONObject(baseInfo);

			String schemaId = obj.getString("schemaId");
			String schemaName = obj.getString("schemaName");
			String schemaType = obj.getString("schemaType");
			String schemaNote = obj.getString("schemaNote");
			String areaId = obj.getString("areaId");
			String siteId = obj.getString("siteId");

			schema.setSchemaName(schemaName);
			schema.setSchemaType(schemaType);
			schema.setSchemaNote(schemaNote); 
			schema.setAreaId(areaId);
			schema.setSiteId(siteId);
			SchemaDao schemaDao = new SchemaDao();
			System.out.println("schemaId = " + schemaId);
			System.out.println(schema);
			if(schemaId==null|| "".equals(schemaId) || schemaId.equals("null")){
				schema.setSchemaAddTime(sdf.format(new Date()));
				boolean insertSuccess = schemaDao.insertSchema(schema);
				return insertSuccess;
			}else{
				schema.setSchemaId(schemaId);
				boolean updateSuccess = schemaDao.updateSchema(schema);
				return updateSuccess;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Schema getSchemaByAreaName(String areaName) {
		if(areaName!=null){
			if(areaName.matches(ParametersValidRegex.AREA_NAME_REGEX)){
				Schema schema = new SchemaDao().getSchemaByAreaName(areaName);
				//TODO 查询视图附加数据
				if(schema!=null){
					String schemaData = schema.getSchemaData();
					String realTimeData = schemaData;// getAddInfo(schemaData);
					schema.setSchemaData(realTimeData);
				}
				return schema;
			}
		}
		return null;
	}
	/**
	 * 检查视图数据，得到实时的额外数据信息
	 * <br />会在数据中加入是否启用的标志: delFlg
	 * @param schemaData 视图数据
	 * @return 新的实时视图数据
	 * @deprecated 原本为获取视图附加信息的方法，因改变策略（改为获取视图信息）而弃用。
	 */
	protected String getAddInfo(String schemaData) {
		try {
			JSONArray jsonArray = new JSONArray(schemaData);
			CableDao cableDao = new CableDao();
			SiteDao siteDao = new SiteDao();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				String type = jsonObj.getString("type");
				String id = jsonObj.getString("id");
				if("valueObjects::Cable".equals(type)){
					Cable cable = cableDao.getCable(id);
					jsonObj.put("isMainRoad", cable.getIsMainRoad());
					jsonObj.put("delFlg", cable.getDelFlg());
				}else if("valueObjects::Site".equals(type)){
					Site site = siteDao.getSiteBySiteId(id);
					jsonObj.put("delFlg", site.getDelFlg());
				}
			}
			return jsonArray.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Site> getListByAreaName(String areaName) {
		if(areaName!=null && !"".equals(areaName)){
			return new SiteDao().getSiteByAreaName(areaName);
		}
		return null;
	}
	@Override
	public List<Site> getListByCondition(SearchSite condition) {
		//System.out.println(condition);
		if(condition!=null){
			return new SiteDao().getSiteByCondition(condition);
		}
		return null;
	}
	@Override
	public Page getPage(SearchSite condition) {
		Page page = condition.getPage();
		int totalRecords = new SiteDao().getTotalRecord(condition);
		int totalPage = (int) Math.ceil(totalRecords*1f / page.getNumPerPage());
		page.setTotalRecords(totalRecords);
		page.setTotalPage(totalPage);
		return page;
	}
	@Override
	public SiteRelation getSiteRelationBySiteName(String siteName, int degree) {
		/**
		 * 得到站点信息， 搜索起始或终止的节点为该站点的
		 */
		
		SiteRelation siteRelation = new SiteRelation();
		
		SiteDao siteDao = new SiteDao();
		Site center = siteDao.getSiteBySiteName(siteName);
		if(center!=null){
			siteRelation.setCenter(center);
			
			CableDao cableDao = new CableDao();
			List<Cable> listCable = cableDao.listCable(center.getSiteId());
			siteRelation.setListCable(listCable);
			
			/**
			 * 一层关系对象
			 */
			List<Site> levelOneList = new ArrayList<Site>();
			for (Cable cable : listCable) {
				if(cable.getCableStartId()!=null){
					if(!center.getSiteId().equals(cable.getCableStartId())){
						Site startSite = siteDao.getSiteBySiteId(cable.getCableStartId());
						levelOneList.add(startSite);
					}
					if(!center.getSiteId().equals(cable.getCableEndId())){
						Site endSite = siteDao.getSiteBySiteId(cable.getCableEndId());
						levelOneList.add(endSite);
					}
				}
			}
			siteRelation.setLevelOneSite(levelOneList);
			
			if(degree>=2){
				List<Site> levelTwoList = new ArrayList<Site>();
				/**
				 * 2层关系对象操作
				 */
				for (Site site : levelOneList) {
					List<Cable> listTwoCable = cableDao.listCable(site.getSiteId());
					//List<Cable> listExistedCable = cableDao.listCable(site.getSiteId());
					for (Cable cable : listTwoCable) {
						boolean cableValid = cable.getCableStartId()!=null && cable.getCableEndId()!=null;
						if(cableValid){
							String targetID = cable.getCableStartId().equals(site.getSiteId())?cable.getCableEndId():
								cable.getCableStartId();
							boolean targetIsCenter = targetID.equals(center.getSiteId());    //目标站点不是‘中心’ 站点
							if(!targetIsCenter){
								Site targetSite = siteDao.getSiteBySiteId(targetID);
								levelTwoList.add(targetSite);
							}
							
						}
					}
					//listTwoCable.removeAll(listExistedCable);
					listCable.addAll(listTwoCable);
				}
				/*
				List<Site> levelOneExistedList = new ArrayList<Site>();
				for (Site siteOne : levelOneList) {
					for (Site siteTwo : levelTwoList) {
						boolean existedInOne = siteOne.getSiteId().equals(siteTwo.getSiteId());
						if(existedInOne){
							levelOneExistedList.add(siteTwo);
						}
					}
				}
				levelTwoList.removeAll(levelOneExistedList);    //去掉第1层中已有站点
				*/
				levelTwoList.removeAll(levelOneList);   //重载Site的hashCode和equals
				
				/**
				 * 去掉重复光缆
				 */
				
				Set<Cable> set = new HashSet<Cable>(listCable); // 通过HashSet去重复  
				listCable.clear(); // 清空原有list  
				listCable.addAll(set); 
		        
				siteRelation.setLevelTwoSite(levelTwoList);
				
			}
			
		}
		return siteRelation;
	}
	@Override
	public SchemaVO getDefaultSchema() {
		SchemaVO schema = new SchemaDao().getDefaultSchemaVO();
		//TODO 查询视图附加数据
		if(schema!=null){
			String schemaData = schema.getSchemaData();
			String realTimeData = schemaData;// getAddInfo(schemaData);
			schema.setSchemaData(realTimeData);
			}
		return schema;
	}
	@Override
	public SchemaVO getSchemaVOByAreaName(String areaName) {
		if(areaName!=null){
			if(areaName.matches(ParametersValidRegex.AREA_NAME_REGEX)){
				SchemaVO schema = new SchemaDao().getSchemaVOByAreaName(areaName);
				//TODO 查询视图附加数据
				if(schema!=null){
					String schemaData = schema.getSchemaData();
					String realTimeData = schemaData;// getAddInfo(schemaData);
					schema.setSchemaData(realTimeData);
				}
				return schema;
			}
		}
		return null;
	}

}
