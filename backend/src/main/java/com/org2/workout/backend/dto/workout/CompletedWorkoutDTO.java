package com.org2.workout.backend.dto.workout;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompletedWorkoutDTO {

    private Long id;
    private String description;

    private Long plannedWorkoutId;
    private String plannedWorkoutDescription;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private String duration;
    private String notes;
}
