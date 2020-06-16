package util;

import domain.gebruiker.Gebruiker;

public class Session {

    public static Gebruiker au;

    public static boolean ingelogd = true;

    public static void setGebruiker(Gebruiker au) {
        Session.au = au;
    }

    public static String getEmailadres() {
        return au.getEmailadres();
    }

    public static boolean getIngelogd() {
        if (au == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void uitloggen() {
        au = null;
    }
}
