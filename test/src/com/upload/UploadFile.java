package com.upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
public class UploadFile {
 private static final Logger LOG = Logger.getLogger(UploadFile.class);// LOG日志
 
 @SuppressWarnings("unchecked")
 public static void upload(HttpServletRequest request,
   HttpServletResponse response) throws IOException {
   LOG.info("客户端提交类型: " + request.getContentType());
   //判断文件类型，为空则报异常
  if (request.getContentType() == null) {
   throw new IOException(
     "the request doesn't contain a multipart/form-data stream");
  }
  String key = request.getParameter("key");
  Progress p = (Progress) request.getSession().getAttribute(key);
  // 设置上传文件总大小
  p.setLength(request.getContentLength());
   LOG.info("上传文件大小为 : " + p.getLength());
  // 上传临时路径
  String path = request.getSession().getServletContext().getRealPath("/file");
   LOG.info("上传临时路径 : " + path);
  // 设置上传工厂
  DiskFileItemFactory factory = new DiskFileItemFactory();
  factory.setRepository(new File(path));
  // 阀值,超过这个值才会写到临时目录
  factory.setSizeThreshold(1024 * 1024 * 10);
  ServletFileUpload upload = new ServletFileUpload(factory);
  // 最大上传限制 200M
  upload.setSizeMax(1024 * 1024 * 200);
  // 设置监听器监听上传进度
  upload.setProgressListener(p);
  try {
    LOG.info("解析上传文件....");
   List<FileItem> items = upload.parseRequest(request);
    LOG.info("上传数据...");
   for (FileItem item : items) {
    // File destFile = new File(path,item.getFieldName());
    // 非表单域
    if (!item.isFormField()) {
      LOG.info("上传路径  : " + path );
     FileOutputStream fos = new FileOutputStream(path
       + item.getName().substring(
         item.getName().lastIndexOf("\\"),
         item.getName().length()));
     // 文件全在内存中
     if (item.isInMemory()) {
      fos.write(item.get());
      p.setComplete(true);
     } else {
      InputStream is = item.getInputStream();
      byte[] buffer = new byte[1024];
      int len;
      while ((len = is.read(buffer)) > 0) {
       fos.write(buffer, 0, len);
      }
      is.close();
     }
     fos.close();
      LOG.info("完成上传文件!");
     item.delete();
      LOG.info("删除临时文件!");
     p.setComplete(true);
      LOG.info("更新progress对象状态为完成状态!");
    }
   }
  } catch (Exception e) {
    LOG.error("上传文件出现异常, 错误原因 : " + e.getMessage());
   // 发生错误,进度信息对象设置为完成状态
   p.setComplete(true);
   request.getSession().removeAttribute(key);
  }
 }
 
 public static void execClientScript(HttpServletResponse resposne,
   String script) throws IOException {
  PrintWriter out = resposne.getWriter();
  out.println("<script type='text/javascript'>" + script + "</script>");
  // fix ie problem
  out.println("------------------------------------------------------");
  out.println("------------------------------------------------------");
  out.println("------------------------------------------------------");
  out.println("------------------------------------------------------");
  out.println("------------------------------------------------------");
  out.flush();
 }
 
 public static class Progress implements ProgressListener {
  // 文件总长度
  private long length = 0;
  // 已上传的文件长度
  private long currentLength = 0;
  // 上传是否完成
  private boolean isComplete = false;
  
  @Override
  public void update(long bytesRead, long contentLength, int items) {
   this.currentLength = bytesRead;
  }

  public long getLength() {
   return length;
  }

  public long getCurrentLength() {
   return currentLength;
  }

  public boolean isComplete() {
   return isComplete;
  }

  public void setLength(long length) {
   this.length = length;
  }

  public void setCurrentLength(long currentLength) {
   this.currentLength = currentLength;
  }

  public void setComplete(boolean isComplete) {
   this.isComplete = isComplete;
  }
 }
}
