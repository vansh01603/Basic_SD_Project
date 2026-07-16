package service;
import model.*;
import java.util.*;
public class NearestParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors,
                                Vehicle vehicle) {

        for(ParkingFloor floor : floors){

            for(ParkingSpot spot : floor.getSpots()){

                if(!spot.isOccupied()
                        &&
                        spot.getType().name()
                                .equals(vehicle.getType().name())){

                    return spot;
                }

            }

        }

        return null;
    }
}