package pl.kurs.zad2.services;

import pl.kurs.zad2.datatypes.Patient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientsDataReader {

    public List<Patient> getPatientListFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Nie instnieje plik do odczytu o takiej nazwie!");
        }

        List<Patient> patients = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Patient patient = createPatientFromLine(line);
                if (!(isPatientADuplicate(patients, patient))) {
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    private Patient createPatientFromLine(String line) {
        String[] elements = line.split("\t");
        int id = Integer.parseInt(elements[0]);
        String surname = elements[1];
        String name = elements[2];
        String pesel = elements[3];
        String birthDate = elements[4];

        return new Patient(id, surname, name, pesel, birthDate);
    }

    private boolean isPatientADuplicate(List<Patient> list, Patient patient) {
        for (Patient p : list) {
            if (patient.getPesel().equals(p.getPesel()) || patient.getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

}
