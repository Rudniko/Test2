package pl.kurs.zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TxtFileReader {
    private final String filePath;

    public TxtFileReader(String filePath) {
        this.filePath = filePath;
    }

    private List<String> getLinesFromText(String filePath) {
        List<String> linesOfText = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linesOfText.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return linesOfText;
    }

    public List<Mother> getMothersFromFile() {
        List<String> linesOfText = getLinesFromText(filePath);
        List<Mother> mothers = new ArrayList<>();

        for (String line : linesOfText) {
            String[] elements = line.split(" ");

            int id = Integer.parseInt(elements[0]);
            String name = elements[1];
            int age = Integer.parseInt(elements[2]);
            Mother mother = new Mother(id, name, age);
            mothers.add(mother);
        }
        return mothers;
    }

    public List<Baby> getBabiesFromFileAndTheirMothers(List<Mother> mothers) {
        List<String> linesOfText = getLinesFromText(filePath);
        List<Baby> babies = new ArrayList<>();

        for (String line : linesOfText) {
            String[] elements = line.split(" ");
            try {
                int id = Integer.parseInt(elements[0]);
                char gender = elements[1].charAt(0);
                String name = elements[2];
                Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(elements[3]);
                double weightG = Double.parseDouble(elements[4]);
                double heightCm = Double.parseDouble(elements[5]);
                int motherId = Integer.parseInt(elements[6]);
                Mother mother = null;

                for (Mother m : mothers) {
                    if (m.getId() == motherId) {
                        mother = m;
                        break;
                    }
                }
                if (mother != null) {
                    Baby baby = new Baby(id, gender, name, birthDate, weightG, heightCm, mother);
                    babies.add(baby);
                    mother.addBaby(baby);
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return babies;
    }


}
