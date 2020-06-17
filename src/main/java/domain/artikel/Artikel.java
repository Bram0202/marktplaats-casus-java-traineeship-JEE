package domain.artikel;

import domain.AbstractEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "artikelen")
@NoArgsConstructor
public class Artikel extends AbstractEntity {

    @NotNull
    private String naam;

    @NotNull
    private BigDecimal prijs;

    @NotNull
    @Enumerated(value = STRING)
    private Soort soort;

    private String omschrijving;

    private String categorie;

    public Artikel(String naam, BigDecimal prijs, Soort soort, String omschrijving, String categorie) {
        this.naam = naam;
        this.prijs = prijs;
        this.soort = soort;
        this.omschrijving = omschrijving;
        this.categorie = categorie;
    }

}
