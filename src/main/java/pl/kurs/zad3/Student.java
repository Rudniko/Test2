package pl.kurs.zad3;

public class Student extends Person {
    private Group group;
    private double scholarship;

    public Student(String name, String surname, String pesel, String city, Group group, double scholarship) {
        super(name, surname, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    @Override
    public String toString() {
        return super.toString() + ", group:" + group + ", scholarship:" + scholarship;
    }
}
