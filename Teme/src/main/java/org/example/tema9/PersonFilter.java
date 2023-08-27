package org.example.temajava8;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonFilter {

    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.csv";
        String targetMonth = "07";
        String outputFile = "src/main/resources/output.csv";

        filterPersonsByMonth(inputFile, targetMonth, outputFile);
    }

    public static void filterPersonsByMonth(String inputFile, String targetMonth, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            lines.stream()
                    .map(PersonFilter::parseLine)
                    .filter(person ->person.getMonth().equals(targetMonth))
                    .sorted(Comparator.comparing(Person::getFullName))
                    .forEach(person -> {
                        try {
                            writer.write(person.getFullName() + " " + person.getDateOfBirth());
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person parseLine(String line) {
        String[] parts = line.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String[] dateParts = parts[2].split("/");
        String dateOfBirth = dateParts[0] + "/" + dateParts[1] + "/" + dateParts[2];
        return new Person(firstName, lastName, dateOfBirth);
    }

}
