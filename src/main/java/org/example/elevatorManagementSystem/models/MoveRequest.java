package org.example.elevatorManagementSystem.models;

public class MoveRequest {
    private int sourceFloor;
    private int destinationFloor;

    public MoveRequest(int sourceFloor, int destinationFloor) {
        this.sourceFloor=sourceFloor;
        this.destinationFloor=destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
