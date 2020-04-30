import dao.GebruikerDao;
import domain.Gebruiker;

import javax.persistence.EntityManager;

import static util.Util.mysql;

public class App {

    public static void main(String[] args) {
        new App() {};
    }

    App() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);

//        System.out.println("Welkom bij Marktplaats Online!");
//        System.out.println("[1] Login\n[2] Registreren");

        gebruikerDao.insert(new Gebruiker("test@mail.com", "tester"));
    }
}
