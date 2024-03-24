package pl.kurs.zad4;

public abstract class Figura {
    private static int licznik = 0;
    protected int numerFigury;

    public Figura() {
        this.numerFigury = 0;
    }

    public static Kwadrat stworzKwadrat(int bok) {
        return new Kwadrat(bok,++licznik);
    }
    public static Kolo stworzKolo(int r) {
        return new Kolo(r,++licznik);
    }
    public static Prostokat stworzProstokat(int a, int b) {
        return new Prostokat(a, b, ++licznik);
    }

    abstract double obliczObwod();

    abstract double obliczPole();

}
