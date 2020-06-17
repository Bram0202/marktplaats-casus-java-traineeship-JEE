package domain.artikel;

import domain.categorie.CategorieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.math.BigDecimal;

@Path("artikelen")
@Produces(MediaType.APPLICATION_JSON)
public class ArtikelResource implements Serializable {

    @Inject
    private ArtikelService artikelService;

    @Inject
    private CategorieService categorieService;

    @GET
    @Path("{id}")
    public Artikel get(@PathParam("id") int id) {
        return artikelService.get(id);
    }

    @GET
    @Path("/artikel-aanbieden-pagina")
    public Artikel artikelToevoegen(
            @QueryParam("naam") String naam,
            @QueryParam("prijs") BigDecimal prijs,
            @QueryParam("soort") String soortInput,
            @QueryParam("omschrijving") String omschrijving,
            @QueryParam("categorie") String categorieInput) {

        Soort soort = artikelService.stringToSoort(soortInput);
        Artikel artikel = artikelService.nieuwArtikel(naam, prijs, soort, omschrijving, categorieInput);
        artikelService.artikelToevoegenAanDatabase(artikel);

        return artikel;
    }
}
