package com.coupons.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coupons.entity.Coupons;
import com.coupons.repository.CouponRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RepoTest {
	
	@Autowired
	
	private CouponRepository repo;
	
	@Test
	public void AddCouponTest() {
		Coupons coupons=repo.save( new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"));
		assertNotNull(coupons);
		assertTrue(coupons.getCouponId() > 0);
	}

	@Test
	public void GetAllCouponsTest() {
	/*	List<Coupons>coupons=new ArrayList<>();
		coupons.add(new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"));
		coupons.add(new Coupons(1,"flower",12,"food",3,"www","www"));*/	
		Coupons c1=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		Coupons c2=new Coupons(1,"coup",21,"LOTHS",10,"www","www");
        repo.save(c1);
        repo.save(c2);
        List<Coupons>coupons=(List<Coupons>) repo.findAll();
		assertNotNull(coupons);
	}
	
	@Test
	public void GetCouponsTest() {
		Integer id=2;
    	//Optional<Coupons>coupons=Optional.of(new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"));
		Coupons c1=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		Coupons c2=new Coupons(1,"coup",21,"LOTHS",10,"www","www");
        repo.save(c1);
        repo.save(c2);
        Optional<Coupons>coupons=(Optional<Coupons>) repo.findById(id);
    	assertNotNull(coupons);
	}
   @Test
	public void DeleteCouponTest() {
	  Coupons c1=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		Coupons c2=new Coupons(1,"coup",21,"LOTHS",10,"www","www");
      repo.save(c2);
	  repo.save(c1);
     	   repo.deleteById(2);
	 //  assertNotNull(coupons);	
	}
	
}
