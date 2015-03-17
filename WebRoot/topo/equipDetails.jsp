<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'equipDetails.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		body {
			padding:0;
			margin:0;
		}
	</style>
  </head>
  
  <body>
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%" height="100%" id="EquipmentDetails">
	               <param name="movie" value="EquipmentDetails.swf" />
	               <param name="quality" value="high" />
	               <param name="bgcolor" value="#93ae93" />
	               <param name="allowScriptAccess" value="sameDomain" />
	               <param name="allowFullScreen" value="true" />
	               <!--[if !IE]>-->
	               <object type="application/x-shockwave-flash" data="topo/fx/EquipmentDetails.swf" width="100%" height="100%">
	                   <param name="quality" value="high" />
	                   <param name="bgcolor" value="#93ae93" />
	                   <param name="allowScriptAccess" value="sameDomain" />
	                   <param name="allowFullScreen" value="true" />
	               <!--<![endif]-->
	               <!--[if gte IE 6]>-->
	               	<p> 
	               		Either scripts and active content are not permitted to run or Adobe Flash Player version
	               		10.0.0 or greater is not installed.
	               	</p>
	               <!--<![endif]-->
	                   <a href="http://www.adobe.com/go/getflashplayer">
	                       <img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash Player" />
	                   </a>
	               <!--[if !IE]>-->
	               </object>
	               <!--<![endif]-->
	           </object>
  </body>
</html>
