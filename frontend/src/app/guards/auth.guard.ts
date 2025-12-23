import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { MessageService } from '../services/message.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private readonly authService: AuthService, 
    private readonly router: Router,
    public messageService: MessageService,     // 👈 pega o service
    ) {}

  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
    this.messageService.setMessage("Você precisa estar logado para acessar esta página.");
      this.router.navigate(['/login']);
      
      return false;
    }
  }
}
