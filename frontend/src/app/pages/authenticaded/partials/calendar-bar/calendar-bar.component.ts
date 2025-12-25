import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkoutDayService } from '../../../../services/workout-day.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-calendar-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './calendar-bar.component.html',
  styleUrls: ['./calendar-bar.component.css'],
})

export class CalendarBarComponent implements OnInit {
  messages = [
    'Keep the momentum going!',
    'You’re on fire 🔥',
    'Consistency beats motivation 💪',
    'Another day, another win 🏆',
    'Don’t break the chain ⛓️'
  ];

  streak$: Observable<number>;

  constructor(private readonly workoutDayService: WorkoutDayService) {
    this.streak$ = this.workoutDayService.getStreak();
  }
  getRandomMessage(): string {
    const index = Math.floor(Math.random() * this.messages.length);
    return this.messages[index];
  }
  ngOnInit(): void {
    console.log(this.streak$);
  }

}
