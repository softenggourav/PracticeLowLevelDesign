package org.example.elevatorManagementSystem;

import org.example.elevatorManagementSystem.models.MoveRequest;
import org.example.elevatorManagementSystem.services.ElevatorService;

public class ElevatorManagementDemo {
    public static void main(String[] args) {
        ElevatorService elevatorService = new ElevatorService(0,12,2);
        elevatorService.handleMoveRequest(new MoveRequest(2,3));
        elevatorService.handleMoveRequest(new MoveRequest(1,5));

        for (int i = 0; i < 15; i++) {
            System.out.println("=== Time Step: " + (i + 1) + " ===");
            elevatorService.step(); // Each step simulates one unit of time
            try {
                Thread.sleep(1000); // Pause for 1 second between steps (optional for realism)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
