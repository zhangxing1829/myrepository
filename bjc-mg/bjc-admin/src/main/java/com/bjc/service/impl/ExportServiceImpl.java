package com.bjc.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.bjc.Utils.ExcelImportUtils;
import com.bjc.Utils.MyException;
import com.bjc.entity.User;
import com.bjc.mapper.UserMapper;
import com.bjc.service.UserExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;



@Service
public class ExportServiceImpl implements UserExportService {
   @Autowired
	private ExcelImportUtils excelImportUtils;
	@Autowired
   private UserMapper userMapper;
	@Override
   public List<User> selectUsers() {
	   return userMapper.selectUsers();	   
   } 
	//导入	
   @Transactional(readOnly = false,rollbackFor = Exception.class) 
   @Override
   public boolean batchImport(String fileName, MultipartFile file) throws Exception {
	   boolean notNull = false; 
	   List<User> userList = new ArrayList<User>();
	   if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
		   throw new MyException("上传文件格式不正确");
		   } 
	   boolean isExcel2003 = true;
	   if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
		   isExcel2003 = false;
		   } 
	   InputStream is = file.getInputStream(); 
	   Workbook wb = null; 
	   if (isExcel2003) { 
		   wb = new HSSFWorkbook(is); 
		   } else {
			   wb = new XSSFWorkbook(is); 
			   } 
	   Sheet sheet = wb.getSheetAt(0);
	   if(sheet!=null){ notNull = true; 
	   } 
	   User user; 
	   for (int r = 2; r <= sheet.getLastRowNum(); r++) {
	   /**
	    * r =0 表示从第1行开始循环 如果你的第1行开始是表的标题
	    * r=1表的第二行是字段说明
	    * r=2表的第三行是数据
	   */
         Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
         if (row == null){ 
        	 continue; 
         } 
        
          user = new User();
         Integer uId=0;
          String number = "";
          String username = "";
          String email = "";
          String password="12121";
         Integer status = 0;
		   username = (String) excelImportUtils.isNullorEmpty(row, 1, username);
		   email = (String) excelImportUtils.isNullorEmpty(row, 2, email);
		   password=(String) excelImportUtils.isNullorEmpty(row,3,password);
    	  number = (String) excelImportUtils.isNullorEmpty(row, 4, number);

    	   //status =  (Integer) excelImportUtils.isNullorEmpty(row, 4, status);
    	user.setNumber(number);
         user.setUsername(username);
         user.setEmail(email);
         user.setPassword(password);
        // user.setStatus(status);
         //将表格中的数据存入userList中       
         userList.add(user); 
         } 
	   //插入user表中数据
	   for (User userResord : userList) { 
			   userMapper.addUser(userResord);
		   }
	   return notNull;
	}
  } 
