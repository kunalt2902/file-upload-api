package com.expensemanager.fileupload.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
		
		
		UUID reportID = UUID.randomUUID();
		service.uploadExpenseDetails(file,reportID);
		service.uploadFileDetails(file.getOriginalFilename(),reportID,startDate,endDate);
		
		return ResponseEntity.ok("Upload Successful");
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		
		service.uploadUser(user);
		return ResponseEntity.ok("Upload Successful");
	}
}
