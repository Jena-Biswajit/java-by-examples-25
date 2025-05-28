package com.example.factory.factorymodel;

import com.example.factory.contracts.Vehicle;
import com.example.factory.models.Bike;
import com.example.factory.models.Car;
import com.example.factory.models.Truck;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType){
        if (vehicleType.equals("Car")){
            return new Car();
        } else if (vehicleType.equals("Truck")) {
            return new Truck();
        } else if (vehicleType.equals("Bike")) {
            return new Bike();
        }
        else{
            throw new IllegalArgumentException("unknown vehicle type");
        }
    }
}
