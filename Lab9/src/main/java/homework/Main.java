package homework;

import homework.model.Album;
import homework.model.Artist;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");

        // Create an EntityManager object
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Create a list of fake artists and persist them
        List<Artist> artists = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Artist artist = new Artist();
            artist.setName("Artist " + i);
            artists.add(artist);
        }
        long startTime = System.currentTimeMillis();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (Artist artist : artists) {
            entityManager.persist(artist);
        }
        entityManager.flush();
        transaction.commit();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Insertion of " + artists.size() + " artists took " + executionTime + " ms.");

        // Create a list of fake albums and persist them
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Album album = new Album();
            album.setTitle("Album " + i);
            album.setReleaseYear(2000 + i % 20);
            album.setArtist(artists.get(i));
            albums.add(album);
        }
        startTime = System.currentTimeMillis();
        transaction = entityManager.getTransaction();
        transaction.begin();
        for (Album album : albums) {
            entityManager.persist(album);
        }
        entityManager.flush();
        transaction.commit();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Insertion of " + albums.size() + " albums took " + executionTime + " ms.");
        // Close the EntityManager and EntityManagerFactory objects
        entityManager.close();
        entityManagerFactory.close();

    }
}
