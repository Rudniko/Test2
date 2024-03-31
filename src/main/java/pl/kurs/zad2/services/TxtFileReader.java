package pl.kurs.zad2.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TxtFileReader {
    public List<String> separateDataPassingTheFirstLine(String filePath) {

        List<String> linesOfText = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))
        ) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linesOfText.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return linesOfText;
    }
}
