package com.org2.workout.backend.controller;

import com.org2.workout.backend.dto.auth.AuthResponseDTO;
import com.org2.workout.backend.dto.auth.LoginDTO;
import com.org2.workout.backend.service.AuthService;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginDTO dto) {
        log.info("POST /auth/login {}", dto);

        return authService.login(dto);
    }
}
