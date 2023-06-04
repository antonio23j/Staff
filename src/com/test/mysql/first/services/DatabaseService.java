package com.test.mysql.first.services;

import com.test.mysql.first.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface {

    private Connection connect;
    public void createConnection() throws SQLException {
        connect = DriverManager.getConnection("jdbc:mysql://localhost/Staff?"
                + "user=root&password=admin123");
    }


    @Override
    public List<User> findAll() throws SQLException {
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from User");
        List<User> user = extractUserFromResultSet(resultSet);

        return user;
    }

    @Override
    public List<User> findByName(String name) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("select * from User where name = ?");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return extractUserFromResultSet(resultSet);
    }

    @Override
    public void insert(User user) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("insert into User values(?,?,?)");
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getName());
        preparedStatement.setInt(3,user.getAge());
        preparedStatement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("delete from User where id = ?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("update User set name = ? , age = ? where id = ?");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setInt(2,user.getAge());
        preparedStatement.setInt(3,user.getId());
        preparedStatement.executeUpdate();
    }

    private List<User> extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        List<User> list = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            User user = new User(id, name,age);
            list.add(user);
        }
        return list;
    }

}
