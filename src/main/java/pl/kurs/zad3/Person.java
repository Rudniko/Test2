package pl.kurs.zad3;

public abstract class Person {
    private String name;
    private String surname;
    private String pesel;
    private String city;

    public Person(String name, String surname, String pesel, String city) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.city = city;
    }

    public abstract double getIncome();

    public static Gender getPlec(Person person) {
        if (person.pesel.charAt(9) % 2 == 0) {
            return Gender.WOMAN;
        } else {
            return Gender.MAN;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + name + " " + surname + ", pesel:" + pesel + ", city:" + city;
    }
}
