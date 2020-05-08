import frontend.console.SchermHandler;
import frontend.pagina.ArtikelAanbiedenPagina;
import frontend.pagina.StartPagina;

public class App {

    public static void main(String[] args) {
        new App() {
        };
    }

    App() {
//      new SchermHandler(new StartPagina());
        new SchermHandler(new ArtikelAanbiedenPagina());
    }

}
