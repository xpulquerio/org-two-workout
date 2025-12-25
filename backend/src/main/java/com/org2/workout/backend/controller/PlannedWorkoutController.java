package com.org2.workout.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org2.workout.backend.dto.workout.PlannedWorkoutDTO;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.service.PlannedWorkoutService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/planned-workout")
public class PlannedWorkoutController {
    // Variaveis
    private PlannedWorkoutService plannedWorkoutService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // Construtor
    public PlannedWorkoutController(PlannedWorkoutService plannedWorkoutService) {
        this.plannedWorkoutService = plannedWorkoutService;
    }

    // Listar todos os usuários
    @GetMapping("/list")
    public List<PlannedWorkoutDTO> listAll(@AuthenticationPrincipal User user) {
        log.info("GET /api/planned-workout/list");
        return plannedWorkoutService.findAllByUser(user);
    }
}
