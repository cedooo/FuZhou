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
    var conditionFiledStore = [['site.siteName','站点名称'],['site.areaId','所属区域'],['site.siteAdress','站点地址'],
    							['site.connactName','负责人姓名'],['site.connactNumber','负责人联系电话'],
    							['site.delFlg','是否启用'],['site.descp','备注']];
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	 /** combo下拉框-字段remote初始化 */
	var areaDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForArea.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"areaName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['areaId', 'areaName']
	});
	areaDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForArea.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});	
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'A_SiteServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root: 'beenList',
    		totalProperty : 'totalCount',
    		fields: ['siteId','siteName','areaId','areaName','siteAdress','connactName','connactNumber','delFlg','descp']
		});
/********************************************* Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '站点-查看',labelWidth:100,frame:true,defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
						        items: [
						        		{id:"viewSiteName",fieldLabel:'<font color="red">(*)</font>站点名称'},
						        		{id:"viewAreaName",fieldLabel:'<font color="red">(*)</font>所属区域'},
						        		{id:"viewSiteAdress",fieldLabel:'站点地址'},
						        		{id:"viewConnactName",fieldLabel:'负责人姓名'},
						        		{id:"viewConnactNumber",fieldLabel:'负责人联系电话'},
						        		{id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'},
						        		{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}
						        ]
						    });
						    
    	/** 新增-FormPanel */
    	var formPanel_add = new Ext.FormPanel({
						        title: '站点-新增',labelWidth:100,frame:true,defaultType:'textfield',
						        url:'A_SiteServiceImpl!add.zdy',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        items: [
						        	{
						        		name:'A_Site.siteName',fieldLabel:'<font color="red">(*)</font>站点名称',
    									emptyText:"请输入站点名称",allowBlank:false,blankText:"站点名称不能为空" 
						            },{
						            	name:'A_Site.areaId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属区域',
						                emptyText:'请选择所属区域',allowBlank:false,blankText:'所属区域不能为空',
						                mode:'local',store:areaDataStore,hiddenName:'A_Site.areaId',
						                displayField:'areaName',valueField:'areaId',
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                name:'A_Site.siteAdress',fieldLabel:'站点地址'
						            },{
						                name:'A_Site.connactName',fieldLabel:'负责人姓名'
						            },{
						            	name:'A_Site.connactNumber',xtype:'numberfield',fieldLabel:'负责人联系电话'
						            },{
						            	name:'A_Site.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                mode:'local',store:delFlgStore,
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	name:'A_Site.descp',fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '站点-更新',labelWidth:100,frame:true, 
						        url:'A_SiteServiceImpl!update.zdy',defaultType: 'textfield',
						        defaults:{labelStyle :"text-align:right;",anchor:'95%'},
						        items: [
						        	{	
						        		id:"updateSiteId",name:'A_Site.siteId',hidden:true
						            },{
						        		id:"updateSiteName",name:'A_Site.siteName',fieldLabel: '<font color="red">(*)</font>站点名称',
						                emptyText:"请输入站点名称",allowBlank:false,blankText:"站点名称不能为空" 
						            },{
						            	id:"updateAreaId",name:'A_Site.areaId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属区域',
						                emptyText:'请选择所属区域',allowBlank:false,blankText:'所属区域不能为空',
						                mode:'local',store:areaDataStore,hiddenName:'A_Site.areaId',
						                displayField:'areaName',valueField:'areaId',
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                id:"updateSiteAdress",name:'A_Site.siteAdress',fieldLabel:'站点地址'
						            },{
						            	id:"updateConnactName",name:'A_Site.connactName',fieldLabel: '负责人姓名'
						            },{
						            	id:"updateConnactNumber",name:'A_Site.connactNumber',
						            	xtype:'numberfield',fieldLabel: '负责人联系电话'
						            },{
						            	id:"updateDelFlg",name:'A_Site.delFlg',xtype:'combo',
						            	fieldLabel:'<font color="red">(*)</font>是否启用',mode: 'local',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",  
						                store:delFlgStore,
						                typeAhead: true,triggerAction: 'all',forceSelection:true
						            },{
						            	id:"updateDescp",name:'A_Site.descp',
						            	fieldLabel: '备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '站点-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'A_SiteServiceImpl!importExcel.zdy',
						        defaultType:'textfield',
						        items: [{
					                    id:'fileName',inputType:'file',
					                    fieldLabel: '<font color="red">(*)</font>上传文件名',labelStyle:"text-align:right;",  
					                    allowBlank:false,blankText:"上传的路径不能为空",anchor:'95%' 
						        }],
						        buttonAlign:'center',
						        buttons: [{
						            text: '下载excel模板',
						            handler:function(){
									   Ext.Ajax.request({
											url: 'A_SiteServiceImpl!downloadExcel.zdy',
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
	            				width:400,height:350,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_view,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_view.hide();}}]
	       					});				        				    
    	/** 新增窗口 */
    	var window_add = new Ext.Window({
	         					title: '新增窗口',closable:true,closeAction:"hide",
	            				width:400,height:350,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_add,
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
	         					title: '更新窗口',closable:true,closeAction:"hide",width:400,height:400,iconCls:'bgi_update',
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
        renderTo:"grid-size",title:'基础列表>>站点', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new Ext.grid.ColumnModel([sm,
        	 new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"站点名称",      width: 140, sortable:true,dataIndex:'siteName'},
            {header:"所属区域",      width: 140, sortable:true,dataIndex:'areaName'},
            {header:"站点地址",      width: 140, sortable:true,dataIndex:'siteAdress'},
            {header:"负责人姓名",    width: 120, sortable:true,dataIndex:'connactName'},
            {header:"负责人联系电话", width: 120, sortable:true,dataIndex:'connactNumber'},
            {header:"是否启用",      width: 120, sortable:true,dataIndex:'delFlg'},
            {header:"备注",         width: 120, sortable:true,dataIndex:'descp'}
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
							 url: 'A_SiteServiceImpl!exportExcel.zdy',
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
		 				Ext.getCmp("updateSiteId").setValue(_jsonData.get("siteId"));
						Ext.getCmp("updateSiteName").setValue(_jsonData.get("siteName"));
						Ext.getCmp("updateAreaId").setValue(_jsonData.get("areaId"));
						Ext.getCmp("updateSiteAdress").setValue(_jsonData.get("siteAdress"));
						Ext.getCmp("updateConnactName").setValue(_jsonData.get("connactName"));
						Ext.getCmp("updateConnactNumber").setValue(_jsonData.get("connactNumber"));
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
										_jsonData = _jsonData +  m[i].get("siteId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("siteId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_SiteServiceImpl!effective.zdy',
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
										_jsonData = _jsonData +  m[i].get("siteId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("siteId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_SiteServiceImpl!invalid.zdy',
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
										_jsonData = _jsonData +  m[i].get("siteId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("siteId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_SiteServiceImpl!delete.zdy',
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
													url: 'A_SiteServiceImpl!query.zdy',
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
							url: 'A_SiteServiceImpl!query.zdy',
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
			Ext.getCmp("viewSiteName").setValue(_jsonData.get("siteName"));
			Ext.getCmp("viewAreaName").setValue(_jsonData.get("areaName"));
			Ext.getCmp("viewSiteAdress").setValue(_jsonData.get("siteAdress"));
			Ext.getCmp("viewConnactName").setValue(_jsonData.get("connactName"));
			Ext.getCmp("viewConnactNumber").setValue(_jsonData.get("connactNumber"));
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
		if(Ext.getCmp('conditionFiled').getValue()=='site.delFlg'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:delFlgStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='site.areaId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:areaDataStore,
				displayField:'areaName',valueField:'areaId'
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
