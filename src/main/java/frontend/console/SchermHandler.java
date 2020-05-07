package frontend.console;

import frontend.pagina.AbstractPagina;
import org.slf4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static util.Util.logger;

public class SchermHandler {

    private String titel;
    private String subtitel;
    private String menuOptie1;
    private String menuOptie2;
    private String menuOptie3;
    private String menuOptie4;
    private AbstractPagina menuOptie1Link;
    private AbstractPagina menuOptie2Link;
    private AbstractPagina menuOptie3Link;
    private AbstractPagina menuOptie4Link;

    private final Logger log = logger(getClass());


    public SchermHandler(AbstractPagina ap) {
        this.titel = ap.getTitel();
        this.subtitel = ap.getPaginaTitel();
        this.menuOptie1 = ap.getMenuOptie1();
        this.menuOptie2 = ap.getMenuOptie1();
        this.menuOptie3 = ap.getMenuOptie1();
        this.menuOptie4 = ap.getMenuOptie1();
        this.menuOptie1Link = ap.getMenuOptie1Link();

        log(ap);
        int gekozenPagina = ontvangGebruikersInput();

        try {
            switch (gekozenPagina) {
                case 1:
                    new SchermHandler(menuOptie1Link);
                    break;
                case 2:
                    new SchermHandler(menuOptie2Link);
                    break;
                case 3:
                    new SchermHandler(menuOptie3Link);
                    break;
                case 4:
                    new SchermHandler(menuOptie4Link);
                    break;
                default:
                    log("Ongeldige invoer!");
                    new SchermHandler(ap);
            }
        } catch (InputMismatchException e){
            log(e);
            log("Ongeldige invoer!");
            new SchermHandler(ap);
        }
    }

    private int ontvangGebruikersInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    private void log(Object o) {
        log.info(o + "");
    }
}
