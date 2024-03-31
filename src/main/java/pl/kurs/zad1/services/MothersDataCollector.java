package pl.kurs.zad1.services;

import pl.kurs.zad1.models.Mother;

import java.util.ArrayList;
import java.util.List;

public class MothersDataCollector extends TxtDataCollector {
    private final String filePath;

    public MothersDataCollector(String filePath) {
        this.filePath = filePath;
    }

    public List<Mother> getMothersData() {
        List<Mother> mothers = new ArrayList<>();
        List<String> unorderedMothersData = separateDataStartingFromFirstLine(filePath);

        for (String line : unorderedMothersData) {
            String[] elements = line.split(" ");
            Mother mother = new Mother(Integer.parseInt(elements[0]), elements[1], Integer.parseInt(elements[2]));
            mothers.add(mother);
        }
        return mothers;
    }
}
