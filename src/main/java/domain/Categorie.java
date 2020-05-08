package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorieen", uniqueConstraints={@UniqueConstraint(columnNames={"naam"})})
public class Categorie extends AbstractEntity {

    @NotNull
    private String naam;

    @OneToMany(mappedBy = "categorie")
    private List<Artikel> artikelen = new ArrayList<>();

    public Categorie(){}

    public Categorie(String naam) {
        this.naam = naam;
    }

    public void addArtikel(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    @Override
    public String toString() {
        return naam;
    }

    public String getNaam() {
        return naam;
    }
}
