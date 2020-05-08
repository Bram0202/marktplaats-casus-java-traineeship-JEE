package dao;

import domain.Gebruiker;

import javax.persistence.*;

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
    public Gebruiker find(int id) {
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker select(String emailadres) {
        TypedQuery<Gebruiker> query = em.createQuery("SELECT g FROM Gebruiker g WHERE g.emailadres = :emailadres", Gebruiker.class);
        query.setParameter("emailadres", emailadres);
        return query.getSingleResult();
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
