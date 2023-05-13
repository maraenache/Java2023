package compulsory;


import homework.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    private EntityManager em =
            EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

    public Artist create(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        return artist;
    }

    public Artist findById(Integer id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> findByName(String name) {
        var query = em.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
