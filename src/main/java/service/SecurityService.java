package service;

import java.security.SecureRandom;
import java.util.Base64;

public class SecurityService {

    public String wachtwoordGen() {
        SecureRandom secureRandom = new SecureRandom();

        byte[] byteArray = new byte[20];
        secureRandom.nextBytes(byteArray);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(byteArray);
    }
}
