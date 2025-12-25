
import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { CompletedWorkoutService } from '../../../services/completed-workout.service';
import { Observable } from 'rxjs';
import { CompletedWorkout } from '../../../models/completed-workout.model';
import { CalendarBarComponent } from "../calendar-bar/calendar-bar.component";

@Component({
    selector: 'app-completed-workout',
    standalone: true,
    imports: [CommonModule, RouterModule, CalendarBarComponent],
    templateUrl: './completed-workout.component.html',
    styleUrls: ['./completed-workout.component.css'],
})

export class CompletedWorkoutComponent implements OnInit {

    completedWorkout$!: Observable<CompletedWorkout>;

    constructor(
        public readonly completedWorkoutService: CompletedWorkoutService,
        private readonly route: ActivatedRoute,
    ) { }


    ngOnInit(): void {
        const id = Number(this.route.snapshot.paramMap.get('id'));
        this.completedWorkout$ = this.completedWorkoutService.findById(id);
    }

}
