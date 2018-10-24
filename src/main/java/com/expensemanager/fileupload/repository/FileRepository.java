package com.expensemanager.fileupload.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanager.fileupload.models.FileDetails;

public interface FileRepository extends MongoRepository<FileDetails, String>  {

}
