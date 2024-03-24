package pl.kurs.zad4;

import java.util.Objects;

public class Kwadrat extends Figura {
    private int a;

    public Kwadrat(int a) {
        this.a = a;
        numerFigury = 0;
    }

    public Kwadrat(int a, int numer) {
        this.a = a;
        numerFigury = numer;

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
        return "Figura nr " + numerFigury + ": Kwadrat o boku " + a + '.';
    }
}
