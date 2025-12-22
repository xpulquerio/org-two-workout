import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { RegisterService } from '../../services/register.service';
import { MessageService } from '../../services/message.service';   // 👈 IMPORTA AQUI
import { CommonModule } from '@angular/common';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],   // ✅ IMPORTAR RouterModule
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {
  title = 'Register'
  full_name = '';
  email = ''
  username = '';
  password = '';
  message: string | null = null;

  constructor(
    private readonly titleService: Title,
    private readonly registerService: RegisterService,
    private readonly router: Router,
    public messageService: MessageService,     // 👈 pega o service
  ) {
      this.titleService.setTitle('Org2 Workout - Register');
  }
  
  register() {
    // 
    const payload = {
      firstName: this.full_name.split(' ')[0],
      lastName: this.full_name.split(' ').slice(1).join(' '),
      email: this.email,
      username: this.username,
      password: this.password,
      
    };

    this.registerService.register(payload).subscribe({
      next: (res) => {
        console.log("Nome completo: ", payload.firstName, payload.lastName, "| Email:", payload.email, "| Usuário:", payload.username);
        
        this.messageService.setMessage("Usuário registrado com sucesso!");
        this.router.navigate(['/login']);

      },
      error: (err) => {
        console.error("Erro:", err);

        let msg = "Falha ao registrar!";
        
        const parsed = JSON.parse(err.error);
        msg = parsed.error || msg;

        this.messageService.setMessage(msg);  // 👈 AGORA FUNCIONA

      }
      

    });
  }
}
