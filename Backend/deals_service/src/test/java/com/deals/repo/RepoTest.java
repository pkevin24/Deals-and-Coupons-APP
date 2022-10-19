package com.deals.repo;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.deals.entity.Deals;
import com.deals.repository.DealsRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RepoTest {
	
	@Autowired
	
	private DealsRepository repo;
	
	@Test
	public void AddTest() {
		Deals deals=repo.save( new Deals(1,"ama",199,18,"sd","dwa"));
		assertNotNull(deals);
		assertTrue(deals.getDealId() > 0);
	}

	@Test
	public void GetAllTest() {
		List<Deals>deals=new ArrayList<>();
		deals.add(new Deals(2,"ama",199,18,"sd","dwa"));
		deals.add(new Deals(1,"ama",199,18,"sd","dwa"));
		repo.findAll();
		assertNotNull(deals);
	}
	@Test
	public void GetDealsTest() {
		Integer id=2;
    	Optional<Deals>deals=Optional.of(new Deals(1,"ama",199,18,"sd","dwa"));
    	repo.findById(id);
    	assertNotNull(deals);
	}
        @Test
	public void DeleteDealsTest() {
	
	  Deals deals=new Deals(1,"ama",199,18,"sd","dwa");
	   repo.deleteById(2);
	   assertNotNull(deals);	
	}
	
}