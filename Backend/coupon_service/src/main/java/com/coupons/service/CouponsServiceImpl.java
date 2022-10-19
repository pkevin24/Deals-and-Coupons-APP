package com.coupons.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coupons.entity.Coupons;
import com.coupons.exception.CouponsNotFoundException;
import com.coupons.repository.CouponRepository;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsServiceImpl implements CouponsService {
	
	//List<Coupons> coupons=new ArrayList<>();
    //List<coupons>coupons=List.of(
    		///new coupons(1234L,"FoodC",100000,"Food",2,"www.google.com"),
    	//	new coupons(12345L,"clothC",199999,"cloth",3,"www.google.com")
    		
    		//);
	@Autowired
	private CouponRepository repo;
	
	@Override
	public Coupons getCoupons(Integer id) throws CouponsNotFoundException{
		// TODO Auto-generated method stub
		//return this.coupons.stream().filter(coupons->coupons.getCouponId()==id).findAny().orElse(null);
		Optional<Coupons>coupons=repo.findById(id);
		if(!coupons.isPresent()) {
			throw new CouponsNotFoundException("coupon not found");
		}
		return coupons.get();
		// return repo.findById(id).get();
	}
	@Override
	public List<com.coupons.entity.Coupons> getAllCoupons() throws CouponsNotFoundException {
		// TODO Auto-generated method stub
		//return repo.findAll();
		List<Coupons> coupons=repo.findAll();
		if(coupons.isEmpty()) {
			throw new CouponsNotFoundException("no coupons found");
			
		}
		return coupons;
	}
	@Override
	public Coupons addCoupons(com.coupons.entity.Coupons coupons) {
		// TODO Auto-generated method stub
		//this.coupons.add(coupons);
		return repo.save(coupons);
	}
	//@Override
	//public com.coupons.entity.Coupons fetchCouponsByCouponsId(Integer id) {
		// TODO Auto-generated method stub
		//List<Coupons> coupons=this.getAllCoupons();
		//return this.coupons.stream().filter(coupons->coupons.getCouponId()==id).findAny().orElse(null);
		//return repo.findById(id);
	//}
	
	//0@Override
	//public void updateCoupon(Coupons coupon , Integer Id) {
		//Coupons tempCoupon=this.getCoupons(Id);
		//tempCoupon.setCouponCode(coupon.getCouponCode());
		//tempCoupon.setCouponCounts(coupon.getCouponCounts());
		//tempCoupon.setCouponName(coupon.getCouponName());
		//tempCoupon.setCouponType(coupon.getCouponType());
		//tempCoupon.setLinkUrl(coupon.getLinkUrl());
		//tempCoupon.setImgUrl(coupon.getImgUrl());
	//}
	@Override
	public void deleteCoupons(Integer Id) {
		//Coupons tempCoupon=this.getCoupons(Id);
		//coupons.remove(tempCoupon);
		repo.deleteById(Id);
	}
	
	

}