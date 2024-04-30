package pl.kurs.zad2.services;

import pl.kurs.zad2.datatypes.HomeVisit;

import java.util.List;

public class HomeVisitService {
    private int countSpecialityOccurrence(List<HomeVisit> homeVisits, String speciality) {
        int counter = 0;
        for (HomeVisit h : homeVisits) {
            if (h.getDoctor().getSpeciality().equals(speciality)) {
                counter++;
            }
        }
        return counter;
    }

    public String findMostPopularSpeciality(List<HomeVisit> homeVisits) {
        String mostPopularSpeciality = homeVisits.get(0).getDoctor().getSpeciality();
        int mostOccurredTimes = 0;

        for (HomeVisit h : homeVisits) {
            int occurredTimes = countSpecialityOccurrence(homeVisits, h.getDoctor().getSpeciality());
            if (occurredTimes > mostOccurredTimes) {
                mostOccurredTimes = occurredTimes;
                mostPopularSpeciality = h.getDoctor().getSpeciality();
            }
        }
        return mostPopularSpeciality;
    }

    private int countYearOccurrence(List<HomeVisit> homeVisits, String date) {
        int counter = 0;
        for (HomeVisit h : homeVisits) {
            if (h.getVisitDate().substring(0, 4).equals(date)) {
                counter++;
            }
        }
        return counter;
    }


    public int getYearWithMostVisits(List<HomeVisit> homeVisits) {
        int yearWithMostVisits = 0;
        int mostOccuredTimes = 0;

        for (HomeVisit h : homeVisits) {
            int occurredTimes = countYearOccurrence(homeVisits, h.getVisitDate().substring(0, 4));
            if (occurredTimes > mostOccuredTimes) {
                mostOccuredTimes = occurredTimes;
                yearWithMostVisits = Integer.parseInt(h.getVisitDate().substring(0, 4));
            }
        }
        return yearWithMostVisits;
    }


}
