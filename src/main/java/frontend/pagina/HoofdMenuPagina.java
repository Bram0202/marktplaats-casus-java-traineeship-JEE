package frontend.pagina;

public class HoofdMenuPagina extends AbstractPagina {

    public HoofdMenuPagina() {
        setPaginaTitel("Hoofdmenu");
        setMenuOptie1("Artikelen bekijken");
        setMenuOptie2("Artikel aanbieden");
        setMenuOptie3("'Mijn profiel' bekijken");
        setMenuOptie4("Voorwaarden bekijken");
        setMenuOptie2Link(new ArtikelAanbiedenPagina());
    }

    @Override
    public void doDingen() {}
}
