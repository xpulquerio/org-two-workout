package com.org2.workout.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Table(name = "tb_exercise_muscle", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "exercise_id", "muscle_id" })
})
@Data
public class ExerciseMuscle {

    public enum Nivel {
        PRIMARY,
        SECONDARY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    @Enumerated(EnumType.STRING)
    @Column(name = "stimulusLevel", length = 10, nullable = false)
    private Nivel stimulusLevel;
}
