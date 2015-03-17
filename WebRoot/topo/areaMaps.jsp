<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>区域展示图</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=basePath%>topo/js/d3/d3.min.js" charset="utf-8"></script>
<script src="<%=basePath%>topo/js/jquery-2.1.1.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		d3.select("body").transition()
	    .style("background-color", "black");
	});
</script>
</head>

<body>
	<p></p>
</body>
</html>
