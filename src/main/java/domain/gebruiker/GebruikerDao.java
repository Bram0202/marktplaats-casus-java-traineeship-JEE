package domain.gebruiker;

import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.*;

@NoArgsConstructor
@Stateless
public class GebruikerDao {

    @PersistenceContext
    private EntityManager em;

    // CREATE (INSERT)
    public void insert(Gebruiker g) {
        em.persist(g);
    }

    // READ (SELECT)
    public Gebruiker find(Long id) {
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker select(String emailadres) {
        TypedQuery<Gebruiker> query = em.createQuery("SELECT g FROM Gebruiker g WHERE g.emailadres = :emailadres", Gebruiker.class);
        query.setParameter("emailadres", emailadres);
        return query.getSingleResult();
    }

    // UPDATE
    public Gebruiker update(Gebruiker g) {
        Gebruiker merged = em.merge(g);
        return merged;
    }

    // DELETE
    public void delete(String emailadres) {
        Gebruiker select = select(emailadres);
        if (select != null) {
            em.remove(select);
        }
    }

}
