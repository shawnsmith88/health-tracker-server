package com.ss.healthtrackerserver.services;

import com.ss.healthtrackerserver.models.dtos.WorkoutDto;
import com.ss.healthtrackerserver.models.Workout;
import com.ss.healthtrackerserver.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkoutService implements IWorkoutService {
    @Autowired
    WorkoutRepository workoutRepository;
    @Transactional
    @Override
    public Workout addNewWorkout(WorkoutDto workoutDto) {
        Workout workout=new Workout();
        workout.addDto(workoutDto);
        workout=workoutRepository.save(workout);
        return workout;
    }
}
