import dao.GebruikerDao;
import service.LoginService;
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
        SchermHandler schermHandler = new SchermHandler(new StartPagina());

//        boolean loginIsGeldig = false;
//        do {
//            loginIsGeldig = login();
//        } while (!loginIsGeldig);
    }

    public boolean login() {
        EntityManager em = mysql();
        GebruikerDao gebruikerDao = new GebruikerDao(em);
        LoginService loginService = new LoginService();

        String emailadres = loginService.ontvangUserInputEmailadres();
        String wachtwoord = loginService.ontvangUserInputWachtwoord();

        try {
            return gebruikerDao.login(emailadres, wachtwoord);
        } catch (NoResultException e) {
            log(e);
            log("Onbekkende combinatie van e-mailadres en wachtwoord!");
            return false;
        }
    }

    private void log(Object o) {
        log.info(o + "");
    }
}
