import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
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
export class DealserviceService {
  datas=[]
    url='http://localhost:8999/deals';
    constructor(private http:HttpClient) { }
    getAllDealsDetails(){
      return this.http.get(this.url);
    }
    saveDealsData(data:any){
      console.log(data);
      return  this.http.post(this.url,data,httpOptions);
      console.log(this.datas);
    }
  deleteDeals(id:any){
    // return this.http.delete(`${this.url}/${id}`);
    return this.http.delete('http://localhost:8999/deals/'+id);
  }
  putDeals(data:any, id:number)
    {
      return this.http.put("http://localhost:8999/deals/" + id,data).pipe(map((res:any)=> {
        return res
      }))
    }
    getaDeal(id:number)
    {
      return this.http.get("http://localhost:8999/deals/"+id);
    }
}
