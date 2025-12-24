// workout-day.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WorkoutDayService {

 private readonly apiUrl = `${environment.apiUrl}`;

  constructor(private readonly http: HttpClient) {}

  getStreak(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/api/workout-day/streak`);
  }
}
