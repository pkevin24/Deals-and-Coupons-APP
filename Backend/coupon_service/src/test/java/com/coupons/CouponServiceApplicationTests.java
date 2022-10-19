package com.coupons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.coupons.entity.Coupons;
import com.coupons.exception.CouponsNotFoundException;
import com.coupons.repository.CouponRepository;
import com.coupons.service.CouponsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class CouponServiceApplicationTests {
	
    @Autowired
	private CouponsService serv;
	
	@MockBean
	private CouponRepository repo;
	
	@Test
	public void getAllCouponsTest() throws CouponsNotFoundException {
		when(repo.findAll()).thenReturn(Stream.of(new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"),new Coupons(1,"coupon",56,"aa",1,"www","www")).collect(Collectors.toList()));
		assertEquals(2, serv.getAllCoupons().size());
	}
	  @Test
	    public void getCouponsTest() throws CouponsNotFoundException {
	    	Integer id=2;
	    	Optional<Coupons>coupons=Optional.of(new Coupons(2,"coupon",121,"CLOTHS",1,"www","www"));
	    	when(repo.findById(id)).thenReturn(coupons);
	    	assertEquals(coupons, Optional.of(serv.getCoupons(id)));
	    }
	  @Test
	  public void addCouponsTest() {
		  Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		  when(repo.save(coupons)).thenReturn(coupons);
		  assertEquals(coupons, serv.addCoupons(coupons));
		  
	  }
	  @Test
	  public void DeleteCouponsTest() {
		  Coupons coupons=new Coupons(2,"coupon",121,"CLOTHS",1,"www","www");
		  serv.deleteCoupons(coupons.getCouponId());
		  //assertEquals(coupons, serv.addCoupons(coupons));
		  verify(repo,times(1)).deleteById(coupons.getCouponId());
	  }
}
