package pl.kurs.zad2.services;


import pl.kurs.zad2.models.Doctor;
import pl.kurs.zad2.models.HomeVisit;
import pl.kurs.zad2.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class HomeVisitDataCollector extends TxtFileReader {
    private final String filePath;

    public HomeVisitDataCollector(String filePath) {
        this.filePath = filePath;
    }

    public List<HomeVisit> getHomeVisitsData(List<Doctor> doctors, List<Patient> patients) {
        List<HomeVisit> homeVisits = new ArrayList<>();
        List<String> unorderedHomeVisitsData = separateDataPassingTheFirstLine(filePath);

        for (String s : unorderedHomeVisitsData) {
            String[] elements = s.split("\t");
            for (Doctor d : doctors) {
                for (Patient p : patients) {
                    if (d.getId() == Integer.parseInt(elements[0]) && p.getId() == Integer.parseInt(elements[1])) {
                        HomeVisit homeVisit = new HomeVisit(d,p,elements[2]);
                        homeVisits.add(homeVisit);
                    }
                }
            }
        }
        return homeVisits;
    }

}
