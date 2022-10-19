import { Component, OnInit } from '@angular/core';
import { DealserviceService } from '../service/dealservice.service';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-deal-user',
  templateUrl: './deal-user.component.html',
  styleUrls: ['./deal-user.component.css']
})

export class DealUserComponent implements OnInit {
  userdet:any=[];
  deals:any=[]
  oneDeal:any=[]
  list:any=[];
  constructor(private dealservice:DealserviceService,private userAuthService:UserAuthService,private userService:UserService) { }
  
  ngOnInit(): void {
    this.dealservice.getAllDealsDetails().subscribe((data)=>{
      this.deals=data;
    })
  }
  addDeals(data:any){
    console.log(data);
    console.log(this.userAuthService.getId());
    this.userService.getAllUsers().subscribe((datas)=>{
      this.userdet=datas;
      this.list = this.userdet.filter((item:any) => item.id == Number(this.userAuthService.getId()));
    console.log(this.list);
    this.list[0].deals=[...this.list[0].deals,data];
    console.log(this.list[0].deals);
    console.log(this.list[0]);
    this.userService.putUser(this.list[0],Number(this.userAuthService.getId())).subscribe((data)=>{
      console.log(data);
    }
    ) 
    })
    
    
      // console.log("data"+data);
       
  }

 
  

}
