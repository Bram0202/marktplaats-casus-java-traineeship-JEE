package dao;

import domain.Gebruiker;
import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProductDao {
    private final EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    // CREATE (INSERT)
    public void insert(Product p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    // READ (SELECT)
    public Product find(int id) {
        return em.find(Product.class, id);
    }

    public Product select(String naam) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.naam = :naam", Product.class);
        query.setParameter("naam", naam);
        return query.getSingleResult();
    }

    // UPDATE
    public Product update(Product p) {
        em.getTransaction().begin();
        Product merged = em.merge(p);
        em.getTransaction().commit();
        return merged;
    }

    // DELETE
    public void delete(String naam) {
        Product select = select(naam);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }
}
