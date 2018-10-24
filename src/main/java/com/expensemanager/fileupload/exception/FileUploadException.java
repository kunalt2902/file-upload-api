package com.expensemanager.fileupload.exception;

public class FileUploadException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileUploadException(String msg ,Throwable e) {
		super(msg,e);
	}
	
	public FileUploadException(String msg) {
		super(msg);
	}

}
