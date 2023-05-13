package homework.repos;


import compulsory.Genre;

import javax.persistence.TypedQuery;

public class GenreRepositoryImpl extends AbstractRepository<Genre, Integer> implements GenreRepository {

    public GenreRepositoryImpl() {
        super(Genre.class);
    }

    @Override
    public Genre findByName(String name) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g WHERE g.name = :name", Genre.class);
        query.setParameter("name", name);
        return executeQuery(query).stream().findFirst().orElse(null);
    }

    @Override
    public <S extends Genre> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public <S extends Genre> Iterable<S> saveAll(Iterable<S> entities) {
        return super.saveAll(entities);
    }
}