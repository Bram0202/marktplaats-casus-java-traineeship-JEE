package frontend.pagina;

import frontend.console.SchermHandler;
import service.LoginService;

public class LoginPagina extends AbstractPagina {

    public LoginPagina() {
        this.setPaginaTitel("inlogpagina");

    }

    @Override
    public void doDingen() {
        LoginService loginService = new LoginService();
        String emailadres = loginService.vraagGebruikerOmEmailadres();
        String wachtwoord = loginService.vraagGebruikerOmWachtwoord();

        boolean loginGelukt = loginService.loginIsCorrect(emailadres, wachtwoord);
        System.out.println(loginGelukt);

        if (loginGelukt) {
            new SchermHandler(new HoofdMenuPagina());
        } else {
            new SchermHandler(new LoginPagina());
        }

    }
}

