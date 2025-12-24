package com.org2.workout.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.Duration;
import jakarta.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "tb_completed_workout")
@Data
public class CompletedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "planned_workout_id")
    private PlannedWorkout plannedWorkout;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Transient
    public String getWorkoutDuration() {
        if (finishedAt == null || startedAt == null)
            return null;

        long minutes = Duration.between(startedAt, finishedAt).toMinutes();

        return minutes >= 60
                ? (minutes / 60) + "h " + (minutes % 60) + "min"
                : minutes + "min";
    }
}
