package com.ss.healthtrackerserver.services;

import com.ss.healthtrackerserver.models.dtos.WorkoutDto;
import com.ss.healthtrackerserver.models.Workout;

public interface IWorkoutService {
    Workout addNewWorkout(WorkoutDto workoutDto);
}
