package com.example.test;

import javafx.scene.control.PasswordField;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    Scanner leer = new Scanner(System.in);

    static ArrayList<User> users = new ArrayList<>();


    public static void Admin() {
        String user = "admin";
        String pass = "supersecreto";
        User admin = new User(user, pass);
        users.add(admin);
    }

    public static void aggUser() {

    }

    public static boolean searchUser(String  user, String  pass) {
        for (User value : users) {
            if (value.getUser().equals(user) && value.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
