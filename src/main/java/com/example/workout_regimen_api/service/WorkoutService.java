package com.example.workout_regimen_api.service;

import com.example.workout_regimen_api.exception.InvalidExerciseTypeException;
import com.example.workout_regimen_api.model.Exercise;
import com.example.workout_regimen_api.model.WorkingSet;
import com.example.workout_regimen_api.model.Workout;
import com.example.workout_regimen_api.model.enumeration.ExerciseType;
import com.example.workout_regimen_api.payload.GenerateWorkoutRequest;
import com.example.workout_regimen_api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class WorkoutService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public WorkoutService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Workout generateWorkout(GenerateWorkoutRequest workoutRequest) {
        Set<Exercise> exercises;
        List<ExerciseType> exerciseTypes;

        try {
            exerciseTypes = workoutRequest.getWorkoutType().stream()
                    .map(ExerciseType::valueOf)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new InvalidExerciseTypeException("Invalid workout type");
        }

        exercises = exerciseRepository.findAllByTypeIn(exerciseTypes);

        // Generate working sets
        List<WorkingSet> workingSets = new ArrayList<>();
        for (Exercise exercise: exercises) {
            workingSets.add(new WorkingSet(exercise.getName(), 8, 12, 4));
        }

        return new Workout(workingSets);
    }
}
