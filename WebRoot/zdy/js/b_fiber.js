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
    var conditionFiledStore = [['fiberName','光纤名称'],['fiberCoreNumber','纤芯数量'],['isUsed','是否使用'],['isJump','是否跳转'],
    						   ['bizType','业务类型'],['connections','连接情况'],['delFlg','是否启用'],['descp','备注']];
	var fiberCoreNumberStore = [
	                              [1,1],[2,2],[3,3],[4,4],[5,5],[6,6],[7,7],[8,8],[9,9],[10,10],
	                              [11,11],[12,12],[13,13],[14,14],[15,15],[16,16],[17,17],[18,18],[19,19],[20,20],
	                              [21,21],[22,22],[23,23],[24,24],[25,25],[26,26],[27,27],[28,28],[29,29],[30,30],
	                              [31,31],[32,32],[33,33],[34,34],[35,35],[36,36],[37,37],[38,38],[39,39],[40,40],
	                              [41,41],[42,42],[43,43],[44,44],[45,45],[46,46],[47,47],[48,48],[49,49],[50,50],
	                              [51,51],[52,52],[53,53],[54,54],[55,55],[56,56],[57,57],[58,58],[59,59],[60,60],
	                              [61,61],[62,62],[63,63],[64,64],[65,65],[66,66],[67,67],[68,68],[69,69],[70,70],
	                              [71,71],[72,72],[73,73],[74,74],[75,75],[76,76],[77,77],[78,78],[79,79],[80,80],
	                              [81,81],[82,82],[83,83],[84,84],[85,85],[86,86],[87,87],[88,88],[89,89],[90,90],
	                              [91,91],[92,92],[93,93],[94,94],[95,95],[96,96],[97,97],[98,98],[99,99],[100,100],
	                              [101,101],[102,102],[103,103],[104,104],[105,105],[106,106],[107,107],[108,108],[109,109],[110,110],
	                              [111,111],[112,112],[113,113],[114,114],[115,115],[116,116],[117,117],[118,118],[119,119],[120,120],
	                              [121,121],[122,122],[123,123],[124,124],[125,125],[126,126],[127,127],[128,128],[129,129],[130,130],
	                              [131,131],[132,132],[133,133],[134,134],[135,135],[136,136],[137,137],[138,138],[139,139],[140,140],
	                              [141,141],[142,142],[143,143],[144,144],[145,145],[146,146],[147,147],[148,148],[149,149],[150,150],
	                              [151,151],[152,152],[153,153],[154,154],[155,155],[156,156],[157,157],[158,158],[159,159],[160,160],
	                              [161,161],[162,162],[163,163],[164,164],[165,165],[166,166],[167,167],[168,168],[169,169],[170,170],
	                              [171,171],[172,172],[173,173],[174,174],[175,175],[176,176],[177,177],[178,178],[179,179],[180,180],
	                              [181,181],[182,182],[183,183],[184,184],[185,185],[186,186],[187,187],[188,188],[189,189],[190,190],
	                              [191,191],[192,192],[193,193],[194,194],[195,195],[196,196],[197,197],[198,198],[199,199],[200,200],
	                              [201,201],[202,202],[203,203],[204,204],[205,205],[206,206],[207,207],[208,208],[209,209],[210,210],
	                              [211,211],[212,212],[213,213],[214,214],[215,215],[216,216],[217,217],[218,218],[219,219],[220,220],
	                              [221,221],[222,222],[223,223],[224,224],[225,225],[226,226],[227,227],[228,228],[229,229],[230,230],
	                              [231,231],[232,232],[233,233],[234,234],[235,235],[236,236],[237,237],[238,238],[239,239],[240,240],
	                              [241,241],[242,242],[243,243],[244,244],[245,245],[246,246],[247,247],[248,248],[249,249],[250,250],
	                              [251,251],[252,252],[253,253],[254,254],[255,255]
							   ];
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	var isStore =[['是','是'],['否','否']]; 
	var bizTypeStore =[['用电','用电'],['配电','配电']]; 
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'B_FiberServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root:'beenList',
    		totalProperty:'totalCount',
    		fields:['fiberId','fiberName','fiberCoreNumber','isUsed','isJump','bizType','connections','delFlg','descp']
		});
 /********************************** Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '光纤-查看',labelWidth:100,frame:true, 
						        defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
						        items: [
						        		{id:"viewFiberName",fieldLabel:'<font color="red">(*)</font>光纤名称'},
						        		{id:"viewFiberCoreNumber",fieldLabel:'纤芯名称'},
						        		{id:"viewIsUsed",fieldLabel:'是否使用'},
						        		{id:"viewIsJump",fieldLabel:'是否跳转' }, 
						        		{id:"viewBizType",fieldLabel:'业务类型'},
						        		{id:"viewConnections",fieldLabel:'连接情况'},
						        		{id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'},
						        		{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}
						        ]
						    });
						    
    	/** 新增-FormPanel */
    	var formPanel_add = new Ext.FormPanel({
						        title: '光纤-新增',labelWidth:100,frame:true, 
						        url:'B_FiberServiceImpl!add.zdy',
						        defaultType:'textfield',
						        defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        items: [
						        	{
						        		name:'B_Fiber.fiberName',fieldLabel:'<font color="red">(*)</font>光纤名称',
    									emptyText:"请输入光纤名称",allowBlank:false,blankText:"光纤名称不能为空" 
						            },{
						        		name:'B_Fiber.fiberCoreNumber',xtype:'combo',fieldLabel:'<font color="red">(*)</font>纤芯数量',
						                emptyText:"请选择纤芯数量",allowBlank:false,blankText:"纤芯数量不能为空",
						                mode:'local',store:fiberCoreNumberStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                name:'B_Fiber.isUsed',xtype:'combo',fieldLabel:'是否使用',
						                mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						                name:'B_Fiber.isJump',xtype:'combo',fieldLabel:'是否跳转',
						                mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            }, {
						            	name:'B_Fiber.bizType',xtype:'combo',fieldLabel:'业务类型',
						                mode:'local',store:bizTypeStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            }, {
						            	name:'B_Fiber.connections',fieldLabel:'连接情况'
						            }, {
						            	name:'B_Fiber.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",
						                mode:'local',store:delFlgStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	name:'B_Fiber.descp',fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '光纤-更新',labelWidth:100,frame:true, 
						        url:'B_FiberServiceImpl!update.zdy',
						        defaultType: 'textfield',
						        defaults:{labelStyle :"text-align:right;",anchor:'95%'},
						        items: [
						        	{	
						        		id:"updateFiberId",name:'B_Fiber.fiberId',hidden:true
						            },{
						        		id:"updateFiberName",name:'B_Fiber.fiberName',fieldLabel: '<font color="red">(*)</font>光纤名称',
						                emptyText:"请输入光纤名称",allowBlank:false,blankText:"光纤名称不能为空" 
						            },{
						                id:"updateFiberCoreNumber",name:'B_Fiber.fiberCoreNumber',xtype:'combo',fieldLabel:'<font color="red">(*)</font>纤芯数量',
						                emptyText:"请选择纤芯数量",allowBlank:false,blankText:"纤芯数量不能为空",
						                mode:'local',store:fiberCoreNumberStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateIsUsed",name:'B_Fiber.isUsed',fieldLabel:'是否使用',
						            	xtype:'combo',mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateIsJump",name:'B_Fiber.isJump',fieldLabel:'是否跳转',
						            	xtype:'combo',mode:'local',store:isStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateBizType",name:'B_Fiber.bizType',xtype:'combo',fieldLabel:'业务类型',
						                mode:'local',store:bizTypeStore,
						                typeAhead:true,triggerAction:'all',forceSelection:true
						            },{
						            	id:"updateConnections",name:'B_Fiber.connections',fieldLabel:'连接情况'
						            },{
						            	id:"updateDelFlg",name:'B_Fiber.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
						                emptyText:"请选择是否启用",allowBlank:false,blankText:"是否启用不能为空",  
						                mode:'local',store:delFlgStore,
						                typeAhead:true,triggerAction: 'all',forceSelection:true
						            },{
						            	id:"updateDescp",name:'B_Fiber.descp',
						            	fieldLabel:'备注',xtype:'textarea'
							        }
						        ]
						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '光纤-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'B_FiberServiceImpl!importExcel.zdy',
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
											url: 'B_FiberServiceImpl!downloadExcel.zdy',
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
        renderTo:"grid-size",title:'下拉维护表>>光纤', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new xg.ColumnModel([sm,
        	new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"光纤名称",width: 140, sortable:true,dataIndex:'fiberName'},
            {header:"纤芯数量",width: 120, sortable:true,dataIndex:'fiberCoreNumber'},
            {header:"是否使用",width: 120, sortable:true,dataIndex:'isUsed'},
            {header:"是否跳转",width: 120, sortable:true,dataIndex:'isJump'},
            {header:"业务类型",width: 120, sortable:true,dataIndex:'bizType'},
            {header:"连接情况",width: 120, sortable:true,dataIndex:'connections'},
            {header:"是否启用",width: 120, sortable:true,dataIndex:'delFlg'},
            {header:"备注",   width: 120, sortable:true,dataIndex:'descp'}
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
							 url: 'B_FiberServiceImpl!exportExcel.zdy',
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
           		 		Ext.getCmp("updateFiberId").setValue(jsonData.get("fiberId"));
           		 		Ext.getCmp("updateFiberName").setValue(jsonData.get("fiberName"));
           		 		Ext.getCmp("updateFiberCoreNumber").setValue(jsonData.get("fiberCoreNumber"));
						Ext.getCmp("updateIsUsed").setValue(jsonData.get("isUsed"));
						Ext.getCmp("updateIsJump").setValue(jsonData.get("isJump"));
						Ext.getCmp("updateBizType").setValue(jsonData.get("bizType"));
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
										jsonData = jsonData +  m[i].get("fiberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_FiberServiceImpl!effective.zdy',
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
										jsonData = jsonData +  m[i].get("fiberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_FiberServiceImpl!invalid.zdy',
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
										jsonData = jsonData +  m[i].get("fiberId");
									} else {
										jsonData = jsonData + "," +  m[i].get("fiberId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'B_FiberServiceImpl!delete.zdy',
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
													url: 'B_FiberServiceImpl!query.zdy',
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
							url: 'B_FiberServiceImpl!query.zdy',
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
			Ext.getCmp("viewFiberName").setValue(jsonData.get("fiberName"));
			Ext.getCmp("viewFiberCoreNumber").setValue(jsonData.get("fiberCoreNumber"));
			Ext.getCmp("viewIsUsed").setValue(jsonData.get("isUsed"));
			Ext.getCmp("viewIsJump").setValue(jsonData.get("isJump"));
			Ext.getCmp("viewBizType").setValue(jsonData.get("bizType"));
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
		}else if(Ext.getCmp('conditionFiled').getValue()=='fiberCoreNumber'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:fiberCoreNumberStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='isUsed'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:isStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='isJump'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:isStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='bizType'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:bizTypeStore,
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
