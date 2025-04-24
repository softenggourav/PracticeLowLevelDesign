package org.example.parkingLot.entities;

import org.example.parkingLot.enums.ParkingSpotType;

public class ParkingSpot {
    private final String id;
    private final ParkingSpotType spotType;
    private boolean isOccupied;
    private Vehicle currentVehicle;

    public ParkingSpot(String id, ParkingSpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.isOccupied = false;
        this.currentVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case MOTORCYCLE:
                return true;
            case CAR:
                return spotType == ParkingSpotType.MEDIUM || spotType == ParkingSpotType.LARGE;
            case TRUCK:
                return spotType == ParkingSpotType.LARGE;
        }
        return false;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied && canFitVehicle(vehicle)) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void removeVehicle() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }

    public String getId() {
        return id;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
