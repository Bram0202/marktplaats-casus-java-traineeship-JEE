package domain;

import service.SecurityService;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static domain.Rol.GEBRUIKER;

@Entity
@Table(name = "gebruikers")
public class Gebruiker extends AbstractEntity {

    @Email @NotNull
    private String emailadres;

    private String naam;

    @Size(min = 8) @NotNull
    private String wachtwoord = new SecurityService().wachtwoordGen();

//    TODO: Enum is geen db type!
//    private Enum rol = GEBRUIKER;

    public Gebruiker() {}

    public Gebruiker(String emailadres, String naam) {
        this.emailadres = emailadres;
        this.naam = naam;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
