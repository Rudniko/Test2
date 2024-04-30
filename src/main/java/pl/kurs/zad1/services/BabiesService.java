package pl.kurs.zad1.services;

import pl.kurs.zad1.datatypes.Baby;
import pl.kurs.zad1.datatypes.Gender;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BabiesService {
    public Baby findTallestGirl(List<Baby> babyList) {
        Baby tallestGirl = babyList.get(0);
        for (Baby b : babyList) {
            if (b.getHeight() > tallestGirl.getHeight() && b.getGender() == Gender.GIRL) {
                tallestGirl = b;
            }
        }
        return tallestGirl;
    }

    public Baby findTallestBoy(List<Baby> babyList) {
        Baby tallestBoy = babyList.get(0);
        for (Baby b : babyList) {
            if (b.getHeight() > tallestBoy.getHeight() && b.getGender() == Gender.BOY) {
                tallestBoy = b;
            }
        }
        return tallestBoy;
    }

    public DayOfWeek getDayOfWeekWithMostBirths(List<Baby> babyList) {
        int[] countedBirthsInWeekDays = getArrayWithCountedBirthsInWeekDays(babyList);

        DayOfWeek dayOfWeek = null;
        int maxBirthsCounter = 0;

        for (int i = 0; i < countedBirthsInWeekDays.length; i++) {
            if (countedBirthsInWeekDays[i] > maxBirthsCounter) {
                maxBirthsCounter = countedBirthsInWeekDays[i];
                dayOfWeek = DayOfWeek.of(i + 1);
            }
        }
        return dayOfWeek;
    }

    public int getAmountOfBirthsInDayOfWeek(List<Baby> babyList, DayOfWeek dayOfWeek) {
        int[] daysOfWeek = getArrayWithCountedBirthsInWeekDays(babyList);
        return daysOfWeek[dayOfWeek.getValue() - 1];
    }

    private int[] getArrayWithCountedBirthsInWeekDays(List<Baby> babyList) {
        int[] weekDaysCounter = new int[7]; //Mon - Su
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Baby b : babyList) {
            LocalDate birthDate = LocalDate.parse(b.getBirthDate(), dtf);
            DayOfWeek dayOfWeek = birthDate.getDayOfWeek();
            int index = dayOfWeek.getValue() - 1;
            weekDaysCounter[index]++;
        }
        return weekDaysCounter;
    }


    public List<Baby> getGirlsWhoInheritedNameFromTheirMother(List<Baby> babyList) {
        List<Baby> daughters = new ArrayList<>();
        for (Baby b : babyList) {
            if (b.getGender() == Gender.GIRL && b.getName().equals(b.getMother().getName())) {
                daughters.add(b);
            }
        }
        return daughters;
    }

}
