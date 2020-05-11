package frontend.pagina;

import util.Logger;

public abstract class AbstractPagina extends Logger implements CustomActies  {
    private final String titel = "MARKTPLAATS ONLINE";
    private String paginaTitel = "";
    private String systeemMelding = ""; // TODO: systeemMeldingen in een andere kleur weergeven in de console.
    private String menuOptie1 = "";
    private String menuOptie2 = "";
    private String menuOptie3 = "";
    private String menuOptie4 = "";
    private AbstractPagina menuOptie1Link;
    private AbstractPagina menuOptie2Link;
    private AbstractPagina menuOptie3Link;
    private AbstractPagina menuOptie4Link;
    // TODO: Een parent/ga terug naar vorige pagina optie toevoegen.

    @Override
    public String toString() {

        if (!systeemMelding.isEmpty()) {
            return "\n\n" +
                    titel + " - " + paginaTitel + "\n" +
                    systeemMelding + "\n" +
                    menuOptie1 + "\n" +
                    menuOptie2 + "\n" +
                    menuOptie3 + "\n" +
                    menuOptie4 + "\n";
        } else {
            return "\n\n" +
                    titel + " - " + paginaTitel + "\n" +
                    menuOptie1 + "\n" +
                    menuOptie2 + "\n" +
                    menuOptie3 + "\n" +
                    menuOptie4 + "\n";
        }
    }

    public void setPaginaTitel(String paginaTitel) {
        this.paginaTitel = paginaTitel.toLowerCase();
    }

    public void setSysteemMelding(String systeemMelding) {
        this.systeemMelding = "MELDING: " + systeemMelding;
    }

    public void setMenuOptie1(String menuOptie1) {
        this.menuOptie1 = "[1] " + menuOptie1;
    }

    public void setMenuOptie2(String menuOptie2) {
        this.menuOptie2 = "[2] " + menuOptie2;
    }

    public void setMenuOptie3(String menuOptie3) {
        this.menuOptie3 = "[3] " + menuOptie3;
    }

    public void setMenuOptie4(String menuOptie4) {
        this.menuOptie4 = "[4] " + menuOptie4;
    }

    public AbstractPagina getMenuOptie1Link() {
        if (menuOptie1Link != null) {
            return menuOptie1Link;
        } else {
            return this;
        }
    }

    public void setMenuOptie1Link(AbstractPagina menuOptie1Link) {
        this.menuOptie1Link = menuOptie1Link;
    }

    public AbstractPagina getMenuOptie2Link() {
        if (menuOptie2Link != null) {
            return menuOptie2Link;
        } else {
            return this;
        }
    }

    public void setMenuOptie2Link(AbstractPagina menuOptie2Link) {
        this.menuOptie2Link = menuOptie2Link;
    }

    public AbstractPagina getMenuOptie3Link() {
        if (menuOptie3Link != null) {
            return menuOptie3Link;
        } else {
            return this;
        }
    }

    public void setMenuOptie3Link(AbstractPagina menuOptie3Link) {
        this.menuOptie3Link = menuOptie3Link;
    }

    public AbstractPagina getMenuOptie4Link() {
        if (menuOptie4Link != null) {
            return menuOptie4Link;
        } else {
            return this;
        }
    }

    public void setMenuOptie4Link(AbstractPagina menuOptie4Link) {
        this.menuOptie4Link = menuOptie4Link;
    }

}
