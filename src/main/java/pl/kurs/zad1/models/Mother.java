package pl.kurs.zad1.models;

import java.util.ArrayList;
import java.util.List;

public class Mother {
    private int id;
    private String name;
    private int age;
    private List<Baby> babies;

    public Mother(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.babies = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public void addBaby(Baby baby) {
        babies.add(baby);
    }

}
