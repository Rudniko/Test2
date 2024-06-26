package pl.kurs.zad4;

import java.util.Arrays;
import java.util.List;

public class FiguryRunner {
    public static void main(String[] args) {
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20));
        for (Figura f : figury) {
            System.out.println(f);
        }
        znajdzFigureZNajwiekszymObwodem(figury);
        znadzFigureZNajwiekszymPolem(figury);
        System.out.println(figury.contains(new Kwadrat(10)));

        Kolo koloZNumer0 = new Kolo(1);
        Kolo koloZNumKolejnym = Figura.stworzKolo(1);

    }

    static void znajdzFigureZNajwiekszymObwodem(List<Figura> figury) {
        Figura figuraZNajwiekszymObwodem = null;
        double najwiekszyObwod = 0;
        for (Figura f : figury) {
            if (f != null && f.obliczObwod() > najwiekszyObwod) {
                najwiekszyObwod = f.obliczObwod();
                figuraZNajwiekszymObwodem = f;
            }
        }
        System.out.println("Figura z największym obwodem to " + figuraZNajwiekszymObwodem);
    }

    static void znadzFigureZNajwiekszymPolem(List<Figura> figury) {
        Figura figuraZNajwiekszymPolem = null;
        double najwiekszePole = 0;
        for (Figura f : figury) {
            if (f != null && f.obliczPole() > najwiekszePole) {
                najwiekszePole = f.obliczPole();
                figuraZNajwiekszymPolem = f;
            }
        }
        System.out.println("Figura z największym polem to " + figuraZNajwiekszymPolem);
    }

}
