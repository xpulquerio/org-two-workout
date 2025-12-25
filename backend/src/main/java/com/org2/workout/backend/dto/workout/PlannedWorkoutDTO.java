package com.org2.workout.backend.dto.workout;

import lombok.Data;

@Data
public class PlannedWorkoutDTO {

    private Long id;
    private Long userId;
    private String description;
}