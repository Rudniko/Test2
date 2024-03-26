package pl.kurs.zad2;


public class HomeVisit {
    private int doctorId;
    private int patientId;
    private String visitDate;

    public HomeVisit(int doctorId, int patientId, String visitDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.visitDate = visitDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getVisitDate() {
        return visitDate;
    }



}
