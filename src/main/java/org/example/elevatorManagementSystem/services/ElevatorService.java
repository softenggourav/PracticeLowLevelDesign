package org.example.elevatorManagementSystem.services;

import org.example.elevatorManagementSystem.enums.Direction;
import org.example.elevatorManagementSystem.models.Elevator;
import org.example.elevatorManagementSystem.models.MoveRequest;

import java.util.ArrayList;
import java.util.List;

public class ElevatorService {
    private int bottomFloor;
    private int topFloor;
    private List<Elevator> elevators;

    public ElevatorService(int bottomFloor, int topFloor, int numberOfElevator) {
        this.bottomFloor=bottomFloor;
        this.topFloor=topFloor;
        elevators = new ArrayList<>();
        for(int i=0;i<numberOfElevator;i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void handleMoveRequest(MoveRequest request) {
        Elevator bestElevator = findBestElevator(request);
        if(bestElevator!=null) {
            bestElevator.addDestination(request.getSourceFloor());
            bestElevator.addDestination(request.getDestinationFloor());
        }

    }

    private Elevator findBestElevator(MoveRequest request) {
        for(Elevator elevator: elevators){
            if(elevator.getDirection()== Direction.IDLE) {
                return elevator;
            }
        }

        Elevator closest = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator: elevators) {
            int distance = Math.abs(elevator.getCurrentFloor()-request.getSourceFloor());
            if(distance<minDistance){
                closest=elevator;
                minDistance=distance;
            }
        }

        return closest;
    }

    public void step() {
        for(Elevator elevator: elevators) {
            elevator.move();
        }
    }
}
