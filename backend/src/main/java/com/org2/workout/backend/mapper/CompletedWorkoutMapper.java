package com.org2.workout.backend.mapper;

import com.org2.workout.backend.dto.workout.CompletedWorkoutDTO;
import com.org2.workout.backend.model.CompletedWorkout;
import com.org2.workout.backend.model.CompletedWorkoutItem;

import java.util.List;

public class CompletedWorkoutMapper {

    private CompletedWorkoutMapper() {
        // Construtor vazio
    }

    public static CompletedWorkoutDTO toDTO(CompletedWorkout completeWorkout, List<CompletedWorkoutItem> items) {

        CompletedWorkoutDTO dto = new CompletedWorkoutDTO();
        dto.setId(completeWorkout.getId());
        dto.setDescription(completeWorkout.getDescription());
        dto.setStartedAt(completeWorkout.getStartedAt());
        dto.setFinishedAt(completeWorkout.getFinishedAt());
        dto.setNotes(completeWorkout.getNotes());
        dto.setDuration(completeWorkout.getWorkoutDuration());

        if (completeWorkout.getPlannedWorkout() != null) {
            dto.setPlannedWorkoutDescription(
                    completeWorkout.getPlannedWorkout().getDescription());
        }

        if (items != null) {
            dto.setItems(
                    items.stream()
                            .map(CompletedWorkoutItemMapper::toDTO)
                            .toList());
        }

        return dto;
    }
}
