import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { UserAuthService } from './user-auth.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  datas=[]
  requestHeader=new HttpHeaders(
    {"No-Auth":"True"}
  )
  url1='http://localhost:8999/users/details';
  constructor(private http:HttpClient,private userAuthService:UserAuthService) { }
  getAllUsers(){
    return this.http.get(this.url1);
  }
  url2='http://localhost:8999/users/registerNewUser';
  saveUser(data:any):Observable<any>{
    console.log(data);
    return  this.http.post<any>(this.url2,data,httpOptions);
    // console.log(this.datas);
  }
  deleteUser(id:any){
    // return this.http.delete(`${this.url}/${id}`);
    return this.http.delete('http://localhost:8999/users/details/'+id);
  }
  getaUser(id:number)
  {
    return this.http.get("http://localhost:8999/users/details/" + id);
  }
  putUser(data:any, id:number)
  {
    return this.http.put("http://localhost:8999/users/details/" + id,data).pipe(map((res:any)=> {
      return res
    }))
  }
  public login(logindata:any)
  {
    return this.http.post("http://localhost:8999/admin/authenticate",logindata,{headers:this.requestHeader});
  }
  public roleMatch(allowedRoles:any):boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
    return isMatch;
  }
}
