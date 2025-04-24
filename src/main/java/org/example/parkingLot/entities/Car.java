package org.example.parkingLot.entities;

import org.example.parkingLot.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String licensePlate, VehicleType vehicleType) {
        super(licensePlate, vehicleType);
    }
}
