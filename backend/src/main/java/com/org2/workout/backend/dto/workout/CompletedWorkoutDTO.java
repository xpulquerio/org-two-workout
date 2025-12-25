package com.org2.workout.backend.dto.workout;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CompletedWorkoutDTO {

    private Long id;
    private String description;
    private String plannedWorkoutDescription;

    private String notes;
    private String duration;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private List<CompletedWorkoutItemDTO> items;
}
