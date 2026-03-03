import { Component } from '@angular/core';
import { MessageService } from '../../../services/message.service';
import { CommonModule } from '@angular/common';
import { CalendarBarComponent } from '../calendar-bar/calendar-bar.component';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [CommonModule, CalendarBarComponent, RouterModule]
})
export class HomeComponent {

  successMessage: string | null = null;
  message: string | null = null;

  constructor(
    public messageService: MessageService,
    public authService: AuthService,
  ) { }

}
