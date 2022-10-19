package com.coupons.service;

import java.util.List;

import com.coupons.entity.Coupons;
import com.coupons.exception.CouponsNotFoundException;

import org.springframework.http.ResponseEntity;

public interface CouponsService {
	
	public Coupons getCoupons(Integer id) throws CouponsNotFoundException;
	
	public List<Coupons> getAllCoupons() throws CouponsNotFoundException;
	
	public Coupons addCoupons(Coupons coupons);
	
	//public Coupons fetchCouponsByCouponsId(Integer id);
	
	//public void updateCoupon(Coupons coupon , Integer Id);
	
	public void deleteCoupons(Integer Id);

}
