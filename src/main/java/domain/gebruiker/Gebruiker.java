package domain.gebruiker;

import domain.AbstractEntity;
import lombok.NoArgsConstructor;
import service.SecurityService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static domain.gebruiker.Rol.GEBRUIKER;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "gebruikers")
@NoArgsConstructor
public class Gebruiker extends AbstractEntity {

    @Email
    @NotNull
    @Column(unique = true)
    private String emailadres;

    private String naam;

    @Size(min = 8)
    @NotNull
    private String wachtwoord = new SecurityService().wachtwoordGen();

    @Enumerated(value = STRING)
    private Rol rol = GEBRUIKER;

    public Gebruiker(String emailadres, String naam) {
        this.emailadres = emailadres;
        this.naam = naam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
