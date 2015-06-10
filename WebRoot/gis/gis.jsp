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
		<param name="bpp" value="24">
		<param name="align" value="top">
		<param name="cabbase" value="" />
		<param name="windowTitle" value="'GIS'" />
	</applet>
</body>
</html>
