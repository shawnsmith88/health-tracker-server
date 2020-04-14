package com.ss.healthtrackerserver.repositories;

import com.ss.healthtrackerserver.models.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout,String> {
    public Workout getByName(@Param("name") String name);
}
