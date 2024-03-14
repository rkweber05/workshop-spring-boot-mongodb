package com.rkweber.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rkweber.workshopmongo.domain.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

	
}
