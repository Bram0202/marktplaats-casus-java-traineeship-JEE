import frontend.console.SchermHandler;
import frontend.pagina.StartPagina;

public class App {

    public static void main(String[] args) {
        new App() {};
    }

    App() { new SchermHandler(new StartPagina()); }

}