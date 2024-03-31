package pl.kurs.zad2.services;

import pl.kurs.zad2.models.Doctor;
import pl.kurs.zad2.models.Patient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonsService {
    private final List<Doctor> doctors;
    private final List<Patient> patients;

    public PersonsService(List<Doctor> doctors, List<Patient> patients) {
        this.doctors = doctors;
        this.patients = patients;
    }

    public Doctor findDoctorWithTheMostVisits() {
        Doctor doctorWithMostVisits = doctors.get(0);

        int mostVisits = doctors.get(0).getVisitCounter();
        for (Doctor d : doctors) {
            if (d.getVisitCounter() > mostVisits) {
                doctorWithMostVisits = d;
                mostVisits = d.getVisitCounter();
            }
        }
        return doctorWithMostVisits;
    }

    public Patient findPatientWithMostVisits() {
        Patient patientWithMostVisits = patients.get(0);

        int mostVisits = patients.get(0).getVisitCounter();
        for (Patient p : patients) {
            if (p.getVisitCounter() > mostVisits) {
                patientWithMostVisits = p;
                mostVisits = p.getVisitCounter();
            }
        }
        return patientWithMostVisits;
    }

    public List<Doctor> findFiveOldestDoctors() {
        List<Doctor> clonedList = new ArrayList<>(doctors);
        clonedList.sort(Comparator.comparing(Doctor::getBirthDate));

        List<Doctor> oldestDoctors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            oldestDoctors.add(clonedList.get(i));
        }
        return oldestDoctors;
    }

    public List<Doctor> findFiveDoctorsWithTheMostVisits() {
        List<Doctor> clonedList = new ArrayList<>(doctors);
        clonedList.sort(Comparator.comparing(Doctor::getVisitCounter));

        List<Doctor> doctorsWithTheMostVisits = new ArrayList<>();
        for (int i = clonedList.size() - 1; i > clonedList.size() - 6; i--) {
            doctorsWithTheMostVisits.add(clonedList.get(i));
        }
        return doctorsWithTheMostVisits;

    }

    public List<Doctor> findDoctorsWithOnlyOneVisit() {
        List<Doctor> doctorsWithOneVisit = new ArrayList<>();

        for (Doctor d : doctors) {
            if (d.getVisitCounter() == 1) {
                doctorsWithOneVisit.add(d);
            }
        }
        return doctorsWithOneVisit;
    }
}
