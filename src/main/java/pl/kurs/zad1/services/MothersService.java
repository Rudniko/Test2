package pl.kurs.zad1.services;

import pl.kurs.zad1.models.Baby;
import pl.kurs.zad1.models.Mother;

import java.util.ArrayList;
import java.util.List;

public class MothersService {
    private final List<Mother> mothers;

    public MothersService(List<Mother> mothers) {
        this.mothers = mothers;
    }

    public List<Mother> findYoungMothersWhoBirthedHeavyChild() {
        List<Mother> youngMothers = new ArrayList<>();

        for (Mother m : mothers) {
            List<Baby> birthedBabies = m.getBabies();
            for (Baby b : birthedBabies) {
                if (m.getAge() < 25 && b.isBabyOver4000Grams()) {
                    youngMothers.add(m);
                }
            }
        }
        return youngMothers;
    }

    public List<Mother> findMothersWithTwins() {
        List<Mother> mothersWithTwins = new ArrayList<>();

        for (Mother m : mothers) {
            List<Baby> babies = m.getBabies();
            Baby baby = babies.get(0);
            for (int i = 1; i < babies.size(); i++) {
                if (babies.get(i).getBirthDate().equals(baby.getBirthDate())) {
                    mothersWithTwins.add(m);
                }
            }
        }
        return mothersWithTwins;
    }
}
