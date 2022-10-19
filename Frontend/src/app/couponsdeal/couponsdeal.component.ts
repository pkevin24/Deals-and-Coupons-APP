import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CouponserviceService } from '../service/couponservice.service';
import { DealserviceService } from '../service/dealservice.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-couponsdeal',
  templateUrl: './couponsdeal.component.html',
  styleUrls: ['./couponsdeal.component.css']
})
export class CouponsdealComponent implements OnInit {
  userdet:any=[];
  id:any='';
  list:any=[];
  deals:any=[];
  coupons:any=[];
  constructor(private userService:UserService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((data)=>{
      this.userdet=data;
      this.id=this.route.snapshot.params['id'];
      this.list = this.userdet.filter((item:any) => item.id == this.id);
      this.deals=this.list[0].deals;
      this.coupons=this.list[0].coupons;
    })
  }

}