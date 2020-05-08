package frontend.pagina;

public class StartPagina extends AbstractPagina {

    public StartPagina() {
        this.setPaginaTitel("startpagina");
        this.setMenuOptie1("Inloggen");
        this.setMenuOptie2("Aanmelden");
        this.setMenuOptie3("Wachtwoord vergeten");
        this.setMenuOptie4("");
        this.setMenuOptie1Link(new LoginPagina());
    }

    @Override
    public void doDingen() {}

}
