package domain.gebruiker;

import util.Session;

import javax.inject.Inject;

public class GebruikerService {

    @Inject
    private GebruikerDao gebruikerDao;

    public Gebruiker controleerEmailadres(String emailadres) {
        if (gebruikerDao.select(emailadres) != null) {
            return gebruikerDao.select(emailadres);
        } else {
            return null;
        }
    }
}
