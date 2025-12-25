// completed-workout.model.ts
export interface CompletedWorkout {

  id: number;
  description: string;

  plannedWorkoutId?: number;
  plannedWorkoutName?: string;

  startedAt: string;   // ISO string
  finishedAt?: string;

  duration?: string;
  notes?: string;
}
