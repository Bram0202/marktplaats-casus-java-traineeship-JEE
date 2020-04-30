import java.util.Scanner;

public class MenuNavigator {

    private Scanner scanner = new Scanner(System.in);

    private int vraagGebruikersInput(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();
    }

    void welkomsMenu() {
        int input;
        System.out.println("Welkom bij Marktplaats Online!");
        System.out.println("[1] Login\n[2] Registreren");
    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
