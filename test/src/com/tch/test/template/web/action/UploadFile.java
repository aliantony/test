package com.tch.test.template.web.action;

import java.io.File;   
import org.apache.commons.io.FileUtils;   
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;   
import java.io.IOException;   
import com.opensymphony.xwork2.ActionSupport;   
@Component("uploadFileAction")
@Scope("prototype")   
public class UploadFile extends ActionSupport {   
    private static final long serialVersionUID = 1L;   
    private File myFile;   
    private String myFileContentType;   
    private String myFileFileName;   
    private String destPath;   
    private String myfield;   
    public void uploadFile() {   
        /* Copy file to a safe location */  
        destPath = "e:/";   
        try {   
            System.out.println("Src File name: " + myFile);   
            System.out.println("Dst File name: " + myFileFileName);   
            System.out.println("myfield : "+myfield);   
            File destFile = new File(destPath+myFileFileName);   
            FileUtils.copyFile(myFile, destFile);   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
    public File getMyFile() {   
        return myFile;   
    }   
    public void setMyFile(File myFile) {   
        this.myFile = myFile;   
    }   
    public String getMyFileContentType() {   
        return myFileContentType;   
    }   
    public void setMyFileContentType(String myFileContentType) {   
        this.myFileContentType = myFileContentType;   
    }   
    public String getMyFileFileName() {   
        return myFileFileName;   
    }   
    public void setMyFileFileName(String myFileFileName) {   
        this.myFileFileName = myFileFileName;   
    }   
    public String getMyfield() {   
        return myfield;   
    }   
    public void setMyfield(String myfield) {   
        this.myfield = myfield;   
    }   
}  

