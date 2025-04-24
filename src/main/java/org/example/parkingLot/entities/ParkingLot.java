package org.example.parkingLot.entities;

import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(List<Level> levels) {
        this.levels=levels;
    }

    public static ParkingLot getInstance(List<Level> levels){
        if(instance==null) {
            instance=new ParkingLot(levels);
        }
        return instance;
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (Level level: levels){
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }
        System.out.println("Parking failed, no space available");
        return false;
    }

    public boolean unParkVehicle(String licensePlate) {
        for(Level level: levels){
            if(level.unParkVehicle(licensePlate)){
                return true;
            }
        }
        System.out.println("Vehicle not found");
        return false;
    }


}
