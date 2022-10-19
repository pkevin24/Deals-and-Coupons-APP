package com.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService serv;
	
	
	@MockBean
	private UserRepository repo;
	
//	@MockBean
//	private RoleRepository repoRole;
	
	@Test
	public void getAllUsersTest() throws UserNotFoundException {
		when(repo.findAll()).thenReturn(Stream.of(new User(144,"SS","SS",9999L,"SS","Suu",0),new User(244,"RR","RR",8888L,"RR","Rsss",0)).collect(Collectors.toList()));
		assertEquals(2, serv.getAllUsers().size());
	}
	
	@Test
	public void getUsersTest() throws UserNotFoundException {
		Integer id=100;
		Optional<User> user=Optional.of(new User(100,"SS","SS",9999L,"SS","Suu",0));
		when(repo.findById(id)).thenReturn(user);
		assertEquals(user, Optional.of(serv.getUsers(id)));
	}
	
	@Test
	public void addUsersTest() {
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0);
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, serv.addUsers(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0);
		serv.deleteUser(user.getId());
		verify(repo,times(1)).deleteById(user.getId());
	}
	
	@Test
	public void fetchUserByEmailTest() {
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0);
		when(repo.findByEmail(user.getEmail())).thenReturn(user);
		assertEquals(user,serv.fetchUserByEmail(user.getEmail()) );
	}
	
	@Test
	public void fetchUserByUserNameTest() {
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0);
		when(repo.findByUserName(user.getUserName())).thenReturn(user);
		assertEquals(user,serv.fetchUserByUserName(user.getUserName()));
	}
	
	@Test
	public void putUserTest() {
		User user=new User(100,"SS","SS",9999L,"SS","Suu",0);
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, serv.putUser(user));
	}
	
//	@AfterTestClass
//	public void createNewRoleTest() {
//		Role role=new Role("User","Default role");
//		when(repoRole.save(role)).thenReturn(role);
//		assertEquals(role, servRole.createNewRole(role));
//	}

}
