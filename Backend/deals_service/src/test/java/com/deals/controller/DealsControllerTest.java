package com.deals.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.deals.entity.Deals;
import com.deals.exception.DealNotFoundException;
import com.deals.repository.DealsRepository;
import com.deals.service.DealsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(DealsContoller.class)
public class DealsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DealsService service;
	
	@MockBean
	private DealsRepository repo;
	
	@InjectMocks
	private DealsContoller controller;
	List<Deals> deals;
	Deals deal;
	@Test
	@Order(1)
	public void getAllDealsTest() throws Exception
	{
		deals=new ArrayList<>();
		deals.add(new Deals(201,"AMAAL",1000,100,"www.ggoglr.com","www.goodle.com"));
		when(service.getAllDeals()).thenReturn(deals);
		String url="/deals";
//		this.mockMvc.perform(get(url)).andExpect(status().isFound());
		this.mockMvc.perform(get(url)).andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getDealsTest() throws Exception,DealNotFoundException {
		Deals deal=new Deals(1,"ama",199,18,"sd","dwa");
		when(service.getDeals(deal.getDealId())).thenReturn(deal);
		String url="/deals/"+deal.getDealId();
		mockMvc.perform(get(url)).andExpect(status().isOk());
		
	}
	@Test
	public void addDealsTest() throws Exception {
		Deals deal=new Deals(1,"ama",199,18,"sd","dwa");
		when(service.addDeals(deal)).thenReturn(deal);
		ObjectMapper mapper=new ObjectMapper();
		String jsonbody=mapper.writeValueAsString(deal);
		String url="/deals";
		mockMvc.perform(post(url)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isCreated());
	}
	@Test
	public void deleteTest() throws Exception
	{
		deal=new Deals(1,"ama",199,18,"sd","dwa");
		when(service.getDeals(1)).thenReturn(deal);
		mockMvc.perform(delete("/deals/"+deal.getDealId())).andExpect(status().isOk());
	}
	
	@Test
	public void updateTest() throws Exception
	{
		deal=new Deals(1,"ama",199,18,"sd","dwa");
		when(service.getDeals(deal.getDealId())).thenReturn(deal);
		when(service.addDeals(deal)).thenReturn(deal);
		ObjectMapper mapper=new ObjectMapper();
		String jsonbody=mapper.writeValueAsString(deal);
		String url="/deals/"+deal.getDealId();
		mockMvc.perform(put(url)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	

}
