package pl.kurs.zad2.app;


import pl.kurs.zad2.models.Doctor;
import pl.kurs.zad2.models.HomeVisit;
import pl.kurs.zad2.models.Patient;
import pl.kurs.zad2.services.*;

import java.util.List;

public class Runner2 {
    public static void main(String[] args) {

        DoctorDataCollector doctorDataCollector = new DoctorDataCollector("src/main/java/pl/kurs/zad2/lekarze.txt");
        PatientDataCollector patientDataCollector = new PatientDataCollector("src/main/java/pl/kurs/zad2/pacjenci.txt");
        HomeVisitDataCollector homeVisitDataCollector = new HomeVisitDataCollector("src/main/java/pl/kurs/zad2/wizyty.txt");

        List<Doctor> doctors = doctorDataCollector.getDoctorsData();
        List<Patient> patients = patientDataCollector.getPatientsData();
        List<HomeVisit> homeVisits = homeVisitDataCollector.getHomeVisitsData(doctors, patients);

        PersonsService personsService = new PersonsService(doctors, patients);
        HomeVisitsService homeVisitsService = new HomeVisitsService(homeVisits);

        //1
        Doctor doctorWithMostVisits = personsService.findDoctorWithTheMostVisits();
        System.out.println("Lekarz, który miał najwięcej wizyt to " + doctorWithMostVisits.getSpeciality() + " " + doctorWithMostVisits.getName() + " " + doctorWithMostVisits.getSurname());

        //2
        Patient patientWithMostVisits = personsService.findPatientWithMostVisits();
        System.out.println("Pacjent, który miał najwięcej wizyt to " + patientWithMostVisits.getName() + " " + patientWithMostVisits.getSurname());

        //3
        String mostPopularSpeciality = homeVisitsService.getMostPopularSpeciality();
        System.out.println("Specjalizacja ciesząca się największym powodzeniem to " + mostPopularSpeciality);

        //4
        int yearWithMostVisits = homeVisitsService.getYearWithMostVisits();
        System.out.println("Najwięcej wizyt było w roku " + yearWithMostVisits);

        //5
        List<Doctor> oldestDoctors = personsService.findFiveOldestDoctors();
        System.out.print("Pięciu najstarszych lekarzy to: ");
        for (Doctor d : oldestDoctors) {
            System.out.print(d.getSpeciality() + " " + d.getName() + " " + d.getSurname() + ", ");
        }
        System.out.println("");

        //6
        List<Doctor> doctorsWithMostVisits = personsService.findFiveDoctorsWithTheMostVisits();
        System.out.print("Pięciu lekarzy z największą ilością wizyt to: ");
        for (Doctor d : doctorsWithMostVisits) {
            System.out.print(d.getSpeciality() + " " + d.getName() + " " + d.getSurname() + ", ");
        }
        System.out.println("");

        //7
        List<Patient> patientsWithFiveDifferentVisits = homeVisitsService.findPatientsWhoWentToMin5DifferentDoctors();
        if (patientsWithFiveDifferentVisits.isEmpty()) {
            System.out.println("Nie ma pacjentów, którzy byli u minimum 5 rożnych lekarzy.");
        } else {
            System.out.print("Pacjenci, którzy byli u minimum 5 różnych lekarzy to: ");
            for (Patient p : patientsWithFiveDifferentVisits) {
                System.out.print(p.getName() + " " + p.getSurname() + ", ");
            }
        }

        //8
        List<Doctor> doctorsWithOneVisit = personsService.findDoctorsWithOnlyOneVisit();
        if (doctorsWithOneVisit.isEmpty()) {
            System.out.println("Nie ma lekarzy, którzy przyjeli tylko jednego pacjenta.");
        } else {
            System.out.print("Lekarze, którzy przyjeli tylko jednego pacjenta to: ");
            for (Doctor d : doctorsWithOneVisit) {
                System.out.print(d.getSpeciality() + " " + d.getName() + " " + d.getSurname() + ", ");
            }
        }



    }
}





