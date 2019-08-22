package com.bjc.Utils;

import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
@Component
public class ExcelImportUtils {
    
    
    // @描述：是否是2003的excel，返回true是2003 
    public static boolean isExcel2003(String filePath)  {  
        return filePath.matches("^.+\\.(?i)(xls)$");  
    }  
   
    //@描述：是否是2007的excel，返回true是2007 
    public static boolean isExcel2007(String filePath)  {  
        return filePath.matches("^.+\\.(?i)(xlsx)$");  
    }  
    
  /**
   * 验证EXCEL文件
   * @param filePath
   * @return
   */
  public static boolean validateExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){  
            return false;  
        }  
        return true;
  }
    
 /**
  * 每一行数据判断为空
  * @param LinkedHashMap
  * */
  public Object isNullorEmpty(Row row,int i,Object param){
	  if (row.getCell(i) == null ) {
			System.out.println("第"+i+"列值为空");
		}else {
			row.getCell(i).setCellType(CellType.STRING);				
			param= String.valueOf(row.getCell(i).getStringCellValue());			
		}  
	  return param;
  }

}
