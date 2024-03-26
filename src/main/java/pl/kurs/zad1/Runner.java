package pl.kurs.zad1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Mother> mothers = TxtFileReader.getMothersInfo();
        List<Baby> babies = TxtFileReader.getBabiesAndTheirMotherInfo(mothers);

        showNameAndHeightFromTallestBabies(babies);
        System.out.println("-----------");
        showDayOfWeekWithMostBirths(babies);
        System.out.println("-----------");
        showNamesOfYoungMothersWhoGaveBirthToAHeavyChild(mothers);
        System.out.println("-----------");
        printDaughterInheritedNamesAndTheirBirthDates(babies);
        System.out.println("-----------");
        showMothersWithTwins(mothers);


    }

    //a)
    static void showNameAndHeightFromTallestBabies(List<Baby> babies) {
        Baby tallestBoy = babies.get(0);
        Baby tallestGirl = babies.get(0);

        for (Baby b : babies) {
            if (b.getHeightCm() > tallestBoy.getHeightCm() && Baby.isBoy(b)) {
                tallestBoy = b;
            }
            if (b.getHeightCm() > tallestGirl.getHeightCm() && !(Baby.isBoy(b))) {
                tallestGirl = b;
            }
        }
        System.out.println("Najwyższy chłopiec ma na imię: " + tallestBoy.getName() + " i ma " + tallestBoy.getHeightCm() + " cm wzrostu");
        System.out.println("Najwyższa dziewczynka ma na imię: " + tallestGirl.getName() + " i ma " + tallestGirl.getHeightCm() + " cm wzrostu");
    }

    //b)
    static void showDayOfWeekWithMostBirths(List<Baby> babies) {
        int[] birthsInWeekDays = showBirthsInWeekDays(babies);
        int mostBirths = 0;
        int dayWithMostBirths = 0;
        for (int i = 0; i < birthsInWeekDays.length; i++) {
            if (birthsInWeekDays[i] > mostBirths) {
                mostBirths = birthsInWeekDays[i];
                dayWithMostBirths = i;
            }
        }
        String[] weekDays = new String[]{"poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela"};
        System.out.println("Dzień z największą liczbą urodzeń to " + weekDays[dayWithMostBirths] + ", liczba urodzonych dzieci to: " + mostBirths);


    }

    static int[] showBirthsInWeekDays(List<Baby> babies) {
        int[] birthsInWeekDays = new int[7];
        for (Baby b : babies) {
            try {
                Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(b.getBirthDate());
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(sdf);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                dayOfWeek -= 2;

                if (dayOfWeek < 0) {
                    dayOfWeek += 7;
                }
                birthsInWeekDays[dayOfWeek]++;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return birthsInWeekDays;
    }

    //c)
    static void showNamesOfYoungMothersWhoGaveBirthToAHeavyChild(List<Mother> mothers) {
        StringBuilder motherNames = new StringBuilder();
        for (Mother mother : mothers) {
            List<Baby> birthedBabies = mother.getBabies();
            for (Baby baby : birthedBabies) {
                if (mother.getAge() < 25 && Baby.isBabyOver4000Grams(baby)) {
                    motherNames.append(mother.getName()).append(", ");
                }
            }
        }
        System.out.println("Kobiety, które urodziły dzieci o wadze powyżej 4000g mając mniej niż 25 lat to: " + motherNames);

    }

    //d)
    static boolean doesDaughterInheritedMotherName(Baby baby) {
        if (!(Baby.isBoy(baby))) {
            return baby.getName().equals(baby.getMother().getName());
        }
        return false;
    }

    static void printDaughterInheritedNamesAndTheirBirthDates(List<Baby> babies) {
        StringBuilder babiesNames = new StringBuilder();
        for (Baby b : babies) {
            if (doesDaughterInheritedMotherName(b)) {
                babiesNames.append(b.getName()).append(" urodzona ").append(b.getBirthDate()).append(", ");
            }
        }
        System.out.println("Dziewczynki, które odziedziczyły imię po matce oraz ich daty urodzenia to: " + babiesNames);
    }

    //e)
    static void showMothersWithTwins(List<Mother> mother) {
        StringBuilder motherWithTwins = new StringBuilder();
        for (Mother m : mother) {
            List<Baby> babies = m.getBabies();
            String birthDate = babies.get(0).getBirthDate();
            for (int i = 1; i < babies.size(); i++) {
                if (babies.get(i).getBirthDate().equals(birthDate)) {
                    motherWithTwins.append(m.getName()).append(" id:").append(m.getId()).append(", ");
                }
            }

        }
        System.out.println("Mamy, które urodziły bliźnięta to: " + motherWithTwins);

    }


}



