package pl.kurs.zad1.services;

import pl.kurs.zad1.datatypes.Mother;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MothersDataReader {
    public List<Mother> getMotherListFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Nie instnieje plik do oczytu o takiej nazwie!");
        }

        List<Mother> mothers = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                mothers.add(createMotherFromLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mothers;
    }

    private Mother createMotherFromLine(String line) {
        String[] elements = line.split(" ");

        int id = Integer.parseInt(elements[0]);
        String name = elements[1];
        int age = Integer.parseInt(elements[2]);
        return new Mother(id, name, age);
    }
}
