package model;

import enums.*;

import java.time.LocalDateTime;

public class Ticket {

    private static int counter = 1;

    private int ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle,
                  ParkingSpot spot){

        this.ticketId = counter++;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();

    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}