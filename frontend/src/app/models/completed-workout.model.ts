import { CompletedWorkoutItem } from "./completed-workout-item.model";

// completed-workout.model.ts
export interface CompletedWorkout {

  id: number;
  description: string;

  plannedWorkoutId?: number;
  plannedWorkoutDescription?: string;

  startedAt: string;     // ISO
  finishedAt?: string;  // ISO

  duration?: string;
  notes?: string;

  items?: CompletedWorkoutItem[]; // 👈 essencial para a tela de detail

}
