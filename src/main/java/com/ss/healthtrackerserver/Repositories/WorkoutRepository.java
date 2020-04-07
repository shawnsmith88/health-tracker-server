package com.ss.healthtrackerserver.Repositories;

import com.ss.healthtrackerserver.Models.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout,String> {
    public Workout getByName(@Param("name") String name);
}
