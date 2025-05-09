package org.example.dao;

import org.example.model.Album;
import org.example.model.Artist;
import org.example.model.Genre;
import org.example.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlbumDAO extends AbstractDAO<Album> {

    @Override
    protected String getTableName() {
        return "albums";
    }

    protected Album mapResultSetToModel(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int releaseYear = resultSet.getInt("release_year");
        String title = resultSet.getString("title");
        String artist = new ArtistDAO().findById(resultSet.getInt("artist")).getName();

        // Get the genres for the album from the album_genre table
        List<String> genres = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(
                "SELECT g.name " +
                        "FROM genres g " +
                        "JOIN album_genre ag ON ag.genre_id = g.id " +
                        "WHERE ag.album_id =" + id)) {
            try (ResultSet resultSet2 = preparedStatement.executeQuery()) {
                while (resultSet2.next()) {
                    genres.add(resultSet2.getString("name"));
                }
            }
        }
        return new Album(releaseYear, title, artist, genres);
    }

    @Override
    protected String createFieldInsertList() {
        return "release_year, title, artist";
    }

    @Override
    protected String createPlaceholderList() {
        return "?, ?, ?";
    }

    @Override
    protected void mapModelToPreparedStatement(PreparedStatement preparedStatement, Album object) throws SQLException {
        preparedStatement.setInt(1, object.getReleaseYear());
        preparedStatement.setString(2, object.getTitle());
        preparedStatement.setInt(3, new ArtistDAO().findByName(object.getArtist()));
    }

    public void addGenresToAlbum(Album album) throws SQLException {
        int albumId = album.getId();
        List<String> genres = album.getGenres();
        if (genres != null && !genres.isEmpty()) {
            Connection connection = ConnectionDB.getConnection();
            for (String genre : genres) {
                Integer genreId = new GenreDAO().findByName(genre);
                if (genreId != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO album_genre (album_id, genre_id) VALUES (?, ?)")) {
                        preparedStatement.setInt(1, albumId);
                        preparedStatement.setInt(2, genreId);
                        preparedStatement.executeUpdate();
                    }
                }
            }
        }
    }

    @Override
    public void create(Album object) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                createInsertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            mapModelToPreparedStatement(preparedStatement, object);

            // Execute the insert statement
            preparedStatement.executeUpdate();

            // Obtain the autogenerated ID
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    object.setId(resultSet.getInt(1));
                } else {
                    throw new SQLException("Model creation failed, no autogenerated ID obtained");
                }
            }

            // Associate the album with its genres
            addGenresToAlbum(object);
        }
    }
}