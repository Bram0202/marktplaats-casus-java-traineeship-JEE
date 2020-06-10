package frontend.pagina;

import domain.categorie.Categorie;
import domain.artikel.Soort;
import frontend.console.SchermHandler;
import domain.artikel.ArtikelService;

import java.math.BigDecimal;
import java.util.List;

public class ArtikelAanbiedenPagina extends AbstractPagina {
    ArtikelService artikelService = new ArtikelService();

    public ArtikelAanbiedenPagina() {
        setPaginaTitel("Artikel aanbieden");
    }

    @Override
    public void paginaSpecifiekeEigenschappen() {

        log("Wat is de naam van het artikel?");
        String naam = artikelService.ontvangGebruikersInvoer_naam();

        log("Voor welke prijs wilt u dit artikel aanbieden?");
        BigDecimal prijs = artikelService.ontvangGebruikersInvoer_prijs(); //TODO: Catch InputMisMatchException!

        //TODO: Gebruiker een 'soort' laten kiezen.
//       log("Is dit artikel een 'dienst' of 'product'?");
//       Soort soort = vraagGebruikerOmSoort();

        Categorie categorie = vraagGebruikerOmCategorie();

        log("Voer een omschrijving in: ");
        String omschrijving = artikelService.ontvangGebruikersInvoer_omschrijving();

        artikelService.nieuwArtikel(naam, prijs, Soort.ONBEKEND, categorie, omschrijving);

        new SchermHandler(new HoofdMenuPagina("Succes! Artikel wordt vanaf nu aangeboden."));
    }

    private Soort vraagGebruikerOmSoort() {
        Soort invoer = artikelService.ontvangGebruikersInvoer_Soort();

        if (invoer.equals(Soort.ONBEKEND)) {
            vraagGebruikerOmSoort();
        } else {
            return invoer;
        }
        return Soort.ONBEKEND;
    }

    private Categorie vraagGebruikerOmCategorie() {
        int counter = 1;
        int invoer = 0;
        Categorie resultaat = new Categorie();

        List<Categorie> categorieList = artikelService.toonAlleCategorien();
        log("Kies een van de volgende categorieën:");

        for (Categorie categorie : categorieList) {
            log("" + counter + ": " + categorie);
            counter++;
        }
        // TODO: Catch InputMisMatchException!
        invoer = artikelService.ontvangGebruikersInvoer_int() - 1;

        if (invoer >= 0 && invoer < categorieList.size()) {
            resultaat = categorieList.get(invoer);
        }

        return resultaat;
    }

}
