package frontend.pagina;

public class StartPagina extends AbstractPagina {

    public StartPagina() {
        setPaginaTitel("startpagina");
        setMenuOptie1("Inloggen");
        setMenuOptie2("Aanmelden");
        setMenuOptie3("Wachtwoord vergeten");
        setMenuOptie4("");
        setMenuOptie1Link(new LoginPagina());
    }

    @Override
    public void doDingen() {}

}
