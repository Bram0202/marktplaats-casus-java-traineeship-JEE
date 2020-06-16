package domain.gebruiker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Produces(MediaType.APPLICATION_JSON)
@Path("gebruikers")
public class GebruikerResource implements Serializable {

    @Inject
    private GebruikerService gebruikerService;

    @GET @Path("/login")
    public Gebruiker login(@QueryParam("emailadres") String emailadres,
                           @QueryParam("wachtwoord") String wachtwoord) {
        System.out.println(emailadres + wachtwoord);

        Gebruiker gebruiker = gebruikerService.controleerEmailadres(emailadres);

        if(gebruiker.getWachtwoord().equals(wachtwoord)) {
            System.out.println("Wachtwoord correct");
            return gebruiker;
        } else {
            System.out.println("Wachtwoord onjuist");
            Response.ok().entity("<hello>ok</hello>").build();
            Response.serverError().build();
            return null;
        }
    }

}
