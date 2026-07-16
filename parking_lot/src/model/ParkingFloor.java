package model;

import java.util.*;

public class ParkingFloor {

    private int floorNo;

    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(int floorNo) {
        this.floorNo = floorNo;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

}