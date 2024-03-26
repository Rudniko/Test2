package pl.kurs.zad2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        List<Doctor> doctors = TxtFileReader.getDoctorsInfo();
        List<Patient> patients = TxtFileReader.getPatientInfo();
        List<HomeVisit> homeVisits = TxtFileReader.getHomeVisitsInfo(doctors, patients);

        Doctor.countDoctorVisits(homeVisits, doctors);
        Patient.countPatientVisits(homeVisits, patients);


        findDoctorWithMostVisits(doctors);
        findPatientWithMostVisits(patients);
        System.out.println("-----");

        System.out.println("Specjalizacja ciesząca się największym powodzeniem to " + getMostPopularStringFromArray(getArrayWithSpecialitiesOfVisits(homeVisits, doctors)));
        System.out.println("-----");

        System.out.println("Najwięcej wizyt było w roku " + getMostPopularStringFromArray(getArrayWithYearsOfVisits(homeVisits)));
        System.out.println("-----");

        show5OldestDoctors(doctors);
        System.out.println("-----");

        show5DoctorsWithMostVisits(doctors);
        System.out.println("-----");

        if (!getPatientsWhoHad5DifferentVisits(patients, homeVisits, doctors).isEmpty()) {
            System.out.println("Pacjenci, którzy byli u minimum 5ciu różnych lekarzy: " + getPatientsWhoHad5DifferentVisits(patients, homeVisits, doctors));
        } else {
            System.out.println("Nie ma pacjentów, którzy byli u minimum 5ciu różnych lekarzy");
        }
        System.out.println("-----");


        if (!getDoctorsWithOnlyOneVisit(doctors).isEmpty()) {
            System.out.println("Lekarze, którzy przyjeli tylko jednego pacjenta: " + getDoctorsWithOnlyOneVisit(doctors));
        } else {
            System.out.println("Nie ma lekarzy, którzy przyjeli tylko jednego pacjenta");
        }

    }

    static void findDoctorWithMostVisits(List<Doctor> doctors) {
        Doctor doctorWithMostVisits = doctors.get(0);

        int mostVisits = doctors.get(0).getVisitCounter();
        for (Doctor doctor : doctors) {
            if (doctor.getVisitCounter() > mostVisits) {
                doctorWithMostVisits = doctor;
            }
        }
        System.out.println("Lekarz z największą liczbą wizyt to " + doctorWithMostVisits);

    }

    static void findPatientWithMostVisits(List<Patient> patients) {
        Patient patientWithMostVisits = patients.get(0);

        int mostVisits = patients.get(0).getVisitCounter();
        for (Patient p : patients) {
            if (p.getVisitCounter() > mostVisits) {
                patientWithMostVisits = p;
            }
        }
        System.out.println("Pacjent z największą liczbą wizyt to " + patientWithMostVisits);

    }

    static String getMostPopularStringFromArray(String[] strings) {
        Arrays.sort(strings);

        String mostPopularString = strings[0];
        int mostStringsCounter = 0;
        int thisStringCounter = 0;

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].equals(strings[i - 1])) {
                thisStringCounter++;
            } else {
                thisStringCounter = 0;
            }

            if (thisStringCounter > mostStringsCounter) {
                mostStringsCounter = thisStringCounter;
                mostPopularString = strings[i];
            }
        }
        return mostPopularString;


    }

    static String[] getArrayWithSpecialitiesOfVisits(List<HomeVisit> homeVisits, List<Doctor> doctors) {
        String[] specialities = new String[homeVisits.size()];
        int index = 0;
        for (HomeVisit h : homeVisits) {
            int doctorId = h.getDoctorId();
            for (Doctor d : doctors) {
                if (d.getId() == doctorId) {
                    specialities[index++] = d.getSpeciality();
                }
            }
        }
        return specialities;

    }

    static String[] getArrayWithYearsOfVisits(List<HomeVisit> homeVisits) {
        String[] years = new String[homeVisits.size()];
        int index = 0;

        try {
            for (HomeVisit h : homeVisits) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(h.getVisitDate());
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(date);
                String year = String.valueOf(calendar.get(Calendar.YEAR));
                years[index++] = year;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return years;
    }

    static void show5OldestDoctors(List<Doctor> doctors) {
        Date[] birthDates = getArrayWithBirtDatesOfDoctors(doctors);
        Arrays.sort(birthDates);

        Doctor[] oldestDoctors = new Doctor[5];
        Date[] oldestDates = new Date[5];
        System.arraycopy(birthDates, 0, oldestDates, 0, 5);

        int index = 0;
        for (Date o : oldestDates) {
            for (Doctor d : doctors) {
                if (d.getBirthDate().equals(o)) {
                    oldestDoctors[index++] = d;
                }
            }
        }
        System.out.println("5 najstarszych lekarzy to: " + Arrays.toString(oldestDoctors));
    }

    static Date[] getArrayWithBirtDatesOfDoctors(List<Doctor> doctors) {
        Date[] birthDates = new Date[doctors.size()];
        int index = 0;
        for (Doctor d : doctors) {
            birthDates[index++] = d.getBirthDate();
        }
        return birthDates;
    }

    static void show5DoctorsWithMostVisits(List<Doctor> doctors) {
        doctors.sort(Comparator.comparing(Doctor::getVisitCounter));

        List<Doctor> doctorsWithMostVisits = new ArrayList<>();
        for (int i = doctors.size() - 1; i > doctors.size() - 6; i--) {
            doctorsWithMostVisits.add(doctors.get(i));
        }
        System.out.println("5 lekarzy, którzy mieli najwięcej wizyt to: " + doctorsWithMostVisits);
    }

    static List<Doctor> getListOfDoctorsPatientWentTo(List<HomeVisit> homeVisits, Patient patient, List<Doctor> doctors) {
        List<Doctor> doctorsForEachVisit = new ArrayList<>();
        int id = patient.getId();
        for (HomeVisit h : homeVisits) {
            if (h.getPatientId() == id) {
                for (Doctor d : doctors) {
                    if (d.getId() == h.getDoctorId()) {
                        doctorsForEachVisit.add(d);
                    }
                }
            }
        }
        return doctorsForEachVisit;
    }

    static int countDifferentDoctors(List<Doctor> doctorsPatientWentTo) {
        int differentDoctors = 0;

        for (int i = 0; i < doctorsPatientWentTo.size(); i++) {
            boolean isDifferent = true;
            for (int j = 0; j < i; j++) {
                if (doctorsPatientWentTo.get(i).equals(doctorsPatientWentTo.get(j))) {
                    isDifferent = false;
                    break;
                }
            }
            if (isDifferent) {
                differentDoctors++;
            }
        }
        return differentDoctors;
    }

    static List<Patient> getPatientsWhoHad5DifferentVisits(List<Patient> patients, List<HomeVisit> homeVisits, List<Doctor> doctors) {
        List<Patient> patientsWith5DifferentVisits = new ArrayList<>();
        for (Patient p : patients) {
            if (countDifferentDoctors(getListOfDoctorsPatientWentTo(homeVisits, p, doctors)) > 4) {
                patientsWith5DifferentVisits.add(p);
            }
        }
        return patientsWith5DifferentVisits;
    }

    static List<Doctor> getDoctorsWithOnlyOneVisit(List<Doctor> doctors) {
        List<Doctor> doctorsWithOneVisit = new ArrayList<>();

        for (Doctor d : doctors) {
            if (d.getVisitCounter() == 1) {
                doctorsWithOneVisit.add(d);
            }
        }
        return doctorsWithOneVisit;
    }
}





