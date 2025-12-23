import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { MessageService } from '../../services/message.service';
import { CommonModule } from '@angular/common';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';
  manterLogado: boolean = false;
  showPassword: boolean = false;

  // 🔥 Variáveis de loading corretas
  loading: boolean = false;
  progress: number = 0;

  constructor(
    private readonly titleService: Title,
    private readonly router: Router,
    public messageService: MessageService,
    private readonly authService: AuthService,
  ) {
    this.titleService.setTitle('Org2 Workout - Login');
  }

  // ===================================================================
  // 🟦 BOTÃO → PROGRESS BAR → LOGIN → REDIRECIONA
  // ===================================================================
  onLogin() {
    if (this.loading) return;

    this.loading = true;
    this.progress = 0;

    const interval = setInterval(() => {
      this.progress++;

      if (this.progress >= 100) {
        clearInterval(interval);
        this.enviarRequisicaoLogin();
      }
    }, 10);
  }


  // ===================================================================
  // 🟩 REQUISIÇÃO REAL PARA O BACKEND
  // ===================================================================
  enviarRequisicaoLogin() {
    const payload = {
      username: this.username,
      password: this.password
    };

    // APENAS UMA CHAMADA:
    this.authService.login(payload).subscribe(() => {
      this.authService.loadUser(); // SEM subscribe
      this.router.navigate(['/home']);
    });
  }

  // ===================================================================
  // 👁 MOSTRAR/ESCONDER SENHA
  // ===================================================================
  showPasswordPress() {
    this.showPassword = true;
  }

  hidePasswordPress() {
    this.showPassword = false;
  }
}
