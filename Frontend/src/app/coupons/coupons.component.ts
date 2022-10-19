import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { faEdit, faTrashAlt } from '@fortawesome/free-regular-svg-icons';
import { CouponserviceService } from '../service/couponservice.service';
import { CouponsModel } from './coupons.model';

@Component({
  selector: 'app-coupons',
  templateUrl: './coupons.component.html',
  styleUrls: ['./coupons.component.css']
})
export class CouponsComponent implements OnInit {
  formValue!: FormGroup;
  couponObj: CouponsModel = new CouponsModel;
  fatrash= faTrashAlt;
  faedit=faEdit;
  constructor(private couponsService: CouponserviceService) { }
  addCoupons = new FormGroup({
    couponName: new FormControl('',Validators.required),
    couponCode: new FormControl(0,Validators.required),
    couponType: new FormControl('',Validators.required),
    couponCounts: new FormControl(0,Validators.required),
    imgUrl: new FormControl('',Validators.required),
    linkUrl: new FormControl('',Validators.required)

  })
 

  couponData: any = [];


  ngOnInit(): void {
    this.couponsService.getAllCouponsdetails().subscribe((allData) => {
      console.log(allData);
      this.couponData = allData;
      console.log(this.couponData);
    })
  }
  deleteCoupons(Id: any) {
    this.couponsService.deleteCoupons(Id).subscribe((result) => {
      window.location.reload();

    });
  }
    SaveData(){
      console.log("check");
      this.couponsService.saveCouponsData(this.addCoupons.value).subscribe((results) => {
        console.log(results);
        this.addCoupons.reset();
        document.getElementById('but')!.click();
        this.ngOnInit();
        window.location.reload();
      });
    }
    get couponName(){
      return this.addCoupons.get('couponName');
    }
    get couponCode(){
      return this.addCoupons.get('couponCode');
    }
    get couponType(){
      return this.addCoupons.get('couponType');
    }
    get couponCounts(){
      return this.addCoupons.get('couponCounts');
    }
    get imgUrl(){
      return this.addCoupons.get('imgUrl');
    }
    get linkUrl(){
      return this.addCoupons.get('linkUrl');
    }

   

  }




