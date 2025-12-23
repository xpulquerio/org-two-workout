import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class RegisterService {
  private readonly apiUrl = `${environment.apiUrl}`;
  
  // private apiUrl = 'http://localhost:8080';

  constructor(
    private readonly http: HttpClient
  ) {}

  register(data: { firstName: string; lastName: string; email: string; username: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/register`, data, {
      responseType: 'text'  // backend retorna string
    });
  }
}
