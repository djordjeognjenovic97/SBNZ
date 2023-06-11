import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccumulateFragrance } from './model/accumulateFragrance';
import { Fragrance } from './model/fragrance';
import { Query } from './model/query';

@Injectable({
  providedIn: 'root'
})
export class FragranceServiceService {

    private readonly path = "http://localhost:8080/";
    private headers = new HttpHeaders({'Content-Type':'application/json'})
    constructor(
        private http:HttpClient
    ){}

    public search(query: Query):Observable<Fragrance[]>{
      return this.http.post<Fragrance[]>(this.path + "bestFrags", query);
  }

  public getAccumulate(brand: string):Observable<AccumulateFragrance>{
    return this.http.get<AccumulateFragrance>(this.path + "brandStats/" + brand);
}
}
