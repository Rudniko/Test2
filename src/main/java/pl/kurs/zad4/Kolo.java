package pl.kurs.zad4;

import java.util.Objects;

public class Kolo extends Figura {
    private int r;

    public Kolo(int r) {
        this.r = r;
    }

    public Kolo(int r, int numer) {
        this.r = r;
        numerFigury = numer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return r == kolo.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * r;
    }

    @Override
    public double obliczPole() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return "Figura nr " + numerFigury + ": Koło o promieniu " + r / 2 + '.';
    }
}
