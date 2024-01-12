package com.example.workout_regimen_api.model;

public class WorkingSet {

    private String exerciseName;

    private int minNumReps;

    private int maxNumReps;

    private int numSets;

    public WorkingSet(String exerciseName, int minNumReps, int maxNumReps, int numSets) {
        this.exerciseName = exerciseName;
        this.minNumReps = minNumReps;
        this.maxNumReps = maxNumReps;
        this.numSets = numSets;
    }

    public String getExercise() {
        return exerciseName;
    }

    public void setExercise(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getMinNumReps() {
        return minNumReps;
    }

    public void setMinNumReps(int minNumReps) {
        this.minNumReps = minNumReps;
    }

    public int getMaxNumReps() {
        return maxNumReps;
    }

    public void setMaxNumReps(int maxNumReps) {
        this.maxNumReps = maxNumReps;
    }

    public int getNumSets() {
        return numSets;
    }

    public void setNumSets(int numSets) {
        this.numSets = numSets;
    }
}