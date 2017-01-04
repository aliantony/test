<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   html {               
	    width:100%; 
	    height:100%;                
	    overflow:hidden;            
	    }
	    div{
	       overflow: hidden;
	    }
	  body{
	   margin: 0 auto;
	   font:12px/180% Arial, Helvetica, sans-serif, "新宋体";
	  }
	  *{margin:0;padding:0;list-style-type:none;}
      a,img{border:0;text-decoration:none;}
	  #content{
	     width: 100%;
	     height: 100%;
	  }
	  #top{
	     width: 100%;
	     height: 80px;
	     background: #B4FFF8 url(images/11.jpg) no-repeat fixed top;
	  }
	  #left{
	  width:180px; 
	  float: left;
	  height:100%; 
	  margin-right:-3px; 
	  }
	  #bottom{
	  background: #ffc;
	  width: 100%;
	  height: 100%;
	  }
	  #contain{
	  height: 100%;
	  width: 100%;
	  }
	</style>
	
	<link rel="stylesheet" type="text/css" href="css/sdmenu.css" />

   <script type="text/javascript" src="js/sdmenu.js"></script>
   <script type="text/javascript">
     var myMenu;
    window.onload = function() {
	myMenu = new SDMenu("left");
	myMenu.init();
   };
</script>
  </head>
  
  <body>
   <div id="content">
      <div id="top">
         这是顶部
      </div>
      <div id="contain">
       <div id="left" class="sdmenu">
			    <div class="collapsed">
					<span>在线工具</span>
					<a href="http://sc.chinaz.com/">图像优化</a>
					<a href="http://sc.chinaz.com/">收藏夹图标生成器</a>
					<a href="http://sc.chinaz.com/">邮件出谜语的人</a>
					<a href="http://sc.chinaz.com/">htaccess密码</a>
					<a href="http://sc.chinaz.com/">梯度图像</a>
					<a href="http://sc.chinaz.com/">按钮生成器</a>
				</div>
				<div class="collapsed">
					<span>支持我们</span>
					<a href="http://sc.chinaz.com/">推荐我们</a>
					<a href="http://sc.chinaz.com/">链接我们</a>
					<a href="http://sc.chinaz.com/">网络资源</a>
				</div>
				<div class="collapsed">
					<span>合作伙伴</span>
					<a href="http://sc.chinaz.com/">JavaScript工具包</a>
					<a href="http://sc.chinaz.com/">CSS驱动</a>
					<a href="http://sc.chinaz.com/">CodingForums</a>
					<a href="http://sc.chinaz.com/">CSS例子</a>
				</div>
				<div class="collapsed">
					<span>测试电流</span>
					<a href="http://sc.chinaz.com/">Current or not</a>
					<a href="http://sc.chinaz.com/">Current or not</a>
					<a href="http://sc.chinaz.com/">Current or not</a>
					<a href="http://sc.chinaz.com/">Current or not</a>
				</div>
	      </div>
	      <div id="bottom">
	                    这是右边
	      </div>
      </div>
   </div>
  </body>
</html>
