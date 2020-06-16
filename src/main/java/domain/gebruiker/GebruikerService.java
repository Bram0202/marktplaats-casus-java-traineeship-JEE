package domain.gebruiker;

import javax.inject.Inject;

public class GebruikerService {

    @Inject
    private GebruikerDao gebruikerDao;

    public Gebruiker controleerEmailadres(String emailadres) {
        if (gebruikerDao.find(emailadres) != null) {
            return gebruikerDao.find(emailadres);
        } else {
            // TODO: return iets anders dan null.
            return null;
        }
    }
}
