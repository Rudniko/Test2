package pl.kurs.zad4;

import java.util.Objects;

public class Prostokat extends Figura {
    private int a;
    private int b;

    public Prostokat(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public Prostokat(int a, int b, int numer){
        this.a = a;
        this.b = b;
        numerFigury = numer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return a == prostokat.a && b == prostokat.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public double obliczObwod() {
        return 2 * a + 2 * b;
    }

    @Override
    public double obliczPole() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Figura nr " + numerFigury + ": Prostokat o bokach " + a + "x" + b + '.';
    }
}
