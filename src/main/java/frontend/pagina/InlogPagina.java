package frontend.pagina;

import service.LoginService;

public class InlogPagina extends AbstractPagina{

    private LoginService loginService = new LoginService();

    public InlogPagina() {
        this.setPaginaTitel("inlogpagina");

    }

}

