package org.example.parkingLot.entities;

import org.example.parkingLot.enums.VehicleType;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate=licensePlate;
        this.vehicleType=vehicleType;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }



}
