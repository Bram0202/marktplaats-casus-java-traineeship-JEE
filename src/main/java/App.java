import dao.GebruikerDao;
import domain.Gebruiker;
import frame.Window;

import javax.persistence.EntityManager;
import javax.swing.*;

import static util.Util.mysql;

public class App {

    public static void main(String[] args) {
        new App() {};
    }

    App() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);

        new Window();
    }


}
