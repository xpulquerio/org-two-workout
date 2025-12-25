// completed-workout.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PlannedWorkout } from '../models/planned-workout.model';
import { CompletedWorkout } from '../models/completed-workout.model';

@Injectable({
  providedIn: 'root'
})
export class PlannedWorkoutService {

  private readonly apiUrl = `${environment.apiUrl}`;

  constructor(private readonly http: HttpClient) { }

  getAllPlannedWorkouts(): Observable<PlannedWorkout[]> {
    return this.http.get<PlannedWorkout[]>(
      `${this.apiUrl}/api/planned-workout/list`
    );
  }

  start(plannedWorkoutId: number) {
    return this.http.post<CompletedWorkout>(
      `${this.apiUrl}/api/completed-workout/start/${plannedWorkoutId}`,
      {}
    );
  }

}
