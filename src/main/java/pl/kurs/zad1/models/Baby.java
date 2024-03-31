package pl.kurs.zad1.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Baby {
    private int id;
    private final char gender;
    private String name;
    private final String birthDate;
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

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public boolean isBoy() {
        return this.gender == 's';
    }

    public boolean isBabyOver4000Grams() {
        return this.weightG > 4000;
    }

    public int getDayOfWeekOfBirthDate() {
        int dayOfWeek = 0;

        try {
            Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return dayOfWeek;
    }

    public boolean doesDaughterInheritedMotherName() {
        return !isBoy() && getName().equals(mother.getName());
    }

}
