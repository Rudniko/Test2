package pl.kurs.zad2.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String surname;
    private String name;
    private String speciality;
    private final String birthDate;
    private String nip;
    private final String pesel;
    private List<HomeVisit> homeVisits;

    public Doctor(int id, String surname, String name, String speciality, String birthDate, String nip, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.speciality = speciality;
        this.birthDate = birthDate;
        this.nip = nip;
        this.pesel = pesel;
        this.homeVisits = new ArrayList<>();
    }

    public void addHomeVisit(HomeVisit homeVisit) {
        this.homeVisits.add(homeVisit);
    }

    public int getId() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNip() {
        return nip;
    }

    public String getPesel() {
        return pesel;
    }

    public List<HomeVisit> getHomeVisits() {
        return homeVisits;
    }
    public int getNumberOfHomeVisits() {
        return homeVisits.size();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
