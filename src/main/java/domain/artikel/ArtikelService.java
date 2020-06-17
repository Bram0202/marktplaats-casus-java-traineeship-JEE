package domain.artikel;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArtikelService {

    @Inject
    private ArtikelDao artikelDao;

    List<Artikel> artikelen = new ArrayList<>();

    public ArtikelService() {
    }

    public Artikel get(int id) {
        return artikelen.get(id);
    }

    public Soort stringToSoort(String input) {
        input = input.trim().toLowerCase();

        if (input.equals("dienst")) {
            return Soort.DIENST;
        } else if (input.equals("product")) {
            return Soort.PRODUCT;
        } else {
            return Soort.ONBEKEND;
        }
    }

    public Artikel nieuwArtikel(String naam, BigDecimal prijs, Soort soort, String omschrijving, String categorie) {
        return new Artikel(naam, prijs, soort, omschrijving, categorie);
    }

    public void artikelToevoegenAanDatabase(Artikel artikel) {
        artikelDao.insert(artikel);
    }
}
