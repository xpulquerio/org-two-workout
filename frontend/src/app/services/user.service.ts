import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';
import { AuthService } from '../services/auth.service';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})

export class UserService {
  private readonly apiUrl = `${environment.apiUrl}/users`;
  
  constructor(
     private readonly http: HttpClient,
     private readonly authService: AuthService,

  ) {}

  getMe() {
    console.log("Chamou getMe()")
    return this.http.get<User>(`${this.apiUrl}/me`, {
      headers: { 
        Authorization: `Bearer ${this.authService.getToken()}`
      }
    });
  }
}