<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function _makeTip(_id) {
		$("#" + _id + "").hover(function(e) {
			e = e || window.event;
			var div = "<div id='_tip_div_id'>" + this.title + "</div>";
			$("body").append(div);
			$("#_tip_div_id").css({
				border : '1px solid black',
				position : 'absolute',
				left : e.clientX + 10 + "px",
				top : e.clientY + 10 + "px"
			});
			this.mytitle = this.title;
			this.title = '';
		}, function(e) {
			e = e || window.event;
			this.title = this.mytitle;
			this.mytitle = '';
			$("#_tip_div_id").remove();
		}).mousemove(function(e) {
			e = e || window.event;
			$("#_tip_div_id").css({
				left : e.clientX + 10 + "px",
				top : e.clientY + 10 + "px"
			});
		});
	}

	$(function() {
		_makeTip("_link");
	});
</script>
</head>

<body>
	This is my HTML page.
	<br>
	<a href="###" title="这里是给用户的提示信息......." id="_link">This is my HTML
		page.</a>

</body>
</html>
