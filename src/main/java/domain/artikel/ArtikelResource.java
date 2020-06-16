package domain.artikel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("artikelen")
@Produces(MediaType.APPLICATION_JSON)
public class ArtikelResource implements Serializable {

    @Inject
    private ArtikelService artikelService;

    @GET
    @Path("{id}")
    public Artikel get(@PathParam("id") int id) {
        return artikelService.get(id);
    }
}
