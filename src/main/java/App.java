import dao.GebruikerDao;
import frontend.console.LoginHandler;
import org.slf4j.Logger;

import javax.persistence.EntityManager;

import static util.Util.logger;
import static util.Util.mysql;

public class App {

    private final Logger log = logger(getClass());

    public static void main(String[] args) {
        new App() {
        };
    }

    App() {
        log("Starting Marktplaats Online");
        LoginHandler loginHandler = new LoginHandler();
        String emailadres = loginHandler.ontvangUserInputEmailadres();
        String wachtwoord = loginHandler.ontvangUserInputWachtwoord();

        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);
        gebruikerDao.login(emailadres, wachtwoord);

    }

    private void log(Object o) { log.info(o + "");}
}
