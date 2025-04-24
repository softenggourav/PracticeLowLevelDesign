package org.example.elevatorManagementSystem.models;

import org.example.elevatorManagementSystem.enums.Direction;

import java.util.TreeSet;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private TreeSet<Integer> destinationFloors;


    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.destinationFloors = new TreeSet<>();
    }

    public void addDestination(int floor) {
        destinationFloors.add(floor);
        updateDirection();
    }

    public void move() {
        if(destinationFloors.isEmpty()){
            direction = Direction.IDLE;
            return;
        }
        if(direction == Direction.UP) {
            currentFloor++;
        }
        else if (direction==Direction.DOWN) {
            currentFloor--;
        }

        if(destinationFloors.contains(currentFloor)) {
            destinationFloors.remove(currentFloor);
            System.out.println("Elevator "+ id + " stopped at "+ currentFloor);
        }
        updateDirection();
    }

    public void updateDirection() {
        if(destinationFloors.isEmpty()) {
            direction=Direction.IDLE;
        } else if (currentFloor < destinationFloors.getFirst()) {
            direction=Direction.UP;
        } else if (currentFloor > destinationFloors.getLast()) {
            direction = Direction.DOWN;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
