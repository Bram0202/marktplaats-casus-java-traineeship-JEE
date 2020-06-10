package domain.artikel;

import domain.AbstractEntity;
import domain.categorie.Categorie;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "artikelen")
public class Artikel extends AbstractEntity {

    @NotNull
    private String naam;

    @NotNull
    private BigDecimal prijs;

    @NotNull
    @Enumerated(value = STRING)
    private Soort soort;

    private String omschrijving;

    @NotNull
    @ManyToOne(cascade = MERGE)
    private Categorie categorie;

    public Artikel(){}

    public Artikel(String naam, BigDecimal prijs, Soort soort, Categorie categorie) {
        this(naam, prijs, soort, categorie, null);
    }

    public Artikel(String naam, BigDecimal prijs, Soort soort, Categorie categorie, String omschrijving) {
        this.naam = naam;
        this.prijs = prijs;
        this.soort = soort;
        this.categorie = categorie;
        setCategorie(categorie);
        this.omschrijving = omschrijving;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
        categorie.addArtikel(this);
    }
}
