package com.deals.repository;

import com.deals.entity.Deals;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
//@CrossOrigin(origins = "http://localhost:4200")
public interface DealsRepository extends MongoRepository<Deals, Integer> {

}
