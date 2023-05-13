package homework;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    T findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    long count();

    void deleteById(ID id);

    void delete(T entity);

}
