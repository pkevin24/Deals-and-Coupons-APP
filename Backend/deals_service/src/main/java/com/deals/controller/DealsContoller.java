package com.deals.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.deals.entity.Deals;
import com.deals.exception.DealNotFoundException;
import com.deals.service.DealsService;
//import com.example.Music.Song;
import com.deals.service.SequenceGeneratorService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/deals")
@CrossOrigin(origins = "http://localhost:4200")
public class DealsContoller {
	
		@Autowired
		private DealsService dealsService;
		@Autowired
		private SequenceGeneratorService seq;
		
		@GetMapping("/{dealId}")
		public ResponseEntity<Deals> getDeals(@PathVariable("dealId") Integer dealId) throws DealNotFoundException
		{
			return ResponseEntity.ok(dealsService.getDeals(dealId));
		}
		
		@GetMapping("")
		public List<Deals> getAllDeals() throws DealNotFoundException
		{
			return dealsService.getAllDeals();
		}
		
		@PostMapping("")
		public ResponseEntity<Deals> addDeals(@Valid @RequestBody Deals deal)
		{
			deal.setDealId(seq.getSequenceNumber(Deals.SEQUENCE_NAME));
			Deals deals=dealsService.addDeals(deal);
			return new ResponseEntity<Deals>(deals,HttpStatus.CREATED);
//			return ResponseEntity.accepted().body(deal);
		}
		
		
		@PutMapping("/{dealId}")
		public ResponseEntity<?>update(@Valid @RequestBody Deals deal,@PathVariable("dealId")  Integer dealId) throws DealNotFoundException
		{
			try {
//				Deals existDeal=dealsService.getDeals(dealId);
				dealsService.addDeals(deal);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		@DeleteMapping("/{dealId}")
		public ResponseEntity<Deals> delete(@PathVariable("dealId")  Integer dealId) throws DealNotFoundException
		{
			Deals deal=dealsService.getDeals(dealId);
			if(deal!=null)
			{
				dealsService.deleteDeals(dealId);
				return new ResponseEntity<>(deal,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
}
