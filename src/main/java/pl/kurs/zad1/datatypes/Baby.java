package pl.kurs.zad1.datatypes;

public class Baby {
    private int id;
    private Gender gender;
    private String name;
    private final String birthDate;
    private double weight;
    private double height;
    private final Mother mother;

    public Baby(int id, Gender gender, String name, String birthDate, double weight, double height, Mother mother) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Mother getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
