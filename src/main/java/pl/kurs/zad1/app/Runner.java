package pl.kurs.zad1.app;


import pl.kurs.zad1.models.Baby;
import pl.kurs.zad1.models.Mother;
import pl.kurs.zad1.services.BabiesDataCollector;
import pl.kurs.zad1.services.BabiesService;
import pl.kurs.zad1.services.MothersDataCollector;
import pl.kurs.zad1.services.MothersService;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;


public class Runner {
    public static void main(String[] args) {

        MothersDataCollector mothersDataCollector = new MothersDataCollector("src/main/java/pl/kurs/zad1/mamy.txt");
        BabiesDataCollector babiesDataCollector = new BabiesDataCollector("src/main/java/pl/kurs/zad1/noworodki.txt");

        List<Mother> mothers = mothersDataCollector.getMothersData();
        List<Baby> babies = babiesDataCollector.getBabiesData(mothers);

        BabiesService babiesService = new BabiesService(babies);
        MothersService mothersService = new MothersService(mothers);


        Baby tallestBoy = babiesService.findTallestBoy();
        Baby tallestGirl = babiesService.findTallestGirl();
        System.out.println("Najwyższy chłopiec to " + tallestBoy.getName() + " i ma " + tallestBoy.getHeightCm() + " cm wzrostu.");
        System.out.println("Najwyższa dziewczynka to " + tallestGirl.getName() + " i ma " + tallestGirl.getHeightCm() + " cm wzrostu.");


        int dayOfWeekWithMostBirths = babiesService.getDayOfWeekWithMostBirths();
        DayOfWeek nameOfDayWithMostBirths = DayOfWeek.of(dayOfWeekWithMostBirths);
        int amountOfBirths = babiesService.getAmountOfBirthsInDay(dayOfWeekWithMostBirths);

        System.out.println("Dzień tygodnia, w którym urodziło się najwięcej dzieci to " + nameOfDayWithMostBirths.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pl-PL"))
                + " z ich liczbą wynoszącą " + amountOfBirths);


        List<Mother> youngMothers = mothersService.findYoungMothersWhoBirthedHeavyChild();
        System.out.print("Kobiety w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g: ");
        for (Mother m : youngMothers) {
            System.out.print(m.getName() + ", ");
        }

        System.out.println("");


        List<Baby> daughtersWithInheritedMotherName = babiesService.findDaughtersWithInheritedMotherNames();
        System.out.print("Dziewczynki, które odziedziczyły imię po matce i ich daty urodzenia to: ");
        for (Baby b : daughtersWithInheritedMotherName) {
            System.out.print(b.getName() + " " + b.getBirthDate() + ", ");
        }

        System.out.println("");



        List<Mother> mothersWithTwins = mothersService.findMothersWithTwins();
        System.out.print("Mamy, które urodziły bliźnięta to: ");
        for (Mother m : mothersWithTwins) {
            System.out.print(m.getName() + ", ");
        }
    }

}
