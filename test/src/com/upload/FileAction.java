package com.upload;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.upload.UploadFile;
import com.upload.UploadFile.Progress;

public class FileAction extends ActionSupport {
 
 private static final long serialVersionUID = 6649027352616232244L;
 private FileService fileService;
 
 public String preupload() {
  return SUCCESS;
 }
 
 public String uploadfile() {
  try {
   LOG.info("文件上传操作开始");
   HttpServletResponse response = ServletActionContext.getResponse();
   HttpServletRequest request = ServletActionContext.getRequest();
   UploadFile.upload(request, response);
  } catch (IOException e) {
   // LOG.error("上传文件发生异常,错误原因 : " + e.getMessage());
  }  
  return null;
 }
 
 
 public String progress() {
  System.out.println("begin");
  LOG.info("文件上传进度监测开始");
  HttpServletResponse response = ServletActionContext.getResponse();
  HttpServletRequest request = ServletActionContext.getRequest();
  String callback1 = request.getParameter("callback1");
  String callback2 = request.getParameter("callback2");
  // 缓存progress对象的key值
  String key = Integer.toString(request.hashCode());
  // 新建当前上传文件的进度信息对象
  Progress p = new Progress();
  // 缓存progress对象
  request.getSession().setAttribute(key, p);
  response.setContentType("text/html;charset=UTF-8");
  response.setHeader("pragma", "no-cache");
  response.setHeader("cache-control", "no-cache");
  response.setHeader("expires", "0");
  try {
   LOG.info("文件上传进度监测开始--------");
   UploadFile.execClientScript(response, callback1 + "(" + key + ")");
   long temp = 0l;
   while (!p.isComplete()) {
    if (temp != p.getCurrentLength()) {
     temp = p.getCurrentLength();
     // 向客户端显示进度
     UploadFile.execClientScript(response, callback2 + "("
       + p.getCurrentLength() + "," + p.getLength() + ")");
      //LOG.info("progress的状态 ：" + p.isComplete());
    } else {
      //LOG.info("progress的状态 ：" + p.isComplete());
      //LOG.info("progress上传的数据量 ：+ " + p.getCurrentLength());
     // 上传进度没有变化时候,不向客户端写数据,写数据过于频繁会让chrome没响应
    Thread.sleep(100);
    }
   }
  } catch (Exception e) {
    LOG.error("调用客户端脚本错误,原因 ：" + e.getMessage());
   p.setComplete(true);
  }
  try {
   UploadFile.execClientScript(response, callback2 + "("
     + p.getCurrentLength() + "," + p.getLength() + ")");
  } catch (Exception e) {
   p.setComplete(true);
  }
  request.getSession().removeAttribute(key);
   LOG.info("删除progress对象的session key");
  return null;
 }
 public FileService getFileService() {
  return fileService;
 }
 public void setFileService(FileService fileService) {
  this.fileService = fileService;
 }
}
