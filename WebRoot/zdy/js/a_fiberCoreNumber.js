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
    var conditionFiledStore = [['fiberCoreNumber.fiberCoreNumberName','纤芯名称'],['fiberCoreNumber.cableId','所属光缆'],['fiberCoreNumber.isUsed','是否使用'],
    						   ['fiberCoreNumber.isJump','是否跳转'],['fiberCoreNumber.bizType','业务类型'],
    						   ['fiberCoreNumber.delFlg','是否启用'],['fiberCoreNumber.descp','备注']];
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	var isStore =[['是','是'],['否','否']]; 
	var bizTypeStore =[['用电','用电'],['配电','配电']]; 
	/** combo下拉框-字段remote初始化 */
	var zdyForConnectionStore=[{text:'gprs','children':[{'text':'仓山一期-GPRS','leaf':true,'deviceType':'gprs','deviceId':'1'},{'text':'仓山二期-GPRS','leaf':true,'deviceType':'gprs','deviceId':'2'},{'text':'台江一期-GPRS','leaf':true,'deviceType':'gprs','deviceId':'3'},{'text':'台江二期-GPRS','leaf':true,'deviceType':'gprs','deviceId':'4'}]},{'text':'olt','children':[{'text':'仓上-olt','leaf':true,'deviceType':'olt','deviceId':'1'},{'text':'晋安-olt','leaf':true,'deviceType':'olt','deviceId':'3'},{'text':'鼓楼-olt','leaf':true,'deviceType':'olt','deviceId':'4'}]},{'text':'onu','children':[{'text':'仓山-onu','leaf':true,'deviceType':'onu','deviceId':'1'},{'text':'晋安-onu','leaf':true,'deviceType':'onu','deviceId':'2'},{'text':'台江-onu','leaf':true,'deviceType':'onu','deviceId':'3'},{'text':'鼓楼-onu','leaf':true,'deviceType':'onu','deviceId':'4'}]},{'text':'载波','children':[{'text':'仓山-载波','leaf':true,'deviceType':'载波','deviceId':'1'},{'text':'台江-载波','leaf':true,'deviceType':'载波','deviceId':'2'},{'text':'晋安-载波','leaf':true,'deviceType':'载波','deviceId':'3'},{'text':'鼓楼-载波','leaf':true,'deviceType':'载波','deviceId':'4'}]},{'text':'二层交换机','children':[{'text':'仓山-二层交换机','leaf':true,'deviceType':'二层交换机','deviceId':'2'},{'text':'台江-二层交换机','leaf':true,'deviceType':'二层交换机','deviceId':'3'},{'text':'晋安-二层交换机','leaf':true,'deviceType':'二层交换机','deviceId':'4'},{'text':'鼓楼-二层交换机','leaf':true,'deviceType':'二层交换机','deviceId':'5'}]},{'text':'三层交换机','children':[{'text':'仓山-三层交换机','leaf':true,'deviceType':'三层交换机','deviceId':'2'},{'text':'台江-三层交换机','leaf':true,'deviceType':'三层交换机','deviceId':'3'},{'text':'晋安-三层交换机','leaf':true,'deviceType':'三层交换机','deviceId':'4'},{'text':'鼓楼-三层交换机','leaf':true,'deviceType':'三层交换机','deviceId':'5'}]}];
	  /** 查询要导出的相应记录 */
	var cableNameStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForCable.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"cableName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['cableId', 'cableName']
	});
	cableNameStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForCable.zdy',
							success: function(response){ajaxQuerySuccess(response);},
							failure: function(response,options){ajaxFailure(response,options);}
						});
			  		}
				}
	});	
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'A_FiberCoreNumberServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root:'beenList',
    		totalProperty:'totalCount',
    		fields:['fiberCoreNumberId','fiberCoreNumberName','cableId','cableName','isUsed','isJump','bizType','connections.deviceId','connections.deviceType','connections.deviceName','transceiver','delFlg','descp']
		});
 /********************************** Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '纤芯列表-查看',labelWidth:100,frame:true, 
						        defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
						        items: [
						        		{id:"viewFiberCoreNumberName",fieldLabel:'<font color="red">(*)</font>纤芯名称'},
						        		{id:"viewCableName",fieldLabel:'所属光缆'},
						        		{id:"viewIsUsed",fieldLabel:'是否使用'},
						        		{id:"viewIsJump",fieldLabel:'是否跳转' }, 
						        		{id:"viewBizType",fieldLabel:'业务类型'},
						        		{id:"viewConnections",fieldLabel:'连接情况'},
						        		{id:"viewTransceiver",fieldLabel:'收发情况'},
						        		{id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'},
						        		{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}
						        ]
						    });
						    
    	/** 新增-FormPanel */
    	var formPanel_add = new Ext.FormPanel({
						        title: '纤芯列表-新增',labelWidth:100,frame:true,defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        items: [
						        	{
						        		id:'addFiberCoreNumberName',fieldLabel:'<font color="red">(*)</font>纤芯名称',
    									emptyText:"请输入纤芯名称",allowBlank:false,blankText:"纤芯名称不能为空" 
						            },{
						        		id:'addCableId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属光缆',
						                emptyText:"请选择所属光缆",allowBlank:false,blankText:"所属光缆不能为空",
						                mode:'local',store:cableNameStore,hiddenName:'A_FiberCoreNumber.cableId',
						                displayField:'cableName',valueField:'cableId',
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                id:'addIsUsed',xtype:'combo',fieldLabel:'是否使用',
						                mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                id:'addIsJump',xtype:'combo',fieldLabel:'是否跳转',
						                mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            }, {
						            	id:'addBizType',xtype:'combo',fieldLabel:'业务类型',
						                mode:'local',store:bizTypeStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            }, {
						            	id:'addConnections',xtype:'treecombo',fieldLabel:'连接情况',
						            	zdyForConnection:zdyForConnectionStore
						            },{
						            	id:'addTransceiver',fieldLabel:'收发情况'
						            }, {
						            	id:'addDelFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
						                mode:'local',store:delFlgStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:'addDescp',fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '纤芯列表-更新',labelWidth:100,frame:true,defaultType: 'textfield',
						        defaults:{labelStyle :"text-align:right;",anchor:'95%'},
						        items: [
						        	{	
						        		id:"updateFiberCoreNumberId",hidden:true
						            },{
						        		id:"updateFiberCoreNumberName",fieldLabel: '<font color="red">(*)</font>纤芯名称',
						                emptyText:"请输入纤芯名称",allowBlank:false,blankText:"纤芯名称不能为空" 
						            },{
						                id:"updateCableId",xtype:'combo',fieldLabel:'<font color="red">(*)</font>所属光缆',
						                emptyText:"请选择所属光缆",allowBlank:false,blankText:"所属光缆不能为空",
						                mode:'local',store:cableNameStore,hiddenName:'A_FiberCoreNumber.cableId',
						                displayField:'cableName',valueField:'cableId',
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateIsUsed",fieldLabel:'是否使用',
						            	xtype:'combo',mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateIsJump",fieldLabel:'是否跳转',
						            	xtype:'combo',mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateBizType",xtype:'combo',fieldLabel:'业务类型',
						                mode:'local',store:bizTypeStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateConnections",xtype:'treecombo',fieldLabel:'连接情况',
						            	zdyForConnection:zdyForConnectionStore
						            },{
						            	id:"updateTransceiver",fieldLabel:'收发情况'
						            },{
						            	id:"updateDelFlg",xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",  
						                mode:'local',store:delFlgStore,
						                typeAhead:true,triggerAction: 'all',forceSelection:true
						            },{
						            	id:"updateDescp",fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '纤芯列表-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'A_FiberCoreNumberServiceImpl!importExcel.zdy',
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
											url: 'A_FiberCoreNumberServiceImpl!downloadExcel.zdy',
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
							            		/** 更新相应记录 */
												Ext.Ajax.request({
													   url: 'A_FiberCoreNumberServiceImpl!add.zdy',
													   params: {
													   		"A_FiberCoreNumber.fiberCoreNumberName":Ext.getCmp('addFiberCoreNumberName').getValue(),
													   		"A_FiberCoreNumber.cableId":Ext.getCmp('addCableId').getValue(),
													   		"A_FiberCoreNumber.isUsed":Ext.getCmp('addIsUsed').getValue(),
													   		"A_FiberCoreNumber.isJump":Ext.getCmp('addIsJump').getValue(),
													   		"A_FiberCoreNumber.bizType":Ext.getCmp('addBizType').getValue(),
													   		"A_FiberCoreNumber.connections":Ext.getCmp('addConnections').getValue(),
													   		"A_FiberCoreNumber.delFlg":Ext.getCmp('addDelFlg').getValue(),
													   		"A_FiberCoreNumber.descp":Ext.getCmp('addDescp').getValue()
													   },
													   success: function(response,options){
													  	   ajaxSuccess(response,options);
													   },
													   failure: function(response,options){
													   	   ajaxFailure(response,options);
													   }
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
							            		Ext.Ajax.request({
													   url: 'A_FiberCoreNumberServiceImpl!update.zdy',
													   params: {
													   		"A_FiberCoreNumber.fiberCoreNumberId":Ext.getCmp('updateFiberCoreNumberId').getValue(),
													   		"A_FiberCoreNumber.fiberCoreNumberName":Ext.getCmp('updateFiberCoreNumberName').getValue(),
													   		"A_FiberCoreNumber.cableId":Ext.getCmp('updateCableId').getValue(),
													   		"A_FiberCoreNumber.isUsed":Ext.getCmp('updateIsUsed').getValue(),
													   		"A_FiberCoreNumber.isJump":Ext.getCmp('updateIsJump').getValue(),
													   		"A_FiberCoreNumber.bizType":Ext.getCmp('updateBizType').getValue(),
													   		"A_FiberCoreNumber.connections":Ext.getCmp('updateConnections').getValue(),
													   		"A_FiberCoreNumber.transceiver":Ext.getCmp('updateTransceiver').getValue(),
													   		"A_FiberCoreNumber.delFlg":Ext.getCmp('updateDelFlg').getValue(),
													   		"A_FiberCoreNumber.descp":Ext.getCmp('updateDescp').getValue()
													   },
													   success: function(response,options){
													  	   ajaxSuccess(response,options);
													   },
													   failure: function(response,options){
													   	   ajaxFailure(response,options);
													   }
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
        renderTo:"grid-size",title:'基础列表>>纤芯列表', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new xg.ColumnModel([sm,
        	new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"纤芯名称",width: 80, sortable:true,dataIndex:'fiberCoreNumberName'},
            {header:"所属光缆",width: 300, sortable:true,dataIndex:'cableName'},
            {header:"是否使用",width: 80, sortable:true,dataIndex:'isUsed'},
            {header:"是否跳转",width: 80, sortable:true,dataIndex:'isJump'},
            {header:"业务类型",width: 80, sortable:true,dataIndex:'bizType'},
            {header:"连接情况",width: 100, sortable:true,dataIndex:'connections.deviceName'},
            {header:"收发情况",width: 100, sortable:true,dataIndex:'transceiver'},
            {header:"是否启用",width: 80, sortable:true,dataIndex:'delFlg'},
            {header:"备注",   width: 100, sortable:true,dataIndex:'descp'}
        ]),
        sm: sm,
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
           	   	 text:'导入',tooltip:'导入',iconCls:'bgi_import',hidden:true,
           		 handler:function(){window_import.show();}
       		 }, '-', {
            	 text:'导出',tooltip:'导出',iconCls:'bgi_export',
            	 handler:function(){
            	 	var flag = 0;
            	  	/** 查询要导出的相应记录 */
						Ext.Ajax.request({
							 url: 'A_FiberCoreNumberServiceImpl!exportExcel.zdy',
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
           	   	 text:'新增',tooltip:'新增',iconCls:'bgi_add',hidden:true,handler:function(){window_add.show();}
       		 }, '-', {
       		 	 id:"update",disabled:true,text:'修改',tooltip:'修改',iconCls:'bgi_update',
            	 handler:function(){
            	 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		var jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
           		 		Ext.getCmp("updateFiberCoreNumberId").setValue(jsonData.get("fiberCoreNumberId"));
           		 		Ext.getCmp("updateFiberCoreNumberName").setValue(jsonData.get("fiberCoreNumberName"));
           		 		Ext.getCmp("updateCableId").setValue(jsonData.get("cableId"));
						Ext.getCmp("updateIsUsed").setValue(jsonData.get("isUsed"));
						Ext.getCmp("updateIsJump").setValue(jsonData.get("isJump"));
						Ext.getCmp("updateBizType").setValue(jsonData.get("bizType")); 
						Ext.getCmp("updateConnections").setValue(jsonData.get("connections.deviceName"));
						Ext.getCmp("updateTransceiver").setValue(jsonData.get("transceiver"));
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
										jsonData = jsonData +  m[i].get("fiberCoreNumberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberCoreNumberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_FiberCoreNumberServiceImpl!effective.zdy',
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
										jsonData = jsonData +  m[i].get("fiberCoreNumberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberCoreNumberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_FiberCoreNumberServiceImpl!invalid.zdy',
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
           		 text:'删除',tooltip:'删除', iconCls:'bgi_delete',hidden:true,
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
										jsonData = jsonData +  m[i].get("fiberCoreNumberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberCoreNumberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_FiberCoreNumberServiceImpl!delete.zdy',
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
													url: 'A_FiberCoreNumberServiceImpl!query.zdy',
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
							url: 'A_FiberCoreNumberServiceImpl!query.zdy',
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
			Ext.getCmp("viewFiberCoreNumberName").setValue(jsonData.get("fiberCoreNumberName"));
			Ext.getCmp("viewCableName").setValue(jsonData.get("cableName"));
			Ext.getCmp("viewIsUsed").setValue(jsonData.get("isUsed"));
			Ext.getCmp("viewIsJump").setValue(jsonData.get("isJump"));
			Ext.getCmp("viewBizType").setValue(jsonData.get("bizType"));
			Ext.getCmp("viewConnections").setValue(jsonData.get("connections.deviceName")); 
			Ext.getCmp("viewTransceiver").setValue(jsonData.get("transceiver"));
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
		if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.delFlg'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:delFlgStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.cableId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:cableNameStore,
				displayField:'cableName',valueField:'cableId',
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.isUsed'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:isStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.isJump'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:isStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.bizType'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:bizTypeStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber.connections'){
			Ext.getCmp('conditionFiledPanel').add({
				id:"conditionValue",xtype:'treecombo',fieldLabel:'查询内容',
				zdyForConnection:zdyForConnectionStore
			});
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
