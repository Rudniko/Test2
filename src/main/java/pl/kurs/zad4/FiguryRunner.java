package pl.kurs.zad4;

import java.util.Arrays;
import java.util.List;

public class FiguryRunner {
    public static void main(String[] args) {


        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20));
        for (Figura f : figury) {
            System.out.println(f);
        }


        Figura figuraZNajwiekszymObwodem = znajdzFigureZNajwiekszymObwodem(figury);
        System.out.println("Figura z nawiększym obwodem to: " + figuraZNajwiekszymObwodem);

        Figura figuraZNajwiekszymPolem = znadzFigureZNajwiekszymPolem(figury);
        System.out.println("Figura z największym polem to: " + figuraZNajwiekszymPolem);


        System.out.println(figury.contains(new Kwadrat(10)));


    }

    static Figura znajdzFigureZNajwiekszymObwodem(List<Figura> figury) {
        Figura figuraZNajwiekszymObwodem = null;
        double najwiekszyObwod = 0;
        for (Figura f : figury) {
            if (f != null && f.obliczObwod() > najwiekszyObwod) {
                najwiekszyObwod = f.obliczObwod();
                figuraZNajwiekszymObwodem = f;
            }
        }
        return figuraZNajwiekszymObwodem;
    }

    static Figura znadzFigureZNajwiekszymPolem(List<Figura> figury) {
        Figura figuraZNajwiekszymPolem = null;
        double najwiekszePole = 0;
        for (Figura f : figury) {
            if (f != null && f.obliczPole() > najwiekszePole) {
                najwiekszePole = f.obliczPole();
                figuraZNajwiekszymPolem = f;
            }
        }
        return figuraZNajwiekszymPolem;
    }

}
