Ext.onReady(function(){
	/*************************************** 数据初始化 ********************************************************/
	/** 加载tips提示信息 */
    Ext.QuickTips.init();
	/** 对话提示框 */
	var resultInfo ="操作结果对话框";
	var tipsInfo ="操作提示对话框";
	/** 表格序号 */
   var record_start = 0;
    /** combo下拉框-字段local初始化 */
    var conditionFiledStore = [['carrier.carrierName','载波名称'],['carrier.siteId','所属站点'],['carrier.projectId','所属项目'],
    						   ['carrier.installationSite','安装地址'],['carrier.debugging','调试情况'],['carrier.ip','IP地址'],['carrier.manufacturersId','所属厂家'],
    						   ['carrier.typeSpecification','型号规格'],['carrier.constructionUnitId','施工单位'],['carrier.runTime','投运时间'],
    						   ['carrier.installationLocation','主载波安装地址'],['carrier.delFlg','是否启用'],['carrier.descp','备注']];
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	 /** combo下拉框-字段remote初始化 */
	var siteDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForSite.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"siteName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['siteId', 'siteName']
	});
	siteDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForSite.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});	
	var projectDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForProject.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"projectName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['projectId', 'projectName']
	});
	projectDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForProject.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});	
	var constructionUnitDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForConstructionUnit.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"constructionUnitName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['constructionUnitId', 'constructionUnitName']
	});
	constructionUnitDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForConstructionUnit.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});
	var manufacturersDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForManufacturers.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"manufacturersName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['manufacturersId', 'manufacturersName']
	});
	manufacturersDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForManufacturers.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});		
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'A_CarrierServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root: 'beenList',
    		totalProperty : 'totalCount',
    		fields: ['carrierId','carrierName','siteId','siteName','projectId','projectName','installationSite',
    				 'debugging','ip','manufacturersId','manufacturersName','typeSpecification','constructionUnitId',
    				 'constructionUnitName','runTime','installationLocation','delFlg','descp']
		});
