import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
  })
};
@Injectable({
  providedIn: 'root'
})
export class CouponserviceService {
  datas=[]
    url='http://localhost:8999/coupons';
    constructor(private http:HttpClient) { }
    getAllCouponsdetails(){
      return this.http.get(this.url);
    }
    saveCouponsData(data:any){
      console.log(data);
      return  this.http.post(this.url,data,httpOptions);
      console.log(this.datas);
    }
  deleteCoupons(id:any){
    // return this.http.delete(`${this.url}/${id}`);
    return this.http.delete('http://localhost:8999/coupons/'+id);
  }
  putCoupons(data:any, id:number)
    {
      return this.http.put("http://localhost:8999/coupons/" + id,data).pipe(map((res:any)=> {
        return res
      }))
    }

}
