package org.example.tema5_2;

public class Main {
    public static void main(String[] args) {
SalesReprezentative[] reprezentatives = {
        new SalesReprezentative("Alex", 10,576),
        new SalesReprezentative("Dan", 20,787),
        new SalesReprezentative("Ana", 30,67),
        new SalesReprezentative("Maria", 40,54)
        };


       SalesReprezentative sortResult = new SalesReprezentative();
       SalesReprezentative[] result = sortResult.bubbleSort(reprezentatives);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i].getNume() + " has made sales of :  " + result[i].totalSum());
        }
    }
}

