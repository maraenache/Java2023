package org.example;
import org.example.dao.AlbumDAO;
import org.example.dao.ArtistDAO;
import org.example.dao.GenreDAO;
import org.example.model.Album;
import org.example.model.Artist;
import org.example.model.Genre;
import org.example.util.ConnectionDB;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();
            artists.create(new Artist("Pink Floyd"));
            artists.create(new Artist("Michael Jackson"));

            var genres = new GenreDAO();
            genres.create(new Genre("Rock"));
            genres.create(new Genre("Funk"));
            genres.create(new Genre("Soul"));
            genres.create(new Genre("Pop"));

            var albums = new AlbumDAO();
            albums.create(new Album(1979, "The Wall", "Pink Floyd", List.of("Rock")));
            albums.create(new Album(1982, "Thriller", "Michael Jackson", List.of("Funk", "Soul", "Pop")));

            var allAlbums = albums.findAll();
            for (Album album : allAlbums) {
                System.out.println(album);
            }
            ConnectionDB.getConnection().rollback();
            ConnectionDB.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            ConnectionDB.rollback();
        }
    }
}
