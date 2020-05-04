import dao.GebruikerDao;
import domain.Gebruiker;
import frontend.LoginPagina;

import javax.persistence.EntityManager;

import static util.Util.mysql;

public class App {

    public static void main(String[] args) {
        new App() {};
    }

    App() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);

        new LoginPagina();
        gebruikerDao.insert(new Gebruiker("test@mail.com", "Tester"));
    }

}
