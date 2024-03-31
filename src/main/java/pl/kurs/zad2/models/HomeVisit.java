package pl.kurs.zad2.models;

public class HomeVisit {

    private Doctor doctor;
    private Patient patient;
    private String visitDate;

    public HomeVisit(Doctor doctor, Patient patient, String visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;
        doctor.setVisitCounter(doctor.getVisitCounter() + 1);
        patient.setVisitCounter(patient.getVisitCounter() + 1);
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
