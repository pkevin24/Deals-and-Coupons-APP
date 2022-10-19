package com.user.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.Coupons;
import com.user.entity.Deals;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;
import com.user.service.JwtService;
import com.user.service.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc(addFilters=false)
@SpringBootTest
class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService serv;
	
	@MockBean
	private UserRepository repo;
	
	@MockBean
	private RoleRepository repoRole;
	
	@MockBean
	private JwtService servJwt;
	
//	@Autowired 
//	private WebApplicationContext webApplicationContext;
//	
//	@Autowired
//	private Filter springSecurityFilterChain;
//	
//	@BeforeAll
//	public void setUp() throws Exception {
//	    mvc = MockMvcBuilders
//	            .webAppContextSetup(webApplicationContext)
//	            .addFilters(springSecurityFilterChain)
//	            .build();
//	}
	
	@Test
	@WithMockUser(roles= {"Admin"})
	public void getAllUsersTest() throws UserNotFoundException,Exception {
		List<User> users=new ArrayList<>();
		Set<Role> roles1=new HashSet<>();
		roles1.add(new Role("Admin","Admin role"));
		List<Deals> deals=new ArrayList<>();
		List<Coupons> coupons=new ArrayList<>();
		users.add(new User(100,"SS","SS",9999L,"SS","Suu",0,roles1,deals,coupons));//401
		users.add(new User(109,"SSS","SSS",999999L,"SSS","SSuu",100,roles1,deals,coupons));
		when(serv.getAllUsers()).thenReturn(users);
		String url="/users/details";
		mvc.perform(get(url)).andExpect(status().isOk());
		
	}
	
//	@Test
//	//@WithMockUser(roles= {"Admin"})
//	public void registerUsersTest() throws Exception {
//		Set<Role> roles=new HashSet<>();
//		roles.add(new Role("Admin","Admin role"));
//		User user=new User(100,"SS","SS",9999L,"SS","Suu",0,roles);
//		//ResponseEntity<User> u1=ResponseEntity.accepted().body(user);
//		when(serv.addUsers(user)).thenReturn(user);
//		String url="/users/registerNewUser";
//		mvc.perform(post(url)).//content(MediaType.JSON_UTF_8);
//		andExpect(status().isOk());
//	}
	
	@Test
	public void registerUserTest() throws Exception {
		Set<Role> roles1=new HashSet<>();
		roles1.add(new Role("User","User role"));
		List<Deals> deals=new ArrayList<>();
		List<Coupons> coupons=new ArrayList<>();
		User user=new User(100,"SS","SS",9999L,"SS@gm.com","Suu",0,roles1,deals,coupons);
//		when(serv.fetchUserByEmail(user.getEmail())).thenReturn(null);
//		when(serv.fetchUserByUserName(user.getUserName())).thenReturn(null);
		when(serv.addUsers(user)).thenReturn(user);
		ObjectMapper objmapper=new ObjectMapper();
		String jsonbody=objmapper.writeValueAsString(user);
		System.out.println(jsonbody);
		String url="/users/registerNewUser";
		
		mvc.perform(post(url)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
//		verify(serv, times(1)).addUsers(user);
		System.out.println(user);
	}
			
	
	@Test
	@WithMockUser(roles= {"Admin"})
	public void forAdminTest() throws Exception {
		String url="/users/forAdmin";
		mvc.perform(get(url)).andExpect(status().isOk());
								//.andExpect(content().string("This is user"));
	}
	
	@Test
	@WithMockUser(roles= {"User"})
	public void forUserTest() throws Exception {
		String url="/users/forUser";
		mvc.perform(get(url)).andExpect(status().isOk());
								//.andExpect(content().string("This is user"));
	}
	
	@Test
	@WithMockUser(roles= {"Admin"})
	public void getUsersTest() throws UserNotFoundException,Exception  {
		Set<Role> roles1=new HashSet<>();
		roles1.add(new Role("Admin","Admin role"));
		List<Deals> deals=new ArrayList<>();
		List<Coupons> coupons=new ArrayList<>();
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0,roles1,deals,coupons);
		when(serv.getUsers(user.getId())).thenReturn(user);
		String url="/users/details/"+user.getId();
		mvc.perform(get(url)).andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles= {"Admin"})
	public void deleteTest() throws UserNotFoundException,Exception {
		Set<Role> roles1=new HashSet<>();
		roles1.add(new Role("Admin","Admin role"));
		List<Deals> deals=new ArrayList<>();
		List<Coupons> coupons=new ArrayList<>();
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0,roles1,deals,coupons);
		when(serv.getUsers(user.getId())).thenReturn(user);
		String url="/users/details/"+user.getId();
		//assertEquals(url,"/users/details/100");
		mvc.perform(delete(url)).andExpect(status().isOk());
		//.with(csrf());//content().string("User is deleted successfully"));	
	}
	
	@Test
	//@WithMockUser(roles= {"Admin"})
	public void updateTest() throws Exception {
		Set<Role> roles1=new HashSet<>();
		roles1.add(new Role("Admin","Admin role"));
		List<Deals> deals=new ArrayList<>();
		List<Coupons> coupons=new ArrayList<>();
		User user=new User(100,"SS","SS",9999L,"SS@gma.com","Suu",0,roles1,deals,coupons);
		when(serv.getUsers(user.getId())).thenReturn(user);
		when(serv.addUsers(user)).thenReturn(user);
		ObjectMapper objmapper=new ObjectMapper();
		String jsonbody=objmapper.writeValueAsString(user);
		String url="/users/details/"+user.getId();
		mvc.perform(put(url)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
