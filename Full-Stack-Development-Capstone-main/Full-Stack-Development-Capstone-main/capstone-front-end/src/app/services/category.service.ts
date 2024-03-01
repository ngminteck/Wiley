import { HttpClient, HttpHeaders, HttpResponse, HttpRequest, HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category';
const baseUrl = 'http://localhost:8080/category'


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({providedIn: 'root'})
export class CategoryService {

  constructor(private http: HttpClient) { }



  getAll(): Observable<Category[]> {
  
    
    return this.http.get<Category[]>(`http://localhost:8080/category/get/all`);
  }


  create(data: Category): Observable<Category> {
    return this.http.post<Category>(baseUrl, data, httpOptions);
  }

}

