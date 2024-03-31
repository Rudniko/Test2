package pl.kurs.zad2.models;

public abstract class Person {
    private int id;
    private String surname;
    private String name;
    private final String birthDate;
    private final String pesel;

    public Person(int id, String surname, String name, String birthDate, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPesel() {
        return pesel;
    }

    public String getBirthDate() {
        return birthDate;
    }

}
