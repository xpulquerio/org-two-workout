import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { MessageService } from './message.service';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private readonly apiUrl = `${environment.apiUrl}/auth`;
  // private apiUrl = environment.apiUrl + '/auth';
  private readonly tokenKey = 'token';


  constructor(
    private readonly http: HttpClient,
    private readonly messageService: MessageService

  ) { }


  login(data: { username: string; password: string }): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, data)
      .pipe(
        tap((resp: any) => {
          if (resp?.token) {
            this.setToken(resp.token);
          }
        })
      );
  }

  // Guard / verificar login
  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  // Logout
  logout(): void {
    localStorage.removeItem(this.tokenKey);
    this.messageService.setMessage("Usuário deslogado com sucesso!");  // 👈 AGORA FUNCIONA
  }

  // Armazena token
  private setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);

  }
  // Recupera token
  getToken(): string | null {
    console.log("Chamou getToken() - this.tokenKey:", localStorage.getItem(this.tokenKey));
    return localStorage.getItem(this.tokenKey);
  }
}
