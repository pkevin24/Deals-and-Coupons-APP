package com.user.repository;

import com.user.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer>{

	User findByEmail(String email);

	User findByUserName(String userName);

}
