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

<title>福州电业局-GIS</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="fzep,rdp">
<meta http-equiv="description" content="rdp">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var winWidth = 0;
	var winHeight = 0;
	function findDimensions() //函数：获取尺寸
	{
		// 获取窗口宽度
		if (window.innerWidth)
			winWidth = window.innerWidth;
		else if ((document.body) && (document.body.clientWidth))
			winWidth = document.body.clientWidth;
		// 获取窗口高度
		if (window.innerHeight)
			winHeight = window.innerHeight;
		else if ((document.body) && (document.body.clientHeight))
			winHeight = document.body.clientHeight;

		// 通过深入Document内部对body进行检测，获取窗口大小
		if (document.documentElement && document.documentElement.clientHeight
				&& document.documentElement.clientWidth) {
			winHeight = document.documentElement.clientHeight;
			winWidth = document.documentElement.clientWidth;
		}
		// 结果输出至两个文本框
		//document.form1.availHeight.value= winHeight;
		//document.form1.availWidth.value= winWidth;
		gisapplet.width = winWidth;
		gisapplet.height = winHeight;
	}
	findDimensions(); // 调用函数，获取数值
</script>
</head>

<body>
	<applet id="gisapplet" code="net.propero.rdp.applet.RdpApplet.class"
		codebase="applet"
		archive="log4j-java1.1.jar,java-getopt-1.0.14.jar,properJavaRDP-1.1.jar,properJavaRDP14-1.1.jar"
		width="1000" height="400" align="bottom" name="gis">
		<param name="server" value="192.168.1.222" />
		<param name="port" value="3389" />
		<param name="username" value="Administrator" />
		<param name="password" value="123" />
		<param name="width" value="1300" />
		<param name="height" value="555" />
		<param name="geometry" value="1300x555" />
		<param name="title" value="GIS" />
		<param name="name" value="GIS" />
		<param name="bpp" value="24">
		<param name="align" value="top">
		<param name="cabbase" value="" />
	</applet>
</body>
</html>
