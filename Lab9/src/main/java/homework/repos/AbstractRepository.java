package homework.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractRepository<T, ID extends Serializable> {

    @PersistenceContext
    protected EntityManager entityManager; // Change access modifier to protected

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T object) {
        entityManager.persist(object);
    }

    public void update(T object) {
        entityManager.merge(object);
    }

    public void delete(T object) {
        entityManager.remove(object);
    }

    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void deleteById(ID id) {
        T entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
    }

    public long count() {
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        cq    .select(entityManager.getCriteriaBuilder().count(cq.from(entityClass)));
        return entityManager.createQuery(cq).getSingleResult();
    }

    public boolean existsById(ID id) {
        return entityManager.find(entityClass, id) != null;
    }

    // Log execution time of JPQL statements
    protected <E> List<E> executeQuery(TypedQuery<E> query) {
        long startTime = System.currentTimeMillis();
        List<E> result = query.getResultList();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Query execution time: " + executionTime + " ms");
        return result;
    }
    public <S extends T> S save(S entity)  {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        if (entityManager.contains(entity)) {
            entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }
        return entity;
    }
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        if (entities == null) {
            throw new IllegalArgumentException("The entity list must not be null");
        }
        entities.forEach(entity -> result.add(save(entity)));
        return result;
    }

}