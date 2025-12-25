package com.org2.workout.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org2.workout.backend.model.User;
import com.org2.workout.backend.service.WorkoutDayService;

@RestController
@RequestMapping("/api/workout-day")
public class WorkoutDayController {

    private final WorkoutDayService workoutDayService;
    private static final Logger log = LoggerFactory.getLogger(WorkoutDayController.class);

    public WorkoutDayController(WorkoutDayService workoutDayService) {
        this.workoutDayService = workoutDayService;
    }

    // 🔥 marca treino hoje
    @PostMapping("/today")
    public ResponseEntity<Void> markToday(@AuthenticationPrincipal User user) {
        workoutDayService.markToday(user);
        return ResponseEntity.ok().build();
    }

    // 🔥 pega o foguinho
    @GetMapping("/streak")
    public ResponseEntity<Integer> getStreak(@AuthenticationPrincipal User user) {
        int streak = workoutDayService.getStreak(user);
        log.info("GET /api/workout-day/streak - {}", streak);
        return ResponseEntity.ok(streak);
    }

    // pega dias treinados na ultima semana
    @GetMapping("/week")
    public List<String> getWorkoutDaysOfWeek(@AuthenticationPrincipal User user) {
        log.info("GET /api/workout-day/week");
        return workoutDayService
                .getWeekWorkoutDates(user)
                .stream()
                .map(LocalDate::toString) // "yyyy-MM-dd"
                .toList();
    }
}
