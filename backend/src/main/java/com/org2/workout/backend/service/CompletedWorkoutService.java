package com.org2.workout.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.dto.workout.CompletedWorkoutDTO;
import com.org2.workout.backend.mapper.CompletedWorkoutMapper;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.repository.CompletedWorkoutRespository;

@Service
public class CompletedWorkoutService {
    // Variaveis
    private final CompletedWorkoutRespository completedWorkoutRespository;
    private static final Logger log = LoggerFactory.getLogger(CompletedWorkoutService.class);

    // Construtores
    public CompletedWorkoutService(
            CompletedWorkoutRespository completedWorkoutRespository) {
        this.completedWorkoutRespository = completedWorkoutRespository;
    }

    // Funções
    public List<CompletedWorkoutDTO> findAllByUser(User user) {
        return completedWorkoutRespository.findByUserOrderByStartedAtDesc(user)
                .stream()
                .map(CompletedWorkoutMapper::toDTO)
                .toList();
    }
}
