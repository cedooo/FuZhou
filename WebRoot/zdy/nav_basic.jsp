<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/common.css" />
<table border=0>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/site.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('站点','a_site.jsp')">站点</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/cable.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('光缆','a_cable.jsp')">光缆</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/fiberCoreNumber.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('纤芯列表','a_fiberCoreNumber.jsp')">纤芯列表</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/gprs.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('GPRS','a_gprs.jsp')">GPRS</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/olt.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('OLT','a_olt.jsp')">OLT</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/onu.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('ONU','a_onu.jsp')">ONU</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/carrier.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('载波','a_carrier.jsp')">载波</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/twoLayerSwitch.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('二层交换机','a_twoLayerSwitch.jsp')">二层交换机</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/threeLayerSwitch.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('三层交换机','a_threeLayerSwitch.jsp')">三层交换机</a>
		</td>
	</tr>
</table>