package pl.kurs.zad2.services;

import pl.kurs.zad2.datatypes.Doctor;
import pl.kurs.zad2.datatypes.HomeVisit;
import pl.kurs.zad2.datatypes.Patient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeVisitsDataReader {

    public List<HomeVisit> getHomeVisitListFromFile(String filePath, List<Doctor> doctorList, List<Patient> patientList) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Nie instnieje plik do odczytu o takiej nazwie!");
        }

        List<HomeVisit> homeVisits = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                HomeVisit homeVisit = createHomeVisitFromLine(line, doctorList, patientList);
                if (homeVisit != null) {
                    homeVisits.add(homeVisit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return homeVisits;
    }

    private HomeVisit createHomeVisitFromLine(String line, List<Doctor> doctorList, List<Patient> patientList) {
        String[] elements = line.split("\t");
        Doctor doctor = getDoctorById(doctorList, Integer.parseInt(elements[0]));
        Patient patient = getPatientById(patientList, Integer.parseInt(elements[1]));
        String visitDate = elements[2];
        if (doctor != null && patient != null) {
            return new HomeVisit(doctor, patient, visitDate);
        }
        return null;
    }

    private Doctor getDoctorById(List<Doctor> list, int id) {
        for (Doctor d : list) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    private Patient getPatientById(List<Patient> list, int id) {
        for (Patient p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
