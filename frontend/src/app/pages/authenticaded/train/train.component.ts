import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CalendarBarComponent } from '../calendar-bar/calendar-bar.component';
import { PlannedWorkout } from '../../../models/planned-workout.model'
import { PlannedWorkoutService } from '../../../services/planned-workout.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-train',
  imports: [FormsModule, CalendarBarComponent, CommonModule],
  standalone: true,
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css'],
})

export class TrainComponent implements OnInit {

  plannedWorkouts$!: Observable<PlannedWorkout[]>;

  constructor(

    private readonly plannedWorkoutService: PlannedWorkoutService,
    private readonly router: Router

  ) { }

  ngOnInit(): void {
    this.plannedWorkouts$ = this.plannedWorkoutService.getAllPlannedWorkouts();
  }

  startWorkout(plannedWorkoutId: number) {
    this.plannedWorkoutService.start(plannedWorkoutId)
    .subscribe(completed => {
      this.router.navigate(['/completed-workout', completed.id]);
    });
  }

  
}