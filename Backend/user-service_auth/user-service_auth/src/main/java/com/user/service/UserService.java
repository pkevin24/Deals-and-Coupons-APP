package com.user.service;

import java.util.List;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;

public interface UserService {

	public User getUsers(Integer id) throws UserNotFoundException;
	public List<User> getAllUsers() throws UserNotFoundException;
	public User addUsers(User user);
	public User fetchUserByEmail(String email);
	public User fetchUserByUserName(String userName);
	//public void updateUser(User user,Integer id);
	public void deleteUser(Integer id);
	public void initRoleAndUser();
	public User putUser(User user);
}
