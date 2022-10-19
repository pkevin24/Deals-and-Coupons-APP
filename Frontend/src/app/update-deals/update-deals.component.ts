import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DealserviceService } from '../service/dealservice.service';

@Component({
  selector: 'app-update-deals',
  templateUrl: './update-deals.component.html',
  styleUrls: ['./update-deals.component.css']
})
export class UpdateDealsComponent implements OnInit {
  editDeals=new FormGroup({
    dealName:new FormControl(''),
    price:new FormControl(),
    imageUrl:new FormControl(''),
    url:new FormControl(''),
    cashback:new FormControl()
  })
  deals:any=[];
  datas:any=[];
  id:any='';
  constructor(private dealsService:DealserviceService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    
    this.dealsService.getAllDealsDetails().subscribe((allData=>{
      this.datas=allData;
      console.log(this.datas);
      this.id=this.route.snapshot.params['id'];
      this.deals = this.datas.filter((item:any) => item.dealId == this.id);
      console.log(this.deals[0]['dealName']);
       this.editDeals=new FormGroup({
        dealName:new FormControl(this.deals[0]['dealName']),
        price:new FormControl(this.deals[0]['price']),
        imageUrl:new FormControl(this.deals[0]['imageUrl']),
        url:new FormControl(this.deals[0]['url']),
        cashback:new FormControl(this.deals[0]['cashback'])
      })
      
    }))
    
    
  }
  editData(){
    var deal=this.editDeals.value;
    var dealProduct={...deal,dealId:Number(this.route.snapshot.params['id'])};
    console.log(dealProduct);
    this.dealsService.putDeals(dealProduct,this.route.snapshot.params['id']).subscribe((res)=>{
      console.log(res);
    });
    this.ngOnInit();
    this.router.navigate(['/admin/deals']);
  }
  

}
