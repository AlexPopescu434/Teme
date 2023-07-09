package org.example.tema5_2;

public class SalesReprezentative {

    private String nume;

    private int nrSales;

    private int quotaSales;


    public SalesReprezentative() {

    }

    public SalesReprezentative(String nume, int nrSales, int quotaSales) {
        this.nume = nume;
        this.nrSales = nrSales;
        this.quotaSales = quotaSales;
    }

    public int totalSum(){
        return nrSales * quotaSales;
    }

    public String getNume() {
        return nume;
    }

    public SalesReprezentative[] bubbleSort(SalesReprezentative[] Arraysales) {
        int n = Arraysales.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (Arraysales[j].totalSum() < Arraysales[j + 1].totalSum()) {
                    SalesReprezentative temp = Arraysales[j];
                    Arraysales[j] = Arraysales[j + 1];
                    Arraysales[j + 1] = temp;

                }
            }
        }
        return Arraysales;
    }
}




