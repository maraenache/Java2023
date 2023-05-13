package homework.repos;

import homework.model.AlbumGenre;

import javax.persistence.TypedQuery;
import java.util.List;
public class AlbumGenreRepositoryImpl extends AbstractRepository<AlbumGenre, Integer> implements AlbumGenreRepository {
    public AlbumGenreRepositoryImpl() {
        super(AlbumGenre.class);
    }

    @Override
    public List<AlbumGenre> findByAlbumTitle(String title) {
        TypedQuery<AlbumGenre> query = entityManager.createQuery("SELECT ag FROM AlbumGenre ag JOIN FETCH ag.album WHERE ag.album.title LIKE CONCAT('%', :title, '%')", AlbumGenre.class);
        query.setParameter("title", title);
        return executeQuery(query);
    }

    @Override
    public <S extends AlbumGenre> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public <S extends AlbumGenre> Iterable<S> saveAll(Iterable<S> entities) {
        return super.saveAll(entities);
    }

}