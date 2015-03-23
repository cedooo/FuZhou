Ext.onReady(function(){
	/*************************************** 初始化 ********************************************************/
	/** 加载tips提示信息 */
    Ext.QuickTips.init();
	/** 对话提示框 */
	var resultInfo ="操作结果对话框";
	var tipsInfo ="操作提示对话框";
	/** 表格序号 */
   var record_start = 0;
   /** combo下拉框-字段local初始化 */
    var conditionFiledStore = [['manufacturersName','厂家名称'],['connactName','厂家负责人'],['manufacturersAddress','厂家地址'],
    						   ['connactNumber','负责人联系电话'],['delFlg','是否启用'],['descp','备注']];
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'B_ManufacturersServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root:'beenList',
    		totalProperty:'totalCount',
    		fields:['manufacturersId','manufacturersName','connactName','manufacturersAddress','connactNumber','delFlg','descp']
		});
    /********************************** Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '厂家-查看',labelWidth:100,frame:true, 
						        defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
						        items: [
						        		{id:"viewManufacturersName",fieldLabel:'<font color="red">(*)</font>厂家名称'},
						        		{id:"viewConnactName",fieldLabel:'厂家名称'},
						        		{id:"viewManufacturersAddress",fieldLabel:'厂家地址' }, 
						        		{id:"viewConnactNumber",fieldLabel:'负责人联系电话'},
						        		{id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'},
						        		{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}
						        ]
						    });
						    
    	/** 新增-FormPanel */
    	var formPanel_add = new Ext.FormPanel({
						        title: '厂家-新增',labelWidth:100,frame:true, 
						        url:'B_ManufacturersServiceImpl!add.zdy',
						        defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        items: [
						        	{
						        		name:'B_Manufacturers.manufacturersName',fieldLabel:'<font color="red">(*)</font>厂家名称',
    									emptyText:"请输入厂家名称",allowBlank:false,blankText:"厂家名称不能为空" 
						            },{
						                name:'B_Manufacturers.connactName',fieldLabel:'厂家负责人'
						            },{
						                name:'B_Manufacturers.manufacturersAddress',fieldLabel:'厂家地址'
						            }, {
						            	name:'B_Manufacturers.connactNumber',xtype:'numberfield',fieldLabel:'负责人联系电话'
						            }, {
						            	name:'B_Manufacturers.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
						                mode:'local',store:delFlgStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	name:'B_Manufacturers.descp',fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '厂家-更新',labelWidth:100,frame:true, 
						        url:'B_ManufacturersServiceImpl!update.zdy',
						        defaultType: 'textfield',
						        defaults:{labelStyle :"text-align:right;",anchor:'95%'},
						        items: [
						        	{	
						        		id:"updateManufacturersId",name:'B_Manufacturers.manufacturersId',hidden:true
						            },{
						        		id:"updateManufacturersName",name:'B_Manufacturers.manufacturersName',fieldLabel: '<font color="red">(*)</font>厂家名称',
						                emptyText:"请输入厂家名称",allowBlank:false,blankText:"厂家名称不能为空" 
						            },{
						            	id:"updateConnactName",name:'B_Manufacturers.connactName',fieldLabel: '厂家负责人'
						            },{
						            	id:"updateManufacturersAddress",name:'B_Manufacturers.manufacturersAddress',fieldLabel:'厂家地址'
						            }, {
						            	id:"updateConnactNumber",name:'B_Manufacturers.connactNumber',
						            	xtype:'numberfield',fieldLabel: '负责人联系电话'
						            },{
						            	id:"updateDelFlg",name:'B_Manufacturers.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",  
						                mode:'local',store:delFlgStore,
						                typeAhead: true,triggerAction: 'all',forceSelection:true
						            },{
						            	id:"updateDescp",name:'B_Manufacturers.descp',
						            	fieldLabel: '备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '厂家-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'B_ManufacturersServiceImpl!importExcel.zdy',
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
											url: 'B_ManufacturersServiceImpl!downloadExcel.zdy',
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
	            				width:400,height:300,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_view,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_view.hide();}}]
	       					});				        				    
    	/** 新增窗口 */
    	var window_add = new Ext.Window({
	         					title: '新增窗口',closable:true,closeAction:"hide",
	            				width:400,height:300,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_add,
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
	         					title: '更新窗口',closable:true,closeAction:"hide",width:400,height:320,iconCls:'bgi_update',
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
  /************************************ Grid ***********************************************************/ 
    /** 自定义的checkbox列选择 */
    var xg = Ext.grid;
    var sm = new xg.CheckboxSelectionModel({
    	/** 添加监听器 */
    	listeners:{
    	  /** 行选择事件 */
          rowselect : function (sm, rowIndex, keep, rec){
          	  var _updateBtn = Ext.getCmp('update');
          	  var _effectiveBtn = Ext.getCmp('effective');
          	  var _invalidBtn = Ext.getCmp('invalid');
          	  var _deleteBtn = Ext.getCmp('delete');
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
          	  var _updateBtn = Ext.getCmp('update');
          	  var _effectiveBtn = Ext.getCmp('effective');
          	  var _invalidBtn = Ext.getCmp('invalid');
          	  var _deleteBtn = Ext.getCmp('delete');
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
   var functionGridPanel =  new xg.GridPanel({
        renderTo:"grid-size",title:'下拉维护表>>厂家', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new xg.ColumnModel([sm,
        	new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"厂家名称",    width: 140, sortable:true,dataIndex:'manufacturersName'},
            {header:"厂家负责人",   width: 120, sortable:true,dataIndex:'connactName'},
            {header:"厂家地址",    width: 120, sortable:true,dataIndex:'manufacturersAddress'},
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
							 url: 'B_ManufacturersServiceImpl!exportExcel.zdy',
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
           	   	 text:'新增',tooltip:'新增',iconCls:'bgi_add',handler:function(){window_add.show();}
       		 }, '-', {
       		 	 id:"update",disabled:true,text:'修改',tooltip:'修改',iconCls:'bgi_update',
            	 handler:function(){
            	 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		var jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
           		 		Ext.getCmp("updateManufacturersId").setValue(jsonData.get("manufacturersId"));
           		 		Ext.getCmp("updateManufacturersName").setValue(jsonData.get("manufacturersName"));
						Ext.getCmp("updateConnactName").setValue(jsonData.get("connactName"));
						Ext.getCmp("updateManufacturersAddress").setValue(jsonData.get("manufacturersAddress"));
						Ext.getCmp("updateConnactNumber").setValue(jsonData.get("connactNumber"));
						Ext.getCmp("updateDelFlg").setValue(jsonData.get("delFlg"));
						Ext.getCmp("updateDescp").setValue(jsonData.get("descp"));
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
								var jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										jsonData = jsonData +  m[i].get("manufacturersId");
									} else {
										jsonData = jsonData + "," +  m[i].get("manufacturersId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_ManufacturersServiceImpl!effective.zdy',
									   params: {"ids":jsonData},
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
								var jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										jsonData = jsonData +  m[i].get("manufacturersId");
									} else {
										jsonData = jsonData + "," +  m[i].get("manufacturersId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_ManufacturersServiceImpl!invalid.zdy',
									   params: {"ids":jsonData},
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
								var jsonData = "";
								for (var i = 0;i <len; i++){
									if (i == 0) {
										jsonData = jsonData +  m[i].get("manufacturersId");
									} else {
										jsonData = jsonData + "," +  m[i].get("manufacturersId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_ManufacturersServiceImpl!delete.zdy',
									   params: {"ids":jsonData},
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
													url: 'B_ManufacturersServiceImpl!query.zdy',
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
	 function rearshGridPanel(_flag){
		  if(_flag != 1){
		  	return false;
		  }
		 /** 刷新页面数据 */
		  gridPanelDataStore.load({
		  		callback: function(records, operation, success) {
			  		if(!success){
			  			Ext.Ajax.request({
							url: 'B_ManufacturersServiceImpl!query.zdy',
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
	rearshGridPanel(1);
	
	/** 增加行双击查看事件-并不从访问后台数据库 */
	var onrowdoubleclick = function(functionGridPanel, index, e){
         var _record = functionGridPanel.getSelectionModel().getSelected();
         if (_record){
           	var jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
			Ext.getCmp("viewManufacturersName").setValue(jsonData.get("manufacturersName"));
			Ext.getCmp("viewConnactName").setValue(jsonData.get("connactName"));
			Ext.getCmp("viewManufacturersAddress").setValue(jsonData.get("manufacturersAddress"));
			Ext.getCmp("viewConnactNumber").setValue(jsonData.get("connactNumber"));
			Ext.getCmp("viewDelFlg").setValue(jsonData.get("delFlg"));
			Ext.getCmp("viewDescp").setValue(jsonData.get("descp"));
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
				_flag = _flag+1;rearshGridPanel(_flag);
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
				Ext.MessageBox.alert(resultInfo,responseJson.message,function(){_flag = _flag+1;rearshGridPanel(_flag);});
		 }else{
				Ext.MessageBox.alert(resultInfo,responseJson.message,function(){_flag = _flag+1;rearshGridPanel(_flag);});
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
		if(Ext.getCmp('conditionFiled').getValue()=='delFlg'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:delFlgStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
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
