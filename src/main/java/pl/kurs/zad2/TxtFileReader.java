package pl.kurs.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TxtFileReader {

    private static List<String> getLinesFromText(String filePath) {
        List<String> linesOfText = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))
        ) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                linesOfText.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return linesOfText;
    }

    public static List<Doctor> getDoctorsInfo() {
        List<String> linesOfText = getLinesFromText("src/main/java/pl/kurs/zad2/lekarze.txt");
        List<Doctor> doctors = new ArrayList<>();
        try {
            for (String line : linesOfText) {
                String[] elements = line.split("\t");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(elements[4]);
                Doctor doctor = new Doctor(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3], date, elements[5], elements[6]);

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
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static List<Patient> getPatientInfo() {
        List<String> linesOfText = getLinesFromText("src/main/java/pl/kurs/zad2/pacjenci.txt");
        List<Patient> patients = new ArrayList<>();
        try {
            for (String line : linesOfText) {
                String[] elements = line.split("\t");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(elements[4]);
                Patient patient = new Patient(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3], date);

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
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static List<HomeVisit> getHomeVisitsInfo(List<Doctor> doctors, List<Patient> patients) {
        List<String> linesOfText = getLinesFromText("src/main/java/pl/kurs/zad2/wizyty.txt");
        List<HomeVisit> homeVisits = new ArrayList<>();

        for (String line : linesOfText) {
            String[] elements = line.split("\t");
            HomeVisit homeVisit = new HomeVisit(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), elements[2]);


            for (Doctor d : doctors) {
                for (Patient p : patients) {
                    if (d.getId() == homeVisit.getDoctorId() && p.getId() == homeVisit.getPatientId()) {
                        homeVisits.add(homeVisit);
                    }
                }
            }


        }
        return homeVisits;
    }

}
