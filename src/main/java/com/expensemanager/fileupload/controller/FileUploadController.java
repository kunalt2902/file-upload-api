package com.expensemanager.fileupload.controller;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.expensemanager.fileupload.helper.ExpenseReportParser;
import com.expensemanager.fileupload.models.ExpenseReport;
import com.expensemanager.fileupload.models.User;
import com.expensemanager.fileupload.service.FileUploadService;



@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadService service;
	
	@RequestMapping("/status")
	public String getStatus() {
		return "OK";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/upload" )
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) throws FileUploadException {
		
		List<ExpenseReport> report = ExpenseReportParser.getExpenseReportFromFile(file,file.getOriginalFilename());
		if(report != null) {
			service.uploadFileDetails(file.getOriginalFilename(),startDate,endDate);
			service.uploadExpenseDetails(report);
			return ResponseEntity.ok("Upload Successful");
		}
		
		return ResponseEntity.ok("Error");
		
		
		
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		
		service.uploadUser(user);
		return ResponseEntity.ok("Upload Successful");
	}
}
