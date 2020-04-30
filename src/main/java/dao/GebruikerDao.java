package dao;

import domain.Gebruiker;

import javax.persistence.EntityManager;

public class GebruikerDao {
    private final EntityManager em;

    public GebruikerDao(EntityManager em) {
        this.em = em;
    }

    // CREATE (INSERT)
    public void insert(Gebruiker g) {
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
    }

    // READ (SELECT)
    public Gebruiker select(int id) {
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker select(String emailadres) {
        return em.find(Gebruiker.class, emailadres);
    }

    // UPDATE
    public Gebruiker update(Gebruiker g) {
        em.getTransaction().begin();
        Gebruiker merged = em.merge(g);
        em.getTransaction().commit();
        return merged;
    }

    // DELETE
    public void delete(String emailadres) {
        Gebruiker select = select(emailadres);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }

}
