package homework.repos;

import compulsory.Genre;
import homework.CrudRepository;


public interface GenreRepository extends CrudRepository<Genre, Integer> {

    Genre findByName(String name);

}
