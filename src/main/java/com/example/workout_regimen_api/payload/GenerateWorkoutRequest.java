package com.example.workout_regimen_api.payload;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class GenerateWorkoutRequest {

    @NotNull
    private List<String> muscleGroups;

    @NotNull
    private List<String> bodyParts;

    @NotNull
    private List<String> duration;

    @NotNull
    private List<String> workoutType;

    public List<String> getMuscleGroups() {
        return muscleGroups;
    }

    public List<String> getBodyParts() {
        return bodyParts;
    }

    public List<String> getDuration() {
        return duration;
    }

    public List<String> getWorkoutType() {
        return workoutType;
    }
}
