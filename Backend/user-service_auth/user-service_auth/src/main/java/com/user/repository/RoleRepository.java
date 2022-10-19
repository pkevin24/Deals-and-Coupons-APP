package com.user.repository;

import com.user.entity.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String>{
	
}
