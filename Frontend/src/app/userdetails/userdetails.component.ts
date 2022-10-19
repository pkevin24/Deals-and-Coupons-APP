import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import {faArrowAltCircleRight} from '@fortawesome/free-regular-svg-icons';
@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css'],
  //providers:[UserService]
})
export class UserdetailsComponent implements OnInit {
  faedit=faArrowAltCircleRight;
  constructor(private userService:UserService) { }
  userDatas:any=[];
  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((allData)=>{
      console.log(allData);
      this.userDatas=allData;
      console.log(this.userDatas)  
    })
  }
}
