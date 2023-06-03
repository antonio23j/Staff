package de.vogella.mysql.first.services;

import de.vogella.mysql.first.models.User;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public List<User> findAll() throws SQLException;
    public List<User> findByName(String name) throws SQLException;
    public void insert(User user) throws SQLException;
    public void delete(int id) throws SQLException;
    public void update(User user) throws SQLException;
}
