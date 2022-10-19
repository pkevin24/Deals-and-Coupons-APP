import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(roles:[])
  {
    localStorage.setItem('roles',JSON.stringify(roles));
  }
  public getRoles():[]
  {
    return JSON.parse(localStorage.getItem('roles')||'{}');
  }
  public setToken(jwtToken:string)
  {
    localStorage.setItem('jwtToken',jwtToken);
  }
  public getToken():string
  {
    return localStorage.getItem('jwtToken')||'';
  }
  public clear()
  {
    localStorage.clear();
  }
  public isLoggedIn(){
    // console.log(this.getRoles() && this.getToken());
    return this.getRoles() && this.getToken();
  }
  public setId(id:number)
  {
    localStorage.setItem('id',JSON.stringify(id));
  }
  public getId():any{
    return localStorage.getItem('id');
  }

}
