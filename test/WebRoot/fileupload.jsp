<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%>  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>My JSP 'upload.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">       
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script> 
    <script type="text/javascript" src="js/jquery-form.js"></script> 
   
   <script type="text/javascript">
   $(document).ready(function() {    
            $("#myForm").submit(function(){   
                $('#myForm').ajaxSubmit({    
                    beforeSubmit:handleBeforeSubmit,   
                    success:handleSuccess   
                });    
                return false;   
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
    <form action="upload/uploadFile.action" method="post" enctype="multipart/form-data" id="myForm">  
      <label for="myFile">选择文件：</label>  
      <input type="file" name="myFile" />  
      <input type="hidden" name="myfield" value="myvalue">  
      <input type="submit" value="上传"/>  
   </form>  
  </body>  
</html>  
