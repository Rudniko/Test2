package pl.kurs.zad4;

import java.util.Objects;

public class Kwadrat extends Figura {
    private int a;

    public Kwadrat(int a) {
        super();
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return a == kwadrat.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public double obliczObwod() {
        return 4 * a;
    }

    @Override
    public double obliczPole() {
        return a * a;
    }

    @Override
    public String toString() {
        return super.toString() + "Kwadrat o boku " + a + '.';
    }
}
