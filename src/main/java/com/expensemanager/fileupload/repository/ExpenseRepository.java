package com.expensemanager.fileupload.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanager.fileupload.models.ExpenseReport;


public interface ExpenseRepository extends MongoRepository<ExpenseReport, UUID> {

}
