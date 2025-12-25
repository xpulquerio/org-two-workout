import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkoutDayService } from '../../../services/workout-day.service';
import { Observable } from 'rxjs';
import { CalendarDay } from '../../../models/calendar-day.model';

@Component({
  selector: 'app-calendar-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './calendar-bar.component.html',
  styleUrls: ['./calendar-bar.component.css'],
})

export class CalendarBarComponent implements OnInit {
  // Variaveis
  messages = [
    'Keep the momentum going!',
    'You’re on fire 🔥',
    'Consistency beats motivation 💪',
    'Another day, another win 🏆',
    'Don’t break the chain ⛓️'
  ];
  
  days: CalendarDay[] = [];
  streak$: Observable<number>;

  // construtor
  constructor(private readonly workoutDayService: WorkoutDayService) {
    this.streak$ = this.workoutDayService.getStreak();
    this.buildCalendar();
  }

  // Funções

  getRandomMessage(): string {
    const index = Math.floor(Math.random() * this.messages.length);
    return this.messages[index];
  }

  private buildCalendar() {
    const today = new Date();
    today.setHours(0, 0, 0, 0);

    const start = new Date(today);
    start.setDate(today.getDate() - 6);

    this.workoutDayService.getWeek().subscribe(workoutDates => {
      this.days = [];

      for (let i = 0; i < 7; i++) {
        const date = new Date(start);
        date.setDate(start.getDate() + i);

        this.days.push({
          date,
          dayLabel: date.toLocaleDateString('en-US', { weekday: 'short' }).charAt(0).toUpperCase(),
          dayNumber: date.getDate(),
          isToday: date.getTime() === today.getTime(),
          hasWorkout: workoutDates.includes(date.toISOString().split('T')[0]),
        });
      }
    });
  }

  ngOnInit(): void {
    console.log(this.streak$);
  }

}
