package com.example.test;

import java.util.ArrayList;

public class Users {

    static ArrayList<User> users = new ArrayList<>();

    public static void Admin() {
        String user = "admin";
        String pass = "supersecreto";
        User admin = new User(user, pass);
        users.add(admin);
    }

    public static void aggUser(String nameC, String user, String pass, int age, String typeUser) {
        switch (typeUser) {
            case "admin":
                User user1 = new User(user, pass);
                user1.setName(nameC);
                user1.setAge(age);
                user1.setTipeUser("Admin");
                users.add(user1);
                break;
            case "Contenido":
                User user2 = new User.UserContents(nameC, user, pass, age, typeUser);
                users.add(user2);
                break;
            case "Limitado":
                User user3 = new User.UserLimited(nameC, user, pass, age, typeUser);
                users.add(user3);
                break;
        }
    }

    public static void listUsers() {
        for (User value : users) {
            System.out.println(value.toString());
        }
    }

    public static boolean validLog(String user, String pass) {
        for (User value : users) {
            if (value.getUser().equals(user) && value.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchUser(String user) {
        for (User value : users) {
            if (value.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

}
