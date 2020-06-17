package domain.categorie;

import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Stateless
public class CategorieDao {

    @PersistenceContext
    private EntityManager em;

    // CREATE (INSERT)
    public void insert(Categorie c) {
        try {
            em.persist(c);
        } catch (RollbackException | NonUniqueResultException e) {
            System.out.println(e); //TODO: De al bestaande domain.categorie teruggeven aan de domain.gebruiker.
        }
    }

    // READ (SELECT)
    public Categorie find(Long id) {
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
        Categorie merged = em.merge(c);
        return merged;
    }

    // DELETE
    public void delete(String naam) {
        Categorie select = select(naam);
        if (select != null) {
            em.remove(select);
        }
    }
}
