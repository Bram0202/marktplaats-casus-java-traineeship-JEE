package service;

import dao.ArtikelDao;
import dao.CategorieDao;
import domain.Artikel;
import domain.Categorie;
import domain.Soort;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static util.Util.mysql;

public class ArtikelService {
    private final Scanner scanner = new Scanner(System.in);

    public String ontvangGebruikersInvoer_naam() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public String ontvangGebruikersInvoer_omschrijving() {
        return scanner.nextLine();
    }

    public int ontvangGebruikersInvoer_int() throws InputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
    }

    public BigDecimal ontvangGebruikersInvoer_prijs() throws InputMismatchException {
        try {
            return scanner.nextBigDecimal();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
    }

    public Soort ontvangGebruikersInvoer_Soort() {
        String input = scanner.nextLine().toLowerCase().trim();

        if (input.equals("product")) {
            return Soort.PRODUCT;
        } else if (input.equals("dienst")) {
            return Soort.DIENST;
        } else {
            return Soort.ONBEKEND;
        }
    }

//    public Categorie ontvangGebruikersInvoer_Categorie() {
//        String input = scanner.nextLine().toLowerCase().trim();
//
//        if (input)
//    }

    public List<Categorie> toonAlleCategorien() {
        CategorieDao categorieDao = new CategorieDao(mysql());

        return categorieDao.selectAlleCategorieen();
    }

    public void nieuwArtikel(String naam, BigDecimal prijs, Soort soort, Categorie categorie, String omschrijving) {
        ArtikelDao artikelDao = new ArtikelDao(mysql());

        artikelDao.insert(new Artikel(naam, prijs, soort, categorie, omschrijving));
    }

}
