package org.example.tema;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AthleteList {

    TreeSet<Athlete> athletes = new TreeSet<>(new ComparatorByTIme());



    public void readAthletes() {
        File file = new File("src/main/resources/Athletes.csv");
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] input = line.split(",\\s*");
                if (input.length == 7) {
                    String athleteNumber = input[0].trim();
                    String athleteName = input[1].trim();
                    CountryCode countryCode = CountryCode.valueOf(input[2].trim());
                    String skiTimeResult = input[3].trim();
                    String firstShootingResult = input[4].trim();
                    String secondShootingResult = input[5].trim();
                    String thirdShootingResult = input[6].trim();

                    athletes.add(new Athlete(athleteNumber, athleteName, countryCode, skiTimeResult,
                            firstShootingResult, secondShootingResult, thirdShootingResult));
                } else {
                    System.out.println("Invalid data: " + line);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not accessible");
        }
    }

    public void printResults() {
        System.out.println("RESULTS:");
        int ranking = 1;
        for (Athlete athlete : athletes) {
            String athleteName = athlete.getAthleteName();
            int minutes = Integer.parseInt(athlete.getSkiTimeResult().split(":")[0]);
            int seconds = Integer.parseInt(athlete.getSkiTimeResult().split(":")[1]);
            int penalty = athlete.getPenalty();
            int totalTime = minutes * 60 + seconds + penalty;
            int totalTimeMinutes = totalTime/60;
            int totalTimeSeconds = totalTime%60;

            String rankingText;
            if (ranking == 1) {
                rankingText = "Winner";
            } else if (ranking == 2) {
                rankingText = "Runner-up";
            } else if (ranking == 3) {
                rankingText = "ThirdPlace";
            } else {
                rankingText = "Place " + ranking;
            }

            System.out.println(rankingText + " - " + athleteName + " " + totalTimeMinutes + ":" + totalTimeSeconds +
                    " (" + athlete.getSkiTimeResult() + " + " + penalty + ")");
            ranking++;
        }
    }
    public TreeSet<Athlete> getAthletes() {
        return athletes;
    }
}