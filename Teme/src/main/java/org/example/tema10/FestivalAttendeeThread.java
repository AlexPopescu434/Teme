package org.example.tema10;

public class FestivalAttendeeThread extends Thread {
    private final FestivalGate gate;
    private final TicketType ticketType;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.gate = gate;
        this.ticketType = ticketType;
    }

    @Override
    public void run() {

        gate.validateTicket(ticketType);
        System.out.println(Thread.currentThread().getName() + ": Validated " + ticketType + " ticket");
    }
}