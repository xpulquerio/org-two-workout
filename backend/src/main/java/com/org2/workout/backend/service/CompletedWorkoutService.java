package com.org2.workout.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org2.workout.backend.dto.workout.CompletedWorkoutDTO;
import com.org2.workout.backend.mapper.CompletedWorkoutMapper;
import com.org2.workout.backend.model.CompletedWorkout;
import com.org2.workout.backend.model.CompletedWorkoutItem;
import com.org2.workout.backend.model.PlannedWorkout;
import com.org2.workout.backend.model.PlannedWorkoutItem;
import com.org2.workout.backend.model.User;
import com.org2.workout.backend.repository.CompletedWorkoutRespository;
import com.org2.workout.backend.repository.PlannedWorkoutRepository;
import com.org2.workout.backend.repository.PlannedWorkoutItemRepository;
import com.org2.workout.backend.repository.CompletedWorkoutItemRepository;

@Service
public class CompletedWorkoutService {
    // Variaveis
    private final CompletedWorkoutRespository completedWorkoutRepository;
    private final PlannedWorkoutRepository plannedWorkoutRepository;
    private final PlannedWorkoutItemRepository plannedWorkoutItemRepository;
    private final CompletedWorkoutItemRepository completedWorkoutItemRepository;
    private static final Logger log = LoggerFactory.getLogger(CompletedWorkoutService.class);

    // Construtores
    public CompletedWorkoutService(
            CompletedWorkoutRespository completedWorkoutRepository,
            PlannedWorkoutRepository plannedWorkoutRepository,
            CompletedWorkoutItemRepository completedWorkoutItemRepository,
            PlannedWorkoutItemRepository plannedWorkoutItemRepository) {
        this.completedWorkoutRepository = completedWorkoutRepository;
        this.plannedWorkoutRepository = plannedWorkoutRepository;
        this.completedWorkoutItemRepository = completedWorkoutItemRepository;
        this.plannedWorkoutItemRepository = plannedWorkoutItemRepository;

    }

    // Funções
    public List<CompletedWorkoutDTO> findAllByUser(User user) {
        return completedWorkoutRepository
                .findByUserOrderByStartedAtDesc(user)
                .stream()
                .map(workout -> {

                    List<CompletedWorkoutItem> items = completedWorkoutItemRepository
                            .findByCompletedWorkoutId(workout.getId());

                    return CompletedWorkoutMapper.toDTO(workout, items);
                })
                .toList();
    }

    public CompletedWorkoutDTO startFromPlanned(Long plannedWorkoutId, User user) {

        PlannedWorkout plannedWorkout = plannedWorkoutRepository
                .findByIdAndUser(plannedWorkoutId, user);

        // 1️⃣ cria o treino executado
        CompletedWorkout completedWorkout = new CompletedWorkout();
        completedWorkout.setUser(user);
        completedWorkout.setPlannedWorkout(plannedWorkout);
        completedWorkout.setStartedAt(LocalDateTime.now());

        completedWorkoutRepository.save(completedWorkout);

        // 2️⃣ clona os itens planejados
        List<PlannedWorkoutItem> plannedItems = plannedWorkoutItemRepository
                .findByPlannedWorkoutOrderBySequence(plannedWorkout);

        for (PlannedWorkoutItem planned : plannedItems) {
            CompletedWorkoutItem item = new CompletedWorkoutItem();

            item.setCompletedWorkout(completedWorkout);
            item.setExercise(planned.getExercise());
            item.setRepititions(planned.getRepetitions());
            item.setDistance(planned.getDistance());
            item.setDurationSeconds(planned.getDurationSeconds());
            item.setWeight(null); // peso só na execução

            completedWorkoutItemRepository.save(item);
        }

        List<CompletedWorkoutItem> items = completedWorkoutItemRepository.findByCompletedWorkout(completedWorkout);

        return CompletedWorkoutMapper.toDTO(completedWorkout, items);
    }

    public CompletedWorkoutDTO findById(Long id) {

        CompletedWorkout completedWorkout = completedWorkoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout não encontrado"));
        ;

        List<CompletedWorkoutItem> items = completedWorkoutItemRepository.findByCompletedWorkout(completedWorkout);

        return CompletedWorkoutMapper.toDTO(completedWorkout, items);
    }

}
