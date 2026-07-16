import java.util.*;

import model.*;
import service.*;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot(new NearestParkingStrategy());

        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addSpot(new BikeSpot(1));
        floor1.addSpot(new BikeSpot(2));
        floor1.addSpot(new CarSpot(3));
        floor1.addSpot(new CarSpot(4));
        floor1.addSpot(new TruckSpot(5));

        parkingLot.addFloor(floor1);

        TicketService ticketService = new TicketService();

        Map<Integer, Ticket> activeTickets = new HashMap<>();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     PARKING LOT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nVehicle Type");
                    System.out.println("1. Bike");
                    System.out.println("2. Car");
                    System.out.println("3. Truck");
                    System.out.print("Choice: ");

                    int type = sc.nextInt();

                    System.out.print("Enter Vehicle Number: ");
                    String number = sc.next();

                    Vehicle vehicle = null;

                    switch (type) {
                        case 1:
                            vehicle = new Bike(number);
                            break;
                        case 2:
                            vehicle = new Car(number);
                            break;
                        case 3:
                            vehicle = new Truck(number);
                            break;
                        default:
                            System.out.println("Invalid Vehicle Type");
                            continue;
                    }

                    Ticket ticket = parkingLot.parkVehicle(vehicle);

                    if (ticket != null) {

                        activeTickets.put(ticket.getTicketId(), ticket);

                        System.out.println("\nVehicle Parked Successfully");
                        System.out.println("Ticket ID : " + ticket.getTicketId());
                        System.out.println("Spot ID   : " + ticket.getSpot().getId());

                    }

                    break;

                case 2:

                    System.out.print("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();

                    Ticket removeTicket = activeTickets.get(ticketId);

                    if (removeTicket == null) {

                        System.out.println("Invalid Ticket.");

                    } else {

                        double fee = ticketService.calculateFee(removeTicket);

                        parkingLot.removeVehicle(removeTicket);

                        activeTickets.remove(ticketId);

                        System.out.println("Vehicle Removed Successfully");
                        System.out.println("Parking Fee : ₹" + fee);
                    }

                    break;

                case 3:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}