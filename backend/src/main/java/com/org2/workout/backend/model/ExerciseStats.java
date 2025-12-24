package com.org2.workout.backend.model;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;

@Entity
@Table(name = "tb_exercise_stats", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "exercise_id", "user_id" })
})
@Data
public class ExerciseStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercise exercise;

    private Integer count = 0;

    @Column(precision = 6, scale = 2)
    private BigDecimal totalWeight;

    @Column(precision = 6, scale = 2)
    private BigDecimal personalRecord;

    @Column(precision = 6, scale = 2)
    private BigDecimal totalDistance;

    @Column(name = "total_duration_seconds")
    private Long totalDurationSeconds;
}
