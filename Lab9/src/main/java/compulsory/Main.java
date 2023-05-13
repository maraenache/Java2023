package compulsory;

import homework.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        Artist artist1 = new Artist("Irina");
        em.persist(artist);
        ArtistRepository a1 = new ArtistRepository();
        Artist a2 = a1.findById(2);
        System.out.println("Artistul cu id ul 2 este " + a2);
        System.out.println(a1.findByName("The Beatles"));
        Artist b = a1.create(artist1);//se adauga artist 1 in baza de date
        em.close();
        emf.close();
    }
}
