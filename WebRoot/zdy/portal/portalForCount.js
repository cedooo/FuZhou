Ext.onReady(function(){
	var tableName =Ext.get("tableNameDiv").dom.innerText;
	Ext.Ajax.request({
				url: 'PortalService!getTotalCount.zdy',
				params: {
					"tableName":tableName
				},
				success: function(response){
				 	var _responseJson = Ext.util.JSON.decode(response.responseText);
					var _result = Ext.util.JSON.decode(_responseJson.result);
		 			if(_result.success){
		 				Ext.get("totalCount").dom.innerText =  _responseJson.totalCount;
			 		}else{
			 			Ext.get("totalCount").dom.innerText =  _result.message;
					}
				},
				failure: function(response,options){
					if(response.status == "404"){
						Ext.MessageBox.alert(resultInfo,"请求的地址有误，请联系管理人员。");
					}else if(response.status == "0"){
						Ext.MessageBox.alert(resultInfo,"连接不到服务器，请联系管理人员");
					}else{
						Ext.MessageBox.alert(resultInfo,"未知错误，请联系管理人员");
					}
					setTimeout(function(){Ext.MessageBox.hide();},errorWaitSeconds);
				}
			});
			
			Ext.Ajax.request({
				url: 'PortalService!getEffectiveCount.zdy',
				params: {
					"tableName":tableName
				},
				success: function(response){
				 	var _responseJson = Ext.util.JSON.decode(response.responseText);
					var _result = Ext.util.JSON.decode(_responseJson.result);
		 			if(_result.success){
		 				Ext.get("effectiveCount").dom.innerText =  _responseJson.totalCount;
			 		}else{
			 			Ext.get("effectiveCount").dom.innerText =  _result.message;
					}
				},
				failure: function(response,options){
					if(response.status == "404"){
						Ext.MessageBox.alert(resultInfo,"请求的地址有误，请联系管理人员。");
					}else if(response.status == "0"){
						Ext.MessageBox.alert(resultInfo,"连接不到服务器，请联系管理人员");
					}else{
						Ext.MessageBox.alert(resultInfo,"未知错误，请联系管理人员");
					}
					setTimeout(function(){Ext.MessageBox.hide();},errorWaitSeconds);
				}
			});
			
			Ext.Ajax.request({
				url: 'PortalService!getInvalidCount.zdy',
				params: {
					"tableName":tableName
				},
				success: function(response){
				 	var _responseJson = Ext.util.JSON.decode(response.responseText);
					var _result = Ext.util.JSON.decode(_responseJson.result);
		 			if(_result.success){
		 				Ext.get("invalidCount").dom.innerText =  _responseJson.totalCount;
			 		}else{
			 			Ext.get("invalidCount").dom.innerText =  _result.message;
					}
				},
				failure: function(response,options){
					if(response.status == "404"){
						Ext.MessageBox.alert(resultInfo,"请求的地址有误，请联系管理人员。");
					}else if(response.status == "0"){
						Ext.MessageBox.alert(resultInfo,"连接不到服务器，请联系管理人员");
					}else{
						Ext.MessageBox.alert(resultInfo,"未知错误，请联系管理人员");
					}
					setTimeout(function(){Ext.MessageBox.hide();},errorWaitSeconds);
				}
			});
});
