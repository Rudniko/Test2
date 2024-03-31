package pl.kurs.zad3;

public class PersonRunner {
    public static void main(String[] args) {
        Student student1 = new Student("Krzysztof", "Byk", "00983842852", "Poznań", Group.BIOLOGY, 1250);
        Student student2 = new Student("Mateusz", "Kasztan", "99128375536", "Warszawa", Group.CHEMISTRY, 1500);
        Student student3 = new Student("Sonia", "Szober", "01442939381", "Warszawa", Group.IT, 2250);

        Employee employee1 = new Employee("Patryk", "Jodeł", "87234565874", "Nysa", Position.MANAGER, 5500);
        Employee employee2 = new Employee("Agnieszka", "Kruk", "90743838264", "Wrocław", Position.SUPERVISOR, 4000);
        Employee employee3 = new Employee("Elżbieta", "Zoń", "90729999346", "Toruń", Position.PRODUCTION_WORKER, 3500);

        Person[] people = new Person[]{student1, student2, student3, employee1, employee2, employee3};

        Person personWithHighestIncome = findPersonWithHighestIncome(people);
        System.out.println("Osoba z największym dochodem to " + personWithHighestIncome);

        int numberOfWomen = countWomen(people);
        System.out.println("Ilość kobiet w tablity: " + numberOfWomen);


    }

    static int countWomen(Person[] people) {
        int womenCount = 0;
        for (Person p : people) {
            if (p != null && p.getPlec().equals(Gender.WOMAN)) {
                womenCount++;
            }
        }
        return womenCount;
    }

    static Person findPersonWithHighestIncome(Person[] people) {
        Person personWithHighestIncome = null;
        double highestIncome = 0;
        for (Person p : people) {
            if (p != null && p.getIncome() > highestIncome) {
                personWithHighestIncome = p;
                highestIncome = p.getIncome();

            }
        }
        return personWithHighestIncome;
    }
}
