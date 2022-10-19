import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  list = ['Welcome to the COUPONS AND DEALS WORLD']
  constructor() { }

  ngOnInit(): void {
  }

}
