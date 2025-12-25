package com.org2.workout.backend.mapper;

import com.org2.workout.backend.dto.workout.PlannedWorkoutDTO;
import com.org2.workout.backend.model.PlannedWorkout;
import com.org2.workout.backend.model.User;

public class PlannedWorkoutMapper {

    private PlannedWorkoutMapper() {
        // construtor privado
    }

    public static PlannedWorkoutDTO toDTO(PlannedWorkout entity) {
        if (entity == null)
            return null;

        PlannedWorkoutDTO dto = new PlannedWorkoutDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());

        if (entity.getUser() != null) {
            dto.setUserId(entity.getUser().getId());
        }

        return dto;
    }

    public static PlannedWorkout toEntity(PlannedWorkoutDTO dto) {
        if (dto == null)
            return null;

        PlannedWorkout entity = new PlannedWorkout();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());

        if (dto.getUserId() != null) {
            User user = new User();
            user.setId(dto.getUserId());
            entity.setUser(user);
        }

        return entity;
    }

    public static void updateEntity(PlannedWorkout entity, PlannedWorkoutDTO dto) {
        if (entity == null || dto == null)
            return;

        entity.setDescription(dto.getDescription());
    }
}
