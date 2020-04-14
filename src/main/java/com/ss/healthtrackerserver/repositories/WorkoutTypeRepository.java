package com.ss.healthtrackerserver.repositories;

import com.ss.healthtrackerserver.models.WorkoutType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutTypeRepository extends MongoRepository<WorkoutType,String> {
}
