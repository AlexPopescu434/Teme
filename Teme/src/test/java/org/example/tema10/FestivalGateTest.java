package org.example.tema10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FestivalGateTest {
    private FestivalGate gate;

    @BeforeEach
    void setUp() {
        gate = new FestivalGate();
    }

    @AfterEach
    void tearDown() {
        gate = null;
    }

    @Test
    void validateTicket() {
        gate.validateTicket(TicketType.FULL);
        gate.validateTicket(TicketType.ONE_DAY_VIP);

        assertEquals(2, gate.getTicketQueue().size());
    }

    @Test
    void testEmptyTicketQueue() {
        assertEquals(0, gate.getTicketQueue().size());
    }


}