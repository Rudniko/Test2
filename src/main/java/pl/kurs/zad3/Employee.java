package pl.kurs.zad3;

public class Employee extends Person {
    private Position position;
    private double salary;

    public Employee(String name, String surname, String pesel, String city, Position position, double salary) {
        super(name, surname, pesel, city);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public double getIncome() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", position:" + position + ", salary:" + salary;
    }
}
