package com.user.service;

import com.user.entity.Role;
import com.user.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	public Role createNewRole(Role role) {
		return repo.save(role);
	}
}
