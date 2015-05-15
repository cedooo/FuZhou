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

<title>福州电业局-科大-GIS</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var winWidth = 0;
	var winHeight = 0;
	function findDimensions() //函数：获取尺�?
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

		// 通过深入Document内部对body进行�?��，获取窗口大�?
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
	findDimensions(); // 调用函数，获取数�?
</script>
</head>

<body>

	<!--"CONVERTED_APPLET"-->
<!-- HTML CONVERTER -->
<object
    classid = "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
    codebase = "http://java.sun.com/update/1.6.0/jinstall-6u45-windows-i586.cab#Version=6,0,0,6"
    WIDTH = "1000" HEIGHT = "400" NAME = "gis" ALIGN = "bottom" >
    <PARAM NAME = CODE VALUE = "net.propero.rdp.applet.RdpApplet.class" >
    <PARAM NAME = CODEBASE VALUE = "applet" >
    <PARAM NAME = ARCHIVE VALUE = "log4j-java1.1.jar,java-getopt-1.0.14.jar,properJavaRDP-1.1.jar,properJavaRDP14-1.1.jar" >
    <PARAM NAME = NAME VALUE = "gis" >
    <param name = "type" value = "application/x-java-applet;version=1.6">
    <param name = "scriptable" value = "false">
    <PARAM NAME = "server" VALUE="192.168.1.222" />
    <PARAM NAME = "port" VALUE="3389" />
    <PARAM NAME = "username" VALUE="Administrator" />
    <PARAM NAME = "password" VALUE="123" />
    <PARAM NAME = "width" VALUE="1300" />
    <PARAM NAME = "height" VALUE="555" />
    <PARAM NAME = "geometry" VALUE="1300x555" />
    <PARAM NAME = "windowTitle" VALUE="GIS" />
    <PARAM NAME = "name" VALUE="GIS" />
    <PARAM NAME = "bpp" VALUE="24">
    <PARAM NAME = "align" VALUE="bottom">
    <PARAM NAME = "cabbase" VALUE="" />

    <comment>
	<embed
            type = "application/x-java-applet;version=1.6" \
            CODE = "net.propero.rdp.applet.RdpApplet.class" \
            JAVA_CODEBASE = "applet" \
            ARCHIVE = "log4j-java1.1.jar,java-getopt-1.0.14.jar,properJavaRDP-1.1.jar,properJavaRDP14-1.1.jar" \
            NAME = "gis" \
            WIDTH = "1000" \
            HEIGHT = "400" \
            ALIGN = "bottom" \
            server ="192.168.1.222" / \
            port ="3389" / \
            username ="Administrator" / \
            password ="123" / \
            width ="1300" / \
            height ="555" / \
            geometry ="1300x555" / \
            windowTitle ="GIS" / \
            name ="GIS" / \
            bpp ="24" \
            align ="bottom" \
            cabbase ="" /
	    scriptable = false
	    pluginspage = "http://java.sun.com/products/plugin/index.html#download">
	    <noembed>
            
            </noembed>
	</embed>
    </comment>
</object>

<!--
<APPLET CODE = "net.propero.rdp.applet.RdpApplet.class" JAVA_CODEBASE = "applet" ARCHIVE = "log4j-java1.1.jar,java-getopt-1.0.14.jar,properJavaRDP-1.1.jar,properJavaRDP14-1.1.jar" WIDTH = "1000" HEIGHT = "400" NAME = "gis" ALIGN = "bottom">
<PARAM NAME = "server" VALUE="192.168.1.222" />
<PARAM NAME = "port" VALUE="3389" />
<PARAM NAME = "username" VALUE="Administrator" />
<PARAM NAME = "password" VALUE="123" />
<PARAM NAME = "width" VALUE="1300" />
<PARAM NAME = "height" VALUE="555" />
<PARAM NAME = "geometry" VALUE="1300x555" />
<PARAM NAME = "windowTitle" VALUE="GIS" />
<PARAM NAME = "name" VALUE="GIS" />
<PARAM NAME = "bpp" VALUE="24">
<PARAM NAME = "align" VALUE="bottom">
<PARAM NAME = "cabbase" VALUE="" />


</APPLET>
-->
<!--"END_CONVERTED_APPLET"-->

</body>
</html>
