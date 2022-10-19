import { Component, OnInit } from '@angular/core';
import { CouponserviceService } from '../service/couponservice.service';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-coupon-user',
  templateUrl: './coupon-user.component.html',
  styleUrls: ['./coupon-user.component.css']
})
export class CouponUserComponent implements OnInit {
  userdet:any=[];
  list: any;
  constructor(private couponservice:CouponserviceService,private userAuthService:UserAuthService,private userService:UserService) { }
   coupons:any=[];

  ngOnInit(): void {
    this.couponservice.getAllCouponsdetails().subscribe((data)=>{
      console.log(data);
      this.coupons=data;

    })
  
  }
  copyMessage(val: string){
    alert("code has been copied!!")
    const selBox = document.createElement('textarea');
    selBox.style.position = 'fixed';
    selBox.style.left = '0';
    selBox.style.top = '0';
    selBox.style.opacity = '0';
    selBox.value = val;
    document.body.appendChild(selBox);
    selBox.focus();
    selBox.select();
    document.execCommand('copy');
    document.body.removeChild(selBox);
  }
   
  addCoupons(data:any){
    console.log(data);
    console.log(this.userAuthService.getId());
    this.userService.getAllUsers().subscribe((datas)=>{
      this.userdet=datas;
      this.list = this.userdet.filter((item:any) => item.id == Number(this.userAuthService.getId()));
    console.log(this.list);
    this.list[0].coupons=[...this.list[0].coupons,data];
    console.log(this.list[0].coupons);
    console.log(this.list[0]);
    this.userService.putUser(this.list[0],Number(this.userAuthService.getId())).subscribe((data)=>{
      console.log(data);
    }
    ) 
    })
  }
}
