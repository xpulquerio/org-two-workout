// completed-workout.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { CompletedWorkout } from '../models/completed-workout.model';

@Injectable({
  providedIn: 'root'
})
export class CompletedWorkoutService {

  private readonly apiUrl = environment.apiUrl;

  constructor(private readonly http: HttpClient) {}

  getAllCompletedWorkouts(): Observable<CompletedWorkout[]> {
    return this.http.get<CompletedWorkout[]>(
      `${this.apiUrl}/api/completed-workout/list`
    );
  }
}
