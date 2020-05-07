import dao.GebruikerDao;
import frontend.console.LoginHandler;
import frontend.console.SchermHandler;
import frontend.pagina.StartPagina;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
        SchermHandler schermHandler = new SchermHandler(new StartPagina());


//        boolean loginIsGeldig = false;
//        do {
//            loginIsGeldig = login();
//        } while (!loginIsGeldig);


    }

    public boolean login() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);
        LoginHandler loginHandler = new LoginHandler();

//        clearConsole();
        String emailadres = loginHandler.ontvangUserInputEmailadres();
        String wachtwoord = loginHandler.ontvangUserInputWachtwoord();

        try {
            return gebruikerDao.login(emailadres, wachtwoord);
        } catch (NoResultException e) {
            log(e);
//            clearConsole();
            log("Onbekkende combinatie van e-mailadres en wachtwoord!");
            return false;
        }
    }

    private void clearConsole() {
        log("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private void log(Object o) {
        log.info(o + "");
    }
}
