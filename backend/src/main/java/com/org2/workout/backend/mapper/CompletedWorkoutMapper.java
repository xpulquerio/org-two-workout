package com.org2.workout.backend.mapper;

import com.org2.workout.backend.dto.workout.CompletedWorkoutDTO;

import com.org2.workout.backend.model.CompletedWorkout;

public class CompletedWorkoutMapper {

    private CompletedWorkoutMapper() {
        // Construtor vazio
    }

    public static CompletedWorkoutDTO toDTO(CompletedWorkout workout) {

        CompletedWorkoutDTO dto = new CompletedWorkoutDTO();
        dto.setId(workout.getId());
        dto.setDescription(workout.getDescription());
        dto.setStartedAt(workout.getStartedAt());
        dto.setFinishedAt(workout.getFinishedAt());
        dto.setNotes(workout.getNotes());
        dto.setDuration(workout.getWorkoutDuration());

        if (workout.getPlannedWorkout() != null) {
            dto.setPlannedWorkoutId(workout.getPlannedWorkout().getId());
            dto.setPlannedWorkoutDescription(workout.getPlannedWorkout().getDescription());
        }

        return dto;
    }
}
