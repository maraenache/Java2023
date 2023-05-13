// AlbumRepositoryImpl.java
package homework.repos;

import homework.model.Album;

import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepositoryImpl extends AbstractRepository<Album, Integer> implements AlbumRepository {

    public AlbumRepositoryImpl() {
        super(Album.class);
    }

    @Override
    public List<Album> findByTitle(String title) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.title LIKE CONCAT('%', :title, '%')", Album.class);
        query.setParameter("title", title);
        return executeQuery(query);
    }

    @Override
    public List<Album> findByReleaseYear(int releaseYear) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.releaseYear = :releaseYear", Album.class);
        query.setParameter("releaseYear", releaseYear);
        return executeQuery(query);
    }

    @Override
    public List<Album> findByArtistName(String name) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a JOIN FETCH a.artist WHERE a.artist.name LIKE CONCAT('%', :name, '%')", Album.class);
        query.setParameter("name", name);
        return executeQuery(query);
    }

    @Override
    public <S extends Album> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public <S extends Album> Iterable<S> saveAll(Iterable<S> entities) {
        return super.saveAll(entities);
    }
}
