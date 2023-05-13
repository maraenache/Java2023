package homework.repos;

import homework.model.Album;
import homework.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    List<Album> findByTitle(String title);

    List<Album> findByReleaseYear(int releaseYear);

    List<Album> findByArtistName(String name);

}
