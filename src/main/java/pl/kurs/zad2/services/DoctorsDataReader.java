package pl.kurs.zad2.services;


import pl.kurs.zad2.datatypes.Doctor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoctorsDataReader {

    public List<Doctor> getDoctorListFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Nie instnieje plik do odczytu o takiej nazwie!");
        }

        List<Doctor> doctors = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Doctor doctor = createDoctorFromLine(line);
                if (!(isDoctorADuplicate(doctors, doctor))) {
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    private Doctor createDoctorFromLine(String line) {
        String[] elements = line.split("\t");
        int id = Integer.parseInt(elements[0]);
        String surname = elements[1];
        String name = elements[2];
        String speciality = elements[3];
        String birthDate = elements[4];
        String nip = elements[5];
        String pesel = elements[6];
        return new Doctor(id, surname, name, speciality, birthDate, nip, pesel);
    }

    private boolean isDoctorADuplicate(List<Doctor> list, Doctor doctor) {
        for (Doctor d : list) {
            if (doctor.getNip().equals(d.getNip()) || doctor.getPesel().equals(d.getPesel()) || doctor.getId() == d.getId()) {
                return true;
            }
        }
        return false;
    }
}
