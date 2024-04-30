package pl.kurs.zad1.services;

import pl.kurs.zad1.datatypes.Baby;
import pl.kurs.zad1.datatypes.Gender;
import pl.kurs.zad1.datatypes.Mother;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BabiesDataReader {

    public List<Baby> getBabyListFromFile(String filePath, List<Mother> mothers) {

        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Nie instnieje plik do oczytu o takiej nazwie!");
        }

        List<Baby> babies = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                babies.add(createBabyFromLine(line, mothers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return babies;
    }

    private Baby createBabyFromLine(String line, List<Mother> mothers) {
        String[] elements = line.split(" ");

        int id = Integer.parseInt(elements[0]);
        Gender gender = elements[1].equals("c") ? Gender.GIRL : Gender.BOY;
        String name = elements[2];
        String birthDate = elements[3];
        double weight = Double.parseDouble(elements[4]);
        double height = Double.parseDouble(elements[5]);
        int motherId = Integer.parseInt(elements[6]);

        Mother mother = findMotherById(mothers, motherId);

        if (mother != null) {
            Baby baby = new Baby(id, gender, name, birthDate, weight, height, mother);
            mother.addBaby(baby);
            return baby;
        }
        return null;

    }

    private Mother findMotherById(List<Mother> mothers, int motherId) {
        for (Mother m : mothers) {
            if (m.getId() == motherId) {
                return m;
            }
        }
        return null;
    }
}
