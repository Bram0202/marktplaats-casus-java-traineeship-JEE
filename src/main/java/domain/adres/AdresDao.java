package domain.adres;

import domain.artikel.Artikel;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoArgsConstructor
@Stateless
public class AdresDao {

    @PersistenceContext
    private EntityManager em;

    // CREATE (INSERT)
    public void insert(Adres a) {
        em.persist(a);
    }
}
