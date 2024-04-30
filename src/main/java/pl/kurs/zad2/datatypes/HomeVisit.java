package pl.kurs.zad2.datatypes;

public class HomeVisit {
    private Doctor doctor;
    private Patient patient;
    private String visitDate;

    public HomeVisit(Doctor doctor, Patient patient, String visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;
        doctor.addHomeVisit(this);
        patient.addHomeVisit(this);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getVisitDate() {
        return visitDate;
    }
}
