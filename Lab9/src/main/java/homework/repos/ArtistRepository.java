package homework.repos;

import homework.CrudRepository;
import homework.model.Artist;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    List<Artist> findByName(String name);

}
