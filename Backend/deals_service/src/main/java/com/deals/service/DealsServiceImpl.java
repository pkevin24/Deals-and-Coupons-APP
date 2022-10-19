package com.deals.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.deals.entity.Deals;
import com.deals.exception.DealNotFoundException;
import com.deals.repository.DealsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DealsServiceImpl implements DealsService{

	@Autowired
	private DealsRepository repo;
	
//	List<Deals>deals=new ArrayList<>();
//	List<Deals>deals=List.of(
//			new Deals(101,"Fridge",20000,5000,"www.google.com"),
//			new Deals(102,"Microwave",10000,2000,"www.google.com")
//			);
	@Override
	public Deals getDeals(Integer id) throws DealNotFoundException {
		// TODO Auto-generated method stub
//		return this.deals.stream().filter(deal->deal.getDealId()==id).findAny().orElse(null);
		Optional<Deals> deal=repo.findById(id);
		if(!deal.isPresent())
		{
			throw new DealNotFoundException("Deal is not found");
		}
		else
			return deal.get();
//		

	}
	@Override
	public List<Deals> getAllDeals() throws DealNotFoundException {
		if(repo.findAll().isEmpty())
			throw new DealNotFoundException("No deals are present");
		return repo.findAll();
	}
	@Override
	public Deals addDeals(Deals deal) {
		// TODO Auto-generated method stub
		return repo.save(deal);
//		this.deals.add(deal);
		
	}
//	@Override
//	public void updateDeals(Deals deal, Integer id) {
//		// TODO Auto-generated method 
//		Deals tempDeal=this.getDeals(id);
//		tempDeal.setPrice(deal.getPrice());
//		tempDeal.setDealName(deal.getDealName());
//		tempDeal.setCashback(deal.getCashback());
//		tempDeal.setUrl(deal.getUrl());
//		tempDeal.setImageUrl(deal.getImageUrl());
//		
//	}
	@Override
	public void deleteDeals(Integer id) {
		// TODO Auto-generated method stub
//		Deals tempDeal=this.getDeals(id);
//		deals.remove(tempDeal);
		repo.deleteById(id);
		
	}

}
