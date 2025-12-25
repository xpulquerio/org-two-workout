package com.org2.workout.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org2.workout.backend.dto.workout.CompletedWorkoutDTO;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.service.CompletedWorkoutService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/completed-workout")
public class CompletedWorkoutController {
    // Variaveis
    private CompletedWorkoutService completedWorkoutService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // Construtor
    public CompletedWorkoutController(CompletedWorkoutService completedWorkoutService) {
        this.completedWorkoutService = completedWorkoutService;
    }

    // Listar todos os usuários
    @GetMapping("/list")
    public List<CompletedWorkoutDTO> listAll(@AuthenticationPrincipal User user) {
        log.info("GET /api/completed-workout/list");
        return completedWorkoutService.findAllByUser(user);
    }
}
