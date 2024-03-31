package pl.kurs.zad1.services;

import pl.kurs.zad1.models.Baby;
import pl.kurs.zad1.models.Mother;

import java.util.ArrayList;
import java.util.List;

public class BabiesDataCollector extends TxtDataCollector {
    private final String filePath;

    public BabiesDataCollector(String filePath) {
        this.filePath = filePath;
    }

    public List<Baby> getBabiesData(List<Mother> mothers) {
        List<String> unorderedBabiesData = separateDataStartingFromFirstLine(filePath);
        List<Baby> babies = new ArrayList<>();

        for (String line : unorderedBabiesData) {
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
