package com.org2.workout.backend.service;

import com.org2.workout.backend.dto.auth.AuthResponseDTO;
import com.org2.workout.backend.dto.auth.LoginDTO;
import com.org2.workout.backend.exception.InvalidPasswordException;
import com.org2.workout.backend.exception.UserNotFoundException;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.repository.UserRepository;
import com.org2.workout.backend.mapper.AuthMapper;
import com.org2.workout.backend.service.AuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO login(LoginDTO dto) {

        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Senha incorreta");
        }

        String token = jwtService.generateToken(user.getUsername());

        return AuthMapper.toAuthResponse(user, token);
    }
}
