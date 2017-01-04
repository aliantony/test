package com.thunisoft.test;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Jdsqxx {
    
    public static void main(String[] args) throws Exception {
        XSSFRow row;
        String cell;
        String strPath = System.getProperty("user.dir");
        strPath += "\\WebRoot\\司法地图街道社区数据.xlsx";
        XSSFWorkbook xwb = new XSSFWorkbook(strPath);
        XSSFSheet sheet = xwb.getSheetAt(0);
        String outPath = "d:/data.sql";
        StringBuffer str = new StringBuffer("insert into dbo.JDHSQXX values (");
        OutputStream os = new BufferedOutputStream(null);
        for (int i = sheet.getFirstRowNum() + 1; i < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < 3; j++) {
                // 通过 row.getCell(j).toString() 获取单元格内容，
                if (row.getCell(j) == null) {
                    cell = "";
                }
                else {
                    cell = row.getCell(j).toString();
                }
                // System.out.print(cell + "\t");
                str.append("'" + cell.trim() + "'" + ",");
            }
            str.deleteCharAt(str.lastIndexOf(","));
            str.append(")");
            System.out.println(str.toString());
            str = new StringBuffer("insert into dbo.JDHSQXX values (");
            System.out.println("");
        }
        
    }
}
