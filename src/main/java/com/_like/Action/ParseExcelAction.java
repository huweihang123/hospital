package com._like.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

/**
 * 用户上传excel文件到服务端, 解析excel文件
 *
 * @author like
 *
 */
public class ParseExcelAction extends ActionSupport {

    @Getter@Setter
    private File excel;// 必须与表单中的name属性一致
    @Setter@Getter
    private String excelContentType;
    @Getter@Setter
    private String excelFileName;// 必须是name属性+FileName

    @Setter@Getter
    private String Checkcode;


    public String execute() throws IOException {

        // 将客户端的文件上传到服务端
        String desPath = ServletActionContext.getServletContext().getRealPath("excelFile");
        File destFile = new File(desPath, excelFileName);
        FileUtils.copyFile(excel, destFile);
        String form = ServletActionContext.getRequest().getParameter("form");
        String[] time = new String[12];
        time[0]=("一");
        time[1]=("二");
        time[2]=("三");
        time[3]=("四");
        time[4]=("五");
        time[5]=("六");
        time[6]=("七");
        time[7]=("八");
        time[8]=("九");
        time[9]=("十");
        time[10]=("十一");
        time[11]=("十二");
        // 解析excel
        // 得到一个excel文件
        Workbook book;
        String excel = excelFileName.toString();
        if (excel.contains(".xlsx")) {
            book = new XSSFWorkbook(new FileInputStream(destFile));
            XSSFSheet sheet = (XSSFSheet) book.getSheetAt(0);
            String[] information = new String[sheet.getLastRowNum() + 1];
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                information[i] = "";
                if(sheet.getRow(0) != null & sheet.getRow(0).getLastCellNum() == 10){
                    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                        if (row != null) {
                            if(i > 0&&(j == 6 || j == 7)){
                                double dome = row.getCell(j).getNumericCellValue();
                                 Date date =   DateUtil.getJavaDate(dome);
                                 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                                 String result =  f.format(date);
                                 //  特定格式的日期
                                 information[i] += "!" + result;
                            }else {
                                XSSFCell cell = row.getCell(j);
                                if (!Objects.equals(cell, null)) {
                                    information[i] += "!" + cell.toString();
                                } else {
                                    information[i] += "!" + "null";
                                }
                            }
                        }
                    }
                }else if(sheet.getRow(0) != null & sheet.getRow(0).getLastCellNum() == 7){
                    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                        if (row != null) {
                            XSSFCell cell = row.getCell(j);
                            if (!Objects.equals(cell, null)) {
                                information[i] += "!" + cell.toString();
                            } else {
                                information[i] += "!" + "null";
                            }
                        }
                    }
                }else{
                    if (Objects.equals(form, "inform")) {
                            return "Informnull";
                    } else {
                            return "Outformnull";
                    }
                    }
                }
            ActionContext.getContext().put("information", information);
            if (Objects.equals(form,"inform")) {
                return "inform";
            } else {
                return "outform";
            }
        } else {
            book = new HSSFWorkbook(new FileInputStream(destFile));
            HSSFSheet sheet = (HSSFSheet) book.getSheetAt(0);
            String[] information = new String[sheet.getLastRowNum() + 1];
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);
                information[i] = "";
                if(sheet.getRow(0) != null & sheet.getRow(0).getLastCellNum() == 10){
                    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                        if (row != null) {
                            if (i > 0 && (j == 6 || j == 7)) {
                                double dome = row.getCell(j).getNumericCellValue();
                                Date date = DateUtil.getJavaDate(dome);
                                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                                String result = f.format(date);
                                //  特定格式的日期
                                information[i] += "!" + result;
                            } else {
                                HSSFCell cell = row.getCell(j);
                                if (!Objects.equals(cell, null)) {
                                    information[i] += "!" + cell.toString();
                                } else {
                                    information[i] += "!" + "null";
                                }
                            }
                        }
                    }
                }else if(sheet.getRow(0) != null & sheet.getRow(0).getLastCellNum() == 7) {
                    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                        if (row != null) {
                            HSSFCell cell = row.getCell(j);
                            if (!Objects.equals(cell, null)) {
                                information[i] += "!" + cell.toString();
                            } else {
                                information[i] += "!" + "null";
                            }
                        }
                    }
                }else{
                    if (Objects.equals(form, "inform")) {
                        return "Informnull";
                    } else {
                        return "Outformnull";
                    }
                }
            }
            ActionContext.getContext().put("information", information);
            if (Objects.equals(form,"inform")) {
                return "inform";
            } else {
                return "outform";
            }
        }
    }
}