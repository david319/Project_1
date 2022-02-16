package com.example.test;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Events extends Event {

    // Atributos
    static ArrayList<Event> eventsA = new ArrayList<>();
    static ArrayList<Event> eventsC = new ArrayList<>();

    public Events(String id, String title, String description, String dateE, String typeE, double amount) {
        super(id, title, description, dateE, typeE, amount);
    }

    public static void eventDefecto() {
        eventsA.add(new EventD("z", "Deportivo", "Deportivo", "12/12/12", "Deportivo", 100, "Futbol", "Deportivo", "Deportivo"));
    }

    public static String getEventType(String id, String typeUser) {
        if (typeUser.equals("admin")) {
            for (Event event : eventsA) {
                if (event.getId().equals(id)) {
                    return event.getTypeE();
                }
            }
        }
        return "";
    }

    private static void createEventC(String id, String title, String description, String dateE, String typeE, double amount, String typeD, String team1, String team2, String TypeM, ArrayList<Event> events) {
        switch (typeE) {
            case "Deportivo":
                events.add(new EventD(id, title, description, dateE, typeE, amount, typeD, team1, team2));
                break;
            case "Musical":
                events.add(new EventM(id, title, description, dateE, typeE, amount, TypeM));
                break;
            case "Religioso":
                events.add(new EventR(id, title, description, dateE, typeE, amount));
                break;
        }
    }

    public static void createEvent(String id, String title, String description, String dateE, String typeE, double amount, String typeD, String team1, String team2, String TypeM, String typeUser) {
        if (typeUser.equals("Admin")) {
            createEventC(id, title, description, dateE, typeE, amount, typeD, team1, team2, TypeM, eventsA);
        } else if (typeUser.equals("Contenido")) {
            createEventC(id, title, description, dateE, typeE, amount, typeD, team1, team2, TypeM, eventsC);
        }
    }



    public static void DeleteE(String id, String typeUser) {
        if (typeUser.equals("admin")) {
            for (Event event : eventsA) {
                if (event.getId().equals(id)) {
                    eventsA.remove(event);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Evento eliminado");
                    alert.setHeaderText("Evento eliminado");
                    alert.setContentText("El evento ha sido eliminado");
                }
            }
        }
    }

    public static boolean showEvents(String Id, String typeUser) {
        System.out.println(typeUser);
        if (typeUser.equals("admin")) {
            for (Event event : eventsA) {
                if (event.getId().equals(Id)) {
                    return true;
                }
            }
        } else if (typeUser.equals("Contenido")) {
            for (Event event : eventsC) {
                if (event.getId().equals(Id)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchEvent(String id, String typeUser) {
        if (typeUser.equals("admin")) {
            for (Event event : eventsA) {
                if (event.getId().equals(id)) {
                    return true;
                }
            }
        } else if (typeUser.equals("Contenido")) {
            for (Event event : eventsC) {
                if (event.getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
