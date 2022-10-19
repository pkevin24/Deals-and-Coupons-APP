package com.deals.service;

import java.util.List;
import java.util.Optional;

import com.deals.entity.Deals;
import com.deals.exception.DealNotFoundException;

public interface DealsService {
	
	public Deals getDeals(Integer id) throws DealNotFoundException;
	public List<Deals> getAllDeals() throws DealNotFoundException;
	public Deals addDeals(Deals deal);
//	public void updateDeals(Deals deal, Integer id);
	public void deleteDeals(Integer id);
}
