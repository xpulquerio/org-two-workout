import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarBarComponent } from './calendar-bar.component';

describe('CalendarBar', () => {
  let component: CalendarBarComponent;
  let fixture: ComponentFixture<CalendarBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CalendarBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalendarBarComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
