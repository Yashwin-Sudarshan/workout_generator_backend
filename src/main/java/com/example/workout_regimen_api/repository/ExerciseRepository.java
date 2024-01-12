package com.example.workout_regimen_api.repository;

import com.example.workout_regimen_api.model.Exercise;
import com.example.workout_regimen_api.model.enumeration.ExerciseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Set<Exercise> findAllByTypeIn(List<ExerciseType> types);
}
