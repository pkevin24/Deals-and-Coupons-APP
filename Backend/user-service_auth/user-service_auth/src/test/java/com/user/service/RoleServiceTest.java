package com.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.user.entity.Role;
import com.user.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RoleServiceTest {

	@Autowired 
	private RoleService serv;
	
	@MockBean
	private RoleRepository repo;
	
	@Test
	void createNewRoleTest() {
		Role role=new Role("Default","Default role");
		when(repo.save(role)).thenReturn(role);
		assertEquals(role, serv.createNewRole(role));
	}
	
}
