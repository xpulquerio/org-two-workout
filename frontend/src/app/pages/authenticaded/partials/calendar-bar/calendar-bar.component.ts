import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkoutDayService } from '../../../../services/workout-day.service';

@Component({
  selector: 'app-calendar-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './calendar-bar.component.html',
  styleUrls: ['./calendar-bar.component.css'],
})

export class CalendarBarComponent implements OnInit {

  streak = 0;

  constructor(private readonly workoutDayService: WorkoutDayService) { }

  ngOnInit(): void {
    this.workoutDayService.getStreak().subscribe({
      next: (value) => {
        console.log('Streak recebida:', value);
        this.streak = value;
      },
      error: (err) => {
        console.error('Erro ao buscar streak:', err);
        this.streak = 0;
      }
    });
  }

}
