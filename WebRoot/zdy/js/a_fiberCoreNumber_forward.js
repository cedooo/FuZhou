Ext.onReady(function(){
	/*************************************** 初始化 ********************************************************/
	/** 加载tips提示信息 */
    Ext.QuickTips.init();
	/** 对话提示框 */
	var resultInfo ="操作结果对话框";
	var tipsInfo ="操作提示对话框";
	/** 表格序号 */
	var dddss = Ext.get("forwardCableId");
	var ssa = Ext.get("forwardCableId").dom.innerText;
   var record_start = 0;
	 /** gridPanel表格数据remote初始化 */
	var gridPanelDataStore = new Ext.data.JsonStore({
    		url: 'A_FiberCoreNumberServiceImpl!query.zdy',
    		baseParams:{start:0,limit:50},
    		root:'beenList',
    		totalProperty:'totalCount',
    		fields:['fiberCoreNumberId','fiberCoreNumberName','cableId','cableName','isUsed','isJump','bizType',
    		'startConnections','startConnections.siteId','startConnections.deviceId','startConnections.deviceType','startConnections.deviceName',
    		'endConnections','endConnections.siteId','endConnections.deviceId','endConnections.deviceType','endConnections.deviceName',
    		'transceiver','delFlg','descp']
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
						        		{id:"viewStartConnections",fieldLabel:'起始端'},
						        		{id:"viewEndConnections",fieldLabel:'目的端'},
						        		{id:"viewTransceiver",fieldLabel:'收发情况'},
						        		{id:"viewDelFlg",fieldLabel:'<font color="red">(*)</font>是否启用'},
						        		{id:"viewDescp",xtype:'textarea',fieldLabel:'备注'}
						        ]
						    });
     /************************************************ 窗口集合 ************************************************ */					    
		/** 查看窗口 */
    	var window_view = new Ext.Window({
	         					title: '查看窗口',closable:true,closeAction:"hide",
	            				width:400,height:400,iconCls:'bgi_add',plain:true,layout:'fit',items:formPanel_view,
	            				buttonAlign:'center',
						        buttons: [{text: '关闭',handler:function(){window_view.hide();}}]
	       					});				        				    
	       					
  /************************************ Grid ***********************************************************/ 
    /** 自定义的checkbox列选择 */
    var xg = Ext.grid;
    var sm = new xg.CheckboxSelectionModel({
    	/** 添加监听器 */
    	listeners:{
    	  /** 行选择事件 */
          rowselect : function (sm, rowIndex, keep, rec){},
          /** 取消选择事件 */
          rowdeselect : function (sm, rowIndex, keep, rec){}
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
            {header:"起始端",width: 100, sortable:true,dataIndex:'startConnections.deviceName'},
            {header:"目的端",width: 100, sortable:true,dataIndex:'endConnections.deviceName'},
            {header:"收发情况",width: 100, sortable:true,dataIndex:'transceiver'},
            {header:"是否启用",width: 80, sortable:true,dataIndex:'delFlg'},
            {header:"备注",   width: 100, sortable:true,dataIndex:'descp'}
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
			}
        })
    });
    
   /*********************************************** 事件初始化*******************************************************/
     /** gridPanelDataStore加载前的事件 */
     var refreshMsgTip;
     gridPanelDataStore.on('beforeload',function(){
     	refreshMsgTip = Ext.MessageBox.wait('页面数据刷新中,请稍等',tipsInfo,{text:"正在获取数据..."});
     	gridPanelDataStore.baseParams["ConditionDto.conditionFiled"] = "fiberCoreNumber.cableId";
     	gridPanelDataStore.baseParams["ConditionDto.conditionConditions"] = "=";
     	gridPanelDataStore.baseParams["ConditionDto.conditionValue"] = Ext.get("forwardCableId").dom.innerText;
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
			Ext.getCmp("viewStartConnections").setValue(jsonData.get("startConnections.deviceName")); 
			Ext.getCmp("viewEndConnections").setValue(jsonData.get("endConnections.deviceName")); 
			Ext.getCmp("viewTransceiver").setValue(jsonData.get("transceiver"));
			Ext.getCmp("viewDelFlg").setValue(jsonData.get("delFlg"));
			Ext.getCmp("viewDescp").setValue(jsonData.get("descp"));
			window_view.show();
          }else{
			Ext.MessageBox.alert(tipsInfo,'请双击要查看的数据项！');
		  } 
    }
    functionGridPanel.addListener('rowdblclick', onrowdoubleclick);
    
    
	
	function ajaxQuerySuccess(response){
    	var _responseJson = Ext.util.JSON.decode(response.responseText);
		var _result = Ext.util.JSON.decode(_responseJson.result);
		if(_result.success){
		 	gridPanelDataStore.load();
		}else{
			Ext.MessageBox.alert(resultInfo,_result.message);
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
	
    /** functionGridPanel宽度自适应 */
    window.onresize=function(){
		functionGridPanel.setWidth(Ext.get("grid-size").getWidth());
		functionGridPanel.setHeight(Ext.get("grid-size").getHeight());
	};
});
