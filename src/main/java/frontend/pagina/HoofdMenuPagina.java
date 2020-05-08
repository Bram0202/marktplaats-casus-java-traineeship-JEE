package frontend.pagina;

public class HoofdMenuPagina extends AbstractPagina {

    public HoofdMenuPagina() {
        this("");
    }

    public HoofdMenuPagina(String systeemMelding) {
        setPaginaTitel("Hoofdmenu");
        setMenuOptie1("Artikelen bekijken");
        setMenuOptie2("Artikel aanbieden");
        setMenuOptie3("'Mijn profiel' bekijken");
        setMenuOptie4("Voorwaarden bekijken");
        setMenuOptie2Link(new ArtikelAanbiedenPagina());

        setSysteemMelding(systeemMelding);
    }


    @Override
    public void paginaSpecifiekeEigenschappen() {}
}
