package pl.kurs.zad2.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private final String pesel;
    private final String birthDate;
    private List<HomeVisit> homeVisits;

    public Patient(int id, String surname, String name, String pesel, String birthDate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.homeVisits = new ArrayList<>();
    }

    public void addHomeVisit(HomeVisit homeVisit) {
        this.homeVisits.add(homeVisit);
    }

    public int getId() {
        return id;
    }

    public String getPesel() {
        return pesel;
    }

    public List<HomeVisit> getHomeVisits() {
        return homeVisits;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
