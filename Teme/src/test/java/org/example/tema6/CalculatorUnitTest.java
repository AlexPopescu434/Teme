package org.example.tema6;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorUnitTest {

    @Before
    public void setUp() throws Exception {
        String expresieTest = "3m+2000mm-100cm";
    }

    @After
    public void tearDown() throws Exception {
        String expresieTest = null;
    }

    @Test
    public void verificaDaca_RezultatulDistanteiMetrice_EsteCorect() {
        String expresieTest = "3m+2000mm-1m";
        double rezultatObtinut = Calculator.calculeazaDistantaMetrica(expresieTest);
        assertEquals(4000, rezultatObtinut,0);

    }
}