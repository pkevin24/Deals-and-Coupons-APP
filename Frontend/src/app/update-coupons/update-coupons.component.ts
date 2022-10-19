import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CouponserviceService } from '../service/couponservice.service';

@Component({
  selector: 'app-update-coupons',
  templateUrl: './update-coupons.component.html',
  styleUrls: ['./update-coupons.component.css']
})
export class UpdateCouponsComponent implements OnInit {
  editCoupons=new FormGroup({
    couponName:new FormControl(''),
    couponCode:new FormControl(),
    couponType:new FormControl(''),
    couponCounts:new FormControl(),
    imgUrl:new FormControl(''),
    linkUrl:new FormControl('')
  
   })
   coupons:any=[];
   datas:any=[];
   id:any='';

  constructor(private couponsService:CouponserviceService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.couponsService.getAllCouponsdetails().subscribe((allData=>{
      this.datas=allData;
      console.log(this.datas);
      this.id=this.route.snapshot.params['id'];
      this.coupons = this.datas.filter((item:any) => item.couponId == this.id);
      console.log(this.coupons[0]['couponName']);
       this.editCoupons=new FormGroup({
        couponName:new FormControl(this.coupons[0]['couponName']),
        couponCode:new FormControl(this.coupons[0]['couponCode']),
        couponType:new FormControl(this.coupons[0]['couponType']),
        couponCounts:new FormControl(this.coupons[0]['couponCounts']),
        imgUrl:new FormControl(this.coupons[0]['imgUrl']),
        linkUrl:new FormControl(this.coupons[0]['linkUrl'])
      })
      
    }))
    
    
  }
  editData(){
    var coupon=this.editCoupons.value;
    var CouponProduct={...coupon,couponId:Number(this.route.snapshot.params['id'])};
    console.log(CouponProduct);
    this.couponsService.putCoupons(CouponProduct,this.route.snapshot.params['id']).subscribe((res)=>{
      console.log(res);
    });
    this.ngOnInit();
    this.router.navigate(['/admin/coupons']);
  }
  

}


 