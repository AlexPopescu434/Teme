package org.example.festival;

import java.util.Random;

public class CheckFestivalTickets {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        Random random = new Random();
        int numParticipants = 100;

        for (int i = 0; i < numParticipants; i++) {
            TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
            FestivalAttendeeThread participant = new FestivalAttendeeThread(ticketType, gate);
            participant.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}