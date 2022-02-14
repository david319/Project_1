package com.example.test;

import java.util.ArrayList;

public class Events extends Event {

    // Atributos
    static ArrayList<Event> events = new ArrayList<>();

    public Events(String id, String title, String description, String dateE, String typeE, double amount) {
        super(id, title, description, dateE, typeE, amount);
    }

    public static void createEvent(String id, String title, String description, String dateE, String typeE, double amount, String typeD, String team1, String team2, String TypeM) {
        switch (typeE) {
            case "Deportivo":
                events.add(new EventD(id, title, description, dateE, typeE, amount, typeD, team1, team2));
                break;
            case "Musical":
                events.add(new EventM(id, title, description, dateE, typeE, amount, TypeM));
                break;
            case "Religioso":
                events.add(new Events(id, title, description, dateE, typeE, amount));
                break;
        }
    }

    public void showEvents() {
        for (Event event : events) {
            System.out.println(event.toString());
        }
    }

    public static boolean searchEvent(String id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
