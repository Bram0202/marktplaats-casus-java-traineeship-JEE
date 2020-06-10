package domain.categorie;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategorieDao {
    private final EntityManager em;

    public CategorieDao(EntityManager em) {
        this.em = em;
    }


    // CREATE (INSERT)
    public void insert(Categorie c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (RollbackException | NonUniqueResultException e) {
            System.out.println(e); //TODO: De al bestaande domain.categorie teruggeven aan de domain.gebruiker.
        }
    }

    // READ (SELECT)
    public Categorie find(int id) {
        return em.find(Categorie.class, id);
    }

    public Categorie select(String naam) {
        TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.naam = :naam", Categorie.class);
        query.setParameter("naam", naam);
        return query.getSingleResult();
    }

    public List<Categorie> selectAlleCategorieen() {
        TypedQuery<Categorie> query = em.createQuery("select c from Categorie c", Categorie.class);
        return query.getResultList();
    }

    // UPDATE
    public Categorie update(Categorie c) {
        em.getTransaction().begin();
        Categorie merged = em.merge(c);
        em.getTransaction().commit();
        return merged;
    }

    // DELETE
    public void delete(String naam) {
        Categorie select = select(naam);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }
}