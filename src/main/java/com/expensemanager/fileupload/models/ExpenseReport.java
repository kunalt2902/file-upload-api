package com.expensemanager.fileupload.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.apache.tomcat.util.http.fileupload.FileUploadException;

import lombok.Data;

import org.springframework.data.annotation.Id;
public class ExpenseReport {
	@Id
	private UUID recordID;
	private UUID reportID;
	private String transDate;
	private String description;
	private String amount;
	List<User> users = new ArrayList<User>();
	
	public UUID getRecordID() {
		return recordID;
	}
	public void setRecordID(UUID recordID) {
		this.recordID = recordID;
	}
	
	public UUID getReportID() {
		return reportID;
	}
	public void setReportID(UUID reportID) {
		this.reportID = reportID;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) throws FileUploadException {
		if(transDate == null)
			throw new FileUploadException("Transaction Date Cannot be null");
		this.transDate = transDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) throws FileUploadException {
		if(transDate == null)
			throw new FileUploadException("Transaction Date Cannot be null");
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) throws FileUploadException {
		if(transDate == null)
			throw new FileUploadException("Amount Date Cannot be null");
		this.amount = amount;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	

}
