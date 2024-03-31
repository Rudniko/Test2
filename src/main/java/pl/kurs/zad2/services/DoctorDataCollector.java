package pl.kurs.zad2.services;


import pl.kurs.zad2.models.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDataCollector extends TxtFileReader {
    private final String filePath;

    public DoctorDataCollector(String filePath) {
        this.filePath = filePath;
    }

    public List<Doctor> getDoctorsData() {
        List<Doctor> doctors = new ArrayList<>();
        List<String> unorderedDoctorsData = separateDataPassingTheFirstLine(filePath);

        for (String s : unorderedDoctorsData) {
            String[] elements = s.split("\t");
            Doctor doctor = new Doctor(Integer.parseInt(elements[0]), elements[1], elements[2], elements[6], elements[4], elements[3], elements[5]);

            int existingDoctorCounter = 0;
            for (Doctor d : doctors) {
                if (doctor.getNip().equals(d.getNip()) || doctor.getPesel().equals(d.getPesel()) || doctor.getId() == d.getId()) {
                    existingDoctorCounter++;
                }
            }
            if (existingDoctorCounter == 0) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }

}
