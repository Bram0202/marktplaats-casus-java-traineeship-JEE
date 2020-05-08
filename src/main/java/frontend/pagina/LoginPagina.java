package frontend.pagina;

import service.LoginService;

public class LoginPagina extends AbstractPagina {

    public LoginPagina() {
        this.setPaginaTitel("inlogpagina");

    }

    public void doDingen() {
        LoginService loginService = new LoginService();
        String emailadres = loginService.vraagGebruikerOmEmailadres();
        String wachtwoord = loginService.vraagGebruikerOmWachtwoord();

        boolean loginGelukt = loginService.login(emailadres, wachtwoord);
        if(loginGelukt) {
            
        }

    }
}

