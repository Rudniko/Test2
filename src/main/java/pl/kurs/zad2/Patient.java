package pl.kurs.zad2;

import java.util.Date;
import java.util.List;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String pesel;
    private Date birthDate;
    private int visitCounter;

    public Patient(int id, String surname, String name, String pesel, Date birthDate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public int getId() {
        return id;
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    public static void countPatientVisits(List<HomeVisit> visits, List<Patient> patients) {
        for (HomeVisit v : visits) {
            for (Patient p : patients) {
                if (v.getPatientId() == p.id) {
                    p.visitCounter++;
                }
            }
        }
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}
