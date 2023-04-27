package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;
import java.sql.*;

public class AlbumDAO {
    public void create(int releaseYear, String title, String artist, String genres) throws SQLException {
        Connection con = ConnectionDB.getConnection();

        String[] genreArray = genres.split(",");
        Integer[] genreIds = new Integer[genreArray.length];
        for (int i = 0; i < genreArray.length; i++) {
            String genre = genreArray[i];
            GenreDAO genreDAO = new GenreDAO();
            Integer genreId = genreDAO.findByName(genre);
            if (genreId == null) {
                genreDAO.create(genre);
                genreId = genreDAO.findByName(genre);
            }
            genreIds[i] = genreId;
        }

        ArtistDAO artistDAO = new ArtistDAO();
        Integer artistId = artistDAO.findByName(artist);
        if (artistId == null) {
            artistDAO.create(artist);
            artistId = artistDAO.findByName(artist);
        }

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist) values (?, ?, ?) returning id")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setInt(3, artistId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int albumId = rs.getInt(1);

            for (int genreId : genreIds) {
                try (PreparedStatement pstmt2 = con.prepareStatement(
                        "insert into albums_genres (album_id, genre_id) values (?, ?)")) {
                    pstmt2.setInt(1, albumId);
                    pstmt2.setInt(2, genreId);
                    pstmt2.executeUpdate();
                }
            }

            con.commit();
        }
    }
    public List<Album> findAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        Connection con = ConnectionDB.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, release_year, title, artist from albums")) {
            while (rs.next()) {
                Album album = new Album(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                albums.add(album);
            }
        }
        return albums;
    }
}