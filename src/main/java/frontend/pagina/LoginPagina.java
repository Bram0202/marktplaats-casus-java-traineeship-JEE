package frontend.pagina;

import frontend.console.SchermHandler;
import service.LoginService;

public class LoginPagina extends AbstractPagina {

    public LoginPagina() {
        setPaginaTitel("inlogpagina");
    }

    @Override
    public void paginaSpecifiekeEigenschappen() {
        LoginService loginService = new LoginService();

        log("E-mailadres: ");
        String emailadres = loginService.vraagGebruikerOmEmailadres();
        log("Wachtwoord: ");
        String wachtwoord = loginService.vraagGebruikerOmWachtwoord();

        //TODO: SysteemMeldingen toevoegen.
        boolean loginGelukt = loginService.loginIsCorrect(emailadres, wachtwoord);
        if (loginGelukt) {
            new SchermHandler(new HoofdMenuPagina());
        } else {
            new SchermHandler(new LoginPagina());
        }
    }

}

