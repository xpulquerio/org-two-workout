package com.org2.workout.backend.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;

@Entity
@Table(name = "tb_muscle_stats", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "muscle_id", "user_id" })
})
@Data
public class MuscleStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    private Muscle muscle;

    private Integer count = 0;
}
