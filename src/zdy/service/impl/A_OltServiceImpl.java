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
import zdy.model.A_Olt;
import zdy.model.A_OltDto;
import zdy.model.A_Site;
import zdy.model.B_ConstructionUnit;
import zdy.model.B_Manufacturers;
import zdy.model.B_Project;
import zdy.model.ConditionDto;
import zdy.model.PageDto;

public class A_OltServiceImpl extends Forward {

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
			templateDao.add(request.getAttribute(Constant.A_OLT));
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
					Constant.A_OLT);
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
					Constant.A_OLT);
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
					Constant.A_OLT);
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
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			templateDao.update(request.getAttribute(Constant.A_OLT));
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
		String sql=" select olt.*,project.projectName as projectName,site.siteName as siteName," +
		   " constructionunit.constructionunitName as constructionUnitName,manufacturers.manufacturersName as manufacturersName" +
		   " from a_olt olt  " +
		   " left join b_project  project on(olt.projectId =project.projectId) " +
		   " left join a_site  site on(olt.siteId  = site.siteId)" +
		   " left join b_manufacturers  manufacturers on(olt.manufacturersId  = manufacturers.manufacturersId)" +
		   " left join b_constructionUnit constructionUnit on(olt.constructionUnitId = constructionUnit.constructionUnitId) ";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO), pageDto, Constant.A_OLTDTO,sql);
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
		String sql=" select olt.*,project.projectName as projectName,site.siteName as siteName," +
		   " constructionunit.constructionunitName as constructionUnitName,manufacturers.manufacturersName as manufacturersName" +
		   " from a_olt olt  " +
		   " left join b_project  project on(olt.projectId =project.projectId) " +
		   " left join a_site  site on(olt.siteId  = site.siteId)" +
		   " left join b_manufacturers  manufacturers on(olt.manufacturersId  = manufacturers.manufacturersId)" +
		   " left join b_constructionUnit constructionUnit on(olt.constructionUnitId = constructionUnit.constructionUnitId) ";
		try {
			TemplateDao templateDao = new TemplateDaoImpl();
			Map<String, Object> map = templateDao.combinedQuery((ConditionDto) request
					.getAttribute(Constant.CONDITIONDTO),Constant.A_OLTDTO,sql);
			/** 生成excel */
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String excelName="olt表-"+simpleDateFormat.format(new Date())+".xls";
			String excelPath = Constant.EXPORTEXCELDIR +excelName;
			WritableWorkbook book = Workbook
					.createWorkbook(new File(excelPath));
			WritableSheet sheet = book.createSheet("olt列表", 0);
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
			Label headLabel1 = new Label(1, 0, "olt名称", headFormat);
			sheet.addCell(headLabel1);
			sheet.setColumnView(1, 30);
			Label headLabel2 = new Label(2, 0, "所属站点", headFormat);
			sheet.addCell(headLabel2);
			sheet.setColumnView(2, 30);
			Label headLabel3 = new Label(3, 0, "所属项目", headFormat);
			sheet.addCell(headLabel3);
			sheet.setColumnView(3, 30);
			Label headLabel4 = new Label(4, 0, "安装地址", headFormat);
			sheet.addCell(headLabel4);
			sheet.setColumnView(4, 30);
			Label headLabel5 = new Label(5, 0, "所属厂家", headFormat);
			sheet.addCell(headLabel5);
			sheet.setColumnView(5, 30);
			Label headLabel6 = new Label(6, 0, "型号规格", headFormat);
			sheet.addCell(headLabel6);
			sheet.setColumnView(6, 30);
			Label headLabel7 = new Label(7, 0, "所属施工单位", headFormat);
			sheet.addCell(headLabel7);
			sheet.setColumnView(7, 30);
			Label headLabel8 = new Label(8, 0, "投运时间", headFormat);
			sheet.addCell(headLabel8);
			sheet.setColumnView(8, 30);
			Label headLabel9 = new Label(9, 0, "VLANID", headFormat);
			sheet.addCell(headLabel9);
			sheet.setColumnView(9, 30);
			Label headLabel10 = new Label(10, 0, "Lookback地址", headFormat);
			sheet.addCell(headLabel10);
			sheet.setColumnView(10, 30);
			Label headLabel11 = new Label(11, 0, "OSPF进程号", headFormat);
			sheet.addCell(headLabel11);
			sheet.setColumnView(11, 30);
			Label headLabel12 = new Label(12, 0, "VPN实例名", headFormat);
			sheet.addCell(headLabel12);
			sheet.setColumnView(12, 30);
			Label headLabel13 = new Label(13, 0, "是否启用", headFormat);
			sheet.addCell(headLabel13);
			sheet.setColumnView(13, 30);
			Label headLabel14 = new Label(14, 0, "备注", headFormat);
			sheet.addCell(headLabel14);
			sheet.setColumnView(14, 30);
			/** 正文内容 */
			int rowCount = 1;
			for (A_OltDto a_OltDto : (List<A_OltDto>)map.get(Constant.BEENLIST)) {
				Label label0 = new Label(0, rowCount, String.valueOf(rowCount), bodyNormalFormat);
				sheet.addCell(label0);
				Label label1 = new Label(1, rowCount,a_OltDto.getOltName(), bodyNormalFormat);
				sheet.addCell(label1);
				Label label2 = new Label(2, rowCount,a_OltDto.getSiteName(), bodyNormalFormat);
				sheet.addCell(label2);
				Label label3 = new Label(3, rowCount,a_OltDto.getProjectName(), bodyNormalFormat);
				sheet.addCell(label3);
				Label label4 = new Label(4, rowCount,a_OltDto.getInstallationSite(), bodyNormalFormat);
				sheet.addCell(label4);
				Label label5 = new Label(5, rowCount,a_OltDto.getManufacturersName(),bodyNormalFormat);
				sheet.addCell(label5);
				Label label6 = new Label(6, rowCount,a_OltDto.getTypeSpecification(),bodyNormalFormat);
				sheet.addCell(label6);
				Label label7 = new Label(7, rowCount, a_OltDto.getConstructionUnitName(),bodyNormalFormat);
				sheet.addCell(label7);
				Label label8 = new Label(8, rowCount, a_OltDto.getRunTime(),bodyNormalFormat);
				sheet.addCell(label8);
				Label label9 = new Label(9, rowCount, a_OltDto.getVlanId(),bodyNormalFormat);
				sheet.addCell(label9);
				Label label10 = new Label(10, rowCount, a_OltDto.getLookbackLocation(),bodyNormalFormat);
				sheet.addCell(label10);
				Label label11 = new Label(11, rowCount, a_OltDto.getOspfNumber(),bodyNormalFormat);
				sheet.addCell(label11);
				Label label12 = new Label(12, rowCount, a_OltDto.getVpnNumber(),bodyNormalFormat);
				sheet.addCell(label12);
				Label label13 = new Label(13, rowCount, a_OltDto.getDelFlg(),bodyNormalFormat);
				sheet.addCell(label13);
				Label label14 = new Label(14, rowCount, a_OltDto.getDescp(),bodyNormalFormat);
				sheet.addCell(label14);
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
            		 String fileName="olt_"+String.valueOf(System.currentTimeMillis())+".xls";
            		 String excelPath = Constant.IMPORTEXCELDIR + fileName;
                     File file = new File(excelPath);  
                     item.write(file);
                     /** 解析excel */
                     InputStream is = new FileInputStream(excelPath);  
                     Workbook rwb = Workbook.getWorkbook(is); 
                     Sheet st = rwb.getSheets()[0];
                     int rows=st.getRows();
                     if(st.getColumns()!=14){
                    	 printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'上传格式不正确，请使用上传模板'"));
                    	 return;
                     }
                     /** 行 */  
                     DBManager dBManager = new DBManager();
                     int exceptionIndex =0;
                     try{
                    	 dBManager.openConnection();
 	             		 dBManager.openTranscation();
	                     for(int i=1;i<rows;i++){
	                    	 /** 表格行数据都为空则跳过 */
	                    	if( "".equals(st.getCell(0,i).getContents())&&"".equals(st.getCell(1,i).getContents())
		                      &&"".equals(st.getCell(2,i).getContents())&&"".equals(st.getCell(3,i).getContents())
		                      &&"".equals(st.getCell(4,i).getContents())&&"".equals(st.getCell(5,i).getContents())
		                      &&"".equals(st.getCell(6,i).getContents())&&"".equals(st.getCell(7,i).getContents())
		                      &&"".equals(st.getCell(8,i).getContents())&&"".equals(st.getCell(9,i).getContents())
		                      &&"".equals(st.getCell(10,i).getContents())&&"".equals(st.getCell(11,i).getContents())
		                      &&"".equals(st.getCell(12,i).getContents())&&"".equals(st.getCell(13,i).getContents())){
		                     			continue;
		                    }
	                    	/** 异常行的序号 */
	                    	exceptionIndex = i;
	                    	if(st.getCell(0,i).getContents()==null||"".equals(st.getCell(0,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的olt名称为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(1,i).getContents()==null||"".equals(st.getCell(1,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的所属起点为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(4,i).getContents()==null||"".equals(st.getCell(4,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的所属厂家为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(6,i).getContents()==null||"".equals(st.getCell(6,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的施工单位为空'"));
                     			return;
	                    	}
	                    	if(st.getCell(12,i).getContents()==null||"".equals(st.getCell(12,i).getContents())){
                     			printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的是否启用为空'"));
                     			return;
	                    	}
	                    	/** 实例化olt模型 */
	                    	A_Olt olt = new A_Olt();
	                     	olt.setOltName(st.getCell(0,i).getContents());
	                     	/** 下拉框查询实例 */
	                     	TemplateDao templateDaoForCombo = new TemplateDaoImpl();
	                    	/** 暂存下拉框的map */
	                    	Map<String, Object> mapForCombo = new HashMap<String,Object>();
	                    	ConditionDto conditionDtoForCombo = new ConditionDto();
	                    	conditionDtoForCombo.setConditionConditions("=");
	                    	conditionDtoForCombo.setOrderValue("asc");
	                     	/** 获取所属站点 */
	                     	conditionDtoForCombo.setConditionFiled("siteName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(1,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("siteName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.A_SITE);
	                     	List<A_Site> siteList =(List<A_Site>)mapForCombo.get(Constant.BEENLIST);
	                     	if(siteList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的所属站点名称错误'"));
                     			return;
	                     	}
	                     	olt.setSiteId(siteList.get(0).getSiteId());
	                     	/** 获取所属项目 */
	                     	if(!"".equals(st.getCell(2,i).getContents().trim())){
			                     	conditionDtoForCombo.setConditionFiled("projectName");
			                     	conditionDtoForCombo.setConditionValue(st.getCell(2,i).getContents());
			                     	conditionDtoForCombo.setOrderFiled("projectName");
			                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.B_PROJECT);
			                     	List<B_Project> projectList =(List<B_Project>)mapForCombo.get(Constant.BEENLIST);
			                     	if(projectList.size()<1){
			                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的所属项目错误'"));
		                     			return;
			                     	}
			                     	olt.setProjectId(projectList.get(0).getProjectId());
	                     	}
	                     	olt.setInstallationSite(st.getCell(3,i).getContents());
	                     	/** 获取所属厂家 */
	                    	conditionDtoForCombo.setConditionFiled("manufacturersName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(4,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("manufacturersName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.B_MANUFACTURERS);
	                     	List<B_Manufacturers> manufacturersList =(List<B_Manufacturers>)mapForCombo.get(Constant.BEENLIST);
	                     	if(manufacturersList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的所属厂家名称错误'"));
                     			return;
	                     	}
	                     	olt.setManufacturersId(manufacturersList.get(0).getManufacturersId());
	                     	olt.setTypeSpecification(st.getCell(5,i).getContents());
	                     	/** 获取施工单位 */
	                    	conditionDtoForCombo.setConditionFiled("constructionUnitName");
	                     	conditionDtoForCombo.setConditionValue(st.getCell(6,i).getContents());
	                     	conditionDtoForCombo.setOrderFiled("constructionUnitName");
	                     	mapForCombo =templateDaoForCombo.query(conditionDtoForCombo, Constant.B_CONSTRUCTIONUNIT);
	                     	List<B_ConstructionUnit> constructionUnitList =(List<B_ConstructionUnit>)mapForCombo.get(Constant.BEENLIST);
	                     	if(constructionUnitList.size()<1){
	                     		printWriter.append(Method.getJsonFormat(Message.ERRORMESSAGE_IMPORT+"+'第"+exceptionIndex+"行的施工单位名称错误'"));
                     			return;
	                     	}
	                     	olt.setConstructionUnitId(constructionUnitList.get(0).getConstructionUnitId());
	                     	olt.setRunTime(st.getCell(7,i).getContents());
	                     	olt.setVlanId(st.getCell(8,i).getContents());
	                     	olt.setLookbackLocation(st.getCell(9,i).getContents());
	                     	olt.setOspfNumber(st.getCell(10,i).getContents());
	                     	olt.setVpnNumber(st.getCell(11,i).getContents());
	                     	olt.setDelFlg(st.getCell(12,i).getContents());
	                     	olt.setDescp(st.getCell(13,i).getContents());
	                     	
	                     	TemplateDao templateDaoForTranscationAdd = new TemplateDaoImpl();
	                     	templateDaoForTranscationAdd.transcationAdd(olt,dBManager);
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
			String excelName="上传模板-olt.xls";
			String excelPath = Constant.IMPORTEXCELDIR +excelName;
			WritableWorkbook book = Workbook.createWorkbook(new File(excelPath));
			WritableSheet oltSheet = book.createSheet("olt列表",0);
			WritableSheet siteSheet = book.createSheet("站点集合",1);
			WritableSheet projectSheet = book.createSheet("项目集合",2);
			WritableSheet manufacturersSheet = book.createSheet("厂家集合",3);
			WritableSheet constructionUnitSheet = book.createSheet("施工单位集合",4);
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
			Label headLabel0 = new Label(0, 0, "olt名称(必填)", requiredFormat);
			oltSheet.addCell(headLabel0);
			oltSheet.setColumnView(0, 30);
			Label headLabel1 = new Label(1, 0, "所属站点(必填)", requiredFormat);
			WritableCellFeatures siteWritableCellFeatures = new WritableCellFeatures();
			siteWritableCellFeatures.setComment("输入值,请查看sheet-站点集合");
			headLabel1.setCellFeatures(siteWritableCellFeatures);
			oltSheet.addCell(headLabel1);
			oltSheet.setColumnView(1, 30);
			Label headLabel2 = new Label(2, 0, "所属项目", normalFormat);
			WritableCellFeatures projectWritableCellFeatures = new WritableCellFeatures();
			projectWritableCellFeatures.setComment("输入值,请查看sheet-项目集合");
			headLabel2.setCellFeatures(projectWritableCellFeatures);
			oltSheet.addCell(headLabel2);
			oltSheet.setColumnView(2, 30);
			Label headLabel3 = new Label(3, 0, "安装地址", normalFormat);
			oltSheet.addCell(headLabel3);
			oltSheet.setColumnView(3, 30);
			Label headLabel4 = new Label(4, 0, "所属厂家(必填)", requiredFormat);
			WritableCellFeatures manufacturersWritableCellFeatures = new WritableCellFeatures();
			manufacturersWritableCellFeatures.setComment("输入值,请查看sheet-厂家集合");
			headLabel4.setCellFeatures(manufacturersWritableCellFeatures);
			oltSheet.addCell(headLabel4);
			oltSheet.setColumnView(4, 30);
			Label headLabel5 = new Label(5, 0, "型号规格", normalFormat);
			oltSheet.addCell(headLabel5);
			oltSheet.setColumnView(5, 30);
			Label headLabel6 = new Label(6, 0, "施工单位(必填)", requiredFormat);
			WritableCellFeatures constructionUnitWritableCellFeatures = new WritableCellFeatures();
			constructionUnitWritableCellFeatures.setComment("输入值,请查看sheet-施工单位集合");
			headLabel6.setCellFeatures(constructionUnitWritableCellFeatures);
			oltSheet.addCell(headLabel6);
			oltSheet.setColumnView(6, 30);
			Label headLabel7 = new Label(7, 0, "投运时间", normalFormat);
			oltSheet.addCell(headLabel7);
			oltSheet.setColumnView(7, 30);
			Label headLabel8 = new Label(8, 0, "vlanId", normalFormat);
			oltSheet.addCell(headLabel8);
			oltSheet.setColumnView(8, 30);
			Label headLabel9 = new Label(9, 0, "lookback地址", normalFormat);
			oltSheet.addCell(headLabel9);
			oltSheet.setColumnView(9, 30);
			Label headLabel10 = new Label(10, 0, "ospf进程号", normalFormat);
			oltSheet.addCell(headLabel10);
			oltSheet.setColumnView(10, 30);
			Label headLabel11 = new Label(11, 0, "vpn实例名", normalFormat);
			oltSheet.addCell(headLabel11);
			oltSheet.setColumnView(11, 30);
			Label headLabel12 = new Label(12, 0, "是否启用(必填)", requiredFormat);
			WritableCellFeatures delFlgWritableCellFeatures = new WritableCellFeatures(); 
			delFlgWritableCellFeatures.setComment("输入值为：启用，停用");
			headLabel12.setCellFeatures(delFlgWritableCellFeatures); 
			oltSheet.addCell(headLabel12);
			oltSheet.setColumnView(12, 30);
			Label headLabel13 = new Label(13, 0, "备注", normalFormat);
			oltSheet.addCell(headLabel13);
			oltSheet.setColumnView(13, 30);
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
			/** 项目集合 */
			{
				Label headLabel = new Label(0, 0, "项目名称", requiredFormat);
				projectSheet.addCell(headLabel);
				projectSheet.setColumnView(0,100);
				Map<String, Object> map = templateDao.query(Constant.B_PROJECT);
				int rowCount = 1;
				for (B_Project project : (List<B_Project>)map.get(Constant.BEENLIST)) {
					Label contentLabel = new Label(0, rowCount,project.getProjectName(),normalFormat);
					projectSheet.addCell(contentLabel);
					rowCount++;
				}
			}
			/** 厂家集合 */
			{
				Label headLabel = new Label(0, 0, "厂家名称", requiredFormat);
				manufacturersSheet.addCell(headLabel);
				manufacturersSheet.setColumnView(0,100);
				Map<String, Object> map = templateDao.query(Constant.B_MANUFACTURERS);
				int rowCount = 1;
				for (B_Manufacturers manufacturers : (List<B_Manufacturers>)map.get(Constant.BEENLIST)) {
					Label contentLabel = new Label(0, rowCount,manufacturers.getManufacturersName(),normalFormat);
					manufacturersSheet.addCell(contentLabel);
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
}
