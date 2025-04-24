package org.example.parkingLot.entities;

import java.util.List;

public class Level {
    private final int levelNumber;
    private final List<ParkingSpot> spots;

    public Level(int levelNumber, List<ParkingSpot> spots) {
        this.levelNumber = levelNumber;
        this.spots = spots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.parkVehicle(vehicle)) {
                System.out.println("Parked at level: " + levelNumber + " spot: " + spot.getId());
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getCurrentVehicle().getLicensePlate().equals(licensePlate)) {
                spot.removeVehicle();
                System.out.println("UnParked from Level: " + levelNumber + " spot: " + spot.getId());
                return true;
            }
        }
        return false;
    }
    public int getLevelNumber(){
        return levelNumber;
    }


}
