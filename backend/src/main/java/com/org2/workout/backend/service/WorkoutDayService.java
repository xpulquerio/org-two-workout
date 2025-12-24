package com.org2.workout.backend.service;

import java.time.LocalDate;

import java.util.List;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.model.User;
import com.org2.workout.backend.model.WorkoutDay;
import com.org2.workout.backend.repository.WorkoutDayRepository;

@Service
public class WorkoutDayService {

    private final WorkoutDayRepository workoutDayRepository;

    public WorkoutDayService(WorkoutDayRepository workoutDayRepository) {
        this.workoutDayRepository = workoutDayRepository;
    }

    // marca que o usuário treinou hoje
    public void markToday(User user) {
        LocalDate today = LocalDate.now();

        if (workoutDayRepository.existsByUserAndWorkoutDate(user, today)) {
            return; // já marcou hoje
        }

        WorkoutDay day = new WorkoutDay();
        day.setUser(user);
        day.setWorkoutDate(today);

        workoutDayRepository.save(day);
    }

    // calcula o streak atual
    public int getStreak(User user) {
        List<WorkoutDay> days = workoutDayRepository.findByUserOrderByWorkoutDateDesc(user);

        int streak = 0;
        LocalDate expected = LocalDate.now();

        for (WorkoutDay day : days) {
            if (day.getWorkoutDate().equals(expected)) {
                streak++;
                expected = expected.minusDays(1);
            } else if (day.getWorkoutDate().isBefore(expected)) {
                break;
            }
        }

        return streak;
    }
}
