package homework.repos;

import homework.model.AlbumGenre;
import homework.CrudRepository;

import java.util.List;

public interface AlbumGenreRepository extends CrudRepository<AlbumGenre, Integer> {

    List<AlbumGenre> findByAlbumTitle(String title);

}