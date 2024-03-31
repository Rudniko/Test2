package pl.kurs.zad2.services;

import pl.kurs.zad2.models.Doctor;
import pl.kurs.zad2.models.HomeVisit;
import pl.kurs.zad2.models.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeVisitsService {
    private final List<HomeVisit> homeVisits;

    public HomeVisitsService(List<HomeVisit> homeVisits) {
        this.homeVisits = homeVisits;
    }

    private List<String> getTypesOfSpecialities() {
        List<String> specialities = new ArrayList<>();

        for (HomeVisit h : homeVisits) {
            if (!(specialities.contains(h.getDoctor().getSpeciality()))) {
                specialities.add(h.getDoctor().getSpeciality());
            }
        }
        return specialities;
    }

    public String getMostPopularSpeciality() {
        String mostPopularSpeciality = "";
        List<String> specialities = getTypesOfSpecialities();
        int maxOccurredTimes = 0;

        for (String s : specialities) {
            int occurredTimes = 0;
            for (HomeVisit h : homeVisits) {
                if (h.getDoctor().getSpeciality().equals(s)) {
                    occurredTimes++;
                }
                if (occurredTimes > maxOccurredTimes) {
                    mostPopularSpeciality = s;
                    maxOccurredTimes = occurredTimes;
                }
            }
        }
        return mostPopularSpeciality;
    }

    private List<String> getYearsOfVisits() {
        List<String> years = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        try {

            for (HomeVisit h : homeVisits) {
                Date date = new SimpleDateFormat("yyyy").parse(h.getVisitDate());
                calendar.setTime(date);
                String year = String.valueOf(calendar.get(Calendar.YEAR));
                if (!(years.contains(year))) {
                    years.add(year);
                }
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return years;
    }

    public int getYearWithMostVisits() {

        int yearWithMostVisits = 0;
        List<String> years = getYearsOfVisits();
        int maxOccurredTimes = 0;

        for (String s : years) {
            int occurredTimes = 0;
            for (HomeVisit h : homeVisits) {
                String year = h.getVisitDate().substring(0, 4);
                if (year.equals(s)) {
                    occurredTimes++;
                }
                if (occurredTimes > maxOccurredTimes) {
                    yearWithMostVisits = Integer.parseInt(s);
                    maxOccurredTimes = occurredTimes;
                }
            }
        }
        return yearWithMostVisits;
    }

    public List<Patient> findPatientsWhoWentToMin5DifferentDoctors() {
        List<Patient> patientsWhoWentToMin5DifferentDoctors = new ArrayList<>();

        for (HomeVisit a : homeVisits) {
            List<Doctor> doctorsPatientWentTo = new ArrayList<>();
            for (HomeVisit b : homeVisits) {
                if (a.getPatient().equals(b.getPatient()) && !doctorsPatientWentTo.contains(b.getDoctor())) {
                    doctorsPatientWentTo.add(b.getDoctor());
                }
            }
            if (doctorsPatientWentTo.size() > 4 && !patientsWhoWentToMin5DifferentDoctors.contains(a.getPatient())) {
                patientsWhoWentToMin5DifferentDoctors.add(a.getPatient());
            }
        }
        return patientsWhoWentToMin5DifferentDoctors;


    }
}
