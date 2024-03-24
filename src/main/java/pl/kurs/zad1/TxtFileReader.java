package pl.kurs.zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TxtFileReader {
    private static List<String> getLinesFromText(String filePath) {
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

    public static List<Mother> getMothersInfo() {
        List<String> linesOfText = getLinesFromText("src/main/java/pl/kurs/zad1/mamy.txt");
        List<Mother> mothers = new ArrayList<>();

        for (String line : linesOfText) {
            String[] elements = line.split(" ");
            Mother mother = new Mother(Integer.parseInt(elements[0]), elements[1], Integer.parseInt(elements[2]));
            mothers.add(mother);
        }
        return mothers;
    }

    public static List<Baby> getBabiesAndTheirMotherInfo(List<Mother> mothers) {
        List<String> linesOfText = getLinesFromText("src/main/java/pl/kurs/zad1/noworodki.txt");
        List<Baby> babies = new ArrayList<>();

        for (String line : linesOfText) {
            String[] elements = line.split(" ");
            int motherId = Integer.parseInt(elements[6]);

            Mother mother = null;
            for (Mother m : mothers) {
                if (m.getId() == motherId) {
                    mother = m;
                    break;
                }
            }
            if (mother != null) {
                Baby baby = new Baby(Integer.parseInt(elements[0]), elements[1].charAt(0), elements[2], elements[3],
                        Double.parseDouble(elements[4]), Double.parseDouble(elements[5]), mother);
                babies.add(baby);
                mother.addBaby(baby);
            }

        }
        return babies;
    }


}
