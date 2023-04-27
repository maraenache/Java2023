package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");

            ConnectionDB.getConnection().commit();

            var albums = new AlbumDAO();
            albums.create(2020, "weekends", "weekend", "Pop");
            albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");

            ConnectionDB.getConnection().commit();

            List<Album> allAlbums = albums.findAll();

            for (Album album : allAlbums) {
                System.out.println(album);
            }
            ConnectionDB.getConnection().close();
        } catch (SQLException e) {
            ConnectionDB.rollback();
            System.err.println(e);
        }
    }
}
