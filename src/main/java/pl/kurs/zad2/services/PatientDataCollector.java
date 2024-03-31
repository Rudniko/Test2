package pl.kurs.zad2.services;


import pl.kurs.zad2.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDataCollector extends TxtFileReader {
    private final String filePath;

    public PatientDataCollector(String filePath) {
        this.filePath = filePath;
    }

    public List<Patient> getPatientsData() {
        List<Patient> patients = new ArrayList<>();
        List<String> unorderedPatientsData = separateDataPassingTheFirstLine(filePath);

        for (String s : unorderedPatientsData) {
            String[] elements = s.split("\t");
            Patient patient = new Patient(Integer.parseInt(elements[0]), elements[1], elements[2], elements[4], elements[3]);

            int existingPatientCounter = 0;
            for (Patient p : patients) {
                if (patient.getPesel().equals(p.getPesel()) || patient.getId() == p.getId()) {
                    existingPatientCounter++;
                }
            }
            if (existingPatientCounter == 0) {
                patients.add(patient);
            }
        }
        return patients;
    }
}
