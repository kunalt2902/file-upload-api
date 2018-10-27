package com.expensemanager.fileupload.models;

import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class FileDetails {
	@Id
	private ObjectId reportID;
	private String name;
	private String startDate;
	private String endDate;
	private String uploadTime;
	private String status;

	public FileDetails() {

	}

	public FileDetails(ObjectId reportID, String name, String startDate, String endDate, String uploadTime, String status) {
		super();
		this.reportID = reportID;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.uploadTime = uploadTime;
		this.status = status;
	}

	

	public ObjectId getReportID() {
		return reportID;
	}

	public void setReportID(ObjectId reportID) {
		this.reportID = reportID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FileDetails [reportID=" + reportID + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", uploadTime=" + uploadTime + ", status=" + status + "]";
	}

}
