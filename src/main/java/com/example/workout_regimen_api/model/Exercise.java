package com.example.workout_regimen_api.model;

import com.example.workout_regimen_api.model.enumeration.ExerciseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name="exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    @NotBlank
    private String name;

    /**
     *  Contains a set of muscles worked during the exercise, as well as
     *  the relative percentage focus on each muscle worked by the exercise.
     * */
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private Set<WorkingMuscleLevel> musclesWorked;

    // Time (seconds) to complete one working set of 10 - 12 reps including rest time.
    @NotNull
    private int setDuration;

    @Enumerated(EnumType.STRING)
    private ExerciseType type;

    public Exercise() {};

    public Exercise(Set<WorkingMuscleLevel> musclesWorked, String name, int setDuration, ExerciseType type) {
        this.name = name;
        this.musclesWorked = musclesWorked;
        this.setDuration = setDuration;
        this.type = type;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<WorkingMuscleLevel> getMusclesWorked() {
        return musclesWorked;
    }

    public void setMusclesWorked(Set<WorkingMuscleLevel> musclesWorked) {
        this.musclesWorked = musclesWorked;
    }

    public int getSetDuration() {
        return setDuration;
    }

    public void setSetDuration(int setDuration) {
        this.setDuration = setDuration;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }
}
