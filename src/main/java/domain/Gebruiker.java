package domain;

import service.SecurityService;

import javax.persistence.*;
import javax.validation.constraints.*;

import static domain.Rol.GEBRUIKER;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "gebruikers")
public class Gebruiker extends AbstractEntity {

    @Email @NotNull
    private String emailadres;

    private String naam;

    @Size(min = 8) @NotNull
    private String wachtwoord = new SecurityService().wachtwoordGen();

    @Enumerated(value = STRING)
    private Rol rol = GEBRUIKER;

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

    public String getEmailadres() {
        return emailadres;
    }

    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
