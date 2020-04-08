package com.ss.healthtrackerserver.Models;

import com.ss.healthtrackerserver.Models.DTOs.WorkoutTypeDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkoutType {
    @Id
    private String id;

    private String type;

    public void addByDto(WorkoutTypeDto workoutTypeDto){
        this.type=workoutTypeDto.getType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
