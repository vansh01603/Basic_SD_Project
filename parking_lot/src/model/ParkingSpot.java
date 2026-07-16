package model;

import enums.*;

public abstract class ParkingSpot {

    private int id;
    private SpotType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int id, SpotType type) {
        this.id = id;
        this.type = type;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public SpotType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        occupied = true;
    }

    public void removeVehicle() {
        vehicle = null;
        occupied = false;
    }

}