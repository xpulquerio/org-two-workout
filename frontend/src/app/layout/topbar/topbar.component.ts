import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-topbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './topbar.component.html',
  styleUrl: './topbar.component.css',
})
export class TopbarComponent {

  profileOpen = false;

  app_name = "SFIC"

  user!: User; // ← PROPRIEDADE CERTA

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
    private readonly userService: UserService,
  ) {}

  ngOnInit() {
    this.loadUser();
  }
  
  loadUser() {
    this.userService.getMe().subscribe({
      next: (data) => {
        this.user = data;
        console.log('Usuário carregado:', data);
      },
      error: (err) => {
        console.error('Erro ao carregar usuário:', err);
      }
    });
  }

  toggleProfile() {
    this.profileOpen = !this.profileOpen;
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/']);
  }
}
