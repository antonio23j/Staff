package com.test.mysql.first;

import com.test.mysql.first.services.DatabaseService;
import com.test.mysql.first.models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseService databaseService = new DatabaseService();
        databaseService.createConnection();


         */
        int nr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("(Press 1 -> Print all  " +
                "\nPress 2 -> Add new user" +
                "\nPress 3 -> Find a user" +
                "\nPress 4 -> Delete user" +
                "\nPress 5 -> Update a user" +
                "\nPress 0 -> Close program)");
        boolean hasFinished = false;
        while (!hasFinished) {
            System.out.println("Press a number:");
            nr = scanner.nextInt();
            switch (nr) {
                case 1:
                    System.out.println(databaseService.findAll());
                    break;
                case 2:
                    insert(databaseService);
                    break;
                case 3:
                    System.out.println("Enter name to find: ");
                    System.out.println(databaseService.findByName(scanner.next()));
                    break;
                case 4:
                    System.out.println("Enter id to delete: ");
                    databaseService.delete(scanner.nextInt());
                    break;
                case 5:
                    update(databaseService);
                    break;
                case 0:
                    System.out.println("Bye");
                    hasFinished = true;
                    break;
            }
        }

    }
    private static void insert(DatabaseService databaseService) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        User user1 = new User();
        System.out.println("Enter name: ");
        user1.setName(scanner.next());
        System.out.println("Enter age: ");
        user1.setAge(scanner.nextInt());
        databaseService.insert(user1);
        System.out.println("User saved successfully");
    }
    private static void update(DatabaseService databaseService) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        User user1 = new User();
        System.out.println("Enter id you want to update: ");
        user1.setId(scanner.nextInt());
        System.out.println("Enter new name: ");
        user1.setName(scanner.next());
        System.out.println("Enter new age: ");
        user1.setAge(scanner.nextInt());
        databaseService.update(user1);
        System.out.printf("User %s has been updated successfully%n",user1.getName());
    }
}




