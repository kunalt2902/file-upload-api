package com.expensemanager.fileupload.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.tomcat.util.http.fileupload.FileUploadException;

import com.expensemanager.fileupload.constants.Constants;
import com.expensemanager.fileupload.models.ExpenseReport;

public class Validator {


	public static void validateRecord(ExpenseReport record , int count) throws FileUploadException {

		checkForBlanks(record,count);
		validateTransactionDate(record.getTransDate(),count);
		validateAmount(record.getAmount(),count);
	}

	private static void checkForBlanks(ExpenseReport record , int count) throws FileUploadException {
		
		if(record == null)
			throw new FileUploadException("Blank record present in the expense report. Please check record number : " + count);
		
		if(record.getTransDate() == null || record.getTransDate().trim().length() <= 0) {
			throw new FileUploadException("Blank transaction date present in the expense report. Please check record number : " + count);
		}
		
		if(record.getDescription() == null || record.getDescription().trim().length() <= 0) {
			throw new FileUploadException("Blank Description present in the expense report. Please check record number : " + count);
		}
		
		if(record.getAmount() == null || record.getAmount().trim().length() <= 0) {
			throw new FileUploadException("Blank amount present in the expense report. Please check record number : " + count);
		}
	}

	private static void validateTransactionDate(String date , int count) throws FileUploadException {
		try {
			new SimpleDateFormat(Constants.EXPENSE_REPORT_DATE_FORMAT).parse(date);
		} catch (ParseException e) {
			throw new FileUploadException("Invalid Date provided in the report at line: " + count,e);
		} 
	}

	private static void validateAmount(String recordAmount , int count) throws FileUploadException {
		
		String amount = recordAmount.contains("$") ? recordAmount.split("$")[1] : recordAmount;
		
		try {
			Double.parseDouble(amount);
		}catch(NumberFormatException e) {
			throw new FileUploadException("Invalid amount provided in the report at line: " + count,e);
		}

	}

}
