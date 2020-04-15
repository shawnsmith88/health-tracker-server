package com.ss.healthtrackerserver.services;

import com.ss.healthtrackerserver.enums.Exchanges;
import com.ss.healthtrackerserver.enums.RoutingKeys;
import com.ss.healthtrackerserver.factories.MessageFactory;
import com.ss.healthtrackerserver.models.dtos.WorkoutDto;
import com.ss.healthtrackerserver.models.Workout;
import com.ss.healthtrackerserver.repositories.WorkoutRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
@SuppressWarnings("unused")
public class WorkoutService implements IWorkoutService {
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Transactional
    @Override
    public Workout addNewWorkout(WorkoutDto workoutDto) {
        Workout workout=new Workout();
        workout.addDto(workoutDto);
        workout=workoutRepository.save(workout);
        rabbitTemplate.convertAndSend(
                Exchanges.WORKOUTS,
                RoutingKeys.NEWWORKOUT,
                MessageFactory.generateWorkoutTypeMessage(workout.getType()));
        return workout;
    }
}
