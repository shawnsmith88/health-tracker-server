package com.ss.healthtrackerserver.Models.DTOs;

public class WorkoutDto {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String workoutType) {
        this.type = workoutType;
    }
}
