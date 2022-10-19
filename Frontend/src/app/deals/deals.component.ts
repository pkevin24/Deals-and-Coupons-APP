import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DealserviceService } from '../service/dealservice.service';
import { DealsModel } from './deals.model';
import {faTrashAlt,faEdit} from '@fortawesome/free-regular-svg-icons';

@Component({
  selector: 'app-deals',
  templateUrl: './deals.component.html',
  styleUrls: ['./deals.component.css']
})
export class DealsComponent implements OnInit {
  fatrash= faTrashAlt;
  faedit=faEdit;
  formValue!: FormGroup; 
  dealObj:DealsModel=new DealsModel;
  constructor(private dealsService:DealserviceService) { }

  addDeals=new FormGroup({
    dealName:new FormControl('',Validators.required),
    price:new FormControl(0,Validators.required),
    imageUrl:new FormControl('',Validators.required),
    url:new FormControl('',Validators.required),
    cashback:new FormControl(0,Validators.required)
  })

  editDeals=new FormGroup({
    dealName:new FormControl(''),
    price:new FormControl(),
    imageUrl:new FormControl(''),
    url:new FormControl(''),
    cashback:new FormControl()
  })

  dealData:any=[];
  ngOnInit(): void {


    this.dealsService.getAllDealsDetails().subscribe((allData)=>{
      console.log(allData);
      this.dealData=allData;
      console.log(this.dealData);
    })
  }

  
  deleteDeals(songId:any){
    this.dealsService.deleteDeals(songId).subscribe((result)=>{
      window.location.reload();
    });
  }
  SaveData(){
    console.log("check");
    this.dealsService.saveDealsData(this.addDeals.value).subscribe((results)=>{
      console.log(results);
      this.addDeals.reset();
      document.getElementById('but')!.click();


      this.ngOnInit();
    });
  }

  EditData(data:any){
    console.log(data);
    console.log(this.editDeals.value);
    this.dealsService.putDeals(this.editDeals.value,data.dealId).subscribe((results)=>{
      console.log(results);
      this.addDeals.reset();
    })
  }
  get dealName(){
    return this.addDeals.get('dealName');
  }
  get imageUrl(){
    return this.addDeals.get('imageUrl');
  }
  get url(){
    return this.addDeals.get('url');
  }
  get price(){
    return this.addDeals.get('price');
  }
  get cashback(){
    return this.addDeals.get('cashback');
  }

}
