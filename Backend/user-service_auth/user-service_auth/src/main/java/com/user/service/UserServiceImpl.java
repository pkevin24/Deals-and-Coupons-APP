package com.user.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.user.entity.Coupons;
import com.user.entity.Deals;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//	List<User> users=new ArrayList<>();
//	List <User> users=List.of(
//			new User(101,"Surya S","Surya101",9734567,"surya@gmail.com","SuryaS"),
//			new User(103,"Roopa V","Roopa144",9735422,"roopa@gmail.com","Roopa"),
//			new User(105,"Suresh G","Suresh345",9732343,"suresh@gmail.com","Suresh")
//	);

	@Autowired
	private UserRepository repo;

	@Autowired
	private RoleRepository repo1;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUsers(Integer id) throws UserNotFoundException {
		// return this.users.stream().filter(user ->
		// user.getId().equals(id)).findAny().orElse(null);
		Optional<User> user = repo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found");

		}
		return user.get();
		// return repo.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		// return this.users;
		// return repo.findAll();
		List<User> users = repo.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("No users are present");
		}
		return users;
	}

	@Override
	public User addUsers(User user) {
		// this.users.add(user);
		Role role = repo1.findById("User").get();

		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);

		List<Deals> deals = new ArrayList<>();
		List<Coupons> coupons = new ArrayList<>();

//		Random random = new Random();
//		user.setId(random.nextInt(50)*random.nextInt(45));
//		
		user.setCoupons(coupons);
		user.setDeals(deals);
		user.setPassword(getEncodedPassword(user.getPassword()));
		user.setPoints(0);
		return repo.save(user);
	}
	
	@Override
	public User putUser(User user) {
		return repo.save(user);
	}

	@Override
	public User fetchUserByEmail(String email) {
//		List<User> users=this.getAllUsers();
//		return this.users.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
		return repo.findByEmail(email);
	}

	@Override
	public User fetchUserByUserName(String userName) {
		// return this.users.stream().filter(user ->
		// user.getUserName().equals(userName)).findAny().orElse(null);
		return repo.findByUserName(userName);
	}

//	@Override
//	public void updateUser(User user, Integer id) {
//		// TODO Auto-generated method stub
//		User tempUser=this.getUsers(id);
//		tempUser.setEmail(user.getEmail());
//		tempUser.setName(user.getName());
//		tempUser.setIsAdmin(user.getIsAdmin());
//		tempUser.setPassword(user.getPassword());
//		tempUser.setPhoneNumber(user.getPhoneNumber());
//		tempUser.setUserName(user.getUserName());
//	}

	@Override
	public void deleteUser(Integer id) {
//		User tempUser = this.getUsers(id);
//		users.remove(tempUser);
		repo.deleteById(id);
	}

	@Override
	public void initRoleAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		repo1.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role");
		repo1.save(userRole);
		List<Deals> deals = new ArrayList<>();
		List<Coupons> coupons = new ArrayList<>();
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		User adminUser = new User(0, "admin", "admin", 974747744L, "sssss@sss.com", getEncodedPassword("admin"), 0,
				adminRoles, deals, coupons);
		repo.save(adminUser);

//		System.out.println("User entity: "+repo1.findAll());
//		System.out.println("Role entity: "+repo1.findAll());
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
