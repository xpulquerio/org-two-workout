package com.org2.workout.backend.repository;

import com.org2.workout.backend.model.WorkoutDay;
import com.org2.workout.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {

    Optional<WorkoutDay> findByUserAndWorkoutDate(User user, LocalDate date);

    boolean existsByUserAndWorkoutDate(User user, LocalDate workoutDate);

    List<WorkoutDay> findByUserOrderByWorkoutDateDesc(User user);

    @Query("""
                select wd.workoutDate
                from WorkoutDay wd
                where wd.user = :user
                  and wd.workoutDate between :start and :end
                order by wd.workoutDate

            """)
    List<LocalDate> findWorkoutDatesInPeriod(
            @Param("user") User user,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end);
}
