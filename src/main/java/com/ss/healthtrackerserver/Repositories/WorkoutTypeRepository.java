package com.ss.healthtrackerserver.Repositories;

import com.ss.healthtrackerserver.Models.WorkoutType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutTypeRepository extends MongoRepository<WorkoutType,String> {
}
