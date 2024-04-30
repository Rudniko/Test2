package pl.kurs.zad2.services;

import pl.kurs.zad2.datatypes.HomeVisit;
import pl.kurs.zad2.datatypes.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientsService {
    public Patient findPatientWithTheMostVisits(List<Patient> patientList) {
        Patient patientWithTheMostVisits = patientList.get(0);
        for (Patient p : patientList) {
            if (p.getHomeVisits().size() > patientWithTheMostVisits.getHomeVisits().size()) {
                patientWithTheMostVisits = p;
            }
        }
        return patientWithTheMostVisits;
    }

    public List<Patient> findPatientsWhoWentToMin5DifferentDoctors(List<Patient> patientList) {
        List<Patient> patients = new ArrayList<>();

        for (Patient p : patientList) {
            if (areThereMin5DifferentDoctors(p.getHomeVisits())) {
                patients.add(p);
            }
        }
        return patients;
    }

    private boolean areThereMin5DifferentDoctors(List<HomeVisit> homeVisitList) {
        int differentDoctorsCounter = 0;

        for (int i = 0; i < homeVisitList.size(); i++) {
            boolean isDifferent = true;
            for (int j = 1; j < i; j++) {
                if (homeVisitList.get(i).getDoctor().equals(homeVisitList.get(j).getDoctor())) {
                    isDifferent = false;
                    break;
                }
            }
            if (isDifferent) {
                differentDoctorsCounter++;
            }
        }
        return differentDoctorsCounter >= 5;
    }


}
