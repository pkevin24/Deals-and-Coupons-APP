package com.user.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.Role;
import com.user.service.JwtService;
import com.user.service.RoleService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc(addFilters = false)//403
@WebMvcTest(RoleController.class)
class RoleControllerTest {
	
	@MockBean
	private RoleService serv;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private JwtService servJwt;
	
	@Test
	public void createNewRoleTest() throws Exception {
		Role role=new Role("Test","Test role");
		when(serv.createNewRole(role)).thenReturn(role);
		ObjectMapper objmapper=new ObjectMapper();
		String jsonbody=objmapper.writeValueAsString(role);
		mvc.perform(post("/createNewRole")//404
		.content(jsonbody)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
