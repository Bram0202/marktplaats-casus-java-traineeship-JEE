import java.util.Scanner;

public class App {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App(){};
    }

    App() {
        System.out.println("Welkom. Wat is uw naam?");
        String input = scanner.nextLine();
    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
