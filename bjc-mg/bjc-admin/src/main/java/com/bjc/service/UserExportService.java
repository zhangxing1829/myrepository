package com.bjc.service;

import java.util.List;

import com.bjc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
	public interface UserExportService {

		
		    //导出的方法
		   List<User> selectUsers();
		   //导入的方法
		   boolean batchImport(String fileName, MultipartFile file) throws Exception;
		   
		}
