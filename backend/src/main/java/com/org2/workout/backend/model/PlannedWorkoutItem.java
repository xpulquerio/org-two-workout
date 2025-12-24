package com.org2.workout.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Table(name = "tb_planned_workout_item")
@Data
public class PlannedWorkoutItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "planned_workout_id", nullable = false)
    private PlannedWorkout plannedWorkout;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(nullable = false)
    private Integer order;

    private Integer repetitions;

    @Column(precision = 6, scale = 2)
    private BigDecimal distance;

    @Column(name = "duration_seconds")
    private Long durationSeconds;
}
