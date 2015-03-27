package zdy.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import zdy.common.Constant;
import zdy.common.Forward;
import zdy.common.Message;
import zdy.common.Method;
import zdy.dao.DBManager;
import zdy.dao.TemplateDao;
import zdy.dao.impl.TemplateDaoImpl;
import zdy.model.A_Cable;
import zdy.model.A_CableDto;
import zdy.model.A_FiberCoreNumber;
import zdy.model.A_Site;
import zdy.model.B_ConstructionUnit;
import zdy.model.B_Fiber;
import zdy.model.ConditionDto;
import zdy.model.PageDto;
import zdy.model.TemplateBeen;

public class A_CableServiceImpl extends Forward {

	/** UID */
	private static final long serialVersionUID = 1L;

	/** 
	 * 增加,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String beenList = request.getParameter(Constant.BEENLIST);
		/** 数据库连接操作 */
		DBManager dBManager = new DBManager();
		try {
			 TemplateDao templateDao = new TemplateDaoImpl();
			 A_Cable a_Cable = (A_Cable)request.getAttribute(Constant.A_CABLE);
			 /** 查询最大的主键，并加1 */
			int cableId = templateDao.queryForCount(" select max(cableId) from a_cable ");
			a_Cable.setCableId(String.valueOf(++cableId));
			 /** 开启事务操作 */
			 dBManager.openConnection();
			 dBManager.openTranscation();
			 templateDao.transcationAddIncludeId(a_Cable,dBManager);
			 /** 判断是否配置纤芯列表的情况 */
			 int fiberCoreNumberCount = 0;
			 if(beenList==null ||"[]".equals(beenList)){
				 ConditionDto conditionDto = new ConditionDto();
				 conditionDto.setConditionFiled("fiberId");
				 conditionDto.setConditionConditions("like");
				 conditionDto.setConditionValue(a_Cable.getFiberId());
				 Map<String, Object> map = templateDao.query(conditionDto,Constant.B_FIBER);
				 fiberCoreNumberCount =Integer.valueOf(((List<B_Fiber>)map.get(Constant.BEENLIST)).get(0).getFiberCoreNumber());
				 for(int i=1;i<=fiberCoreNumberCount;i++){
					 A_FiberCoreNumber fiberCoreNumber = new A_FiberCoreNumber();
					 fiberCoreNumber.setFiberCoreNumberName("纤芯"+i);
					 fiberCoreNumber.setCableId(a_Cable.getCableId());
					 fiberCoreNumber.setStartConnections("{\"siteId\":\""+a_Cable.getCableStartId()+"\"}");
					 fiberCoreNumber.setEndConnections("{\"siteId\":\""+a_Cable.getCableEndId()+"\"}");
					 fiberCoreNumber.setDelFlg("启用");
					 fiberCoreNumber.setDescp("");
					 templateDao.transcationAdd(fiberCoreNumber,dBManager);
				 }
			 }else{
				 JSONArray fiberCoreNumberArray = JSONArray.fromObject(beenList);
				 for(int i=0;i<fiberCoreNumberArray.size();i++){
					 JSONObject  jsonObject  =fiberCoreNumberArray.getJSONObject(i);
					 A_FiberCoreNumber fiberCoreNumber = new A_FiberCoreNumber();
					 fiberCoreNumber.setFiberCoreNumberName(jsonObject.getString("fiberCoreNumberName"));
					 fiberCoreNumber.setCableId(a_Cable.getCableId());
					 fiberCoreNumber.setIsUsed(jsonObject.getString("isUsed"));
					 fiberCoreNumber.setIsJump(jsonObject.getString("isJump"));
					 fiberCoreNumber.setBizType(jsonObject.getString("bizType"));
					 /** 站点的起始连接情况 */
					 String startConnectionStr = jsonObject.getString("startConnections");
					 if(startConnectionStr==null||"[null]".equals(startConnectionStr)||"[]".equals(startConnectionStr)){
						 startConnectionStr ="{\"siteId\":\""+a_Cable.getCableStartId()+"\"}";
					 }else{
						 startConnectionStr = startConnectionStr.substring(1, startConnectionStr.length()-1);
					 }
					 fiberCoreNumber.setStartConnections(startConnectionStr);
					 /** 站点的目的连接情况 */
					 String endConnectionStr = jsonObject.getString("endConnections");
					 if(endConnectionStr==null||"[null]".equals(endConnectionStr)||"[]".equals(endConnectionStr)){
						 endConnectionStr ="{\"siteId\":\""+a_Cable.getCableEndId()+"\"}";
					 }else{
						 endConnectionStr = endConnectionStr.substring(1, endConnectionStr.length()-1);
					 }
					 fiberCoreNumber.setEndConnections(endConnectionStr);
					 fiberCoreNumber.setTransceiver(jsonObject.getString("transceiver"));
					 fiberCoreNumber.setDelFlg("启用");
					 fiberCoreNumber.setDescp("");
					 templateDao.transcationAdd(fiberCoreNumber,dBManager);
				 };
			 }
			printWriter.append(Message.SUCCESSMESSAGE_ADD);
			dBManager.closeTranscation();
		} catch (Exception e) {
			dBManager.rollbackTranscation();
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_ADD+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			dBManager.closeConnection();
		}
	}

	/**
	 * 启用,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void effective(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.effective((String) request.getParameter(Constant.IDS),
					Constant.A_CABLE);
			printWriter.append(Message.SUCCESSMESSAGE_EFFECTIVE);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_EFFECTIVE+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	/**
	 * 停用,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void invalid(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.invalid((String) request.getParameter(Constant.IDS),
					Constant.A_CABLE);
			printWriter.append(Message.SUCCESSMESSAGE_INVALID);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_INVALID+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	/**
	 * 删除,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		DBManager dBManager = new DBManager();
		try {
			String executeSql1 = "delete from a_fiberCoreNumber  where cableId   in (" + (String) request.getParameter(Constant.IDS) + ")";
			String executeSql2 = "delete from a_cable  where cableId   in (" + (String) request.getParameter(Constant.IDS) + ")";
			dBManager.openConnection();
			dBManager.openTranscation();
			dBManager.executeUpdate(executeSql1);
			dBManager.executeUpdate(executeSql2);
			dBManager.closeTranscation();
			printWriter.append(Message.SUCCESSMESSAGE_DELETE);
		} catch (Exception e) {
			dBManager.rollbackTranscation();
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_DELETE+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			dBManager.closeConnection();
		}
	}

	/**
	 * 更新,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String beenList = request.getParameter(Constant.BEENLIST);
		/** 数据库连接操作 */
		DBManager dBManager = new DBManager();
		try {
			 TemplateDao templateDao = new TemplateDaoImpl();
			 A_Cable a_Cable = (A_Cable)request.getAttribute(Constant.A_CABLE);
			 /** 开启事务操作 */
			 dBManager.openConnection();
			 dBManager.openTranscation();
			 templateDao.transcationUpdate(a_Cable,dBManager);
			 templateDao.transcationExecute("delete from a_fibercorenumber where cableId = "+a_Cable.getCableId(), dBManager);
			 /** 判断是否配置纤芯列表的情况 */
			 int fiberCoreNumberCount = 0;
			 if(beenList==null ||"[]".equals(beenList)){
				 ConditionDto conditionDto = new ConditionDto();
				 conditionDto.setConditionFiled("fiberId");
				 conditionDto.setConditionConditions("like");
				 conditionDto.setConditionValue(a_Cable.getFiberId());
				 Map<String, Object> map = templateDao.query(conditionDto,Constant.B_FIBER);
				 fiberCoreNumberCount =Integer.valueOf(((List<B_Fiber>)map.get(Constant.BEENLIST)).get(0).getFiberCoreNumber());
				 for(int i=1;i<=fiberCoreNumberCount;i++){
					 A_FiberCoreNumber fiberCoreNumber = new A_FiberCoreNumber();
					 fiberCoreNumber.setFiberCoreNumberName("纤芯"+i);
					 fiberCoreNumber.setCableId(a_Cable.getCableId());
					 fiberCoreNumber.setStartConnections("{\"siteId\":\""+a_Cable.getCableStartId()+"\"");
					 fiberCoreNumber.setEndConnections("{\"siteId\":\""+a_Cable.getCableEndId()+"\"}");
					 fiberCoreNumber.setDelFlg("启用");
					 fiberCoreNumber.setDescp("");
					 templateDao.transcationAdd(fiberCoreNumber,dBManager);
				 }
			 }else{
				 JSONArray fiberCoreNumberArray = JSONArray.fromObject(beenList);
				 for(int i=0;i<fiberCoreNumberArray.size();i++){
					 JSONObject  jsonObject  =fiberCoreNumberArray.getJSONObject(i);
					 A_FiberCoreNumber fiberCoreNumber = new A_FiberCoreNumber();
					 fiberCoreNumber.setFiberCoreNumberName(jsonObject.getString("fiberCoreNumberName"));
					 fiberCoreNumber.setCableId(a_Cable.getCableId());
					 fiberCoreNumber.setIsUsed(jsonObject.getString("isUsed"));
					 fiberCoreNumber.setIsJump(jsonObject.getString("isJump"));
					 fiberCoreNumber.setBizType(jsonObject.getString("bizType"));
					 /** 站点起始连接情况 */
					 String startConnectionStr = jsonObject.getString("startConnections");
					 if(startConnectionStr==null||"[null]".equals(startConnectionStr)||startConnectionStr.contains("undefined")||"[]".equals(startConnectionStr)){
						 startConnectionStr ="{\"siteId\":\""+a_Cable.getCableStartId()+"\"}";
					 }else{
						 startConnectionStr = startConnectionStr.substring(1, startConnectionStr.length()-1);
					 }
					 fiberCoreNumber.setStartConnections(startConnectionStr);
					 /** 站点目标地址连接情况 */
					 String endConnectionStr = jsonObject.getString("endConnections");
					 if(endConnectionStr==null||"[null]".equals(endConnectionStr)||endConnectionStr.contains("undefined")||"[]".equals(endConnectionStr)){
						 endConnectionStr ="{\"siteId\":\""+a_Cable.getCableEndId()+"\"}";
					 }else{
						 endConnectionStr = endConnectionStr.substring(1, endConnectionStr.length()-1);
					 }
					 fiberCoreNumber.setEndConnections(endConnectionStr);
					 fiberCoreNumber.setTransceiver(jsonObject.getString("transceiver"));
					 fiberCoreNumber.setDelFlg("启用");
					 fiberCoreNumber.setDescp("");
					 templateDao.transcationAdd(fiberCoreNumber,dBManager);
				 };
			 }
			printWriter.append(Message.SUCCESSMESSAGE_ADD);
			dBManager.closeTranscation();
		} catch (Exception e) {
			dBManager.rollbackTranscation();
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_ADD+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			dBManager.closeConnection();
		}
	}


	/**
	 * 查询,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		PageDto pageDto = new PageDto();
		String start = request.getParameter("start");
		if(start != null&& !"".equals(start)){
			pageDto.setStartRecord(Integer.valueOf(start));
		}
		String limit = request.getParameter("limit");
		if(limit != null&& !"".equals(limit)){
			pageDto.setPerPage(Integer.valueOf(limit));
		}
		String sql=" select cable.*,site1.siteName as startSiteName,site2.siteName as endSiteName," +
				   " fiber.fiberName as fiberName,constructionunit.constructionunitName as constructionUnitName"+
				   " from a_cable cable  " +
				   " left join a_site  site1 on(cable.cableStartId = site1.siteId) "+
        		   " left join a_site  site2 on(cable.cableEndId   = site2.siteId)"+
        		   " left join b_fiber fiber on(cable.fiberId      = fiber.fiberId)"+
				   " left join b_constructionUnit constructionUnit on(cable.constructionUnitId = constructionUnit.constructionUnitId) ";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO), pageDto, Constant.A_CABLEDTO,sql);
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.BEENLIST, JSONArray.fromObject(map.get(Constant.BEENLIST)));
			jsonMap.put(Constant.TOTALCOUNT,map.get(Constant.TOTALCOUNT));
			jsonMap.put(Constant.RESULT,Message.SUCCESSMESSAGE_QUERY);
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_QUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	/**
	 * 查询,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String sql=" select cable.*,site1.siteName as startSiteName,site2.siteName as endSiteName," +
		   " fiber.fiberName as fiberName,constructionunit.constructionunitName as constructionUnitName"+
		   " from a_cable cable  " +
		   " left join a_site  site1 on(cable.cableStartId = site1.siteId) "+
		   " left join a_site  site2 on(cable.cableEndId   = site2.siteId)"+
		   " left join b_fiber fiber on(cable.fiberId      = fiber.fiberId)"+
		   " left join b_constructionUnit constructionUnit on(cable.constructionUnitId = constructionUnit.constructionUnitId) ";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_CABLEDTO,sql);
			/** 生成excel */
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String excelName="光缆表-"+simpleDateFormat.format(new Date())+".xls";
			String excelPath = Constant.EXPORTEXCELDIR +excelName;
			WritableWorkbook book = Workbook
					.createWorkbook(new File(excelPath));
			WritableSheet sheet = book.createSheet("光缆列表", 0);
			/** 头部样式 */
			WritableFont headFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD);
			WritableCellFormat headFormat = new WritableCellFormat(headFont);
			headFormat.setAlignment(jxl.format.Alignment.CENTRE);
			headFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			headFormat.setWrap(true);
			headFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
			/** 正文样式（正常白色） */
			WritableFont bodyNormalFont = new WritableFont(WritableFont.TIMES,
					12, WritableFont.NO_BOLD);
			WritableCellFormat bodyNormalFormat = new WritableCellFormat(
					NumberFormats.TEXT);
			bodyNormalFormat.setFont(bodyNormalFont);
			bodyNormalFormat.setAlignment(jxl.format.Alignment.CENTRE);
			bodyNormalFormat
					.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			bodyNormalFormat.setWrap(true);
			bodyNormalFormat.setBackground(Colour.BLACK);
			bodyNormalFormat.setBorder(Border.ALL, BorderLineStyle.THIN,
					Colour.BLACK);
			/** 表头内容+列宽 */
			Label headLabel0 = new Label(0, 0, "序号", headFormat);
			sheet.addCell(headLabel0);
			sheet.setColumnView(0, 10);
			Label headLabel1 = new Label(1, 0, "光缆名称", headFormat);
			sheet.addCell(headLabel1);
			sheet.setColumnView(1, 30);
			Label headLabel2 = new Label(2, 0, "光缆起点", headFormat);
			sheet.addCell(headLabel2);
			sheet.setColumnView(2, 30);
			Label headLabel3 = new Label(3, 0, "光缆终点", headFormat);
			sheet.addCell(headLabel3);
			sheet.setColumnView(3, 30);
			Label headLabel4 = new Label(4, 0, "是否主干网", headFormat);
			sheet.addCell(headLabel4);
			sheet.setColumnView(4, 30);
			Label headLabel5 = new Label(5, 0, "光缆类型", headFormat);
			sheet.addCell(headLabel5);
			sheet.setColumnView(5, 30);
			Label headLabel6 = new Label(6, 0, "光缆长度(km)", headFormat);
			sheet.addCell(headLabel6);
			sheet.setColumnView(6, 30);
			Label headLabel7 = new Label(7, 0, "纤芯数量", headFormat);
			sheet.addCell(headLabel7);
			sheet.setColumnView(7, 30);
			Label headLabel8 = new Label(8, 0, "敷设类型", headFormat);
			sheet.addCell(headLabel8);
			sheet.setColumnView(8, 30);
			Label headLabel9 = new Label(9, 0, "投运时间", headFormat);
			sheet.addCell(headLabel9);
			sheet.setColumnView(9, 30);
			Label headLabel10 = new Label(10, 0, "施工单位", headFormat);
			sheet.addCell(headLabel10);
			sheet.setColumnView(10, 30);
			Label headLabel11 = new Label(11, 0, "业务类型", headFormat);
			sheet.addCell(headLabel11);
			sheet.setColumnView(11, 30);
			Label headLabel12 = new Label(12, 0, "是否启用", headFormat);
			sheet.addCell(headLabel12);
			sheet.setColumnView(12, 30);
			Label headLabel13 = new Label(13, 0, "备注", headFormat);
			sheet.addCell(headLabel13);
			sheet.setColumnView(13, 30);
			/** 正文内容 */
			int rowCount = 1;
			for (A_CableDto a_CableDto : (List<A_CableDto>)map.get(Constant.BEENLIST)) {
				Label label0 = new Label(0, rowCount, String.valueOf(rowCount), bodyNormalFormat);
				sheet.addCell(label0);
				Label label1 = new Label(1, rowCount,a_CableDto.getCableName(), bodyNormalFormat);
				sheet.addCell(label1);
				Label label2 = new Label(2, rowCount,a_CableDto.getStartSiteName(), bodyNormalFormat);
				sheet.addCell(label2);
				Label label3 = new Label(3, rowCount,a_CableDto.getEndSiteName(), bodyNormalFormat);
				sheet.addCell(label3);
				Label label4 = new Label(4, rowCount,a_CableDto.getIsMainRoad(), bodyNormalFormat);
				sheet.addCell(label4);
				Label label5 = new Label(5, rowCount,a_CableDto.getCableType(), bodyNormalFormat);
				sheet.addCell(label5);
				Label label6 = new Label(6, rowCount,a_CableDto.getCableLength(),bodyNormalFormat);
				sheet.addCell(label6);
				Label label7 = new Label(7, rowCount,a_CableDto.getFiberName(),bodyNormalFormat);
				sheet.addCell(label7);
				Label label8 = new Label(8, rowCount, a_CableDto.getLayingType(),bodyNormalFormat);
				sheet.addCell(label8);
				Label label9 = new Label(9, rowCount, a_CableDto.getRunTime(),bodyNormalFormat);
				sheet.addCell(label9);
				Label label10 = new Label(10, rowCount, a_CableDto.getConstructionUnitName(),bodyNormalFormat);
				sheet.addCell(label10);
				Label label11 = new Label(11, rowCount, a_CableDto.getBizType(),bodyNormalFormat);
				sheet.addCell(label11);
				Label label12 = new Label(12, rowCount, a_CableDto.getDelFlg(),bodyNormalFormat);
				sheet.addCell(label12);
				Label label13 = new Label(13, rowCount, a_CableDto.getDescp(),bodyNormalFormat);
				sheet.addCell(label13);
				rowCount++;
			}
			/** 写入数据并关闭文件 */
			book.write();
			book.close();
			/** 设置为下载application/x-download */
			String requestUrl = request.getRequestURI();
			requestUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/"))+"/export/"+excelName;
			printWriter.append(Method.getJsonFormat(Message.SUCCESSMESSAGE_EXPORT+",url:'"+requestUrl+"'"));
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_EXPORT+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	/**
	 * 导入excel,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void importExcel(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			/** 生成excel */
			/** 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload */
			DiskFileItemFactory factory = new DiskFileItemFactory();
			/** 设置上传文件时用于临时存放文件的内存大小,这里是2M.多于的部分将临时存放 */
			factory.setSizeThreshold(1024*1024*2);
			/** 设置存放临时文件的目录 */
			factory.setRepository(new File(Constant.IMPORTEXCELDIR));
			/** 用上面的工厂实例化上传组件 */
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        /** 设置最大上传大小 10M   */
	        upload.setSizeMax(1024*1024*10);              
            /** 得到所有FileItem */              
            List  items = upload.parseRequest(request);
            Iterator iterator = items.iterator(); 
            /** 循环处理所有文件 */
            while (iterator.hasNext()) {
            	 FileItem item = (FileItem) iterator.next(); 
            	/** 判断是否是表单元素(<input type="text" />单选，多选等) */ 
            	 if (!item.isFormField()) {
            		/** 得到文件的名称 */ 
            		 String uploadName = item.getName();
                    /** 未选择上传文件 */ 
            		 if(uploadName==null || "".equals(uploadName.trim())){  
                        continue;  
                    }else if(!uploadName.endsWith(".xls") && !uploadName.endsWith(".xlsx")){
                    	printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'<br/>异常原因：上传的不是excel文件。'"));
                    	return;
                    } 
            		 String fileName="光缆_"+String.valueOf(System.currentTimeMillis())+".xls";
            		 String excelPath = Constant.IMPORTEXCELDIR + fileName;
                     File file = new File(excelPath);  
                     item.write(file);
                     /** 解析excel */
                     InputStream is = new FileInputStream(excelPath);  
                     Workbook rwb = Workbook.getWorkbook(is); 
                     Sheet st = rwb.getSheets()[0];
                     int rows=st.getRows();
                     if(st.getColumns()!=12){
                    	 printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'上传格式不正确，请使用上传模板'"));
                    	 return;
                     }
                     /** 行 */  
                     DBManager dBManager = new DBManager();
                     int exceptionIndex =0;
                     try{
                    	 dBManager.openConnection();
 	             		 dBManager.openTranscation();
 	             		 /** 因为是事务操作，只有提交后才会持久化，此cableNameMap是为了判断是否有相同的记录存在 */
 	             		Map<String,String> cableNameMap = new HashMap<String,String>();
 	             		/** 查询最近的主键，并加1（主键自增） */
 	             		TemplateDao templateDaoForTranscationAdd = new TemplateDaoImpl();
      					int cableId = templateDaoForTranscationAdd.queryForCount(" select max(cableId) from a_cable ");
      					cableNameMap.put("cableId", String.valueOf(++cableId));
	                     for(int i=1;i<rows;i++){
	                    	 /** 表格行数据都为空则跳过 */
	                    	if( "".equals(st.getCell(0,i).getContents())&&"".equals(st.getCell(1,i).getContents())
		                      &&"".equals(st.getCell(2,i).getContents())&&"".equals(st.getCell(3,i).getContents())
		                      &&"".equals(st.getCell(4,i).getContents())&&"".equals(st.getCell(5,i).getContents())
		                      &&"".equals(st.getCell(6,i).getContents())&&"".equals(st.getCell(7,i).getContents())
		                      &&"".equals(st.getCell(8,i).getContents())&&"".equals(st.getCell(9,i).getContents())
		                      &&"".equals(st.getCell(10,i).getContents())&&"".equals(st.getCell(11,i).getContents())){
		                     			continue;
		                    }
	                    	/** 异常行的序号 */
	                    	exceptionIndex = i;
	                    	if(st.getCell(0,i).getContents()==null||"".equals(st.getCell(0,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的光缆起点为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(1,i).getContents()==null||"".equals(st.getCell(1,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的光缆终点为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(5,i).getContents()==null||"".equals(st.getCell(5,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的纤芯数量为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(8,i).getContents()==null||"".equals(st.getCell(8,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的施工单位为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(10,i).getContents()==null||"".equals(st.getCell(10,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的是否启用为空'"));
                     			return;
	                    	}
	                    	/** 实例化光缆模型 */
	                    	A_Cable cable = new A_Cable();
	                     	/** 下拉框查询实例 */
	                     	TemplateDao templateDaoForCombo = new TemplateDaoImpl();
	                    	/** 暂存下拉框的map */
	                    	Map<String, Object> mapForCombo = new HashMap<String,Object>();
	                    	ConditionDto conditionDtoForCombo = new ConditionDto();
	                    	conditionDtoForCombo.setConditionConditions("=");
	                    	conditionDtoForCombo.setOrderValue("asc");
	                     	/** 获取光缆站点起点 */
	                     	conditionDtoForCombo.setConditionFiled("siteName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(0,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("siteName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.A_SITE);
	                     	List<A_Site> cableStartList =(List<A_Site>)mapForCombo.get(Constant.BEENLIST);
	                     	if(cableStartList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的光缆起点名称错误'"));
                     			return;
	                     	}
	                     	cable.setCableStartId(cableStartList.get(0).getSiteId());
	                     	 /** 获取光缆站点终点 */
	                     	conditionDtoForCombo.setConditionValue(st.getCell(1,i).getContents());
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.A_SITE);
	                     	List<A_Site> cableEndList =(List<A_Site>)mapForCombo.get(Constant.BEENLIST);
	                     	if(cableEndList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的光缆终点名称错误'"));
                     			return;
	                     	}
	                     	cable.setCableEndId(cableEndList.get(0).getSiteId());
	                     	cable.setIsMainRoad(st.getCell(2,i).getContents());
	                     	cable.setCableType(st.getCell(3,i).getContents());
	                     	cable.setCableLength(st.getCell(4,i).getContents());
	                     	/** 获取光纤数量 */
	                    	conditionDtoForCombo.setConditionFiled("fiberName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(5,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("fiberName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.B_FIBER);
	                     	List<B_Fiber> fiberList =(List<B_Fiber>)mapForCombo.get(Constant.BEENLIST);
	                     	if(fiberList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的纤芯数量名称错误'"));
                     			return;
	                     	}
	                     	cable.setFiberId(fiberList.get(0).getFiberId());
	                     	cable.setLayingType(st.getCell(6,i).getContents());
	                     	cable.setRunTime(st.getCell(7,i).getContents());
	                     	/** 获取施工单位 */
	                    	conditionDtoForCombo.setConditionFiled("constructionUnitName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(8,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("constructionUnitName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.B_CONSTRUCTIONUNIT);
	                     	List<B_ConstructionUnit> constructionUnitList =(List<B_ConstructionUnit>)mapForCombo.get(Constant.BEENLIST);
	                     	if(constructionUnitList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的施工单位名称错误'"));
                     			return;
	                     	}
	                     	cable.setConstructionUnitId(constructionUnitList.get(0).getConstructionUnitId());
	                     	cable.setBizType(st.getCell(9,i).getContents());
	                     	cable.setDelFlg(st.getCell(10,i).getContents());
	                     	cable.setDescp(st.getCell(11,i).getContents());
	                     	/** 对光缆名称进行设置 */
	                     	String cableName = st.getCell(0,i).getContents()+"-"+st.getCell(1,i).getContents()+"-";
	                     	ConditionDto conditionDto = new ConditionDto();
	                     	conditionDto.setConditionFiled("cableName");
	                     	conditionDto.setConditionConditions("like");
	                     	conditionDto.setConditionValue(cableName);
	                     	conditionDto.setOrderFiled("cableId");
	                     	conditionDto.setOrderValue("desc");
	            			List<TemplateBeen> list = (List<TemplateBeen>)templateDaoForTranscationAdd
	            															.query(conditionDto,Constant.A_CABLE)
	            														    .get(Constant.BEENLIST);
	            			/** 判断数据库是否存在对应的光缆名称前缀 */
	            			if(list.size()==0){
	            				if(cableNameMap.get(cableName)!=null){
	            					String tempCableName =cableNameMap.get(cableName);
	            					String subfix = tempCableName.substring(tempCableName.lastIndexOf("-")+1,tempCableName.length());
		            				subfix = String.valueOf(Integer.valueOf(subfix)+1);
		            				cableName = tempCableName.substring(0,tempCableName.lastIndexOf("-")+1)+subfix;
	            				}else{
	            					cableName +="1";
	            				}
	            			}else{
	            				cableName = ((A_Cable)list.get(0)).getCableName();
	            				String tempCableName = cableName.substring(0,cableName.lastIndexOf("-")+1);
	            				if(cableNameMap.get(tempCableName)!=null){
	            					tempCableName = cableNameMap.get(tempCableName);
	            					String subfix = tempCableName.substring(tempCableName.lastIndexOf("-")+1,tempCableName.length());
		            				subfix = String.valueOf(Integer.valueOf(subfix)+1);
		            				cableName = tempCableName.substring(0,tempCableName.lastIndexOf("-")+1)+subfix;
	            				}else{
	            					String subfix = cableName.substring(cableName.lastIndexOf("-")+1,cableName.length());
		            				subfix = String.valueOf(Integer.valueOf(subfix)+1);
		            				cableName = cableName.substring(0,cableName.lastIndexOf("-")+1)+subfix;
	            				}
	            				
	            			}
	            			cable.setCableName(cableName);
	            			cableNameMap.put(cableName.substring(0,cableName.lastIndexOf("-")+1), cableName);
	            			/** 获取光缆主键 */
          					cable.setCableId(String.valueOf(cableNameMap.get("cableId")));
          					cableNameMap.put("cableId", String.valueOf(
          														Integer.valueOf(
          																	cableNameMap.get("cableId")
          												)+1)
          									);
	                     	templateDaoForTranscationAdd.transcationAddIncludeId(cable, dBManager);
	                     	{
	                     		/** 判断是否配置纤芯列表的情况 */
	               			 int fiberCoreNumberCount = 0;
	               				 ConditionDto _conditionDto = new ConditionDto();
	               				_conditionDto.setConditionFiled("fiberId");
	               				_conditionDto.setConditionConditions("like");
	               				_conditionDto.setConditionValue(cable.getFiberId());
	               				 Map<String, Object> map = templateDaoForTranscationAdd.query(_conditionDto,Constant.B_FIBER);
	               				 fiberCoreNumberCount =Integer.valueOf(((List<B_Fiber>)map.get(Constant.BEENLIST)).get(0).getFiberCoreNumber());
	               				 for(int _i=1;_i<=fiberCoreNumberCount;_i++){
	               					 A_FiberCoreNumber fiberCoreNumber = new A_FiberCoreNumber();
	               					 fiberCoreNumber.setFiberCoreNumberName("纤芯"+_i);
	               					 /** 查询最近的主键，并加1 */
	               					 fiberCoreNumber.setCableId(cable.getCableId());
	               					 fiberCoreNumber.setIsUsed("");
	               					 fiberCoreNumber.setIsJump("");
	               					 fiberCoreNumber.setBizType("");
	               					 fiberCoreNumber.setStartConnections("{\"siteId\":\""+cable.getCableStartId()+"\"}");
	               					 fiberCoreNumber.setEndConnections("{\"siteId\":\""+cable.getCableEndId()+"\"}");
	               					 fiberCoreNumber.setTransceiver("");
	               					 fiberCoreNumber.setDelFlg("启用");
	               					fiberCoreNumber.setDescp("");
	               					templateDaoForTranscationAdd.transcationAdd(fiberCoreNumber,dBManager);
	               				 }
	                     	}
	                     } 
	        			dBManager.closeTranscation();
                     }catch(Exception e){
                    	 dBManager.rollbackTranscation();
                    	 printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的记录出现错误。'"+Method.getExceptionMessage(e)));
          				return;
         			 }finally{
	             		dBManager.closeConnection();
         				rwb.close();  
         			 } 
            	 }
            } 
         printWriter.append(Message.SUCCESSMESSAGE_IMPORT);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * 下载excel模板,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void downloadExcel(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			/** 生成excel */
			String excelName="上传模板-光缆.xls";
			String excelPath = Constant.IMPORTEXCELDIR +excelName;
			WritableWorkbook book = Workbook.createWorkbook(new File(excelPath));
			WritableSheet cableSheet = book.createSheet("光缆列表",0);
			WritableSheet siteSheet = book.createSheet("站点集合",1);
			WritableSheet fiberSheet = book.createSheet("光纤集合",2);
			WritableSheet constructionUnitSheet = book.createSheet("施工单位集合",3);
			/** 必填样式 */
			WritableFont requiredFont = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);
			WritableCellFormat requiredFormat = new WritableCellFormat(requiredFont);
			requiredFormat.setAlignment(jxl.format.Alignment.CENTRE);
			requiredFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			requiredFormat.setWrap(true);
			/** 普通样式 */
			WritableFont normalFont = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
			WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
			normalFormat.setAlignment(jxl.format.Alignment.CENTRE);
			normalFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			normalFormat.setWrap(true);
			/** 表头内容+列宽 */
			Label headLabel0 = new Label(0, 0, "光缆起点(必填)", requiredFormat);
			WritableCellFeatures startSiteWritableCellFeatures = new WritableCellFeatures();
			startSiteWritableCellFeatures.setComment("输入值,请查看sheet-站点集合");
			headLabel0.setCellFeatures(startSiteWritableCellFeatures);
			cableSheet.addCell(headLabel0);
			cableSheet.setColumnView(0, 30);
			Label headLabel1 = new Label(1, 0, "光缆终点(必填)", requiredFormat);
			WritableCellFeatures endSiteWritableCellFeatures = new WritableCellFeatures();
			endSiteWritableCellFeatures.setComment("输入值,请查看sheet-站点集合");
			headLabel1.setCellFeatures(endSiteWritableCellFeatures);
			cableSheet.addCell(headLabel1);
			cableSheet.setColumnView(1, 30);
			Label headLabel2 = new Label(2, 0, "是否主干网(必填)", requiredFormat);
			WritableCellFeatures isMarjorWritableCellFeatures = new WritableCellFeatures(); 
			isMarjorWritableCellFeatures.setComment("输入值为：是，否");
			headLabel2.setCellFeatures(isMarjorWritableCellFeatures); 
			cableSheet.addCell(headLabel2);
			cableSheet.setColumnView(2, 30);
			Label headLabel3 = new Label(3, 0, "光缆类型", normalFormat);
			cableSheet.addCell(headLabel3);
			cableSheet.setColumnView(3, 30);
			Label headLabel4 = new Label(4, 0, "光缆长度(km)", normalFormat);
			cableSheet.addCell(headLabel4);
			cableSheet.setColumnView(4, 30);
			Label headLabel5 = new Label(5, 0, "纤芯数量(必填)", requiredFormat);
			WritableCellFeatures fiberWritableCellFeatures = new WritableCellFeatures();
			fiberWritableCellFeatures.setComment("输入值,请查看sheet-光纤集合");
			headLabel5.setCellFeatures(fiberWritableCellFeatures);
			cableSheet.addCell(headLabel5);
			cableSheet.setColumnView(5, 30);
			Label headLabel6 = new Label(6, 0, "敷设类型", normalFormat);
			cableSheet.addCell(headLabel6);
			cableSheet.setColumnView(6, 30);
			Label headLabel7 = new Label(7, 0, "投运时间", normalFormat);
			cableSheet.addCell(headLabel7);
			cableSheet.setColumnView(7, 30);
			Label headLabel8 = new Label(8, 0, "施工单位(必填)", requiredFormat);
			WritableCellFeatures constructionUnitWritableCellFeatures = new WritableCellFeatures();
			constructionUnitWritableCellFeatures.setComment("输入值,请查看sheet-施工单位集合");
			headLabel8.setCellFeatures(constructionUnitWritableCellFeatures);
			cableSheet.addCell(headLabel8);
			cableSheet.setColumnView(8, 30);
			Label headLabel9 = new Label(9, 0, "业务类型", normalFormat);
			WritableCellFeatures bizTypeWritableCellFeatures = new WritableCellFeatures(); 
			bizTypeWritableCellFeatures.setComment("输入值为：用电，配电");
			headLabel9.setCellFeatures(bizTypeWritableCellFeatures); 
			cableSheet.addCell(headLabel9);
			cableSheet.setColumnView(9, 30);
			Label headLabel10 = new Label(10, 0, "是否启用(必填)", requiredFormat);
			WritableCellFeatures delFlgWritableCellFeatures = new WritableCellFeatures(); 
			delFlgWritableCellFeatures.setComment("输入值为：启用，停用");
			headLabel10.setCellFeatures(delFlgWritableCellFeatures); 
			cableSheet.addCell(headLabel10);
			cableSheet.setColumnView(10, 30);
			Label headLabel11 = new Label(11, 0, "备注", normalFormat);
			cableSheet.addCell(headLabel11);
			cableSheet.setColumnView(11, 30);
			/** 实例化查询接口 */
			TemplateDao templateDao = new TemplateDaoImpl();
			/** 站点集合 */
			{
				Label headLabel = new Label(0, 0, "站点名称", requiredFormat);
				siteSheet.addCell(headLabel);
				siteSheet.setColumnView(0,100);
				Map<String, Object> map = templateDao.query(Constant.A_SITE);
				int rowCount = 1;
				for (A_Site site : (List<A_Site>)map.get(Constant.BEENLIST)) {
					Label contentLabel = new Label(0, rowCount,site.getSiteName(),normalFormat);
					siteSheet.addCell(contentLabel);
					rowCount++;
				}
			}
			/** 光纤集合 */
			{
				Label headLabel = new Label(0, 0, "光纤名称", requiredFormat);
				fiberSheet.addCell(headLabel);
				fiberSheet.setColumnView(0,100);
				Map<String, Object> map = templateDao.query(Constant.B_FIBER);
				int rowCount = 1;
				for (B_Fiber fiber : (List<B_Fiber>)map.get(Constant.BEENLIST)) {
					Label contentLabel = new Label(0, rowCount,fiber.getFiberName(),normalFormat);
					fiberSheet.addCell(contentLabel);
					rowCount++;
				}
			}
			/** 施工单位集合 */
			{
				Label headLabel = new Label(0, 0, "施工单位名称", requiredFormat);
				constructionUnitSheet.addCell(headLabel);
				constructionUnitSheet.setColumnView(0,100);
				Map<String, Object> map = templateDao.query(Constant.B_CONSTRUCTIONUNIT);
				int rowCount = 1;
				for (B_ConstructionUnit constructionUnit : (List<B_ConstructionUnit>)map.get(Constant.BEENLIST)) {
					Label contentLabel = new Label(0, rowCount,constructionUnit.getConstructionUnitName(),normalFormat);
					constructionUnitSheet.addCell(contentLabel);
					rowCount++;
				}
			}
			/** 写入数据并关闭文件 */
			book.write();
			book.close();
			/** 设置为下载application/x-download */
			String requestUrl = request.getRequestURI();
			requestUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/"))+"/download/"+excelName;
			printWriter.append(Method.getJsonFormat(Message.SUCCESSMESSAGE_DOWNLOAD+",url:'"+requestUrl+"'"));
			printWriter.close();
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_DOWNLOAD+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * 获取光缆名称,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	@SuppressWarnings("unchecked")
	public void getCableName(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.query((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_CABLE);
			List<TemplateBeen> list = (List<TemplateBeen>)map.get(Constant.BEENLIST);
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			if(list.size()==0){
				jsonMap.put(Constant.RESULT,Message.SUCCESSMESSAGE_QUERY);
				jsonMap.put(Constant.BEEN,null);
			}else{
				String cableName = ((A_Cable)list.get(0)).getCableName();
				String subfix = cableName.substring(cableName.lastIndexOf("-")+1,cableName.length());
				subfix = String.valueOf(Integer.valueOf(subfix)+1);
				cableName = cableName.substring(0,cableName.lastIndexOf("-")+1)+subfix;
				cableName = "{'cableName':'"+cableName+"'}";
				jsonMap.put(Constant.RESULT,Message.SUCCESSMESSAGE_QUERY);
				jsonMap.put(Constant.BEEN,cableName);
			}
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} catch (Exception e) {
			/** 将数据封装成json格式 */
			Map<String,Object> jsonMap = new HashMap<String,Object>();
			jsonMap.put(Constant.RESULT,Method.getJsonFormat(Message.ERRORMESSAGE_QUERY+Method.getExceptionMessage(e)));
			JSONObject jsonObject = JSONObject.fromObject(jsonMap);
			printWriter.append(jsonObject.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
