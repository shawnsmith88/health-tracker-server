package com.ss.healthtrackerserver.Controllers.api;

import com.ss.healthtrackerserver.Models.DTOs.WorkoutTypeDto;
import com.ss.healthtrackerserver.Models.WorkoutType;
import com.ss.healthtrackerserver.Repositories.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class WorkoutTypeAPI {
    @Autowired
    WorkoutTypeRepository workoutTypeRepository;

    @GetMapping
    @CrossOrigin(origins = {"*"})
    public List<WorkoutType> getAll(){
        return workoutTypeRepository.findAll();
    }
    @PostMapping
    @CrossOrigin(origins = {"*"})
    public WorkoutType addType(@RequestBody WorkoutTypeDto workoutTypeDto){
        WorkoutType workoutType=new WorkoutType();
        workoutType.addByDto(workoutTypeDto);
        workoutType=workoutTypeRepository.save(workoutType);
        return workoutType;
    }
    @DeleteMapping("all")
    public void deleteAll(){
        workoutTypeRepository.deleteAll();
    }
}
