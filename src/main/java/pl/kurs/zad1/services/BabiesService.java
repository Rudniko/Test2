package pl.kurs.zad1.services;

import pl.kurs.zad1.models.Baby;

import java.util.ArrayList;
import java.util.List;

public class BabiesService {

    private final List<Baby> babies;

    public BabiesService(List<Baby> babies) {
        this.babies = babies;
    }

    public Baby findTallestGirl() {
        Baby tallestGirl = babies.get(0);
        for (Baby b : babies) {
            if (b.getHeightCm() > tallestGirl.getHeightCm() && !b.isBoy()) {
                tallestGirl = b;
            }
        }
        return tallestGirl;
    }

    public Baby findTallestBoy() {
        Baby tallestBoy = babies.get(0);
        for (Baby b : babies) {
            if (b.getHeightCm() > tallestBoy.getHeightCm() && b.isBoy()) {
                tallestBoy = b;
            }
        }
        return tallestBoy;
    }

    private int[] getArrayWithCountedBirthsInWeekDays() {
        int[] birthsInWeekDays = new int[7];
        for (Baby b : babies) {
            int dayOfWeek = b.getDayOfWeekOfBirthDate();
            dayOfWeek -= 2;
            if (dayOfWeek < 0) {
                dayOfWeek += 7;
            }
            birthsInWeekDays[dayOfWeek]++;
        }
        return birthsInWeekDays;
    }

    public int getDayOfWeekWithMostBirths() {
        int[] birthsInWeek = getArrayWithCountedBirthsInWeekDays();

        int dayOfWeekWithMostBirths = 0;
        int maxBirths = birthsInWeek[0];

        for (int i = 1; i < birthsInWeek.length; i++) {
            if (birthsInWeek[i] > maxBirths) {
                maxBirths = birthsInWeek[i];
                dayOfWeekWithMostBirths = i;
            }
        }
        return dayOfWeekWithMostBirths + 1;
    }

    public int getAmountOfBirthsInDay(int dayOfWeekWithMostBirths) {
        int[] births = getArrayWithCountedBirthsInWeekDays();
        return births[--dayOfWeekWithMostBirths];
    }

    public List<Baby> findDaughtersWithInheritedMotherNames() {
        List<Baby> daughters = new ArrayList<>();
        for (Baby b : babies) {
            if (b.doesDaughterInheritedMotherName()) {
                daughters.add(b);
            }
        }
        return daughters;
    }
}
