package service;

import org.slf4j.Logger;
import java.util.Scanner;

import static util.Util.logger;

public class LoginService {
    private final Logger log = logger(getClass());
    private final Scanner scanner = new Scanner(System.in);

    public String ontvangUserInputEmailadres() {
        log("E-mailadres: ");
        return scanner.nextLine();
    }

    public String ontvangUserInputWachtwoord() {
        log("Wachtwoord: ");
        return scanner.nextLine();
    }

    private void log(Object o) {
        log.info(o + "");
    }

}
