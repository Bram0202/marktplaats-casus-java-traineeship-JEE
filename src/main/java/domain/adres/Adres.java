package domain.adres;

import domain.AbstractEntity;
import domain.gebruiker.Gebruiker;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adressen")
@NoArgsConstructor
public class Adres extends AbstractEntity {

    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;

    @OneToMany(mappedBy = "adres")
    private List<Gebruiker> gebruikers = new ArrayList<>();

    public Adres(String straatnaam, String huisnummer, String postcode, String woonplaats) {
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public void addGebruiker(Gebruiker gebruiker) {
        this.gebruikers.add(gebruiker);
    }

}
