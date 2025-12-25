import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CalendarBarComponent } from '../calendar-bar/calendar-bar.component'
import { CompletedWorkout } from '../../../models/completed-workout.model';
import { CompletedWorkoutService } from '../../../services/completed-workout.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-settings',
  imports: [FormsModule, CalendarBarComponent, CommonModule],
  standalone: true,
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})

export class HistoryComponent implements OnInit {
  
  completedWorkouts$!: Observable<CompletedWorkout[]>;

  constructor(

      private readonly completedWorkoutService: CompletedWorkoutService,
  
    ) {}

  ngOnInit(): void {
      this.completedWorkouts$ = this.completedWorkoutService.getAllCompletedWorkouts();
  }
}