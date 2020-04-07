package com.ss.healthtrackerserver.Controllers.api;

import com.ss.healthtrackerserver.Models.DTOs.WorkoutDto;
import com.ss.healthtrackerserver.Models.Workout;
import com.ss.healthtrackerserver.Repositories.WorkoutRepository;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutAPI {
    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping("/workout")
    public ResponseEntity<List<Workout>> getWorkouts(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");
        httpHeaders.add("Access-Control-Allow-Origin","*");
        return ResponseEntity.ok().headers(httpHeaders).body(workoutRepository.findAll());
    }
    @PostMapping("/workout")
    @CrossOrigin(origins={"*"})
    public ResponseEntity<Workout> addWorkout(@RequestBody WorkoutDto workoutDto){
        Workout workout=new Workout();
        workout.addDto(workoutDto);
        workout=workoutRepository.save(workout);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(workout);
    }
    @PutMapping("/workout")
    @CrossOrigin(origins = {"*"})
    public Workout updateWorkout(@RequestBody Workout workout){
        return workoutRepository.save(workout);
    }
    @DeleteMapping("/workout")
    @CrossOrigin(origins = {"*"})
    public void deleteOne(@RequestParam("id") String id){
        workoutRepository.deleteById(id);
    }
    @DeleteMapping("/workout/deleteall")
    public ResponseEntity<String> deleteAll(){
        workoutRepository.deleteAll();
        return ResponseEntity.ok("{\"response\":\"ok\"}");
    }
}
