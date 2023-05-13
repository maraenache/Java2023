package org.example.dao;
import org.example.model.AbstractEntity;
import org.example.model.Artist;
import org.example.util.ConnectionDB;

import java.sql.*;


public class ArtistDAO extends AbstractDAO<Artist> {

    @Override
    protected String getTableName() {
        return "artists";
    }

    @Override
    protected Artist mapResultSetToModel(ResultSet resultSet) throws SQLException {
        return new Artist(resultSet.getInt("id"), resultSet.getString("name"));
    }

    @Override
    protected String createFieldInsertList() {
        return "name";
    }

    @Override
    protected String createPlaceholderList() {
        return "?";
    }

    @Override
    protected void mapModelToPreparedStatement(PreparedStatement preparedStatement, Artist object) throws SQLException {
        preparedStatement.setString(1, object.getName());
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id FROM artists WHERE name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }
}
