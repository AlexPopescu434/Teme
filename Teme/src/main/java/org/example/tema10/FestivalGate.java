package org.example.tema10;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    private Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void validateTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public synchronized Queue<TicketType> getTicketQueue() {
        return new LinkedList<>(ticketQueue);
    }
}
