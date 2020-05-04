package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorieen")
public class Categorie extends AbstractEntity {

    @NotNull
    private String naam;

    @OneToMany(mappedBy = "categorie")
    private List<Product> producten = new ArrayList<>();

    public Categorie(){}

    public Categorie(String naam) {
        this.naam = naam;
    }

    public void addProduct(Product product) {
        this.producten.add(product);
    }
}
