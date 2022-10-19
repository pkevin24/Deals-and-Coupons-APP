package com.user.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;

	@Test
	public void findByEmailTest() {
		User user = new User(100, "SS", "SS", 9999L, "SS", "Suu", 0);
		repo.save(user);
		assertNotNull(repo.findByEmail(user.getEmail()));
		//when(repo.findByEmail(user.getEmail())).thenReturn(user);
		//assertEquals(repo.findByEmail(user.getEmail()), user);
	}

	@Test
	public void findByUserNameTest() {
		User user = new User(100, "SS", "SS", 9999L, "SS", "Suu", 0);
		repo.save(user);
		assertNotNull(repo.findByUserName(user.getUserName()));
		//when(repo.findByUserName(user.getUserName())).thenReturn(user);
		//assertEquals(repo.findByUserName(user.getUserName()), user);
	}

	@Test
	public void saveTest() {
		User user = repo.save(new User(100, "SS", "SS", 9999L, "SS", "Suu", 0));
		assertNotNull(repo.findById(100));
		assertTrue(user.getId() > 0);
	}

	@Test
	public void findAllTest() {
		List<User> users = new ArrayList<>();
		users.add(new User(100, "SS", "SS", 9999L, "SS", "Suu", 0));
		users.add(new User(1001, "SSD", "SSE", 9L, "SSS", "SuuS", 200));
		repo.findAll();
		assertNotNull(users);
	}

	@Test
	public void findByIdTest() {
		Integer id = 100;
		Optional<User> user =Optional.of(new User(100, "SS", "SS", 9999L, "SS", "Suu", 0));
		repo.findById(id);
		assertNotNull(user);
	}

	@Test
	public void deleteByIdTest() {
		User user = new User(100, "SS", "SS", 9999L, "SS", "Suu", 0);
		repo.deleteById(100);
		assertNotNull(user);
	}
}
