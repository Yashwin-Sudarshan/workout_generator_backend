package com.example.workout_regimen_api.model;

import java.util.List;

public class Workout {

    private List<WorkingSet> workingSets;

    public Workout(List<WorkingSet> workingSets) {
        this.workingSets = workingSets;
    }

    public List<WorkingSet> getWorkingSets() {
        return workingSets;
    }

    public void setWorkingSets(List<WorkingSet> workingSets) {
        this.workingSets = workingSets;
    }
}
