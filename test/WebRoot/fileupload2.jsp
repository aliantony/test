<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();   
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<base href="<%=basePath%>">

<title>My JSP 'upload.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">

<meta http-equiv="cache-control" content="no-cache">

<meta http-equiv="expires" content="0">

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<meta http-equiv="description" content="This is my page">

<script type="text/javascript"
	src="<%=basePath%>/js/jquery-2.1.3.js"></script>

<script type="text/javascript"
	src="<%=basePath%>/js/jquery.form.js"></script>

<script type="text/javascript">  
        $(document).ready(function() {    
            $('#myForm').ajaxForm({    
                beforeSubmit:handleBeforeSubmit,   
                success:handleSuccess   
            });    
        });   
        /**   
         * 提交请求发出之前的处理   
         */   
        function handleBeforeSubmit(){   
            console.info('提交请求发出之前的处理')   
        }   
        /**   
         * 上传成功后的处理   
         */   
        function handleSuccess(){   
            console.info('上传成功后的处理')   
            alert('上传成功 !');   
        }   
    </script>

</head>

<body>

	<form action="upload/uploadFile.htm" method="post"
		enctype="multipart/form-data" id="myForm">
 <label for="myFile">选择文件：</label> <input type="file"
			name="myFile" /> <input type="hidden" name="myfield"
			value="myvalue">  <input type="submit" value="上传" /> 
	</form>

</body>

</html>
