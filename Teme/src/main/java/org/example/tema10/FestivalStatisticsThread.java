package org.example.tema10;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private volatile boolean shouldStop = false;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (!shouldStop) {
            try {
                Thread.sleep(5000);
                generateStatistics();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateStatistics() {
        Queue<TicketType> ticketQueue = gate.getTicketQueue();

        int totalParticipants = ticketQueue.size();
        int fullTickets = 0;
        int fullVipTickets = 0;
        int freePassTickets = 0;
        int oneDayTickets = 0;
        int oneDayVipTickets = 0;

        for (TicketType ticketType : ticketQueue) {
            switch (ticketType) {
                case FULL:
                    fullTickets++;
                    break;
                case FULL_VIP:
                    fullVipTickets++;
                    break;
                case FREE_PASS:
                    freePassTickets++;
                    break;
                case ONE_DAY:
                    oneDayTickets++;
                    break;
                case ONE_DAY_VIP:
                    oneDayVipTickets++;
                    break;
            }
        }

        System.out.println("Statistics:\n" +
                "Total participants: " + totalParticipants + "\n" +
                "Full tickets: " + fullTickets + "\n" +
                "Full VIP tickets: " + fullVipTickets + "\n" +
                "Free pass tickets: " + freePassTickets + "\n" +
                "One-day tickets: " + oneDayTickets + "\n" +
                "One-day VIP tickets: " + oneDayVipTickets + "\n");

        if (totalParticipants >= 100) {
            shouldStop = true;
            System.out.println("Processed 100 participants. The thread has been stopped!.");
        }
    }
}

