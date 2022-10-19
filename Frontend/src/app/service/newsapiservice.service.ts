import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class NewsapiserviceService {

  constructor(private _http:HttpClient) { }
  //newsapiurl
  newsApiUrl="https://newsapi.org/v2/top-headlines?country=us&apiKey=62b44f0f92194db19ae6bde048f16f38";

  topHeading():Observable<any>
  {
    return this._http.get(this.newsApiUrl);
  }
}
