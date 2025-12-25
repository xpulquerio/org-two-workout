package com.org2.workout.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org2.workout.backend.model.PlannedWorkout;
import com.org2.workout.backend.model.User;

public interface PlannedWorkoutRepository extends JpaRepository<PlannedWorkout, Long> {
    List<PlannedWorkout> findByUserAndActiveTrueOrderByUpdatedAtDesc(User user);

    PlannedWorkout findByIdAndUser(Long plannedWorkoutId, User user);

}
