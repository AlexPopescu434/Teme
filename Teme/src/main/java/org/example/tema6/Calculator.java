package org.example.tema6;

public class Calculator {
    public static void main(String[] args) {


        String expresie ="3cm+2cm+1cm-10mm";

        double rezultat = calculeazaDistantaMetrica(expresie);
        System.out.println("Rezultatul calculului este: " + rezultat + " mm.");
    }

    public static double calculeazaDistantaMetrica(String expresie) {

        expresie = expresie.replaceAll("\\s+", "");

        double rezultat = 0;
        char operator = '+';
        int index = 0;

        while (index < expresie.length()) {

            String numarStr = "";
            while (index < expresie.length() && Character.isDigit(expresie.charAt(index))) {
                numarStr += expresie.charAt(index);
                index++;
            }
            double numar = Double.parseDouble(numarStr);

            String unitateMasura = "";
            while (index < expresie.length() && Character.isLetter(expresie.charAt(index))) {
                unitateMasura += expresie.charAt(index);
                index++;
            }

            double finalUnit = 1.0;
            switch (unitateMasura) {
                case "mm":
                    finalUnit = 1;
                    break;
                case "cm":
                    finalUnit = 10;
                    break;
                case "dm":
                    finalUnit = 100;
                    break;
                case "m":
                    finalUnit = 1000;
                    break;
                case "km":
                    finalUnit = 1000000;
                    break;
            }

            switch (operator) {
                case '+':
                    rezultat += numar * finalUnit;
                    break;
                case '-':
                    rezultat -= numar * finalUnit;
                    break;
            }

            if (index < expresie.length()) {
                operator = expresie.charAt(index);
                index++;
            }
        }

        return rezultat;
    }
}
