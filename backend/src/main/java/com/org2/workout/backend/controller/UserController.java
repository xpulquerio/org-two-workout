package com.org2.workout.backend.controller;

import com.org2.workout.backend.dto.users.UserCreateDTO;
import com.org2.workout.backend.dto.users.UserDTO;
import com.org2.workout.backend.mapper.UserMapper;
import com.org2.workout.backend.service.UserService;
import com.org2.workout.backend.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    // Variaveis
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // Construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Pegar dados do usuário logado!
    @PostMapping("/register")
    public UserDTO register(@RequestBody UserCreateDTO dto) {
        log.info("POST /auth/login {}", dto);
        return userService.register(dto);
    }

    // Listar todos os usuários
    @GetMapping("/list")
    public List<UserDTO> listAll() {
        log.info("GET /users/list");
        return userService.getAllUsers();
    }

    // Pegar dados do usuário logado!
    @GetMapping("/me")
    public UserDTO getCurrentUser() {
        User user = userService.getCurrentUser();
        log.info("GET /users/me {}", user);

        return UserMapper.toDTO(user); // Mapeie no construtor

    }
}
