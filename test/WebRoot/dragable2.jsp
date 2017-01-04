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

<title>My JSP 'dragable2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#movedivid {
	width: 300px;
	height: 200px;
	background: #cccccc;
}
</style>

<script language="javascript" src="js/moveDiv.js"></script>
</head>

<body>
	<div id="movedivid"
		style="position: absolute; left: 145px; top: 30px;width:300px;height:200px;background:#cccccc;cursor:move;"
		onmousedown="MoveDiv.Move('movedivid')">test text</div>
</body>
</html>
