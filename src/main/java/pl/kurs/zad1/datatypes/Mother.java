package pl.kurs.zad1.datatypes;

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

    public void addBaby(Baby baby) {
        this.babies.add(baby);
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

    @Override
    public String toString() {
        return "Mother{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
