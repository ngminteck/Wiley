import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isUserLoggedIn: boolean = false;

  constructor(private http : HttpClient) { }

  /**
   * send a request to the backend with the username and password that was inputted.
   * @param username the username that the user entered in the form
   * @param password the plaintext password that the user entered in the form
   * @return a success message if the login was successful.
   */
  login = (username: string, password: string): Observable<User> => {
    return this.http.post<User>('/api/login', {username, password});

  }

  /**
   * Destroy the cookie on the client side
   * and let the server know that the token is invalid.
   */
  logout = (): void => {

  }
}
