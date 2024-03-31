package pl.kurs.zad2.models;

public class Patient extends Person {
    private int visitCounter;

    public Patient(int id, String surname, String name, String birthDate, String pesel) {
        super(id, surname, name, birthDate, pesel);
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    protected void setVisitCounter(int visitCounter) {
        this.visitCounter = visitCounter;
    }


}
