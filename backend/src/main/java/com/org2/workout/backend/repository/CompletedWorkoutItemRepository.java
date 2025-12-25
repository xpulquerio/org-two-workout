package com.org2.workout.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org2.workout.backend.model.CompletedWorkout;
import com.org2.workout.backend.model.CompletedWorkoutItem;

public interface CompletedWorkoutItemRepository
        extends JpaRepository<CompletedWorkoutItem, Long> {

    List<CompletedWorkoutItem> findByCompletedWorkout(CompletedWorkout completedWorkout);

    List<CompletedWorkoutItem> findByCompletedWorkoutId(Long completedWorkoutId);
}
