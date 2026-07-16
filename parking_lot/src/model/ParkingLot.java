package model;

import java.util.*;
import service.*;

public class ParkingLot {

    private List<ParkingFloor> floors =
            new ArrayList<>();

    private ParkingStrategy strategy;

    public ParkingLot(ParkingStrategy strategy){

        this.strategy = strategy;

    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle){

        ParkingSpot spot =
                strategy.findSpot(floors,vehicle);

        if(spot==null){

            System.out.println("No Spot Available");
            return null;

        }

        spot.parkVehicle(vehicle);

        return new Ticket(vehicle,spot);

    }

    public void removeVehicle(Ticket ticket){

        ticket.getSpot().removeVehicle();

    }

}