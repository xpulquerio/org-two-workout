import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { MessageService } from './message.service';
import { environment } from '../../environments/environment';
import { User } from '../models/user.model'; // ← O CAMINHO PARA SUA INTERFACE
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly apiUrl = `${environment.apiUrl}`;
  

  private readonly userSubject = new BehaviorSubject<User | null>(null);
  user$ = this.userSubject.asObservable();
  private tokenKey = 'token';

  constructor(
    private readonly http: HttpClient,
    private readonly messageService: MessageService,

  ) {
    
  }

  login(data: any) {
    console.log('Função: login()')
    return this.http.post<any>(`${this.apiUrl}/auth/login`, data)
      .pipe(
        tap((resp: any) => {
          localStorage.setItem(this.tokenKey, resp.token);
        })
      );
  }

  loadUser() {
    console.log('Função: loadUser()')
    
    this.http.get<User>(`${environment.apiUrl}/users/me`).subscribe((user: User) => {
      this.userSubject.next(user);
    });
  }

  logout(): void {
    console.log('Função: logout()')
    localStorage.removeItem(this.tokenKey);
    this.userSubject.next(null); // 5. Limpa o estado global ao deslogar
    this.messageService.setMessage("Usuário deslogado com sucesso!");
  }

  getToken(): string | null {
    const token = localStorage.getItem(this.tokenKey);
    console.log('Função: getToken() - ', token)
    return token;
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }


}