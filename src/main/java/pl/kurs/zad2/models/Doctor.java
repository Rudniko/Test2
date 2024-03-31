package pl.kurs.zad2.models;

public class Doctor extends Person {
    private String speciality;
    private String nip;
    private int visitCounter;

    public Doctor(int id, String surname, String name, String birthDate, String pesel, String speciality, String nip) {
        super(id, surname, name, pesel, birthDate);
        this.speciality = speciality;
        this.nip = nip;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getNip() {
        return nip;
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    protected void setVisitCounter(int visitCounter) {
        this.visitCounter = visitCounter;
    }

}
