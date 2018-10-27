package com.expensemanager.fileupload.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ExpenseReport {
	@Id
	private ObjectId recordID;
	private String reportID;
	private String transDate;
	private String description;
	private String amount;
	List<String> userIds = new ArrayList<String>();

	public ObjectId getRecordID() {
		return recordID;
	}

	public void setRecordID(ObjectId recordID) {
		this.recordID = recordID;
	}

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) throws FileUploadException {
		if (transDate == null)
			throw new FileUploadException("Transaction Date Cannot be null");
		this.transDate = transDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws FileUploadException {
		if (transDate == null)
			throw new FileUploadException("Transaction Date Cannot be null");
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) throws FileUploadException {
		if (transDate == null)
			throw new FileUploadException("Amount Date Cannot be null");
		this.amount = amount;
	}

}
