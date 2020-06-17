package domain.adres;

import javax.inject.Inject;

public class AdresService {

    @Inject
    private AdresDao adresDao;

    public Adres nieuwAdres(String straatnaam, String huisnummer, String postcode, String woonplaats) {
        return new Adres(straatnaam, huisnummer, postcode, woonplaats);
    }

    public void adresToevoegenAanDatabase(Adres adres) {adresDao.insert(adres);}
}
