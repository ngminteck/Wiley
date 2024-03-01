import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../models/post.model'
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
      'Content-Type': 'application/json'
  })
};

const baseUrl = 'http://localhost:8080/posts'

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }
  
  getApproved(): Observable<Post[]> {
    return this.http.get<Post[]>('http://localhost:8080/posts', httpOptions);
  }
  
  getAll(): Observable<Post[]> {
    return this.http.get<Post[]>('http://localhost:8080/posts/all', httpOptions);
  }

  get(id: number): Observable<any> {
    return this.http.get<Post>(`${baseUrl}/${id}`, httpOptions);
  }

  create(post: Post): Observable<any> {
    return this.http.post(baseUrl, post);
  }

  update(id: number, post: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, post);
  }

  delete(id: number): Observable<{}> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  findByCategory(category: string): Observable<Post[]> {
    return this.http.get<Post[]>(`${baseUrl}?cat=${category}`, httpOptions);
  }

}
