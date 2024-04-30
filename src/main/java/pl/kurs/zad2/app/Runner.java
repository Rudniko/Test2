package pl.kurs.zad2.app;

import pl.kurs.zad2.datatypes.Doctor;
import pl.kurs.zad2.datatypes.HomeVisit;
import pl.kurs.zad2.datatypes.Patient;
import pl.kurs.zad2.services.*;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        DoctorsDataReader ddr = new DoctorsDataReader();
        PatientsDataReader pdr = new PatientsDataReader();
        HomeVisitsDataReader hvdr = new HomeVisitsDataReader();

        List<Doctor> doctors = ddr.getDoctorListFromFile("lekarze.txt");
        List<Patient> patients = pdr.getPatientListFromFile("pacjenci.txt");
        List<HomeVisit> homeVisits = hvdr.getHomeVisitListFromFile("wizyty.txt", doctors, patients);

        DoctorService ds = new DoctorService();
        PatientsService ps = new PatientsService();
        HomeVisitService hvs = new HomeVisitService();


        Doctor doctorWithTheMostVisits = ds.findDoctorWithTheMostVisits(doctors);
        System.out.println("Lekarz, który miał najwięcej wizyt to " + doctorWithTheMostVisits);

        Patient patientWithTheMostVisits = ps.findPatientWithTheMostVisits(patients);
        System.out.println("Pacjent, który miał najwięcej wizyt to " + patientWithTheMostVisits);

        String mostPopularSpecialisation = hvs.findMostPopularSpeciality(homeVisits);
        System.out.println("Specjalizacja ciesząca się najwięszym powodzeniem to " + mostPopularSpecialisation);

        int yearWithTheMostVisits = hvs.getYearWithMostVisits(homeVisits);
        System.out.println("Najwięcej wizyt było w " + yearWithTheMostVisits + " roku");

        List<Doctor> fiveOldestDoctors = ds.findFiveOldestDoctors(doctors);
        System.out.println("Top 5 najstarszych lekarzy: ");
        for (Doctor d : fiveOldestDoctors) {
            System.out.println(d);
        }

        List<Doctor> fiveDoctorsWithMostVisits = ds.findFiveDoctorsWithTheMostVisits(doctors);
        System.out.println("Top 5 lekarzy z największą ilością wizyt: ");
        for (Doctor d : fiveDoctorsWithMostVisits) {
            System.out.println(d);
        }


        List<Patient> patientsWhoWentToMin5DifferentDoctors = ps.findPatientsWhoWentToMin5DifferentDoctors(patients);
        if (patientsWhoWentToMin5DifferentDoctors.isEmpty()) {
            System.out.println("Nie ma pacjentów, którzy byli u minimum 5 rożnych lekarzy.");
        } else {
            System.out.print("Pacjenci, którzy byli u minimum 5 różnych lekarzy to: ");
            for (Patient p : patientsWhoWentToMin5DifferentDoctors) {
                System.out.println(p);
            }
        }


        List<Doctor> doctorsWhoHadOnlyOnePatient = ds.getDoctorsWhoHadOnlyOnePatient(doctors);
        if (doctorsWhoHadOnlyOnePatient.isEmpty()) {
            System.out.println("Nie ma lekarzy, którzy przyjeli tylko jednego pacjenta.");
        } else {
            System.out.print("Lekarze, którzy przyjeli tylko jednego pacjenta to: ");
            for (Doctor d : doctorsWhoHadOnlyOnePatient) {
                System.out.println(d);
            }
        }


    }
}
