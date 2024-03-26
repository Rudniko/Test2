package pl.kurs.zad2;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Doctor {
    private int id;
    private String surname;
    private String name;
    private String speciality;
    private Date birthDate;
    private String nip;
    private String pesel;
    private int visitCounter;


    public Doctor(int id, String surname, String name, String speciality, Date birthDate, String nip, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.speciality = speciality;
        this.birthDate = birthDate;
        this.nip = nip;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNip() {
        return nip;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && visitCounter == doctor.visitCounter && Objects.equals(surname, doctor.surname) && Objects.equals(name, doctor.name) && Objects.equals(speciality, doctor.speciality) && Objects.equals(birthDate, doctor.birthDate) && Objects.equals(nip, doctor.nip) && Objects.equals(pesel, doctor.pesel);
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    public static void countDoctorVisits(List<HomeVisit> visits, List<Doctor> doctors) {
        for (HomeVisit v : visits) {
            for (Doctor d : doctors) {
                if (v.getDoctorId() == d.id) {
                    d.visitCounter++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return speciality + " " + name + " " + surname;
    }
}
