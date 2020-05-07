package frontend.console;

import frontend.pagina.AbstractPagina;
import org.slf4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static util.Util.logger;

public class SchermHandler {

    private final Logger log = logger(getClass());
    private final AbstractPagina menuOptie1Link;
    private final AbstractPagina menuOptie2Link;
    private final AbstractPagina menuOptie3Link;
    private final AbstractPagina menuOptie4Link;
    private final AbstractPagina huidigePagina;

    public SchermHandler(AbstractPagina abstractPagina) {
        this.huidigePagina = abstractPagina;
        this.menuOptie1Link = abstractPagina.getMenuOptie1Link();
        this.menuOptie2Link = abstractPagina.getMenuOptie2Link();
        this.menuOptie3Link = abstractPagina.getMenuOptie3Link();
        this.menuOptie4Link = abstractPagina.getMenuOptie4Link();

        log(huidigePagina);
        int gekozenPagina = ontvangGebruikersInput();
        new SchermHandler(navigeerNaarVolgendePagina(gekozenPagina));
    }

    private AbstractPagina navigeerNaarVolgendePagina(int gekozenPagina) {
        switch (gekozenPagina) {
            case 1:
                return menuOptie1Link;
            case 2:
                return menuOptie2Link;
            case 3:
                return menuOptie3Link;
            case 4:
                return menuOptie4Link;
            default:
                huidigePagina.setSysteemMelding("Ongeldige invoer!");
                return huidigePagina;
        }
    }

    private int ontvangGebruikersInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            log(e);
            huidigePagina.setSysteemMelding("Ongeldige invoer!");
            new SchermHandler(huidigePagina);
        }
        return -1;
    }

    private void log(Object o) {
        log.info(o + "");
    }
}
