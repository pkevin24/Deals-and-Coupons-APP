package com.coupons.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.coupons.entity.Coupons;
import com.coupons.exception.CouponsNotFoundException;
import com.coupons.repository.CouponRepository;
import com.coupons.service.CouponsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(CouponsController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CouponControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CouponsService service;
	
	@MockBean
	private CouponRepository repo;
	 @Test
		public void getAllCouponssTest() throws Exception
		{
			List<Coupons>coupons=new ArrayList<>();
			coupons.add(new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"));
			when(service.getAllCoupons()).thenReturn(coupons);
			String url="/coupons";
			mockMvc.perform(get(url)).andExpect(status().isOk());
		}
	  @Test
	  public void getCouponsTest() throws Exception,CouponsNotFoundException {
			Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
			when(service.getCoupons(coupons.getCouponId())).thenReturn(coupons);
			String url="/coupons/"+coupons.getCouponId();
			mockMvc.perform(get(url)).andExpect(status().isOk());
			
		}
	  @Test
	  public void addCouponssTest() throws Exception {
			Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
			when(service.addCoupons(coupons)).thenReturn(coupons);
			ObjectMapper mapper=new ObjectMapper();
			String jsonbody=mapper.writeValueAsString(coupons);
			String url="/coupons";
			mockMvc.perform(post(url)
					.content(jsonbody)
					.contentType(MediaType.APPLICATION_JSON)
					).andExpect(status().isAccepted());
		}
	  @Test
		public void deleteTest() throws Exception
		{
		  Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		  when(service.getCoupons(1)).thenReturn(coupons);
			mockMvc.perform(delete("/coupons/"+coupons.getCouponId())).andExpect(status().isOk());
		}
	  
	@Test
	public void updateTest() throws Exception {
		Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
        when(service.addCoupons(coupons)).thenReturn(coupons);
        ObjectMapper objmapper=new ObjectMapper();
		String jsonbody=objmapper.writeValueAsString(coupons);
		String url="/coupons/"+coupons.getCouponId();
		mockMvc.perform(put(url)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	

}
