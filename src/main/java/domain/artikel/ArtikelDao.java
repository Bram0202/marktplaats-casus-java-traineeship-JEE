package domain.artikel;

import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//TODO: lijst met producten tonen aan gebruiker.

@NoArgsConstructor
@Stateless
public class ArtikelDao {

    @PersistenceContext
    private EntityManager em;

    // CREATE (INSERT)
    public void insert(Artikel a) {
        em.persist(a);
    }

    // READ (SELECT)
    public Artikel find(Long id) {
        return em.find(Artikel.class, id);
    }

    public Artikel select(String naam) {
        TypedQuery<Artikel> query = em.createQuery("SELECT a FROM Artikel a WHERE a.naam = :naam", Artikel.class);
        query.setParameter("naam", naam);
        return query.getSingleResult();
    }

    public List<Artikel> selectAll() {
        TypedQuery<Artikel> query = em.createNamedQuery("SELECT a FROM Artikel a", Artikel.class);
        return query.getResultList();
    }

    // UPDATE
    public Artikel update(Artikel a) {
        Artikel merged = em.merge(a);
        return merged;
    }

    // DELETE
    public void delete(String naam) {
        Artikel select = select(naam);
        if (select != null) {
            em.remove(select);
        }
    }
}
