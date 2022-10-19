import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { User } from './User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  msg="";
  check:boolean=false;
  showPassword: boolean = false;
  user = new User();
registerForm: any;
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
  }
  showHidePassword() {
    this.showPassword = !this.showPassword;
  }
  registerUser(){
    this.userService.saveUser(this.user).subscribe(
      data =>{
        console.log("response received");
        this.msg="Registration successful";
        this.router.navigate(['/login']);
      },
      error => {
        console.log("exception received");
        this.check=true;
        this.msg=error.error;
      }
    )
  }
}
