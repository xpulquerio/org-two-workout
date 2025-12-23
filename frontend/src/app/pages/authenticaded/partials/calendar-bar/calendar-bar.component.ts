import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

export interface CalendarDay {
  date: Date;
  label: string;
  value?: number; // qualquer dado (treinos, kcal, etc)
}

@Component({
  selector: 'app-calendar-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './calendar-bar.component.html',
  styleUrls: ['./calendar-bar.component.css'],
})
export class CalendarBarComponent implements OnInit {

  @Input() data: Record<string, number> = {}; 
  days: CalendarDay[] = [];

  ngOnInit(): void {

  }
  
}
