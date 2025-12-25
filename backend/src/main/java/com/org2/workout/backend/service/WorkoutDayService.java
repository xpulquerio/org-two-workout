package com.org2.workout.backend.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.model.User;
import com.org2.workout.backend.model.WorkoutDay;
import com.org2.workout.backend.repository.WorkoutDayRepository;

@Service
public class WorkoutDayService {

    private final WorkoutDayRepository workoutDayRepository;
    private static final Logger log = LoggerFactory.getLogger(WorkoutDayService.class);

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
        log.info("getStreak()");
        List<WorkoutDay> days = workoutDayRepository.findByUserOrderByWorkoutDateDesc(user);
        // log.info("getStreak() - {}", days);
        // Se não tiver registros = 0
        if (days.isEmpty())
            return 0;

        Set<LocalDate> workoutDates = days.stream()
                .map(WorkoutDay::getWorkoutDate)
                .collect(Collectors.toSet());

        LocalDate today = LocalDate.now();
        LocalDate expected = workoutDates.contains(today)
                ? today
                : today.minusDays(1);

        // log.info("Data último treino - {}", expected);

        int streak = 0;

        while (workoutDates.contains(expected)) {
            streak++;
            expected = expected.minusDays(1);
        }

        return streak;
    }

    public List<LocalDate> getWeekWorkoutDates(User user) {

        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(6); // últimos 7 dias

        return workoutDayRepository.findWorkoutDatesInPeriod(
                user,
                start,
                today);
    }
}
