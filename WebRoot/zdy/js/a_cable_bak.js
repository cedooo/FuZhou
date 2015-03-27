Ext.onReady(function(){
	/*************************************** 数据初始化 ********************************************************/
	/** 获取服务器当前路径 */
	var location = (window.location+'').split('/'); 
	/** 加载tips提示信息 */
    Ext.QuickTips.init();
	/** 对话提示框 */
	var resultInfo ="操作结果对话框";
	var tipsInfo ="操作提示对话框";
	/** 是否是纤芯列表的第一次初始化 */
	var isAddFiberCoreNumberInit = false;
	var isUpdateFiberCoreNumberInit = false;
	/** 表格序号 */
   var record_start = 0;
    /** combo下拉框-字段local初始化 */
    var conditionFiledStore = [['cable.cableName','光缆名称'],['cable.cableStartId','光缆起点'],['cable.cableEndId','光缆终点'],
    						   ['cable.isMainRoad','是否主干网'],['cable.cableType','光缆类型'],['cable.cableLength','光缆长度'],
    						   ['cable.fiberId','纤芯数量'],['cable.layingType','敷设类型'],['cable.runTime','投运时间'],['cable.constructionUnitId','施工单位'],
    						   ['cable.bizType','业务类型'],['cable.delFlg','是否启用'],['cable.descp','备注']];
	var isStore =[['是','是'],['否','否']];  
	var delFlgStore =[['启用','启用'],['停用','停用']]; 
	var bizTypeStore =[['用电','用电'],['配电','配电']];
	 /** combo下拉框-字段remote初始化 */
	 var zdyForConnectionsStore;
	  /** 查询要导出的相应记录 */
	 Ext.Ajax.request({
				url: 'ComboForService!comboForConnections.zdy',
				params: {
				  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用"
				},
				success: function(response){
					var _responseJson = Ext.util.JSON.decode(response.responseText);
					zdyForConnectionsStore  = _responseJson;
				}
	});     
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
	var fiberDataStore = new Ext.data.JsonStore({
    		url: 'ComboForService!comboForFiber.zdy',
    		baseParams:{
    			  "ConditionDto.conditionFiled":"delFlg",
				  "ConditionDto.conditionConditions":"=",
				  "ConditionDto.conditionValue":"启用",
				  "ConditionDto.orderFiled":"fiberName",
				  "ConditionDto.orderValue":"asc"
    		},
    		root: 'beenList',
    		fields: ['fiberId', 'fiberName']
	});
	fiberDataStore.load({callback: function(records, operation, success) {
			  		if(!success){Ext.Ajax.request({
							url: 'ComboForService!comboForFiber.zdy',
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
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'A_CableServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root: 'beenList',
    		totalProperty : 'totalCount',
    		fields: ['cableId','cableName','cableStartId','startSiteName','cableEndId','endSiteName','isMainRoad','cableType',
    				 'cableLength','fiberId','fiberName','layingType','runTime','constructionUnitId',
    				 'constructionUnitName','bizType','delFlg','descp']
		});
/********************************************* Form集合 ***********************************************************/
     	 /** form的提示信息位置 */
     	 Ext.form.Field.prototype.msgTarget = 'side';	
     	 /** 纤芯列表-FormPanel */
    	var formPanel_addFiberCoreNumber = new Ext.FormPanel({
						        title:'纤芯列表',frame:true, xtype:'panel',
						        bodyStyle : 'overflow-x:hidden; overflow-y:scroll',
						        defaults:{layout:'column',anchor:'100%'}
						    });
		 /** 纤芯列表-FormPanel */
    	var formPanel_updateFiberCoreNumber = new Ext.FormPanel({
						        title:'纤芯列表',frame:true, xtype:'panel',
						        bodyStyle : 'overflow-x:hidden; overflow-y:scroll',
						        defaults:{layout:'column',anchor:'100%'}
						    });
     	 /** 查看-FormPanel */
    	var formPanel_view = new Ext.FormPanel({
						        title: '光缆-查看',labelWidth:100,frame:true, 
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						        items: [{
							        		items:[{
							        				layout:'form',columnWidth:1,defaultType:'textfield', 
							            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
							        				items:[{id:"viewCableName",fieldLabel:'<font color="red">(*)</font>光缆名称'}]
							        		}]
						            	},{
							            	 items:[{
							            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
							            	 		defaults:{labelStyle:"text-align:right;",anchor:'90%',readOnly:true},
									            	items:[{id:"viewStartSiteName",fieldLabel:'<font color="red">(*)</font>光缆起点'},
									            		   {id:"viewCableType",fieldLabel:'光缆类型'},
									            		   {id:"viewFiberId",fieldLabel:'<font color="red">(*)</font>纤芯数量'},
									            		   {id:"viewRunTime",fieldLabel:'投运时间'},
									            		   {id:"viewConstructionUnitId",fieldLabel:'<font color="red">(*)</font>施工单位'}]
									            	},{
									            	layout:'form',columnWidth:.5,defaultType:'textfield',
									            	defaults:{labelStyle:"text-align:right;",anchor:'90%',readOnly:true}, 
									            	items:[{id:"viewEndSiteName",fieldLabel:'<font color="red">(*)</font>光缆终点 '},
									            		   {id:"viewIsMainRoad",fieldLabel:'<font color="red">(*)</font>是否主干网'},
									            		   {id:"viewCableLength",fieldLabel:'光缆长度(km)'},
									            		   {id:"viewLayingType",fieldLabel:'敷设类型'},
									            		   {id:"viewBizType",fieldLabel:'业务类型'},
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
						        title: '光缆-新增',labelWidth:100,frame:true, 
						        url:'A_CableServiceImpl!add.zdy',
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						        items:[{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{	
						        						id:'addCableName',name:'A_Cable.cableName',fieldLabel:'<font color="red">(*)</font>光缆名称',
    													allowBlank:false,blankText:"光缆名称不能为空" ,readOnly:true
    											}]
						        		}]
						            },{
						            	items:[{
						            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
								            	items:[{
										            		id:'addCableStartId',name:'A_Cable.cableStartId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>光缆起点',
										                	allowBlank:false,blankText:'光缆起点不能为空',
										                	mode:'local',store:siteDataStore,hiddenName:'A_Cable.cableStartId',
										               		displayField:'siteName',valueField:'siteId',
										               	 	typeAhead:true,triggerAction:'all',forceSelection:true
								            	 	   },{
						              				 		id:'addCableType',name:'A_Cable.cableType',fieldLabel:'光缆类型'
						            				   },{
											            	id:'addFiberId',name:'A_Cable.fiberId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>纤芯数量',
											            	allowBlank:false,blankText:'纤芯数量不能为空',
											                mode:'local',store:fiberDataStore,hiddenName:'A_Cable.fiberId',
											                displayField:'fiberName',valueField:'fiberId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
									            	   },{
									               			id:'addRunTime',name:'A_Cable.runTime',xtype:'datefield',fieldLabel:'投运时间',
									               			maxValue: new Date(),format:'Y-m-d',
						                					invalidText:"输入的日期格式不正确，请参考格式‘2014-01-01’格式"
									            	   },{
											                id:'addConstructionUnitId',name:'A_Cable.constructionUnitId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>施工单位',
											                emptyText:'请选择施工单位',allowBlank:false,blankText:'施工单位不能为空',
											                mode:'local',store:constructionUnitDataStore,hiddenName:'A_Cable.constructionUnitId',
											                displayField:'constructionUnitName',valueField:'constructionUnitId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
									            }]
								            },{
								            	layout:'form',columnWidth:.5,defaultType:'textfield',
								            	defaults:{labelStyle:"text-align:right;",anchor:'90%'}, 
								            	items:[{
										            		id:'addCableEndId',name:'A_Cable.cableEndId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>光缆终点',
										               	 	allowBlank:false,blankText:'光缆终点不能为空',
										               	 	mode:'local',store:siteDataStore,hiddenName:'A_Cable.cableEndId',
										                	displayField:'siteName',valueField:'siteId',
										                	typeAhead:true,triggerAction:'all',forceSelection:true
								            		},{
						                					id:'addIsMainRoad',name:'A_Cable.isMainRoad',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否主干网',
											                emptyText:"请选择是否主干网",allowBlank:false,blankText:"是否主干网不能为空",
											                mode:'local',store:isStore,
											                typeAhead:true,triggerAction:'all',forceSelection:true
						           					},{
						                					id:'addCableLength',name:'A_Cable.cableLength',fieldLabel:'光缆长度(km)'
						           					},{
									              		    id:'addLayingType',name:'A_Cable.layingType',fieldLabel:'敷设类型'
									           		},{
											                id:'addBizType',name:'A_Cable.bizType',xtype:'combo',fieldLabel:'业务类型',
											                mode:'local',store:bizTypeStore,
											                typeAhead:true,triggerAction:'all',forceSelection:true
									          		 },{
											            	id:'addDelFlg',name:'A_Cable.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
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
						        					id:'addDescp',name:'A_Cable.descp',fieldLabel:'备注',xtype:'textarea'
    											}]
						        		}]
						           }
						        ]
						    });
						    
		/** 更新FormPanel */
    	var formPanel_update = new Ext.FormPanel({
						        title: '光缆-更新',labelWidth:100,frame:true, 
						        url:'A_CableServiceImpl!update.zdy',
						        defaults:{xtype: 'panel',layout: 'column',anchor:'100%'},
						       	items:[{
						        		items:[{
						        				layout:'form',columnWidth:1,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%'},
						        				items:[{
						        						id:'updateCableId',name:'A_Cable.cableId',hidden:true
						        				},{	
						        						id:'updateCableName',name:'A_Cable.cableName',fieldLabel:'<font color="red">(*)</font>光缆名称',
    													allowBlank:false,blankText:"光缆名称不能为空" 
    											}]
						        		}]
						            },{
						            	items:[{
						            	 		layout:'form',columnWidth:.5,defaultType:'textfield', 
						            	 		defaults:{labelStyle:"text-align:right;",anchor:'90%'},
								            	items:[{
										            		id:'updateCableStartId',name:'A_Cable.cableStartId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>光缆起点',
										                	allowBlank:false,blankText:'光缆起点不能为空',
										                	mode:'local',store:siteDataStore,hiddenName:'A_Cable.cableStartId',
										               		displayField:'siteName',valueField:'siteId',
										               	 	typeAhead:true,triggerAction:'all',forceSelection:true
								            	 	   },{
						              				 		id:'updateCableType',name:'A_Cable.cableType',fieldLabel:'光缆类型'
						            				   },{
											            	id:'updateFiberId',name:'A_Cable.fiberId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>纤芯数量',
											            	allowBlank:false,blankText:'纤芯数量不能为空',
											                mode:'local',store:fiberDataStore,hiddenName:'A_Cable.fiberId',
											                displayField:'fiberName',valueField:'fiberId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
									            	   },{
									               			id:'updateRunTime',name:'A_Cable.runTime',xtype:'datefield',fieldLabel:'投运时间',
									               			maxValue: new Date(),format:'Y-m-d',
						                					invalidText:"输入的日期格式不正确，请参考格式‘2014-01-01’格式"
									            	   },{
											                id:'updateConstructionUnitId',name:'A_Cable.constructionUnitId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>施工单位',
											                emptyText:'请选择施工单位',allowBlank:false,blankText:'施工单位不能为空',
											                mode:'local',store:constructionUnitDataStore,hiddenName:'A_Cable.constructionUnitId',
											                displayField:'constructionUnitName',valueField:'constructionUnitId',
											                typeAhead:true,triggerAction:'all',forceSelection:true
									            }]
								            },{
								            	layout:'form',columnWidth:.5,defaultType:'textfield',
								            	defaults:{labelStyle:"text-align:right;",anchor:'90%'}, 
								            	items:[{
										            		id:'updateCableEndId',name:'A_Cable.cableEndId',xtype:'combo',fieldLabel:'<font color="red">(*)</font>光缆终点',
										               	 	allowBlank:false,blankText:'光缆终点不能为空',
										               	 	mode:'local',store:siteDataStore,hiddenName:'A_Cable.cableEndId',
										                	displayField:'siteName',valueField:'siteId',
										                	typeAhead:true,triggerAction:'all',forceSelection:true
								            		},{
						                					id:'updateIsMainRoad',name:'A_Cable.isMainRoad',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否主干网',
											                emptyText:"请选择是否主干网",allowBlank:false,blankText:"是否主干网不能为空",
											                mode:'local',store:isStore,
											                typeAhead:true,triggerAction:'all',forceSelection:true
						           					},{
						                					id:'updateCableLength',name:'A_Cable.cableLength',fieldLabel:'光缆长度(km)'
						           					},{
									              		    id:'updateLayingType',name:'A_Cable.layingType',fieldLabel:'敷设类型'
									           		},{
											                id:'updateBizType',name:'A_Cable.bizType',xtype:'combo',fieldLabel:'业务类型',
											                mode:'local',store:bizTypeStore,
											                typeAhead:true,triggerAction:'all',forceSelection:true
									          		 },{
											            	id:'updateDelFlg',name:'A_Cable.delFlg',xtype:'combo',fieldLabel:'<font color="red">(*)</font>是否启用',
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
						        					id:'updateDescp',name:'A_Cable.descp',fieldLabel:'备注',xtype:'textarea'
    											}]
						        		}]
						           }
						        ]

						    });
						    
		/** 上传FormPanel */	
		var formPanel_import = new Ext.FormPanel({
						        title: '光缆-上传',labelWidth:100,
						        frame:true,fileUpload :true,
						        url:'A_CableServiceImpl!importExcel.zdy',
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
											url: 'A_CableServiceImpl!downloadExcel.zdy',
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
    	/** 纤芯列表-增加窗口 */
    	var window_addFiberCoreNumber = new Ext.Window({
	         					title: '纤芯列表',closable:true,closeAction:"hide",
	            				width:1000,height:500,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_addFiberCoreNumber,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_addFiberCoreNumber.hide();}}]
	       					});
	       					
	    /** 纤芯列表-更新窗口 */
    	var window_updateFiberCoreNumber = new Ext.Window({
	         					title: '纤芯列表',closable:true,closeAction:"hide",
	            				width:1000,height:500,iconCls:'bgi_update',plain:true,layout:'fit',items:formPanel_updateFiberCoreNumber,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_updateFiberCoreNumber.hide();}}]
	       					});						    
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
	            				tbar:[{
					           	   	 text:'配置纤芯列表',tooltip:'配置纤芯列表',iconCls:'bgi_add',handler:function(){
					           	   	 	/** 纤芯数量不能为空 */
					           	   		 if(Ext.getCmp('addFiberId').getValue()==""||
					           	   		 Ext.getCmp('addCableStartId').getValue()==""||
					           	   		 Ext.getCmp('addCableEndId').getValue()==""){
					           	   		 Ext.MessageBox.alert(tipsInfo,'配置前，纤芯数量，起始站点和目的站点不能为空');
					           	   		 	return;
					           	   		 };
					           	   		 /** 判断是否是第一次初始化 */
					           	   		 if(isAddFiberCoreNumberInit){
	           		 						window_addFiberCoreNumber.show();
	           		 						return;
	           		 					 }
					           	   		 Ext.MessageBox.confirm(tipsInfo, '是否需要配置纤芯列表？配置后纤芯数量将不能更改。', function(btn){
					           	   		 	var waitBox;
	           		 						if (btn == "yes"){
	           		 							/** 将纤芯数量设置为只读 */
	           		 							Ext.getCmp('addFiberId').setReadOnly(true);
	           		 							waitBox = Ext.MessageBox.wait('光芯数量列表加载中...',tipsInfo,{text:"第一次加载比较慢，请耐心等待..."});
												/** 查询要导出的相应记录 */
												Ext.Ajax.request({
													 url: 'B_FiberServiceImpl!getFiberCoreNumber.zdy',
													 params: {
													 	"ConditionDto.conditionFiled":"fiberId",
						   								"ConditionDto.conditionConditions":"like",
														"ConditionDto.conditionValue":Ext.getCmp('addFiberId').getValue()
													 },
												     success: function(response){
												       	 var _responseJson = Ext.util.JSON.decode(response.responseText);
												       	 var _result = Ext.util.JSON.decode(_responseJson.result);
														 if(_result.success){
															var _fiberCoreNumber = _responseJson.beenList[0].fiberCoreNumber;
															for ( var i=1;i<=_fiberCoreNumber;i++){
																formPanel_addFiberCoreNumber.add(new Ext.Panel({
															            	 items:[{
															            	 		layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield', 
															            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
																	            	items:[{id:'addFiberCoreNumberName'+i,fieldLabel:'纤芯名称',value:'纤芯'+i}]
																	            },{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'addIsUsed'+i,xtype:'combo',fieldLabel:'是否使用',
																			                mode:'local',store:isStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'addIsJump'+i,xtype:'combo',fieldLabel:'是否跳转',
																			                mode:'local',store:isStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'addBizType'+i,xtype:'combo',fieldLabel:'业务类型',
																			                mode:'local',store:bizTypeStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.2,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'addStartConnections'+i,xtype:'treecombo',fieldLabel:'起始端',
																	            			zdyForConnection:zdyForConnectionsStore
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.2,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'addEndConnections'+i,xtype:'treecombo',fieldLabel:'目的端',
																	            			zdyForConnection:zdyForConnectionsStore
																			        }] 
															            		},{
															            	 		layout:'form',labelWidth:1,columnWidth:.12,defaultType:'textfield', 
															            	 		defaults:{labelStyle:"text-align:right;",anchor:'50%'},
																	            	items:[{id:'addTransceiver'+i}]
																	            }]
														        }));
														   }
														  formPanel_addFiberCoreNumber.doLayout();
														  /** 设置已经被初始化 */
														  isAddFiberCoreNumberInit = true;
														  waitBox.hide();
														  window_addFiberCoreNumber.show();
														}else{
															Ext.MessageBox.alert(resultInfo,_responseJson.message);
														}
													},
													failure: function(response,options){
														ajaxFailure(response,options);
													 }
												});
	           		 						}
	           		 					});	
									}
					       		 }],
	            				buttonAlign:'center',
						        buttons: 
						        [{
						            text: '保存',
						            handler:function(){
							            if (formPanel_add.form.isValid()) {
								            var addJson="[";
											var _index =1;
											/** 判断是否配置了纤芯列表 */
											if(Ext.getCmp('addFiberCoreNumberName'+_index)==undefined){
												Ext.MessageBox.alert(tipsInfo,'未配置纤芯列表！');
												return;
											}
											while(true){
												/** 判断是否到了纤芯列表的最后一个 */
												if(Ext.getCmp('addFiberCoreNumberName'+_index)==undefined){
													addJson = addJson.substr(0,addJson.length-1);
													break;
												}
												addJson +="{";
												addJson +="'fiberCoreNumberName':'"+Ext.getCmp('addFiberCoreNumberName'+_index).getValue()+"',"; 
												addJson +="'isUsed':'"+Ext.getCmp('addIsUsed'+_index).getValue()+"',"; 
												addJson +="'isJump':'"+Ext.getCmp('addIsJump'+_index).getValue()+"',"; 
												addJson +="'bizType':'"+Ext.getCmp('addBizType'+_index).getValue()+"',";
												addJson +="'delFlg':'启用',"; 
												addJson +="'startConnections':["+Ext.getCmp('addStartConnections'+_index).getValue()+"],"; 
												addJson +="'endConnections':["+Ext.getCmp('addEndConnections'+_index).getValue()+"],"; 
												addJson +="'transceiver':'"+Ext.getCmp('addTransceiver'+_index).getValue()+"'"; 
												addJson +="},";
												_index++;
											}
											addJson +="]";
								            /** 更新相应记录 */
											Ext.Ajax.request({
												url: 'A_CableServiceImpl!add.zdy',
												params: {
													"A_Cable.cableName":Ext.getCmp('addCableName').getValue(),
													"A_Cable.isMainRoad":Ext.getCmp('addIsMainRoad').getValue(),
													"A_Cable.cableStartId":Ext.getCmp('addCableStartId').getValue(),
													"A_Cable.cableEndId":Ext.getCmp('addCableEndId').getValue(),
											        "A_Cable.cableType":Ext.getCmp('addCableType').getValue(),
												    "A_Cable.cableLength":Ext.getCmp('addCableLength').getValue(),
												    "A_Cable.fiberId":Ext.getCmp('addFiberId').getValue(),
												    "A_Cable.layingType":Ext.getCmp('addLayingType').getValue(),
												    "A_Cable.runTime":Ext.getCmp('addRunTime').getValue(),
												    "A_Cable.constructionUnitId":Ext.getCmp('addConstructionUnitId').getValue(),
												    "A_Cable.bizType":Ext.getCmp('addBizType').getValue(),
												    "A_Cable.delFlg":Ext.getCmp('addDelFlg').getValue(),
												    "A_Cable.descp":Ext.getCmp('addDescp').getValue(),
												    "beenList":addJson
												},
											    success: function(response,options){
											    /** 保存成功后，设置初始化为false */
												    isAddFiberCoreNumberInit = false;
												    formPanel_addFiberCoreNumber.removeAll();
		           		 							Ext.getCmp('addFiberId').setReadOnly(false);
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
	         					title: '更新窗口',closable:true,closeAction:"hide",width:600,height:400,iconCls:'bgi_update',
	            				plain:true,layout:'fit',items: formPanel_update,
	            				tbar:[{
					           	   	 	text:'配置纤芯列表',tooltip:'配置纤芯列表',iconCls:'bgi_update',handler:function(){
						           	   	 /** 纤芯数量不能为空 */
						           	   	 if(Ext.getCmp('updateFiberId').getValue()==""){
						           	   		 Ext.MessageBox.alert(tipsInfo,'请先选择纤芯数量');
						           	   		 return;
						           	   	 };
						           	   	/** 判断是否是第一次初始化 */
						           	   	if(isUpdateFiberCoreNumberInit){
		           		 					formPanel_updateFiberCoreNumber.removeAll();
		           		 				}
					           	   	 	 Ext.MessageBox.confirm(tipsInfo, '是否需要配置纤芯列表？配置后纤芯数量将不能更改。', function(btn){
					           	   		 	var waitBox;
	           		 						if (btn == "yes"){
	           		 							/** 将纤芯数量设置为只读 */
	           		 							Ext.getCmp('updateFiberId').setReadOnly(true);
	           		 							waitBox = Ext.MessageBox.wait('光芯数量列表加载中...',tipsInfo,{text:"第一次加载比较慢，请耐心等待..."});
												/** 查询要导出的相应记录 */
												Ext.Ajax.request({
													 url: 'B_FiberServiceImpl!getFiberCoreNumber.zdy',
													 params: {
													 	"ConditionDto.conditionFiled":"fiberId",
						   								"ConditionDto.conditionConditions":"like",
														"ConditionDto.conditionValue":Ext.getCmp('updateFiberId').getValue()
													 },
												     success: function(response){
												       	 var _responseJson = Ext.util.JSON.decode(response.responseText);
												       	 var _result = Ext.util.JSON.decode(_responseJson.result);
														 if(_result.success){
															var _fiberCoreNumber = _responseJson.beenList[0].fiberCoreNumber;
															for ( var i=1;i<=_fiberCoreNumber;i++){
																formPanel_updateFiberCoreNumber.add(new Ext.Panel({
															            	 items:[{
															            	 		layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield', 
															            	 		defaults:{labelStyle:"text-align:right;",anchor:'95%',readOnly:true},
																	            	items:[{id:'updateFiberCoreNumberName'+i,fieldLabel:'纤芯名称',value:'纤芯'+i}]
																	            },{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'updateIsUsed'+i,xtype:'combo',fieldLabel:'是否使用',
																			                mode:'local',store:isStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'updateIsJump'+i,xtype:'combo',fieldLabel:'是否跳转',
																			                mode:'local',store:isStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.12,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'updateBizType'+i,xtype:'combo',fieldLabel:'业务类型',
																			                mode:'local',store:bizTypeStore,
																			                typeAhead:true,triggerAction:'all',forceSelection:true
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.2,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'updateStartConnections'+i,xtype:'treecombo',fieldLabel:'起始端',
																	            			zdyForConnection:zdyForConnectionsStore
																			        }] 
															            		},{
																	            	layout:'form',labelWidth:55,columnWidth:.2,defaultType:'textfield',
																	            	defaults:{labelStyle:"text-align:right;",anchor:'95%'}, 
																	            	items:[{
																	            			id:'updateEndConnections'+i,xtype:'treecombo',fieldLabel:'目的端',
																	            			zdyForConnection:zdyForConnectionsStore
																			        }] 
															            		},{
															            	 		layout:'form',labelWidth:1,columnWidth:.12,defaultType:'textfield', 
															            	 		defaults:{labelStyle:"text-align:right;",anchor:'50%'},
																	            	items:[{id:'updateTransceiver'+i}]
																	            }]
														        }));
														   }
														  formPanel_updateFiberCoreNumber.doLayout();
														  /** 设置已经被初始化 */
														  isUpdateFiberCoreNumberInit = true;
														  /** 将数据进行填充 */
														  Ext.Ajax.request({
															 url: 'A_FiberCoreNumberServiceImpl!query.zdy',
															 params: {
															 	"ConditionDto.conditionFiled":"fiberCoreNumber.cableId",
								   								"ConditionDto.conditionConditions":"like",
																"ConditionDto.conditionValue":Ext.getCmp('updateCableId').getValue(),
																"ConditionDto.orderFiled":"fiberCoreNumber.fiberCoreNumberId",
																"ConditionDto.orderValue":"asc",
																"limit":_fiberCoreNumber
															 },success: function(_response){
															 	var __responseJson = Ext.util.JSON.decode(_response.responseText);
												       	 		var __totalCount = Ext.util.JSON.decode(__responseJson.totalCount);
															 	for (var j=0;j<__totalCount;j++){
															 	  Ext.getCmp("updateFiberCoreNumberName"+(j+1)).setValue(__responseJson.beenList[j].fiberCoreNumberName);
															 	  Ext.getCmp("updateIsUsed"+(j+1)).setValue(__responseJson.beenList[j].isUsed);
															 	  Ext.getCmp("updateIsJump"+(j+1)).setValue(__responseJson.beenList[j].isJump);
															 	  Ext.getCmp("updateBizType"+(j+1)).setValue(__responseJson.beenList[j].bizType);
															 	  Ext.getCmp("updateStartConnections"+(j+1)).setZdyValue(__responseJson.beenList[j].startConnections);
																  Ext.getCmp("updateEndConnections"+(j+1)).setZdyValue(__responseJson.beenList[j].endConnections);
															 	  Ext.getCmp("updateTransceiver"+(j+1)).setValue(__responseJson.beenList[j].transceiver);
															 	}
															 },failure: function(response,options){
																ajaxFailure(response,options);
															}
														  });
														   
														  waitBox.hide();
														  window_updateFiberCoreNumber.show();
														}else{
															Ext.MessageBox.alert(resultInfo,_responseJson.message);
														}
													},
													failure: function(response,options){
														ajaxFailure(response,options);
													}
												});
	           		 						}
	           		 					});	
					           	   	 }
					           	}],
	            				buttonAlign:'center',
						        buttons: 
						        [{
						            text: '保存',
						            handler:function(){
						            	if (formPanel_update.form.isValid()) {
						            		var addJson="[";
											var _index =1;
											/** 判断是否配置了纤芯列表 */
											if(Ext.getCmp('updateFiberCoreNumberName'+_index)==undefined){
												Ext.MessageBox.alert(tipsInfo,'未配置纤芯列表！');
												return;
											}
											while(true){
												/** 判断是否到了纤芯列表的最后一个 */
												if(Ext.getCmp('updateFiberCoreNumberName'+_index)==undefined){
													addJson = addJson.substr(0,addJson.length-1);
													break;
												}
												addJson +="{";
												addJson +="'fiberCoreNumberName':'"+Ext.getCmp('updateFiberCoreNumberName'+_index).getValue()+"',"; 
												addJson +="'isUsed':'"+Ext.getCmp('updateIsUsed'+_index).getValue()+"',"; 
												addJson +="'isJump':'"+Ext.getCmp('updateIsJump'+_index).getValue()+"',"; 
												addJson +="'bizType':'"+Ext.getCmp('updateBizType'+_index).getValue()+"',";
												addJson +="'delFlg':'启用',"; 
												addJson +="'startConnections':["+Ext.getCmp('updateStartConnections'+_index).getValue()+"],"; 
												addJson +="'endConnections':["+Ext.getCmp('updateEndConnections'+_index).getValue()+"],"; 
												addJson +="'transceiver':'"+Ext.getCmp('updateTransceiver'+_index).getValue()+"'"; 
												addJson +="},";
												_index++;
											}
											addJson +="]";
								            /** 更新相应记录 */
											Ext.Ajax.request({
												url: 'A_CableServiceImpl!update.zdy',
												params: {
													"A_Cable.cableId":Ext.getCmp('updateCableId').getValue(),
													"A_Cable.cableName":Ext.getCmp('updateCableName').getValue(),
													"A_Cable.isMainRoad":Ext.getCmp('updateIsMainRoad').getValue(),
													"A_Cable.cableStartId":Ext.getCmp('updateCableStartId').getValue(),
													"A_Cable.cableEndId":Ext.getCmp('updateCableEndId').getValue(),
											        "A_Cable.cableType":Ext.getCmp('updateCableType').getValue(),
												    "A_Cable.cableLength":Ext.getCmp('updateCableLength').getValue(),
												    "A_Cable.fiberId":Ext.getCmp('updateFiberId').getValue(),
												    "A_Cable.layingType":Ext.getCmp('updateLayingType').getValue(),
												    "A_Cable.runTime":Ext.getCmp('updateRunTime').getValue(),
												    "A_Cable.constructionUnitId":Ext.getCmp('updateConstructionUnitId').getValue(),
												    "A_Cable.bizType":Ext.getCmp('updateBizType').getValue(),
												    "A_Cable.delFlg":Ext.getCmp('updateDelFlg').getValue(),
												    "A_Cable.descp":Ext.getCmp('updateDescp').getValue(),
												    "beenList":addJson
												},
											    success: function(response,options){
											    /** 保存成功后，设置初始化为false */
												    isUpdateFiberCoreNumberInit = false;
												    formPanel_updateFiberCoreNumber.removeAll();
		           		 							Ext.getCmp('updateFiberId').setReadOnly(false);
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
        renderTo:"grid-size",title:'基础列表>>光缆', width:Ext.get("grid-size").getWidth(),height:Ext.get("grid-size").getHeight(),
        frame:true,iconCls:'bgi_grid',
        store:gridPanelDataStore,
        cm: new Ext.grid.ColumnModel([sm,
        	 new Ext.grid.RowNumberer({header:'序号',width:35,
        		renderer:function(value,metadata,record,rowIndex){
			　　　		return　record_start　+　1　+　rowIndex;
			　　	}
			}),
            {header:"光缆名称", width: 250, sortable:true,dataIndex:'cableName'},
            {header:"光缆起点", width: 140, sortable:true,dataIndex:'startSiteName'},
            {header:"光缆终点", width: 140, sortable:true,dataIndex:'endSiteName'},
            {header:"是否主干网", width: 140, sortable:true,dataIndex:'isMainRoad'},
            {header:"光缆类型", width: 140, sortable:true,dataIndex:'cableType'},
            {header:"光缆长度(km)", width: 120, sortable:true,dataIndex:'cableLength'},
            {header:"纤芯数量", width: 120, sortable:true,dataIndex:'fiberName'},
            {header:"敷设类型", width: 120, sortable:true,dataIndex:'layingType'},
            {header:"投运时间", width: 120, sortable:true,dataIndex:'runTime'},
            {header:"施工单位", width: 120, sortable:true,dataIndex:'constructionUnitName'},
            {header:"业务类型", width: 120, sortable:true,dataIndex:'bizType'},
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
							 url: 'A_CableServiceImpl!exportExcel.zdy',
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
       		 }, '-',{
       		 	 id:"update",disabled:true,text:'修改',tooltip:'修改',iconCls:'bgi_update',
            	 handler:function(){
            	 	var _record = functionGridPanel.getSelectionModel().getSelected();
           		 	if (_record){
           		 		var _jsonData = functionGridPanel.getSelectionModel().getSelections()[0];
			 				Ext.getCmp("updateCableId").setValue(_jsonData.get("cableId"));
							Ext.getCmp("updateCableName").setValue(_jsonData.get("cableName"));
							Ext.getCmp("updateCableStartId").setValue(_jsonData.get("cableStartId"));
							Ext.getCmp("updateCableEndId").setValue(_jsonData.get("cableEndId"));
							Ext.getCmp("updateIsMainRoad").setValue(_jsonData.get("isMainRoad"));
							Ext.getCmp("updateCableType").setValue(_jsonData.get("cableType"));
							Ext.getCmp("updateCableLength").setValue(_jsonData.get("cableLength"));
							Ext.getCmp("updateFiberId").setValue(_jsonData.get("fiberId"));
							Ext.getCmp("updateLayingType").setValue(_jsonData.get("layingType"));
							Ext.getCmp("updateRunTime").setValue(_jsonData.get("runTime"));
							Ext.getCmp("updateConstructionUnitId").setValue(_jsonData.get("constructionUnitId"));
							Ext.getCmp("updateBizType").setValue(_jsonData.get("bizType"));
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
										_jsonData = _jsonData +  m[i].get("cableId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("cableId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CableServiceImpl!effective.zdy',
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
										_jsonData = _jsonData +  m[i].get("cableId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("cableId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CableServiceImpl!invalid.zdy',
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
										_jsonData = _jsonData +  m[i].get("cableId");
									} else {
										_jsonData = _jsonData + "," +  m[i].get("cableId");
									}
								}
								/** 更新相应记录 */
								Ext.Ajax.request({
									   url: 'A_CableServiceImpl!delete.zdy',
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
													url: 'A_CableServiceImpl!query.zdy',
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
							url: 'A_CableServiceImpl!query.zdy',
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
			Ext.getCmp("viewCableName").setValue(_jsonData.get("cableName"));
			Ext.getCmp("viewStartSiteName").setValue(_jsonData.get("startSiteName"));
			Ext.getCmp("viewEndSiteName").setValue(_jsonData.get("endSiteName"));
			Ext.getCmp("viewIsMainRoad").setValue(_jsonData.get("isMainRoad"));
			Ext.getCmp("viewCableType").setValue(_jsonData.get("cableType"));
			Ext.getCmp("viewCableLength").setValue(_jsonData.get("cableLength"));
			Ext.getCmp("viewFiberId").setValue(_jsonData.get("fiberName"));
			Ext.getCmp("viewLayingType").setValue(_jsonData.get("layingType"));
			Ext.getCmp("viewRunTime").setValue(_jsonData.get("runTime"));
			Ext.getCmp("viewConstructionUnitId").setValue(_jsonData.get("constructionUnitName"));
			Ext.getCmp("viewBizType").setValue(_jsonData.get("bizType"));
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
	
 /** 光缆名称事件 */
	 function addCaleNameSelect(){
		if(Ext.get('addCableEndId').dom.value!=''&& Ext.get('addCableStartId').dom.value!=''){
				var _tempCableName = Ext.get('addCableStartId').dom.value+"-"+Ext.get('addCableEndId').dom.value+"-";
				Ext.Ajax.request({
					url: 'A_CableServiceImpl!getCableName.zdy',
					params: {
							"ConditionDto.conditionFiled":'cableName',
							"ConditionDto.conditionConditions":'like',
							"ConditionDto.conditionValue":_tempCableName,
							"ConditionDto.orderFiled":'cableId',
							"ConditionDto.orderValue":'desc'
					},
					success: function(response){
						var _responseJson = Ext.util.JSON.decode(response.responseText);
						var _result = Ext.util.JSON.decode(_responseJson.result);
						if(_result.success){
							if(_responseJson.been==null){
								Ext.getCmp('addCableName').setValue(_tempCableName+"1");
							}else{
								var _been = Ext.util.JSON.decode(_responseJson.been);
								Ext.getCmp('addCableName').setValue(_been.cableName);
							}
						}else{
							Ext.getCmp('addCableName').setValue('');
							Ext.MessageBox.alert(resultInfo,_result.message);
						}
				  },
				  failure: function(response,options){ajaxFailure(response,options);}
			 });
		}
	}		
 	Ext.getCmp('addCableStartId').addListener('select',addCaleNameSelect);
 	Ext.getCmp('addCableEndId').addListener('select',addCaleNameSelect);
 	function updateCaleNameSelect(){
		if(Ext.get('updateCableEndId').dom.value!=''&& Ext.get('updateCableStartId').dom.value!=''){
				var _tempCableName = Ext.get('updateCableStartId').dom.value+"-"+Ext.get('updateCableEndId').dom.value+"-";
				Ext.Ajax.request({
					url: 'A_CableServiceImpl!getCableName.zdy',
					params: {
							"ConditionDto.conditionFiled":'cableName',
							"ConditionDto.conditionConditions":'like',
							"ConditionDto.conditionValue":_tempCableName,
							"ConditionDto.orderFiled":'cableId',
							"ConditionDto.orderValue":'desc'
					},
					success: function(response){
						var _responseJson = Ext.util.JSON.decode(response.responseText);
						var _result = Ext.util.JSON.decode(_responseJson.result);
						if(_result.success){
							if(_responseJson.been==null){
								Ext.getCmp('updateCableName').setValue(_tempCableName+"1");
							}else{
								var _been = Ext.util.JSON.decode(_responseJson.been);
								Ext.getCmp('updateCableName').setValue(_been.cableName);
							}
						}else{
							Ext.getCmp('updateCableName').setValue('');
							Ext.MessageBox.alert(resultInfo,_result.message);
						}
				  },
				  failure: function(response,options){ajaxFailure(response,options);}
			 });
		}
	}	
  	Ext.getCmp('updateCableStartId').addListener('select',updateCaleNameSelect);
  	Ext.getCmp('updateCableEndId').addListener('select',updateCaleNameSelect);
  	/** 查询下拉框事件 */
	function conditionFiledSelect(){
		Ext.getCmp('conditionFiledPanel').remove("conditionValue");
		if(Ext.getCmp('conditionFiled').getValue()=='cable.delFlg'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:delFlgStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.cableStartId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:siteDataStore,
				displayField:'siteName',valueField:'siteId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.cableEndId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:siteDataStore,
				displayField:'siteName',valueField:'siteId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.isMainRoad'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:isStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.fiberId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:fiberDataStore,
				displayField:'fiberName',valueField:'fiberId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.constructionUnitId'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				typeAhead:true,triggerAction:'all',forceSelection:true,
				mode:'local',store:constructionUnitDataStore,
				displayField:'constructionUnitName',valueField:'constructionUnitId'
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.bizType'){
			Ext.getCmp('conditionFiledPanel').add(new Ext.form.ComboBox({
				id:"conditionValue",xtype:'combo',fieldLabel:'查询内容',
				mode:'local',store:bizTypeStore,
				typeAhead:true,triggerAction:'all',forceSelection:true
			}));
		}else if(Ext.getCmp('conditionFiled').getValue()=='cable.runTime'){
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
