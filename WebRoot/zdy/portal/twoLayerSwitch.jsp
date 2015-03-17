<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../head.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/extjs2/resources/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/common.css" />
		<script type="text/javascript" src="<%=basePath%>/extjs2/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=basePath%>/extjs2/ext-all.js"></script>
		<script type="text/javascript" src="<%=basePath%>/extjs2/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=basePath%>/portal/portalForCount.js"></script>
	</head>
	<body>
		<div class="w128 h128 fl">
			<img class="w100_p h100_p" src="<%=basePath%>/images/twoLayerSwitch.png" />
		</div>
		<div id="tableNameDiv" class="dn">a_twoLayerSwitch</div>
		<div class="w200 h128 fr">
			<div class="h32 fwb fs16 fb lh32">二层交换机</div>
			<div class="h32 fs16 fb lh32">总记录数:<span id="totalCount">获取中...稍等</span></div>
			<div class="h32 fs16 fb lh32">有效数目:<span id="effectiveCount">获取中...稍等</span></div>
			<div class="h32 fs16 fb lh32">无效数目:<span id="invalidCount">获取中...稍等</span></div>
		</div>
	</body>
</html>

