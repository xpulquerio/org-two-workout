package com.org2.workout.backend.repository;

import com.org2.workout.backend.model.WorkoutDay;
import com.org2.workout.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {

    Optional<WorkoutDay> findByUserAndWorkoutDate(User user, LocalDate date);

    boolean existsByUserAndWorkoutDate(User user, LocalDate workoutDate);

    List<WorkoutDay> findByUserOrderByWorkoutDateDesc(User user);
}
