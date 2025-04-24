package org.example.parkingLot;

import org.example.parkingLot.entities.*;
import org.example.parkingLot.enums.ParkingSpotType;
import org.example.parkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance(getLevels());

        Vehicle motorCycle1 = new MotorCycle("MOTOR123", VehicleType.MOTORCYCLE);
        Vehicle car1 = new Car("Car123", VehicleType.CAR);

        parkingLot.parkVehicle(motorCycle1);
        parkingLot.parkVehicle(car1);

        parkingLot.unParkVehicle("Car123");
        parkingLot.unParkVehicle("MOTOR321");

    }

    private static List<Level> getLevels() {
        List<Level> levels = new ArrayList<>();

        List<ParkingSpot> level1Spots = Arrays.asList(
                new ParkingSpot("L1S1", ParkingSpotType.SMALL),
                new ParkingSpot("L1S2", ParkingSpotType.MEDIUM),
                new ParkingSpot("L1S3", ParkingSpotType.LARGE)
        );
        Level level1 = new Level(1, level1Spots);
        levels.add(level1);

        List<ParkingSpot> level2Spots = Arrays.asList(
                new ParkingSpot("L2S1", ParkingSpotType.SMALL),
                new ParkingSpot("L2S2", ParkingSpotType.MEDIUM),
                new ParkingSpot("L2S3", ParkingSpotType.LARGE)
        );
        Level level2 = new Level(2, level2Spots);
        levels.add(level2);

        List<ParkingSpot> level3Spots = Arrays.asList(
                new ParkingSpot("L3S1", ParkingSpotType.SMALL),
                new ParkingSpot("L3S2", ParkingSpotType.MEDIUM),
                new ParkingSpot("L3S3", ParkingSpotType.LARGE)
        );
        Level level3 = new Level(3, level3Spots);
        levels.add(level3);

        return levels;
    }
}