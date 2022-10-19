package com.user.controller;

import com.user.entity.Role;
import com.user.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/users")
@Api(tags="Roles") 
public class RoleController {
	
	@Autowired
	private RoleService serv;
	
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		return serv.createNewRole(role);
	}
}
