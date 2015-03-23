package zdy.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import zdy.common.Constant;
import zdy.common.Forward;
import zdy.common.Message;
import zdy.common.Method;
import zdy.dao.TemplateDao;
import zdy.dao.impl.TemplateDaoImpl;
import zdy.model.A_FiberCoreNumber;
import zdy.model.A_FiberCoreNumberDto;
import zdy.model.ConditionDto;
import zdy.model.PageDto;

public class A_FiberCoreNumberServiceImpl extends Forward {

	/** UID */
	private static final long serialVersionUID = 1L;

	/**
	 * 增加,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.add(request.getAttribute(Constant.A_FIBERCORENUMBER));
			printWriter.append(Message.SUCCESSMESSAGE_ADD);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_ADD+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
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
					Constant.A_FIBERCORENUMBER);
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
					Constant.A_FIBERCORENUMBER);
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
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.delete((String) request.getParameter(Constant.IDS),
					Constant.A_FIBERCORENUMBER);
			printWriter.append(Message.SUCCESSMESSAGE_DELETE);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_DELETE+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	/**
	 * 更新,操作结果写入到PrintWriter用于页面的ajax结果显示
	 * 
	 * @param 【HttpServletRequest,HttpServletResponse】
	 * @throws 【IOException】
	 * @throws 【SQLException】
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/** 获取输出流，设置为UTF-8 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		A_FiberCoreNumber a_FiberCoreNumber = (A_FiberCoreNumber)request.getAttribute(Constant.A_FIBERCORENUMBER);
		if("".equals(a_FiberCoreNumber.getIsUsed())){
			a_FiberCoreNumber.setIsUsed(null);
		}
		if("".equals(a_FiberCoreNumber.getIsJump())){
			a_FiberCoreNumber.setIsJump(null);
		}
		if("".equals(a_FiberCoreNumber.getBizType())){
			a_FiberCoreNumber.setBizType(null);
		}
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.update(request.getAttribute(Constant.A_FIBERCORENUMBER));
			printWriter.append(Message.SUCCESSMESSAGE_UPDATE);
		} catch (Exception e) {
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_UPDATE+Method.getExceptionMessage(e)));
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
		String sql=" select fiberCoreNumber.*,cable.cableName as cableName"+
		   " from a_fiberCoreNumber fiberCoreNumber  " +
		   " left join a_cable cable on(fiberCoreNumber.cableId = cable.cableId) ";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO), pageDto, Constant.A_FIBERCORENUMBERDTO,sql);
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
	 * 导出excel,操作结果写入到PrintWriter用于页面的ajax结果显示
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
		String sql=" select fiberCoreNumber.*,cable.cableName as cableName"+
		   " from a_fiberCoreNumber fiberCoreNumber  " +
		   " left join a_cable cable on(fiberCoreNumber.cableId = cable.cableId) ";
		try {

			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_FIBERCORENUMBERDTO,sql);
			/** 生成excel */
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String excelName="纤芯列表-"+simpleDateFormat.format(new Date())+".xls";
			String excelPath = Constant.EXPORTEXCELDIR +excelName;
			WritableWorkbook book = Workbook
					.createWorkbook(new File(excelPath));
			WritableSheet sheet = book.createSheet("纤芯列表", 0);
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
			Label headLabel1 = new Label(1, 0, "纤芯名称", headFormat);
			sheet.addCell(headLabel1);
			sheet.setColumnView(1, 30);
			Label headLabel2 = new Label(2, 0, "所属光缆", headFormat);
			sheet.addCell(headLabel2);
			sheet.setColumnView(2, 30);
			Label headLabel3 = new Label(3, 0, "是否使用", headFormat);
			sheet.addCell(headLabel3);
			sheet.setColumnView(3, 30);
			Label headLabel4 = new Label(4, 0, "是否跳转", headFormat);
			sheet.addCell(headLabel4);
			sheet.setColumnView(4, 30);
			Label headLabel5 = new Label(5, 0, "业务类型", headFormat);
			sheet.addCell(headLabel5);
			sheet.setColumnView(5, 30);
			Label headLabel6 = new Label(6, 0, "起始端", headFormat);
			sheet.addCell(headLabel6);
			sheet.setColumnView(6, 30);
			Label headLabel7 = new Label(7, 0, "目的端", headFormat);
			sheet.addCell(headLabel7);
			sheet.setColumnView(7, 30);
			Label headLabel8 = new Label(8, 0, "收发情况", headFormat);
			sheet.addCell(headLabel8);
			sheet.setColumnView(8, 30);
			Label headLabel9 = new Label(9, 0, "是否启用", headFormat);
			sheet.addCell(headLabel9);
			sheet.setColumnView(9, 30);
			Label headLabel10 = new Label(10, 0, "备注", headFormat);
			sheet.addCell(headLabel10);
			sheet.setColumnView(10, 30);
			/** 正文内容 */
			int rowCount = 1;
			for (A_FiberCoreNumberDto fiberCoreNumber : (List<A_FiberCoreNumberDto>)map.get(Constant.BEENLIST)) {
				Label label0 = new Label(0, rowCount, String
						.valueOf(rowCount), bodyNormalFormat);
				sheet.addCell(label0);
				Label label1 = new Label(1, rowCount,fiberCoreNumber.getFiberCoreNumberName(), bodyNormalFormat);
				sheet.addCell(label1);
				Label label2 = new Label(2, rowCount,fiberCoreNumber.getCableName(), bodyNormalFormat);
				sheet.addCell(label2);
				Label label3 = new Label(3, rowCount, fiberCoreNumber.getIsUsed(), bodyNormalFormat);
				sheet.addCell(label3);
				Label label4 = new Label(4, rowCount,fiberCoreNumber.getIsJump(), bodyNormalFormat);
				sheet.addCell(label4);
				Label label5 = new Label(5, rowCount,fiberCoreNumber.getBizType(), bodyNormalFormat);
				sheet.addCell(label5);
				{
					/** 对连接情况进行json解析 */
					JSONObject jsonObject = JSONObject.fromObject(fiberCoreNumber.getStartConnections());
					if(jsonObject==null||jsonObject.size()<1){
						Label label6 = new Label(6, rowCount,"",bodyNormalFormat);
						sheet.addCell(label6);
					}else{
						Label label6 = new Label(6, rowCount,jsonObject.getString("deviceName"),bodyNormalFormat);
						sheet.addCell(label6);
					}
				}
				{
					/** 对连接情况进行json解析 */
					JSONObject jsonObject = JSONObject.fromObject(fiberCoreNumber.getEndConnections());
					if(jsonObject==null||jsonObject.size()<1){
						Label label7 = new Label(7, rowCount,"",bodyNormalFormat);
						sheet.addCell(label7);
					}else{
						Label label7 = new Label(7, rowCount,jsonObject.getString("deviceName"),bodyNormalFormat);
						sheet.addCell(label7);
					}
				}
				Label label8 = new Label(8, rowCount, fiberCoreNumber.getTransceiver(),bodyNormalFormat);
				sheet.addCell(label8);
				Label label9 = new Label(9, rowCount, fiberCoreNumber.getDelFlg(),bodyNormalFormat);
				sheet.addCell(label9);
				Label label10 = new Label(10, rowCount, fiberCoreNumber.getDescp(),bodyNormalFormat);
				sheet.addCell(label10);
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
			System.out.println(e.getMessage());
			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_EXPORT+Method.getExceptionMessage(e)));
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
