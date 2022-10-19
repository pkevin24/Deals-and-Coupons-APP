package com.coupons.repository;

import com.coupons.entity.Coupons;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupons, Integer> {
	

}
//MongoRepository<Coupons,Integer>