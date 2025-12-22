import { Component, HostListener } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MessageService } from '../../../services/message.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [RouterLink, CommonModule]
})
export class HomeComponent {

  successMessage: string | null = null;
  message: string | null = null;

  constructor(
    public messageService: MessageService,
  ) { }

  // 👁️ ANIMAÇÃO - faz os olhos seguirem o mouse
  @HostListener('document:mousemove', ['$event'])
  onMouseMove(event: MouseEvent) {
    const pupils = document.querySelectorAll('.pupil');

    pupils.forEach((pupil: any) => {
      const rect = pupil.getBoundingClientRect();
      const pupX = rect.left + rect.width / 2;
      const pupY = rect.top + rect.height / 2;

      const angle = Math.atan2(event.pageY - pupY, event.pageX - pupX);
      const moveX = Math.cos(angle) * 6;
      const moveY = Math.sin(angle) * 6;

      pupil.style.transform = `translate(${moveX}px, ${moveY}px)`;
    });
  }
}