/********************************************* Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '载波-查看',labelWidth:100,frame:true, 
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						        items: [{
							        		items:[{
							        				layout:'form',columnWidth:1,defaultType:'textfield', 
							            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
							        				items:[{id:"viewCarrierName",fieldLabel:'<font color="red">(*)</font>载波名称'}]
							        		}]
						            	},{
							            	 items:[{
							            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
							            	 		defaults:{labelStyle:"text-align:right;",anchor:'90%',readOnly:true},
									            	items:[{id:"viewSiteName",fieldLabel:'<font color="red">(*)</font>所属站点'},
									            		   {id:"viewInstallationSite",fieldLabel:'安装地址'},
									            		   {id:"viewIp",fieldLabel:'IP地址'},
									            		   {id:"viewTypeSpecification",fieldLabel:'型号规格'},
									            		   {id:"viewRunTime",fieldLabel:'投运时间'}]
									            	},{
									            	layout:'form',columnWidth:.5,defaultType:'textfield',
									            	defaults:{labelStyle:"text-align:right;",anchor:'90%',readOnly:true}, 
									            	items:[{id:"viewProjectName",fieldLabel:'<font color="red">(*)</font>所属项目 '},
									            		   {id:"viewDebugging",fieldLabel:'调试情况'},
									            		   {id:"viewManufacturersName",fieldLabel:'<font color="red">(*)</font>所属厂家'},
									            		   {id:"viewConstructionUnitName",fieldLabel:'<font color="red">(*)</font>施工单位'},
									            		   {id:"viewInstallationLocation",fieldLabel:'主载波安装地址'},
									            		   {id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'}] 
							            	}]
						              },{
							        		items:[{
								        			layout:'form',columnWidth:1,defaultType:'textfield', 
								            	 	defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
								        			items:[{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}]
								        	}]
						            }
						        ]
						    });
						    
    	/** 新增-FormPanel */
    	var formPanel_add = new Ext.FormPanel({
						        title: '载波-新增',labelWidth:100,frame:true, 
						        url:'A_CarrierServiceImpl!add.zdy',
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						        items:[{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{	
						        						name:'A_Carrier.carrierName',fieldLabel:'<font color="red">(*)</font>载波名称',
    													emptyText:"请输入载波名称",allowBlank:false,blankText:"载波名称不能为空" 
    											}]
						        		}]
						            },{
						            	items:[{
						            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'90%'},
								            	items:[{
										            		name:'A_Carrier.siteId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属站点',
										                	emptyText:'请选择所属站点',allowBlank:false,blankText:'所属站点不能为空',
										                	mode:'local',store:siteDataStore,hiddenName:'A_Carrier.siteId',
										               		displayField:'siteName',valueField:'siteId',
										               	 	typeAhead:true,triggerAction:'all',forceSelection:true
								            	 	   },{
						              				 		name:'A_Carrier.installationSite',fieldLabel:'安装地址'
						            				   },{
									               			name:'A_Carrier.ip',fieldLabel:'IP地址'
									            	   },{
									               			name:'A_Carrier.typeSpecification',fieldLabel:'型号规格'
									            	   },{
									               			name:'A_Carrier.runTime',xtype:'datefield',fieldLabel:'投运时间',
									               			maxValue: new Date(),format:'Y-m-d',
						                					invalidText:"输入的日期格式不正确，请参考格式‘2014-01-01’格式"
									            	   }]
								            },{
								            	layout:'form',columnWidth:.5,defaultType:'textfield',
								            	defaults:{labelStyle:"text-align:right;",anchor:'90%'}, 
								            	items:[{
										            		name:'A_Carrier.projectId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属项目',
										               	 	emptyText:'请选择所属项目',allowBlank:false,blankText:'所属项目不能为空',
										               	 	mode:'local',store:projectDataStore,hiddenName:'A_Carrier.projectId',
										                	displayField:'projectName',valueField:'projectId',
										                	typeAhead:true,triggerAction:'all',forceSelection:true
								            		},{
						                					name:'A_Carrier.debugging',fieldLabel:'调试情况'
						           					},{
						                					name:'A_Carrier.manufacturersId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属厂家',
											                emptyText:'请选择所属厂家',allowBlank:false,blankText:'所属厂家不能为空',
											                mode:'local',store:manufacturersDataStore,hiddenName:'A_Carrier.manufacturersId',
											                displayField:'manufacturersName',valueField:'manufacturersId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
						           					},{
											                name:'A_Carrier.constructionUnitId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>施工单位',
											                emptyText:"请输入施工单位",allowBlank:false,blankText:"施工单位不能为空", 
											                mode:'local',store:constructionUnitDataStore,hiddenName:'A_Carrier.constructionUnitId',
											                displayField:'constructionUnitName',valueField:'constructionUnitId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
									            	},{
						                					name:'A_Carrier.installationLocation',fieldLabel:'主载波安装地址'
						           					},{
											            	name:'A_Carrier.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
											                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
											                mode:'local',store:delFlgStore,
											                typeAhead:true,triggerAction:'all',forceSelection:true
								             	}] 
						            	}]
						            },{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{	
						        					name:'A_Carrier.descp',fieldLabel:'备注',xtype:'textarea'
    											}]
						        		}]
						           }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '载波-更新',labelWidth:100,frame:true, 
						        url:'A_CarrierServiceImpl!update.zdy',
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						       	items:[{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{
						        						id:'updateCarrierId',name:'A_Carrier.carrierId',hidden:true
						        				},{	
						        						id:'updateCarrierName',name:'A_Carrier.carrierName',fieldLabel:'<font color="red">(*)</font>载波名称',
    													emptyText:"请输入载波名称",allowBlank:false,blankText:"载波名称不能为空" 
    											}]
						        		}]
						            },{
						            	items:[{
						            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'90%'},
								            	items:[{
										            	id:'updateSiteId',name:'A_Carrier.siteId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属站点',
										                emptyText:'请选择所属站点',allowBlank:false,blankText:'所属站点不能为空',
										                mode:'local',store:siteDataStore,hiddenName:'A_Carrier.siteId',
										               	displayField:'siteName',valueField:'siteId',
										               	typeAhead:true,triggerAction:'all',forceSelection:true
								            	 	   },{
						              				 	id:'updateInstallationSite',name:'A_Carrier.installationSite',fieldLabel:'安装地址'
						            				   },{
									               		id:'updateIp',name:'A_Carrier.ip',fieldLabel:'IP地址'
									            	   },{
									               		id:'updateTypeSpecification',name:'A_Carrier.typeSpecification',fieldLabel:'型号规格'
									            	   },{
									               		id:'updateRunTime',name:'A_Carrier.runTime',xtype:'datefield',fieldLabel:'投运时间',
									               		maxValue: new Date(),format:'Y-m-d',
						                				invalidText:"输入的日期格式不正确，请参考格式‘2014-01-01’格式"
									            	   }]
								            },{
								            	layout:'form',columnWidth:.5,defaultType:'textfield',
								            	defaults:{labelStyle:"text-align:right;",anchor:'90%'}, 
								            	items:[{
										            	id:'updateProjectId',name:'A_Carrier.projectId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属项目',
										               	emptyText:'请选择所属项目',allowBlank:false,blankText:'所属项目不能为空',
										               	mode:'local',store:projectDataStore,hiddenName:'A_Carrier.projectId',
										                displayField:'projectName',valueField:'projectId',
										                typeAhead:true,triggerAction:'all',forceSelection:true
								            		},{
						                				id:'updateDebugging',name:'A_Carrier.debugging',fieldLabel:'调试情况'
						           					},{
						                				id:'updateManufacturersId',name:'A_Carrier.manufacturersId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属厂家',
											            emptyText:'请选择所属厂家',allowBlank:false,blankText:'所属厂家不能为空',
											            mode:'local',store:manufacturersDataStore,hiddenName:'A_Carrier.manufacturersId',
											            displayField:'manufacturersName',valueField:'manufacturersId',
											            typeAhead:true,triggerAction:'all',forceSelection:true
						           					},{
											            id:'updateConstructionUnitId',name:'A_Carrier.constructionUnitId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>施工单位',
											            emptyText:'请选择施工单位',allowBlank:false,blankText:'施工单位不能为空',
											            mode:'local',store:constructionUnitDataStore,hiddenName:'A_Carrier.constructionUnitId',
											            displayField:'constructionUnitName',valueField:'constructionUnitId',
											            ypeAhead:true,triggerAction:'all',forceSelection:true
									            	},{
						                				id:'updateInstallationLocation',name:'A_Carrier.installationLocation',fieldLabel:'主载波安装地址'
						           					},{
											           id:'updateDelFlg',name:'A_Carrier.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
											           emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
											           mode:'local',store:delFlgStore,
											           typeAhead:true,triggerAction:'all',forceSelection:true
								             	}] 
						            	}]
						            },{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{	
						        					id:'updateDescp',name:'A_Carrier.descp',fieldLabel:'备注',xtype:'textarea'
    											}]
						        		}]
						           }
						        ]

						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '载波-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'A_CarrierServiceImpl!importExcel.zdy',
						        defaultType:'textfield',
						        items: [{
					                    id:'fileName',inputType:'file',
					                    fieldLabel: '上传文件名<font color="red">(*)</font>',labelStyle:"text-align:right;",  
					                    allowBlank:false,blankText:"上传的路径不能为空",anchor:'95%' 
						        }],
						        buttonAlign:'center',
						        buttons: [{
						            text: '下载excel模板',
						            handler:function(){
									   Ext.Ajax.request({
											url: 'A_CarrierServiceImpl!downloadExcel.zdy',
											success: function(response){
												ajaxExcelSuccess(response);
											},
											failure: function(response,options){
												ajaxFailure(response,options);
											 }
										});
									}
								 }]
							});
     /************************************************ 窗口集合 ************************************************ */					    
		/** 查看窗口 */
    	var window_view = new Ext.Window({
	         					title: '查看窗口',closable:true,closeAction:"hide",
	            				width:600,height:400,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_view,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_view.hide();}}]
	       					});				        				    
    	/** 新增窗口 */
    	var window_add = new Ext.Window({
	         					title: '新增窗口',closable:true,closeAction:"hide",
	            				width:600,height:400,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_add,
	            				buttonAlign:'center',
						        buttons: 
						        [{
						            text: '保存',
						            handler:function(){
							            if (formPanel_add.form.isValid()) {
							            		formPanel_add.form.submit({
								                    waitMsg : '正在保存数据，稍后...',
								                    success: function(form,action){formSuccess(form, action);},
								                    failure: function(form,action){formFailure(form, action);}
								                });
							            }
						            }
						        },{
						            text: '重置',handler:function(){formPanel_add.getForm().reset();}
						        },{
						            text: '取消', handler:function(){window_add.hide();}
						        }]
	       					});
	       					
    	/** 更新窗口 */
    	var window_update = new Ext.Window({
	         					title: '更新窗口',closable:true,closeAction:"hide",width:600,height:400,iconCls:'bgi_update',
	            				plain:true,layout:'fit',items: formPanel_update,
	            				buttonAlign:'center',
						        buttons: 
						        [{
						            text: '保存',
						            handler:function(){
						            	if (formPanel_update.form.isValid()) {
							            		formPanel_update.form.submit({
								                    waitMsg : '正在更新数据，稍后...',
								                    success: function(form,action){formSuccess(form, action);},
								                    failure: function(form,action){formFailure(form, action);}
								                });
							            }
						            }
						        },{
						            text: '重置',handler:function(){formPanel_update.getForm().reset();}
						        },{
						            text: '取消',handler:function(){window_update.hide();}
						        }]
	       					});
	       					
	     /** 导入窗口 */
    	var window_import = new Ext.Window({
	         					title: '导入窗口',closable:true,closeAction:"hide",width:400,height:200,iconCls:'bgi_import',
	            				plain:true,layout: 'fit',items:formPanel_import,
	            				buttonAlign:'center',
						        buttons: 
						        [{  
			                        text: '保存',  
			                        handler: function() {  
			                        	if (formPanel_import.form.isValid()){ 
											formPanel_import.form.submit({
											   waitMsg : '正在导入数据，稍后...',
								               success: function(form,action){formSuccess(form, action);},
								               failure: function(form,action){formFailure(form, action);}
								            });
			                       		}
			                       	}	  
			                    },{
						            text: '重置',handler:function(){formPanel_import.getForm().reset();}
						        },{
						            text: '关闭',handler:function(){window_import.hide();}
						        }]
	       					});
 /********************************************** Grid ***********************************************************/
  	/** 自定义的checkbox列选择 */
    var sm = new Ext.grid.CheckboxSelectionModel({
    	/** 添加监听器 */
    	listeners:{
    	  /** 行选择事件 */
          rowselect : function (sm, rowIndex, keep, rec){
          	  var _updateBtn = Ext.getCmp('update');   var _effectiveBtn = Ext.getCmp('effective');
          	  var _invalidBtn = Ext.getCmp('invalid'); var _deleteBtn = Ext.getCmp('delete');
          	  /** 选择数量小于1的情况 */
          	  if(sm.getCount() < 1){
          	  	  _updateBtn.disable();_effectiveBtn.disable();_invalidBtn.disable();_deleteBtn.disable();
          	  }else if(sm.getCount() == 1){
          	  	  _updateBtn.enable();_effectiveBtn.enable();_invalidBtn.enable();_deleteBtn.enable();
          	  }else{
          	  	  _updateBtn.disable();_effectiveBtn.enable();_invalidBtn.enable();_deleteBtn.enable();
          	  }
          },
          /** 取消选择事件 */
          rowdeselect : function (sm, rowIndex, keep, rec){
          	  var _updateBtn = Ext.getCmp('update');   var _effectiveBtn = Ext.getCmp('effective');
          	  var _invalidBtn = Ext.getCmp('invalid'); var _deleteBtn = Ext.getCmp('delete');
          	  /** 选择数量小于1的情况 */
          	  if(sm.getCount() < 1){
          	  	  _updateBtn.disable();_effectiveBtn.disable();_invalidBtn.disable();_deleteBtn.disable();
          	  }else if(sm.getCount() == 1){
          	  	  _updateBtn.enable();_effectiveBtn.enable();_invalidBtn.enable();_deleteBtn.enable();
          	  }else{
          	  	  _updateBtn.disable();_effectiveBtn.enable();_invalidBtn.enable();_deleteBtn.enable();
          	  }
          }
        }
    }); 
    
    /** GridPanel */ 
   var functionGridPanel =  new Ext.grid.GridPanel({
        renderTo:"grid-size",title:'基础列表>>载波', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new Ext.grid.ColumnModel([sm,
        	 new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"载波名称", width: 140, sortable:true,dataIndex:'carrierName'},
            {header:"所属站点", width: 140, sortable:true,dataIndex:'siteName'},
            {header:"所属项目", width: 140, sortable:true,dataIndex:'projectName'},
            {header:"安装地址", width: 140, sortable:true,dataIndex:'installationSite'},
            {header:"调试情况", width: 120, sortable:true,dataIndex:'debugging'},
            {header:"IP地址", width: 120, sortable:true,dataIndex:'ip'},
            {header:"所属厂家", width: 120, sortable:true,dataIndex:'manufacturersName'},
            {header:"型号规格", width: 120, sortable:true,dataIndex:'typeSpecification'},
            {header:"施工单位", width: 120, sortable:true,dataIndex:'constructionUnitName'},
            {header:"投运时间", width: 120, sortable:true,dataIndex:'runTime'},
            {header:"主载波安装地址 ", width: 120, sortable:true,dataIndex:'installationLocation'},
            {header:"是否启用", width: 120, sortable:true,dataIndex:'delFlg'},
            {header:"备注",    width: 120, sortable:true,dataIndex:'descp'}
        ]),
        sm: sm,
        stripeRows: true,
        /** 分页工具栏 */
         bbar: new Ext.PagingToolbar({
             pageSize:50,store: gridPanelDataStore,displayInfo: true,
            displayMsg: '显示 {0}-{1}条 / 共 {2} 条',emptyMsg: "无数据",
            plugins:new Ext.ui.plugins.ComboPageSize({ addToItem: false, prefixText: '每页', postfixText: '条'}),
            doLoad　:　function(startIndex){
				record_start　=　startIndex;
				gridPanelDataStore.baseParams = {start:startIndex,limit:Ext.getCmp('pageSizesCombo').getValue()};
				gridPanelDataStore.load();
			},
            items:['-',{
           	   	 text:'导入',tooltip:'导入',iconCls:'bgi_import',
           		 handler:function(){window_import.show();}
       		 }, '-', {
            	 text:'导出',tooltip:'导出',iconCls:'bgi_export',
            	 handler:function(){
            	 	var flag = 0;
            	  	/** 查询要导出的相应记录 */
						Ext.Ajax.request({
							 url: 'A_CarrierServiceImpl!exportExcel.zdy',
							 params: {
							 	"ConditionDto.conditionFiled":Ext.getCmp("conditionFiled").getValue(),
   								"ConditionDto.conditionConditions":"like",
								"ConditionDto.conditionValue":Ext.getCmp("conditionValue").getValue()
							 },
						     success: function(response){
						       	ajaxExcelSuccess(response);
							},
							failure: function(response,options){
								ajaxFailure(response,options);
							 }
						});
            	 }
        	 }]
        }),
        /** 菜单工具栏 */
        tbar:[{
           	   	 text:'新增',tooltip:'新增',iconCls:'bgi_add',handler:function(){
           	   	 window_add.show();}
       		 }, '-', {
       		 	 id:"update",disabled:true,text:'修改',tooltip:'修改',iconCls:'bgi_update',
            	 handler:function(){
            	 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){ 
           		 		var _jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
			 				Ext.getCmp("updateCarrierId").setValue(_jsonData.get("carrierId"));
							Ext.getCmp("updateCarrierName").setValue(_jsonData.get("carrierName"));
							Ext.getCmp("updateSiteId").setValue(_jsonData.get("siteId"));
							Ext.getCmp("updateProjectId").setValue(_jsonData.get("projectId"));
							Ext.getCmp("updateInstallationSite").setValue(_jsonData.get("installationSite"));
							Ext.getCmp("updateDebugging").setValue(_jsonData.get("debugging"));
							Ext.getCmp("updateIp").setValue(_jsonData.get("ip"));
							Ext.getCmp("updateManufacturersId").setValue(_jsonData.get("manufacturersId"));
							Ext.getCmp("updateTypeSpecification").setValue(_jsonData.get("typeSpecification"));
							Ext.getCmp("updateConstructionUnitId").setValue(_jsonData.get("constructionUnitId"));
							Ext.getCmp("updateRunTime").setValue(_jsonData.get("runTime"));
							Ext.getCmp("updateInstallationLocation").setValue(_jsonData.get("installationLocation"));
							Ext.getCmp("updateDelFlg").setValue(_jsonData.get("delFlg"));
							Ext.getCmp("updateDescp").setValue(_jsonData.get("descp"));
							window_update.show();
           		 	}else{
						Ext.MessageBox.alert(tipsInfo,'请选择要更新的数据项！');
					} 
            	 }
        	 },'-',{
        	 	 id:"effective",disabled:true,text:'启用',tooltip:'启用',iconCls:'bgi_effective',
           		 handler:function(){
           		 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		Ext.MessageBox.confirm('确认启用', '确认要启用选择的数据吗？', function(btn){
	           		 		if (btn == "yes") {
		           		 		var m = functionGridPanel.getSelectionModel().getSelections();
		           		 		var len = m.length;
								var _jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										_jsonData = _jsonData +  m[i].get("carrierId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("carrierId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CarrierServiceImpl!effective.zdy',
									   params: {"ids":_jsonData},
									   success: function(response,options){
									  	   ajaxSuccess(response,options);
									   },
									   failure: function(response,options){
									   	   ajaxFailure(response,options);
									   }
								});
	           		 		}
           		 		});
           		 	}else{
						Ext.MessageBox.alert(tipsInfo,'请选择要启用的数据项。');
					} 
           		 }
        	 },'-',{
        	 	 id:"invalid",disabled:true,
           		 text:'停用',tooltip:'停用',iconCls:'bgi_invalid',
           		 handler:function(){
           		 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		Ext.MessageBox.confirm('确认停用', '确认要停用选择的数据吗？', function(btn){
	           		 		if (btn == "yes") {
		           		 		var m = functionGridPanel.getSelectionModel().getSelections();
		           		 		var len = m.length;
								var _jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										_jsonData = _jsonData +  m[i].get("carrierId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("carrierId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CarrierServiceImpl!invalid.zdy',
									   params: {"ids":_jsonData},
									   success: function(response,options){
									   		 ajaxSuccess(response,options);
									   },
									   failure: function(response,options){
									    	 ajaxFailure(response,options);
									   }
								});
	           		 		}
           		 		});
           		 	}else{
						Ext.MessageBox.alert(tipsInfo,'请选择要停用的数据项。');
					} 
           		 }
        	 },'-',{
        	 	 id:"delete",disabled:true,
           		 text:'删除',tooltip:'删除', iconCls:'bgi_delete',
           		 handler:function(){
           		 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		Ext.MessageBox.confirm('确认删除', '确认要删除选择的数据吗？', function(btn){
	           		 		if (btn == "yes") {
		           		 		var m = functionGridPanel.getSelectionModel().getSelections();
		           		 		var len = m.length;
								var _jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										_jsonData = _jsonData +  m[i].get("carrierId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("carrierId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CarrierServiceImpl!delete.zdy',
									   params: {"ids":_jsonData},
									   success: function(response,options){
									   		ajaxSuccess(response,options);
									   },
									   failure: function(response,options){
									   		ajaxFailure(response,options);
									   }
									    
								});
	           		 		}
           		 		});
           		 	}else{
						Ext.MessageBox.alert(tipsInfo,'请选择要删除的数据项！');
					} 
           		 }
        	  },{xtype:"tbfill"},'查询字段：',
        	 {
				id:"conditionFiled",xtype:'combo',fieldLabel:'查询字段',mode:'local',
				blankText:"查询字段不能为空",store:conditionFiledStore,  
				typeAhead: true,triggerAction:'all',forceSelection:true
			},'','查询内容：',{
				id:'conditionFiledPanel',xtype:'panel',defaultType:'textfield',
				defaults:{labelStyle :"text-align:right;",anchor:'100%'},
				items:[{id:"conditionValue",fieldLabel:'查询内容'}]
			},{
				text:'查找',tooltip:'查找',iconCls:'bgi_search',handler:function(){
				 /** 刷新页面数据 */
					gridPanelDataStore.load({
							callback: function(records, operation, success) {
								if(!success){
											  Ext.Ajax.request({
													url: 'A_CarrierServiceImpl!query.zdy',
													success: function(response){ajaxQuerySuccess(response);},
													failure: function(response,options){ajaxFailure(response,options);}
											  });
								}
							}
				});
			}
        }]
    });
    
   /*********************************************** 事件初始化*******************************************************/
     /** gridPanelDataStore加载前的事件 */
     var refreshMsgTip;
     gridPanelDataStore.on('beforeload',function(){
     	refreshMsgTip = Ext.MessageBox.wait('页面数据刷新中,请稍等',tipsInfo,{text:"正在获取数据..."});
     	gridPanelDataStore.baseParams["ConditionDto.conditionFiled"] = Ext.getCmp("conditionFiled").getValue();
     	gridPanelDataStore.baseParams["ConditionDto.conditionConditions"] = "like";
     	gridPanelDataStore.baseParams["ConditionDto.conditionValue"] = Ext.getCmp("conditionValue").getValue();
	 });
	 gridPanelDataStore.on('load',function(){refreshMsgTip.hide();});
	 gridPanelDataStore.on('reLoad',function(){refreshMsgTip.hide();});
	 
	  /** gridPanelDataStore加载数据事件 */
	 function refreshGridPanel(_flag){
		  if(_flag != 1){
		  	return false;
		  }
		 /** 刷新页面数据 */
		  gridPanelDataStore.load({
		  		callback: function(records, operation, success) {
			  		if(!success){
			  			Ext.Ajax.request({
							url: 'A_CarrierServiceImpl!query.zdy',
							success: function(response){
								ajaxQuerySuccess(response);
							},
							failure: function(response,options){
								ajaxFailure(response,options);
							 }
						});
			  		}
				}
		});	
	}	
	refreshGridPanel(1);
	
	/** 增加行双击查看事件-并不从访问后台数据库 */
	var onrowdoubleclick = function(functionGridPanel, index, e){
         var _record = functionGridPanel.getSelectionModel().getSelected();
         if (_record){
           	var _jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
			Ext.getCmp("viewCarrierName").setValue(_jsonData.get("carrierName"));
			Ext.getCmp("viewSiteName").setValue(_jsonData.get("siteName"));
			Ext.getCmp("viewProjectName").setValue(_jsonData.get("projectName"));
			Ext.getCmp("viewInstallationSite").setValue(_jsonData.get("installationSite"));
			Ext.getCmp("viewDebugging").setValue(_jsonData.get("debugging"));
			Ext.getCmp("viewIp").setValue(_jsonData.get("ip"));
			Ext.getCmp("viewManufacturersName").setValue(_jsonData.get("manufacturersName"));
			Ext.getCmp("viewTypeSpecification").setValue(_jsonData.get("typeSpecification"));
			Ext.getCmp("viewConstructionUnitName").setValue(_jsonData.get("constructionUnitName"));
			Ext.getCmp("viewRunTime").setValue(_jsonData.get("runTime"));
			Ext.getCmp("viewInstallationLocation").setValue(_jsonData.get("installationLocation"));
			Ext.getCmp("viewDelFlg").setValue(_jsonData.get("delFlg"));
			Ext.getCmp("viewDescp").setValue(_jsonData.get("descp"));
			window_view.show();
          }else{
			Ext.MessageBox.alert(tipsInfo,'请双击要查看的数据项！');
		  } 
    }
    functionGridPanel.addListener('rowdblclick', onrowdoubleclick);
    
    
    /** form回调函数 */
    function formSuccess(form, action){
    	var _flag = 0;
    	Ext.MessageBox.alert(resultInfo,action.result.message,function(){
				_flag = _flag+1;refreshGridPanel(_flag);
		});
    }
    function formFailure(form, action){
       if(action.failureType == Ext.form.Action.SERVER_INVALID){
			Ext.MessageBox.alert(resultInfo,action.result.message);
	   }else if (action.failureType == Ext.form.Action.LOAD_FAILURE){
			Ext.MessageBox.alert(resultInfo,"读取服务器返回信息错误");
	   }else if (action.failureType == Ext.form.Action.CLIENT_INVALID){
			Ext.MessageBox.alert(resultInfo, "客户端验证失败");
	   } else if (action.failureType == Ext.form.Action.CONNECT_FAILURE) {
			Ext.MessageBox.alert(resultInfo,"糟糕，连接服务器失败！");
	   }else{
			Ext.MessageBox.alert(resultInfo,"未知异常！");
	   }
    }
    /** ajax回调函数 */
    function ajaxSuccess(response,options){
    	 var _flag = 0;
		 var responseJson = Ext.util.JSON.decode(response.responseText);
		 if(responseJson.success){
				Ext.MessageBox.alert(resultInfo,responseJson.message,function(){_flag = _flag+1;refreshGridPanel(_flag);});
		 }else{
				Ext.MessageBox.alert(resultInfo,responseJson.message,function(){_flag = _flag+1;refreshGridPanel(_flag);});
		}
	}
	function ajaxQuerySuccess(response){
    	var _responseJson = Ext.util.JSON.decode(response.responseText);
		var _result = Ext.util.JSON.decode(_responseJson.result);
		if(_result.success){
		 	gridPanelDataStore.load();
		}else{
			Ext.MessageBox.alert(resultInfo,_result.message);
		}
    }
	function ajaxExcelSuccess(response){
		 var _responseJson = Ext.util.JSON.decode(response.responseText);
		 if(_responseJson.success){
			window.location.href=_responseJson.url;
			Ext.MessageBox.alert(resultInfo,_responseJson.message);
		}else{
			Ext.MessageBox.alert(resultInfo,_responseJson.message);
		}
	}
	function ajaxFailure(response,options){
		if(response.status == "404"){
			Ext.MessageBox.alert(resultInfo,"请求的地址有误，请联系管理人员。");
		}else if(response.status == "0"){
			Ext.MessageBox.alert(resultInfo,"连接不到服务器，请联系管理人员");
		}else{
			Ext.MessageBox.alert(resultInfo,"未知错误，请联系管理人员");
	    }
	}
	/** 查询下拉框事件 */
	function conditionFiledSelect(){
		Ext.getCmp('conditionFiledPanel').remove("conditionValue");
		if(Ext.getCmp('conditionFiled').getValue()=='carrier.delFlg'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:delFlgStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='carrier.siteId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:siteDataStore,
				displayField:'siteName',valueField:'siteId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='carrier.projectId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:projectDataStore,
				displayField:'projectName',valueField:'projectId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='carrier.constructionUnitId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:constructionUnitDataStore,
				displayField:'constructionUnitName',valueField:'constructionUnitId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='carrier.manufacturersId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:manufacturersDataStore,
				displayField:'manufacturersName',valueField:'manufacturersId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='carrier.runTime'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.DateField({
				id:"conditionValue",xtype:'datefield',fieldLabel:'查询内容',
				maxValue: new Date(),format:'Y-m-d',
				invalidText:"输入的日期格式不正确，请参考格式‘2014-01-01’格式"
			}));
		}else{
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.TextField({
				id:"conditionValue",fieldLabel:'查询内容'
			}));
		};
		Ext.getCmp('conditionFiledPanel').doLayout();
	}	
  	Ext.getCmp('conditionFiled').addListener('select',conditionFiledSelect);
    /** functionGridPanel宽度自适应 */
    window.onresize=function(){
		functionGridPanel.setWidth(Ext.get("grid-size").getWidth());
		functionGridPanel.setHeight(Ext.get("grid-size").getHeight());
	};
});
