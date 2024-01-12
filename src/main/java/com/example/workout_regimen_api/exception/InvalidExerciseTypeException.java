package com.example.workout_regimen_api.exception;

public class InvalidExerciseTypeException extends RuntimeException {

    public InvalidExerciseTypeException() {
        super();
    }

    public InvalidExerciseTypeException(String message) {
        super(message);
    }

    public InvalidExerciseTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
