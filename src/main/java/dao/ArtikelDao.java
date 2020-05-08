package dao;

import domain.Artikel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//TODO: lijst met producten tonen aan gebruiker.
public class ArtikelDao {
    private final EntityManager em;

    public ArtikelDao(EntityManager em) {
        this.em = em;
    }

    // CREATE (INSERT)
    public void insert(Artikel a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    // READ (SELECT)
    public Artikel find(int id) {
        return em.find(Artikel.class, id);
    }

    public Artikel select(String naam) {
        TypedQuery<Artikel> query = em.createQuery("SELECT a FROM Artikel a WHERE a.naam = :naam", Artikel.class);
        query.setParameter("naam", naam);
        return query.getSingleResult();
    }

    // UPDATE
    public Artikel update(Artikel a) {
        em.getTransaction().begin();
        Artikel merged = em.merge(a);
        em.getTransaction().commit();
        return merged;
    }

    // DELETE
    public void delete(String naam) {
        Artikel select = select(naam);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }
}
