/** nav导航树点击功能 */
var showMain = function(title,page){}

Ext.onReady(function(){
	/*************************************** 初始化 ********************************************************/
	/** 获取服务器当前路径 */
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]+'/zdy/'; 
	 
   /** 初始化Ext状态管理器，在Cookie中记录用户的操作状态，如果不启用，象刷新时就不会保存当前的状态，而是重新加载象
 	 * 如果窗口中有用可拖动面板的话，你在拖动后如果启动了Ext.state.Manager.setProvider(new Ext.state.CookieProvider()),
  	 * 就算刷新后面板仍然会在你拖动后的位置。如果不启用的话是不是就会按照默认的排列方式排列  
  	 */
  	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
    /** 菜单工具栏-关闭按钮的定义 */
    var tools = [{id:'close',handler: function(e, target, panel){panel.ownerCt.remove(panel, true);}}];
    			
	/** panel首页的初始化 */
 	var pannel = new Ext.TabPanel({
 				  id:'center',region:'center',deferredRender:false,activeTab:0,minTabWidth:100,
 				  plugins: new Ext.ux.TabCloseMenu(),resizeTabs:true,enableTabScroll:true,
				  items:[{
					   xtype: 'portal',title: '首页',closable: false,autoScroll: true,
					   items:[{
                		   columnWidth:.33,style:'padding:10px 0 10px 10px',
                		   defaults:{tools:tools,scrolling:true,height:160},
               			   items:[{
								title:'站点',
								html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/site.jsp"+'"></iframe>'
							 },{
								title:'OLT',
								html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/olt.jsp"+'"></iframe>'
							 },{
								title:'二层交换机',
								html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/twoLayerSwitch.jsp"+'"></iframe>'
							}]
						},{
                			columnWidth:.33,style:'padding:10px 0 10px 10px',
                			defaults:{tools:tools,scrolling:true,height:160},
	               			items:[{
									title:'光缆',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/cable.jsp"+'"></iframe>'
							 	},{
									title: 'ONU',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/onu.jsp"+'"></iframe>'
							 	},{
									title: '三层交换机',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/threeLayerSwitch.jsp"+'"></iframe>'
							}]
						},{
	                		 columnWidth:.33,style:'padding:10px 0 10px 10px',
	                		 defaults:{tools:tools,scrolling:true,height:160},
	               			 items:[{
									title: '纤芯列表',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/fiberCoreNumber.jsp"+'"></iframe>'
							 	},{
									title: 'GPRS',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/gprs.jsp"+'"></iframe>'
							 	},{
									title: '载波',
									html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+"portal/carrier.jsp"+'"></iframe>'
							 }]
						}]
				}]
		})
		
    
	/** 首页初始化 */
   var viewport = new Ext.Viewport({
    	id:"viewport",layout:'border',
        items:[{
  				region:"north",height:64,autoScroll:false,
  				autoLoad:basePath+'header.jsp'
  			},{
	            region:'west',id:"nav",title:"导航条",split:true,width:160,minSize:128,maxSize:256,
	            collapsible:true,autoScroll:false,layout:'accordion',layoutConfig:{animate:true},
	            items:[{
	  				 	title:"基础表",collapsed:false,hidden:false,border:false,iconCls:'bgi_folder',
						autoLoad:basePath+'nav_basic.jsp'
	  				},{
	  					title:"下拉维护表",collapsed:false,hidden:false,border:false,iconCls:'bgi_folder',
	  					autoLoad:basePath+'nav_pullDown.jsp'
	  				}
	  			]
       		 },pannel
       	]
    });
    
    /** tabPanel加载页面(只能放在tabPanel初始化完毕) */
	 showMain =function(title,page){
	 /** 相同的Id组件，不重复加载 */
	 	if(Ext.getCmp(title) != undefined){
	 		pannel.setActiveTab(Ext.getCmp(title));
	 		return false;
	 	}
		var currentPanel = pannel.add({
								id:title,title:title,closable:true,autoScroll:true,
						   		html:'<iframe frameborder="0" scrolling="no" style="width:100%;height:100%" src="'+basePath+page+'"></iframe>'
							});
  		pannel.setActiveTab(currentPanel);
	}
});

