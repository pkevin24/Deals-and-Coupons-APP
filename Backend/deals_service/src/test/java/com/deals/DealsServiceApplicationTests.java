package com.deals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.deals.entity.Deals;
import com.deals.exception.DealNotFoundException;
import com.deals.repository.DealsRepository;
import com.deals.service.DealsService;
//import com.mongodb.connection.Stream;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

@SpringBootTest
class DealsServiceApplicationTests {
	@Autowired
	private DealsService service;
	
	@MockBean
	private DealsRepository repo;
	
	@Test
	public void getAllDealsTest() throws DealNotFoundException {
		when(repo.findAll()).thenReturn(Stream.of(new Deals(201,"MAAL",1000,100,"www.ggoglr.com","www.goodle.com"),new Deals(203,"MAALi",1000,100,"www.ggoglr.com","www.goodle.com")).collect(Collectors.toList()));
		assertEquals(2, service.getAllDeals().size());
		
	}
	
	@Test
	public void getDealsTest() throws DealNotFoundException
	{
		int id=101;
		Optional<Deals> deal=Optional.of(new Deals(201,"MAAL",1000,100,"www.ggoglr.com","www.goodle.com"));
		when(repo.findById(id)).thenReturn(deal);
		assertEquals(deal,Optional.of(service.getDeals(id)));
	}
	
	@Test
	public void addDealsTest()
	{
			Deals deal=new Deals(201,"MAAL",1000,100,"www.ggoglr.com","www.goodle.com");
			when(repo.save(deal)).thenReturn(deal);
			assertEquals(deal, service.addDeals(deal));
	}
	
	@Test
	public void deleteDealsTest()
	{
		Deals deal=new Deals(201,"MAAL",1000,100,"www.ggoglr.com","www.goodle.com");
		service.deleteDeals(deal.getDealId());
		verify(repo,times(1)).deleteById(deal.getDealId());
	}

}
