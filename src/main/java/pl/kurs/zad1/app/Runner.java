package pl.kurs.zad1.app;

import pl.kurs.zad1.datatypes.Baby;
import pl.kurs.zad1.datatypes.Mother;
import pl.kurs.zad1.services.BabiesDataReader;
import pl.kurs.zad1.services.BabiesService;
import pl.kurs.zad1.services.MothersDataReader;
import pl.kurs.zad1.services.MothersService;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        MothersDataReader mdr = new MothersDataReader();
        BabiesDataReader bdr = new BabiesDataReader();

        List<Mother> mothers = mdr.getMotherListFromFile("mamy.txt");
        List<Baby> babies = bdr.getBabyListFromFile("noworodki.txt", mothers);

        BabiesService bs = new BabiesService();
        MothersService ms = new MothersService();


        Baby tallestBoy = bs.findTallestBoy(babies);
        Baby tallestGirl = bs.findTallestGirl(babies);
        System.out.println("Najwyższy chłopiec to " + tallestBoy.getName() + " i ma " + tallestBoy.getHeight() + "cm wzrostu");
        System.out.println("Najwyższa dziewczynka to " + tallestGirl.getName() + " i ma " + tallestGirl.getHeight() + "cm wzrostu");


        DayOfWeek dayOfWeekWithMostBirths = bs.getDayOfWeekWithMostBirths(babies);
        int amountOfBirths = bs.getAmountOfBirthsInDayOfWeek(babies, dayOfWeekWithMostBirths);
        System.out.println("Dzień tygodnia z największą liczbą urodzeń to " + dayOfWeekWithMostBirths.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pl-PL"))
                + " z ich liczbą wynoszącą " + amountOfBirths);


        List<Mother> youngMothers = ms.getMothersUnder25WhoBirthedBabyOver4000g(mothers);

        if (youngMothers.isEmpty()) {
            System.out.println("Nie ma kobiet, które urodziły dziecko ważące powyżej 4000g mając mniej niż 25 lat");
        } else {
            System.out.println("Kobiety w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000g to: ");
            for (Mother m : youngMothers) {
                System.out.print(m.getName() + ", ");
            }
        }
        System.out.println("");


        List<Baby> daughtersWithInheritedMotherNames = bs.getGirlsWhoInheritedNameFromTheirMother(babies);

        if (daughtersWithInheritedMotherNames.isEmpty()) {
            System.out.println("Nie ma dziewczynek, które odziedziczyły imię po matce");
        } else {
            System.out.println("Dziewczynki, które odziedziczyły imię po matce to: ");
            for (Baby b : daughtersWithInheritedMotherNames) {
                System.out.print(b.getName() + " urodzona " + b.getBirthDate() + ", ");
            }
        }
        System.out.println("");


        List<Mother> mothersWithTwins = ms.findMothersWhoBirthedTwins(mothers);

        if (mothersWithTwins.isEmpty()) {
            System.out.println("Nie ma matek, które urodziły bliźnięta");
        } else {
            System.out.println("Mamy, które urodziły bliźnięta to: ");
            for (Mother m : mothersWithTwins) {
                System.out.print(m + ", ");
            }
        }


    }

}
