package com.org2.workout.backend.service;

import com.org2.workout.backend.repository.UserRepository;
import com.org2.workout.backend.mapper.UserMapper;
import com.org2.workout.backend.model.User;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.dto.users.UserCreateDTO;
import com.org2.workout.backend.dto.users.UserDTO;
import com.org2.workout.backend.exception.EmailAlreadyExistsException;
import com.org2.workout.backend.exception.UsernameAlreadyExistsException;
import java.util.List;
import org.springframework.security.core.Authentication;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO register(UserCreateDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("O email informado já está cadastrado.");
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException("O nome de usuário já está em uso.");
        }
        // System.out.println(dto);
        // -- Cria entidade User
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // -- Salva
        userRepository.save(user);

        // -- Retorna DTO
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("📌 Usuários encontrados: " + users);
        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    // Recupera o usuário logado
    // public UserDTO getCurrentUser() {
    // var auth = SecurityContextHolder.getContext().getAuthentication();
    // if (auth == null || !auth.isAuthenticated()) {
    // throw new RuntimeException("Usuário não autenticado");
    // }

    // String username = auth.getName(); // pega o username do token

    // User user = userRepository.findByUsername(username)
    // .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    // return UserMapper.toDTO(user);
    // }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !(auth.getPrincipal() instanceof User)) {
            return null;
        }

        return (User) auth.getPrincipal();
    }

    // Carrega User para o filtro JWT
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
