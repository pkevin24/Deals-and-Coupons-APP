package com.user.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import com.user.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleRepositoryTest {
	
	@Autowired
	private RoleRepository repo;
	
	@Test
	public void saveTest() {
		repo.save(new Role("Default","Default role"));
		assertNotNull(repo.findById("Default"));
	}

	@Test
	public void findAllTest() {
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("Default","Default role"));
		roles.add(new Role("Default1","Default1 role"));
		repo.saveAll(roles);
		assertNotNull(repo.findAll());
	}

	@Test
	public void findByIdTest() {
		Role role = new Role("Default","Default role");
		repo.save(role);
		assertNotNull(repo.findById("Default"));
	}

	@Test
	public void deleteByIdTest() {
		Role role=new Role("Default","Default role");
		repo.save(role);
		repo.deleteById("Default");
		assertNotNull(repo.findAll());
	}
}
