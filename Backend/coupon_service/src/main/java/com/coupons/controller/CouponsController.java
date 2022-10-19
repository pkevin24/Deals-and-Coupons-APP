package com.coupons.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.coupons.entity.Coupons;
import com.coupons.exception.CouponsNotFoundException;
import com.coupons.service.CouponsService;
import com.coupons.service.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons") 
public class CouponsController {
	@Autowired
	private CouponsService couponsService;
	@Autowired
	private SequenceGeneratorService ser;
	
	@GetMapping("/{couponsId}")
	public ResponseEntity<Coupons> getCoupons(@PathVariable("couponsId") Integer couponId) throws CouponsNotFoundException{
		//return this.couponsService.getCoupons(couponId);
	//	try {
		//	Coupons coupons=couponsService.getCoupons(couponId);
			//return new ResponseEntity<Coupons>(coupons,HttpStatus.OK);
		//}
			//return new ResponseEntity<Coupons>(HttpStatus.NOT_FOUND);
		//}
		Coupons coupons=couponsService.getCoupons(couponId);
		return new ResponseEntity<Coupons>(coupons,HttpStatus.OK);
	}
     @GetMapping("")
     public List<Coupons> getAllCoupons() throws CouponsNotFoundException
     {
    	 return this.couponsService.getAllCoupons();
     }
     
     @PostMapping("")
    public ResponseEntity<Coupons> addCoupons(@Valid @RequestBody  Coupons coupon) throws Exception 
     {
    	 coupon.setCouponId(ser.getSequenceNumber(Coupons.SEQUENCE_NAME));
    	couponsService.addCoupons(coupon);
    	return ResponseEntity.accepted().body(coupon);
     }
    
   @PutMapping("/{couponsId}")
    public  ResponseEntity<?> update(@Valid @RequestBody Coupons coupon, @PathVariable("couponsId") Integer couponId) {
    	//couponsService.updateCoupon(coupon, couponId);
	   try {
		//	Coupons existCoupon=couponsService.getCoupons(couponId);
			couponsService.addCoupons(coupon);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
   
    @DeleteMapping("/{couponsId}")
   public String delete(@PathVariable("couponsId") Integer couponId) throws CouponsNotFoundException {
    	Coupons tempCoupon=couponsService.getCoupons(couponId);
    	
    		if(tempCoupon!=null) {
    			couponsService.deleteCoupons(couponId);
    			return "deleted successfully";
    		}
    		return "coupon id didnt found";
    	
    		}
    
    		
    	}
    


