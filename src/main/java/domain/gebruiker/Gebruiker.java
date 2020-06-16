package domain.gebruiker;

import domain.AbstractEntity;
import service.SecurityService;

import javax.persistence.*;
import javax.validation.constraints.*;

import static domain.gebruiker.Rol.GEBRUIKER;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "gebruikers")
public class Gebruiker {

    @Id @Email @NotNull @Column(unique = true)
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
