<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/common.css" />
<table border=0>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/project.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('项目','b_project.jsp')">项目</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/constructionUnit.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('施工单位','b_constructionUnit.jsp')">施工单位</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/area.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('区域','b_area.jsp')">区域</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/fiber.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('光纤','b_fiber.jsp')">光纤</a>
		</td>
	</tr>
	<tr>
		<td class="h16">
			&nbsp;&nbsp;&nbsp;
			<img src="<%=basePath%>/images/manufacturers.png" class="w16 h16 vam" />
			<a href="#" class="h16 fs12 fwb lh16" onclick="showMain('厂家','b_manufacturers.jsp')">厂家</a>
		</td>
	</tr>
</table>