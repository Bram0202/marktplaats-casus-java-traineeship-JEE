package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class Util {

    private Util() { }

    public static EntityManager mysql() { return Persistence.createEntityManagerFactory("MySQL").createEntityManager();}
    public static EntityManager h2() { return Persistence.createEntityManagerFactory("H2").createEntityManager();}
}