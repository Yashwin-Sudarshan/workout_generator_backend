package com.example.workout_regimen_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="working_muscle_levels")
public class WorkingMuscleLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workingMuscleLevelId;

    @NotBlank
    private String muscle;

    /**
     *  A number between 0 and 1 to denote the proportion of work
     *  the muscle is doing for a particular exercise.
     * */
    @NotNull
    private float relativeIntensity;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
