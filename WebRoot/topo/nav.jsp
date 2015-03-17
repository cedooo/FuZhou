<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>展示图管理</title>
<script type="text/javascript">
	function toNewSiteEquipSchema(){
		var siteID = document.getElementById("siteID").value;
		window.location.href="<%=basePath %>topo/addView.jsp?siteID=" + siteID;
	}
	function toNewCustomSchema(){
		window.location.href="<%=basePath %>topo/addView.jsp";
	}
	function toShowSchema(){
		var schemaID = document.getElementById("schemaID").value;
		window.location.href="<%=basePath %>topo/view.jsp?schemaID=" + schemaID;
	}
	function toNewSiteSchema(){
		var areaID = document.getElementById("areaID").value;
		window.location.href="<%=basePath %>topo/addSiteView.jsp?areaID=" + areaID;
	}
	function toNewAreaSchema(){
		window.location.href="<%=basePath %>topo/addAreaView.jsp";
	}
</script>
</head>
<body>
<h2>索引</h2>
<a href="<%=basePath %>topo/default.jsp" >默认页面</a>
<a href="<%=basePath %>topo/manager.jsp" >管理页面</a>

<h2>其它</h2>
		<button onclick="toNewAreaSchema()">区域视图添加</button>
		<button onclick="toNewSiteSchema()">站点视图添加</button><input id="areaID" type="text"  placeholder="区域ID" />
		<button onclick="toNewSiteEquipSchema()">添加站点设备视图</button><input id="siteID" type="text" value="3" placeholder="站点ID" />
		<button onclick="toNewCustomSchema()">添加自定义视图</button>
		<button onclick="toShowSchema()">视图展示</button><input id="schemaID" type="text" value="7" placeholder="视图ID" />
</body>
</html>