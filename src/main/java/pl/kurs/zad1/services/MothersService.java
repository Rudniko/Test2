package pl.kurs.zad1.services;

import pl.kurs.zad1.datatypes.Baby;
import pl.kurs.zad1.datatypes.Mother;

import java.util.ArrayList;
import java.util.List;

public class MothersService {

    public List<Mother> getMothersUnder25WhoBirthedBabyOver4000g(List<Mother> motherList) {
        List<Mother> mothers = new ArrayList<>();

        for (Mother m : motherList) {
            if (m.getAge() < 25 && doesMotherHadABabyThatWeightOver4000g(m.getBabies())){
                mothers.add(m);
            }
        }
        return mothers;
    }

    private boolean doesMotherHadABabyThatWeightOver4000g(List<Baby> babyList) {
        for (Baby b : babyList) {
            if (b.getWeight() > 4000) {
                return true;
            }
        }
        return false;
    }

    public List<Mother> findMothersWhoBirthedTwins(List<Mother> motherList) {
        List<Mother> mothersWithTwins = new ArrayList<>();

        for (Mother m : motherList) {
            if (doesMotherHaveTwins(m.getBabies())) {
                mothersWithTwins.add(m);
            }
        }
        return mothersWithTwins;
    }

    private boolean doesMotherHaveTwins(List<Baby> babyList) {

        for (int i = 0; i < babyList.size() - 1; i++) {
            for (int j = i + 1; j < babyList.size(); j++) {
                if (babyList.get(i).getBirthDate().equals(babyList.get(j).getBirthDate())) {
                    return true;
                }
            }
        }
        return false;
    }
}