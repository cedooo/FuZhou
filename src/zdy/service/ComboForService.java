package zdy.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import zdy.common.Constant;
import zdy.common.Forward;
import zdy.common.Message;
import zdy.common.Method;
import zdy.dao.TemplateDao;
import zdy.dao.impl.TemplateDaoImpl;
import zdy.model.A_Carrier;
import zdy.model.A_Gprs;
import zdy.model.A_Olt;
import zdy.model.A_Onu;
import zdy.model.A_ThreeLayerSwitch;
import zdy.model.A_TwoLayerSwitch;
import zdy.model.ConditionDto;

public class ComboForService extends Forward {

	/** UID */
	private static final long serialVersionUID = 1L;

	/**
	 * 所属项目,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForProject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.B_PROJECT);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOPROJECTQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * 所属区域,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForArea(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.B_AREA);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOAREAQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	/**
	 * 所属站点,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForSite(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_SITE);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOSITEQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	/**
	 * 所属光纤,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForFiber(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.B_FIBER);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOFIBERQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	/**
	 * 所属施工单位,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForConstructionUnit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.B_CONSTRUCTIONUNIT);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOCONSTRUCTIONUNITQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	/**
	 * 所属厂家,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForManufacturers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.B_MANUFACTURERS);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOMANUFACTURERSQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * 所属光缆,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void comboForCable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_CABLE);
			request.setAttribute(Constant.BEENLIST, map.get(Constant.BEENLIST));
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_COMBOCABLEQUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * 连接情况,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void comboForConnections(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String connectionDataStore="[";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			{
				/** gprs */
				Map<String, Object> gprsMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_GPRS);
				connectionDataStore +="{text:'gprs','children':[";
				List<A_Gprs> beenList = (List<A_Gprs>)gprsMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]},";
				}else{
					for(A_Gprs gprs:beenList){
						connectionDataStore +="{'text':'"+gprs.getGprsName()+"','leaf':true,'deviceType':'gprs','deviceId':'"+gprs.getGprsId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]},";
				}
			}
			{
				/** olt */
				Map<String, Object> oltMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_OLT);
				connectionDataStore +="{'text':'olt','children':[";
				List<A_Olt>  beenList = (List<A_Olt>)oltMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]},";
				}else{
					for(A_Olt olt:beenList){
						connectionDataStore +="{'text':'"+olt.getOltName()+"','leaf':true,'deviceType':'olt','deviceId':'"+olt.getOltId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]},";
				}
			}
			{
				/** onu */
				Map<String, Object> onuMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_ONU);
				connectionDataStore +="{'text':'onu','children':[";
				List<A_Onu> beenList = (List<A_Onu>)onuMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]},";
				}else{
					for(A_Onu onu:beenList){
						connectionDataStore +="{'text':'"+onu.getOnuName()+"','leaf':true,'deviceType':'onu','deviceId':'"+onu.getOnuId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]},";
				}
			}
			{
				/** 载波 */
				Map<String, Object> carrierMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_CARRIER);
				connectionDataStore +="{'text':'载波','children':[";
				List<A_Carrier> beenList = (List<A_Carrier>)carrierMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]},";
				}else{
					for(A_Carrier carrier:beenList){
						connectionDataStore +="{'text':'"+carrier.getCarrierName()+"','leaf':true,'deviceType':'载波','deviceId':'"+carrier.getCarrierId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]},";
				}
			}
			{
				/** 二层交换机 */
				Map<String, Object> twoLayerSwitchMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_TWOLAYERSWITCH);
				connectionDataStore +="{'text':'二层交换机','children':[";
				List<A_TwoLayerSwitch> beenList = (List<A_TwoLayerSwitch>)twoLayerSwitchMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]},";
				}else{
					for(A_TwoLayerSwitch twoLayerSwitch:beenList){
						connectionDataStore +="{'text':'"+twoLayerSwitch.getTwoLayerSwitchName()+"','leaf':true,'deviceType':'二层交换机','deviceId':'"+twoLayerSwitch.getTwoLayerSwitchId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]},";
				}
			}
			{
				/** 三层交换机 */
				Map<String, Object> threeLayerSwitchMap = templateDao.query((ConditionDto) request
						.getAttribute(Constant.CONDITIONDTO),Constant.A_THREELAYERSWITCH);
				connectionDataStore +="{'text':'三层交换机','children':[";
				List<A_ThreeLayerSwitch> beenList = (List<A_ThreeLayerSwitch>)threeLayerSwitchMap.get(Constant.BEENLIST);
				if(beenList.size()<1){
					connectionDataStore +="]}";
				}else{
					for(A_ThreeLayerSwitch threeLayerSwitch:beenList){
						connectionDataStore +="{'text':'"+threeLayerSwitch.getThreeLayerSwitchName()+"','leaf':true,'deviceType':'三层交换机','deviceId':'"+threeLayerSwitch.getThreeLayerSwitchId()+"'},";
					}
					connectionDataStore = connectionDataStore.substring(0, connectionDataStore.length()-1);
					connectionDataStore +="]}";
				}
			}
			connectionDataStore+="]";
			/** 将数据封装成json格式 */
			printWriter.append(connectionDataStore);
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			connectionDataStore="[]";
			printWriter.append(connectionDataStore);
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
