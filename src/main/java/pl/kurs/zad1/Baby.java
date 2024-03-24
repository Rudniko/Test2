package pl.kurs.zad1;

import java.util.*;

public class Baby {
    private int id;
    private final char gender;
    private String name;
    private String birthDate;
    private double weightG;
    private double heightCm;
    private final Mother mother;

    public Baby(int id, char gender, String name, String birthDate, double weightG, double heightCm, Mother mother) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
        this.weightG = weightG;
        this.heightCm = heightCm;
        this.mother = mother;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public Mother getMother() {
        return mother;
    }

    public static boolean isBoy(Baby baby) {
        return baby.gender == 's';
    }
    public static boolean isBabyOver4000Grams(Baby baby) {
        return baby.weightG > 4000;
    }

}
