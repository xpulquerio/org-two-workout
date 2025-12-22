import { Component, HostListener } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MessageService } from '../../../services/message.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [CommonModule]
})
export class HomeComponent {

  successMessage: string | null = null;
  message: string | null = null;

  constructor(
    public messageService: MessageService,
  ) { }

}
