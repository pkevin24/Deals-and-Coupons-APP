import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-demologin',
  templateUrl: './demologin.component.html',
  styleUrls: ['./demologin.component.css']
})
export class DemologinComponent implements OnInit {
  showPassword: boolean = false;
  msg="";
  constructor(private userService:UserService,private userAuthService:UserAuthService,private router:Router) { }

  ngOnInit(): void {
  }
  showHidePassword() {
    this.showPassword = !this.showPassword;
  }
  login(loginForm:NgForm){
    this.userService.login(loginForm.value).subscribe(
      (response:any)=>{
        console.log(response.jwtToken);
        console.log(response.user.role);
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        this.userAuthService.setId(response.user.id);
        console.log(response.user.id);
        const role=response.user.role[0];
        console.log(role.roleName);
        if(role.roleName==='Admin')
        {
          console.log("check");
          this.router.navigate(['/admin']);
        }
        else{
          this.router.navigate(['/home']);
        }
      },
    (error:any)=>{
      console.log(error);
      this.msg="Bad credentials , please enter valid username and password";
    }
    );
  }
}


