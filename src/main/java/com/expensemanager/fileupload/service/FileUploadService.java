package com.expensemanager.fileupload.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensemanager.fileupload.constants.Constants;
import com.expensemanager.fileupload.models.ExpenseReport;
import com.expensemanager.fileupload.models.FileDetails;
import com.expensemanager.fileupload.models.User;
import com.expensemanager.fileupload.repository.ExpenseRepository;
import com.expensemanager.fileupload.repository.FileRepository;
import com.expensemanager.fileupload.repository.UserRepository;

@Service
public class FileUploadService {
	private Logger log = LoggerFactory.getLogger(FileUploadService.class);

	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private UserRepository userRepository;

	public void uploadExpenseDetails(List<ExpenseReport> report) throws FileUploadException {

		if (report != null) {
			log.info("Saving expense details to the database");
			report.forEach(record -> expenseRepository.save(record));
		}

	}

	public void uploadFileDetails(String name, String startDate, String endDate) {

		FileDetails file = new FileDetails(name, name, startDate, endDate,
				DateTimeFormatter.ofPattern(Constants.UPLOAD_DATE_TIME_FORMAT).format(LocalDateTime.now()),
				Constants.INITIAL_STATUS);
		log.info("Saving file details to the database");
		fileRepository.insert(file);

	}

	public void uploadUser(User user) {
		userRepository.insert(user);
	}

}
