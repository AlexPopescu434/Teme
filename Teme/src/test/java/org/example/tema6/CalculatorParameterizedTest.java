package org.example.tema6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "3m+2000mm-100cm, 4000.0",
            "10cm-2m, -1900.0",
            "5dm+1km-3m, 997500.0",
            "5cm+3cm+1cm-10mm, 80.0",
            "0m+0cm, 0.0"
    })
    public void testCalculeazaDistantaMetrica(String expresie, double rezultatAsteptat) {
        double rezultatObtinut = Calculator.calculeazaDistantaMetrica(expresie);
        assertEquals(rezultatAsteptat, rezultatObtinut, 0);
    }
}