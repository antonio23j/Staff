package de.vogella.mysql.first;

import de.vogella.mysql.first.models.User;
import de.vogella.mysql.first.services.DatabaseService;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        int i=0;
        DatabaseService databaseService = new DatabaseService();
        databaseService.createConnection();
        User user1 = new User("Bill",20);
        databaseService.insert(user1);
        System.out.println(databaseService.findAll());
        user1.setName("Jack");
        databaseService.update(user1);
        System.out.println(databaseService.findAll());
        databaseService.delete(user1.getId());
        System.out.println(databaseService.findAll());

    }
}

