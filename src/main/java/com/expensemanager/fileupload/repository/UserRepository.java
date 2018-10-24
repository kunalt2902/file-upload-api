package com.expensemanager.fileupload.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanager.fileupload.models.User;

public interface UserRepository extends MongoRepository<User, String>  {

}
