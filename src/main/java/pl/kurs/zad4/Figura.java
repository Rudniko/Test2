package pl.kurs.zad4;

public abstract class Figura {
    private static int licznik = 0;
    protected int numerFigury;

    public Figura() {
        this.numerFigury = 0;
    }

    public static Kwadrat stworzKwadrat(int bok) {
        Kwadrat kwadrat = new Kwadrat(bok);
        kwadrat.numerFigury = ++licznik;
        return kwadrat;
    }

    public static Kolo stworzKolo(int r) {
        Kolo kolo = new Kolo(r);
        kolo.numerFigury = ++licznik;
        return kolo;

    }

    public static Prostokat stworzProstokat(int a, int b) {
        Prostokat prostokat = new Prostokat(a,b);
        prostokat.numerFigury = ++licznik;
        return prostokat;
    }

    abstract double obliczObwod();

    abstract double obliczPole();

    @Override
    public String toString() {
        return "Figura nr " + numerFigury + ": ";
    }
}
