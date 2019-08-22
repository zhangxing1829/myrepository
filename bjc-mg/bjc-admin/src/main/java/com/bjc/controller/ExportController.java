package com.bjc.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjc.entity.User;
import com.bjc.service.UserExportService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExportController {
	@Autowired
   private UserExportService userService;
	
	@RequestMapping("/{page}")
	public String sendSimpleMail(@PathVariable String page) {
			return page;
	}
	
@RequestMapping("/dataExport")
public String showUser(Model model) {
	List<User> users = userService.selectUsers();
	model.addAttribute("users", users);
	return "dataExport"; 
	}

//  导出
@RequestMapping(value = "/export") 
@ResponseBody
   public void export(HttpServletResponse response) throws IOException { 
	List<User> users = userService.selectUsers();
	System.out.println(users);
	//List<Apply> applys = userService.selectUsers(); 
	HSSFWorkbook wb = new HSSFWorkbook(); 
	HSSFSheet sheet = wb.createSheet("获取excel测试表格");
	HSSFRow row = null; 
	row = sheet.createRow(0);//创建第一个单元格
      row.setHeight((short) (26.25 * 20)); 
      row.createCell(0).setCellValue("用户信息列表");//为第一行单元格设值
      
    //CellRangeAddress(0, 0, 0, 2):起始行号，终止行号， 起始列号，终止列号
      CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
      sheet.addMergedRegion(rowRegion); 
    
      row = sheet.createRow(1); row.setHeight((short) (22.50 * 20));//设置行高
      //row.createCell(0).setCellValue("用户编号");//为第一个单元格设值
	row.createCell(0).setCellValue("id");//为第一个单元格设值
	row.createCell(1).setCellValue("用户名");
	row.createCell(2).setCellValue("email");
	row.createCell(3).setCellValue("密码");
	row.createCell(4).setCellValue("用户工号");
	row.createCell(5).setCellValue("状态");

      for (int i = 0; i < users.size(); i++) {
    	  row = sheet.createRow(i + 2); 
    	  User user = users.get(i); 

    	  row.createCell(0).setCellValue(user.getuId());
    	  row.createCell(1).setCellValue(user.getUsername()); 
    	  row.createCell(2).setCellValue(user.getEmail());
		  row.createCell(3).setCellValue(user.getPassword());
		  row.createCell(4).setCellValue(user.getNumber());
		 row.createCell(5).setCellValue(user.getStatus());
    	  }
      sheet.setDefaultRowHeight((short) (16.5 * 20)); //列宽自适应
      for (int i = 0; i <= 4; i++) { 
    	  sheet.autoSizeColumn(i); 
    	  } 
      //获取类型
      response.setContentType("application/vnd.ms-excel;charset=utf-8");
      OutputStream os = response.getOutputStream(); 
    //默认Excel名称
      response.setHeader("Content-disposition", "attachment;filename=user.xls");
      wb.write(os); 
      os.flush(); 
      os.close(); 
      } 

//  导入
@RequestMapping(value = "/import")
public String exImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session) { 
	boolean a = false; 
	String fileName = file.getOriginalFilename(); 
	
	System.out.println("fileName"+fileName);
	System.out.println("file"+file);
	try { a = userService.batchImport(fileName, file); 
	} catch (Exception e) { 
		e.printStackTrace();
		} 
	return "redirect:dataExport"; 
	} 
} 
