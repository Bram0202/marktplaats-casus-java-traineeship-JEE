package service;

import dao.GebruikerDao;
import domain.Gebruiker;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Scanner;

import static util.Util.logger;
import static util.Util.mysql;

public class LoginService extends util.Logger {
//    private final Logger log = logger(getClass());
    private final Scanner scanner = new Scanner(System.in);

    public String vraagGebruikerOmEmailadres() {
        log("E-mailadres: ");
        return scanner.nextLine();
    }

    public String vraagGebruikerOmWachtwoord() {
        log("Wachtwoord: ");
        return scanner.nextLine();
    }

    public boolean controleerLoginPoging() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);
        LoginService loginService = new LoginService();

        String emailadres = loginService.vraagGebruikerOmEmailadres();
        String wachtwoord = loginService.vraagGebruikerOmWachtwoord();

        try {
            return gebruikerDao.login(emailadres, wachtwoord);
        } catch (NoResultException e) {
            log(e);
            log("Onbekkende combinatie van e-mailadres en wachtwoord!");
            return false;
        }
    }

    public boolean loginIsCorrect(String emailadres, String wachtwoord) {
        EntityManager em = mysql();

        try {
            TypedQuery<Gebruiker> query = em.createQuery(
                    "SELECT g FROM Gebruiker g " +
                            "WHERE g.emailadres = :emailadres AND g.wachtwoord = :wachtwoord"
                    , Gebruiker.class);
            query.setParameter("emailadres", emailadres);
            query.setParameter("wachtwoord", wachtwoord);
            return true;
        } catch (NoResultException e) {
            log(e);
            return false;
        }
    }

    public boolean login(String emailadres, String wachtwoord) throws NoResultException {
        GebruikerDao gDao = new GebruikerDao(mysql());
        Gebruiker g = gDao.select(emailadres);

        if (g != null && emailadres.equals(g.getEmailadres()) && wachtwoord.equals(g.getWachtwoord())) {
            System.out.println("Welkom " + g.getNaam() + "!");
            log("Succes!");
            return true;
        } else {
            return false;
        }
    }

//    private void log(Object o) {
//        log.info(o + "");
//    }

}
