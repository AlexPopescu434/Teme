package org.example.tema9.unittest;

import org.example.tema9.PersonFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFilterTest {

    private String inputFile;
    private String outputFile;

    @BeforeEach
    public void setUp() throws IOException {

        inputFile ="src/test/java/test_input_temp.csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
        writer.write("Daniel Popescu 1978/03/28\n");
        writer.write("Bogdan Simion 1990/07/10\n");
        writer.write("Alex Petrescu 1992/09/20\n");
        writer.write("Ionut Vasile 1975/03/14\n");
        writer.close();

        outputFile ="src/test/java/test_output_temp.csv";
    }

    @AfterEach
    public void tearDown() {

        File inputFileObj = new File(inputFile);
        File outputFileObj = new File(outputFile);
       //  nputFileObj.delete();
       //  outputFileObj.delete();
    }

    @Test
    public void testFilterBirthdaysByMonth() {

        PersonFilter.filterPersonsByMonth(inputFile, "03", outputFile);

        List<String> outputData = readOutputFile(outputFile);

        assertEquals(2, outputData.size());
        assertEquals("Daniel Popescu 1978/03/28", outputData.get(0));
        assertEquals("Ionut Vasile 1975/03/14", outputData.get(1));
    }

    @Test
    public void testFilterBirthdaysByNonExistentMonth() {

        PersonFilter.filterPersonsByMonth(inputFile, "13", outputFile);

        List<String> outputData = readOutputFile(outputFile);

        assertEquals(0, outputData.size());
    }

    private List<String> readOutputFile(String outputFile) {
        List<String> outputData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                outputData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputData;
    }
}