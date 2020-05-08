package service;

import domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Scanner;

import static util.Util.mysql;

public class LoginService extends util.Logger {
    private final Scanner scanner = new Scanner(System.in);

    public String vraagGebruikerOmEmailadres() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public String vraagGebruikerOmWachtwoord() {
        return scanner.nextLine();
    }

    //TODO: Dit is niet hoofdlettergevoelig!
    public boolean loginIsCorrect(String emailadres, String wachtwoord) {
        EntityManager em = mysql();

        try {
            TypedQuery<Gebruiker> query = em.createQuery(
                    "SELECT g FROM Gebruiker g " +
                            "WHERE g.emailadres = :emailadres AND g.wachtwoord = :wachtwoord"
                    , Gebruiker.class);
            query.setParameter("emailadres", emailadres);
            query.setParameter("wachtwoord", wachtwoord);
            query.getSingleResult();

            return true;
        } catch (NoResultException e) {
            log(e);
            return false;
        } finally {
            em.close();
        }
    }

}
