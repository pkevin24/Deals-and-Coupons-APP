package com.user.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.user.entity.JwtRequest;
import com.user.entity.User;
import com.user.exception.PasswordNotMatchingException;
import com.user.exception.UserNameEmailDuplicateException;
import com.user.exception.UserNotFoundException;
import com.user.service.SequenceGeneratorService;
import com.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
@Api(tags="Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private SequenceGeneratorService serv;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRoleAndUser();
	}
	
	
	@GetMapping("/details/{id}")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User>/*User*/ getUsers(@PathVariable("id") Integer id) throws UserNotFoundException {
		return ResponseEntity.ok(userService.getUsers(id));
		//return userService.getUsers(id);
		
		
	//@GetMapping("/{id}")
	//public ResponseEntity<User> getUsers(@PathVariable("id") Integer id) throws UserNotFoundException {
//		User tempUser=userService.getUsers(id);
//		if(tempUser==null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		//return new ResponseEntity<User>(HttpStatus.OK);
//		return ResponseEntity.ok(tempUser);
//		try {
//			User user=userService.getUsers(id);
//			return new ResponseEntity<User>(user,HttpStatus.OK);
//		} 
//		catch (NoSuchElementException e) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
		
	}
	
//	@GetMapping("/details")
//	public List<User> getAllUsers() throws UserNotFoundException{
//		return this.userService.getAllUsers();
//	}
	// @GetMapping("/details")
	// public List<User> getAllUsers() throws UserNotFoundException{
	// 	return this.userService.getAllUsers();
	// }
	
//	@PostMapping("/details")
//	public ResponseEntity<User> addUsers(@RequestBody User user) {
//		Integer tempId=user.getId();
//		if(userService.getUsers(tempId)==null) {
//			userService.addUsers(user);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
	
	@PostMapping("/registerNewUser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserNameEmailDuplicateException{
//	@PostMapping("/register")
//	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserNameEmailDuplicateException {
		String tempEmail=user.getEmail();
		String tempUserName=user.getUserName();
		//Integer tempId=user.getId();
		User userObject=null;
		User userObject1=null;
		if(tempEmail!=null && !"".equals(tempEmail) && tempUserName!=null && !"".equals(tempUserName)) {
			userObject=this.userService.fetchUserByEmail(tempEmail);
			userObject1=this.userService.fetchUserByUserName(tempUserName);
			if(userObject!=null) {
				throw new UserNameEmailDuplicateException(" User with "+tempEmail+" exist ");
			}
			if(userObject1!=null) {
				throw new UserNameEmailDuplicateException(" User with "+tempUserName+" exist ");
			}
		}
		user.setId(serv.getSequenceNumber(User.SEQUENCE_NAME));
		userService.addUsers(user);
		return ResponseEntity.accepted().body(user);
		//return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@PostMapping("/user/login")
	public String validateUser(@RequestBody JwtRequest user) throws UserNotFoundException,PasswordNotMatchingException{
		String tempUserName=user.getUserName();
		String tempPassword=user.getPassword();
		User userObject=this.userService.fetchUserByUserName(tempUserName);
		if(userObject==null) {
			throw new UserNotFoundException(" User with "+tempUserName+" does not exist ");
		}
		if(!userObject.getPassword().equals(tempPassword)) {
			throw new PasswordNotMatchingException("Password does not match");
		}
		else {
			return "User login successful";
		}
	}
//	@PostMapping("/login")
//	public String validateUser(@RequestBody UserLogin user) throws UserNotFoundException,PasswordNotMatchingException{
//		String tempUserName=user.getUserName();
//		String tempPassword=user.getPassword();
//		User userObject=this.userService.fetchUserByUserName(tempUserName);
//		if(userObject==null) {
//			throw new UserNotFoundException(" User with "+tempUserName+" does not exist ");
//		}
//		if(!userObject.getPassword().equals(tempPassword)) {
//			throw new PasswordNotMatchingException("Password does not match");
//		}
//		else {
//			return "User login successful";
//		}
//	}
	
//	@PostMapping("/admin/login")
//	public String validateAdmin(@RequestBody JwtRequest user) throws UserNotFoundException,PasswordNotMatchingException,AdminAuthenticationException{
//		String tempUserName=user.getUserName();
//		String tempPassword=user.getPassword();
//		User userObject=this.userService.fetchUserByUserName(tempUserName);
//		if(userObject==null) {
//			throw new UserNotFoundException(" User with "+tempUserName+" does not exist ");
//		}
//		if(userObject.getIsAdmin()==0) {
//			throw new AdminAuthenticationException("You are not an admin");
//		}
//		if(!userObject.getPassword().equals(tempPassword)) {
//			throw new PasswordNotMatchingException("Password does not match");
//		}
//		else {
//			return "Admin login successful";
//		}
//	}
	
	@PutMapping("/details/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody User user, @PathVariable("id") Integer id) throws UserNotFoundException{
//		try{
//			userService.updateUser(user, id);
//			return "User information updated successfully";
//		}
//		catch(Exception e) {
//			return "User id not found";
//		}
//		try {
//			User existUser=userService.getUsers(id);
//			userService.addUsers(user);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} 
//		catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		User existUser=userService.getUsers(id);
		userService.putUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/details/{id}")
	@PreAuthorize("hasRole('Admin')")
	public /*String*/ResponseEntity<?> delete(@PathVariable("id") Integer id) throws UserNotFoundException {
//@DeleteMapping("/{id}")
//	public String delete(@PathVariable("id") Integer id) throws UserNotFoundException {
		User tempUser=userService.getUsers(id);
		if(tempUser!=null) {
			userService.deleteUser(id);
			/*return "User deleted successfully";*/
			return new ResponseEntity<>(HttpStatus.OK);
		}
		/*return "User id not found";*/
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This is admin";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This is user";
	}
	
	@GetMapping({"/details"})
	@PreAuthorize("hasRole('Admin')")
	public List<User> getAllUsers() throws UserNotFoundException {
		return this.userService.getAllUsers();
	}
	
//	@RabbitListener(queues = MQConfig.QUEUE)
//	public void updateCoupons(Coupons couponsReceived) {
//		
//	}
	
}
