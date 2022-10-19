import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../service/user-auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private userauthservice:UserAuthService,private router:Router) { }

  ngOnInit(): void {
  }
  public isLoggedIn()
  {
    return this.userauthservice.isLoggedIn();
  }
  public logout()
  {
    this.userauthservice.clear();
    this.router.navigate(['/home']);
  }
  public isAdmin(): boolean{
    var x=this.userauthservice.getId();
    if(x==0)
      return true;
    return false;
  }

}
