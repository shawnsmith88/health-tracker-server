package com.ss.healthtrackerserver.factories;

public class MessageFactory {
    public static String generateWorkoutTypeMessage(String workoutType) {
        return "{\"workoutType\":\"" + workoutType + "\"}";
    }
}
