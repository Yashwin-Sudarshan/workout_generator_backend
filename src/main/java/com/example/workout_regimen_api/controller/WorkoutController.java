package com.example.workout_regimen_api.controller;

import com.example.workout_regimen_api.model.Workout;
import com.example.workout_regimen_api.payload.GenerateWorkoutRequest;
import com.example.workout_regimen_api.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<?> generateWorkout(@Valid @RequestBody GenerateWorkoutRequest workoutRequest) {
        Workout generatedWorkout;

        Map<String, String> errorResponse = new HashMap<>();
        Map<String, Workout> response = new HashMap<>();

        try {
            generatedWorkout = workoutService.generateWorkout(workoutRequest);
        } catch (Exception e) {
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        response.put("workout", generatedWorkout);
        return ResponseEntity.ok(response);
    }
}
