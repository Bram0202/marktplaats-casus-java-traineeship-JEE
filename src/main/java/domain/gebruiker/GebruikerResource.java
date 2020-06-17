package domain.gebruiker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("gebruikers")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource implements Serializable {

    @Inject
    private GebruikerService gebruikerService;

    @GET
    @Path("/login")
    public Gebruiker login(@QueryParam("emailadres") String emailadres,
                           @QueryParam("wachtwoord") String wachtwoord) {

        Gebruiker gebruiker = gebruikerService.controleerEmailadres(emailadres);

        if (gebruiker.getWachtwoord().equals(wachtwoord)) {
            return gebruiker;
        } else {
            Response.ok().entity("<hello>ok</hello>").build();
            Response.serverError().build();
            return null;
        }
    }

}
