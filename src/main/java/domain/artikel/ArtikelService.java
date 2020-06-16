package domain.artikel;

import domain.categorie.CategorieDao;
import domain.categorie.Categorie;
import util.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static util.Util.mysql;

public class ArtikelService {

    @Inject
    private ArtikelDao artikelDao;

    List<Artikel> artikelen = new ArrayList<>();

    public ArtikelService() {
    }

    public Artikel get(int id) {
        return artikelen.get(id);
    }

}
