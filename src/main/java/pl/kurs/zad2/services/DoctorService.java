package pl.kurs.zad2.services;

import pl.kurs.zad2.datatypes.Doctor;
import pl.kurs.zad2.datatypes.HomeVisit;
import pl.kurs.zad2.datatypes.Patient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoctorService {
    public Doctor findDoctorWithTheMostVisits(List<Doctor> doctorList) {
        Doctor doctorWithTheMostVisits = doctorList.get(0);
        for (Doctor d : doctorList) {
            if (d.getHomeVisits().size() > doctorWithTheMostVisits.getHomeVisits().size()) {
                doctorWithTheMostVisits = d;
            }
        }
        return doctorWithTheMostVisits;
    }

    public List<Doctor> findFiveOldestDoctors(List<Doctor> doctorList) {
        List<Doctor> clonedList = new ArrayList<>(doctorList);
        clonedList.sort(Comparator.comparing(Doctor::getBirthDate));
        return clonedList.subList(0, 5);
    }

    public List<Doctor> findFiveDoctorsWithTheMostVisits(List<Doctor> list) {
        List<Doctor> clonedList = new ArrayList<>(list);
        clonedList.sort(Comparator.comparing(Doctor::getNumberOfHomeVisits).reversed());
        return clonedList.subList(0, 5);
    }

    public List<Doctor> getDoctorsWhoHadOnlyOnePatient(List<Doctor> list) {
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor d : list) {
            if (doesAllVisitsHaveTheSamePatient(d.getHomeVisits())) {
                doctors.add(d);
            }
        }
        return doctors;
    }

    private boolean doesAllVisitsHaveTheSamePatient(List<HomeVisit> list) {
        Patient firstPatient = list.get(0).getPatient();
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).getPatient().equals(firstPatient)) {
                return false;
            }
        }
        return true;
    }
}
