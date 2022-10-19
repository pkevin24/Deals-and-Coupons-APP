import { Component, OnInit } from '@angular/core';
import {NewsapiserviceService} from '../service/newsapiservice.service';


@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {


  constructor(private services:NewsapiserviceService) { }

  topHeadingData:any=[];

  ngOnInit(): void {
    this.services.topHeading().subscribe((result)=>{
      console.log(result);
      this.topHeadingData=result.articles;
      
    })
  }

}
