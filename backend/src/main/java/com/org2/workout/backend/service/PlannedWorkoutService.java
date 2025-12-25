package com.org2.workout.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.dto.workout.PlannedWorkoutDTO;
import com.org2.workout.backend.mapper.PlannedWorkoutMapper;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.repository.PlannedWorkoutRepository;

@Service
public class PlannedWorkoutService {
    // Variaveis
    private final PlannedWorkoutRepository plannedWorkoutRepository;
    private static final Logger log = LoggerFactory.getLogger(CompletedWorkoutService.class);

    // Construtores
    public PlannedWorkoutService(
            PlannedWorkoutRepository plannedWorkoutRepository) {
        this.plannedWorkoutRepository = plannedWorkoutRepository;
    }

    // Funções
    public List<PlannedWorkoutDTO> findAllByUser(User user) {
        return plannedWorkoutRepository.findByUserAndActiveTrueOrderByUpdatedAtDesc(user)
                .stream()
                .map(PlannedWorkoutMapper::toDTO)
                .toList();
    }
}
