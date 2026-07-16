package service;
import model.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class TicketService {

    public double calculateFee(Ticket ticket){

        long hours = Duration.between(
                ticket.getEntryTime(),
                LocalDateTime.now())
                .toHours();

        return Math.max(1,hours)*20;
    }

}