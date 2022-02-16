package com.example.test;

import java.util.ArrayList;

public class Event {

    // Atributos
    protected String typeD;
    protected String team1;
    protected String team2;
    static ArrayList<String> jugadores1 = new ArrayList<>();
    static ArrayList<String> jugadores2 = new ArrayList<>();
    static ArrayList<String> peopleM = new ArrayList<>();
    static ArrayList<String> peopleR = new ArrayList<>();
    protected String Id, Title, description, DateE, TypeE;
    protected double amount;
    protected String TypeM;

    public Event(String id, String title, String description, String dateE, String typeE, double amount) {
        Id = id;
        Title = title;
        this.description = description;
        DateE = dateE;
        TypeE = typeE;
        this.amount = amount;
    }

    public Event(String id, String title, String description, String date, String typeD, String team1, String team2, String jugadores1, String jugadores2, String typeM, String peopleM, String peopleR) {
        Id = id;
        Title = title;
        this.description = description;
        DateE = date;
        TypeE = typeD;
        this.team1 = team1;
        this.team2 = team2;

        this.TypeM = typeM;
        this.peopleM.add(peopleM);
        this.peopleR.add(peopleR);

    }


    public String getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return DateE;
    }

    public void setDate(String date) {
        this.DateE = date;
    }

    public String getTypeE() {
        return TypeE;
    }


    public double getAmount() {
        return amount;
    }



    public String toString() {
        return "Event [Id=" + Id + ", Title=" + Title + ", description=" + description + ", Date=" + DateE + ", TypeE=" + TypeE + ", amount=" + amount + "]";
    }

    public void setAmount(String newValue) {
        this.amount = Double.parseDouble(newValue);
    }

    public void setTypeD(String newValue) {
        this.TypeE = newValue;
    }

    public void setTeam1(String newValue) {
        this.Title = newValue;
    }

    public void setTeam2(String newValue) {
        this.description = newValue;
    }

    public void setTypeM(String newValue) {
        this.DateE = newValue;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTypeM() {
        return TypeM;
    }

    public void setJugadores1(String jugadores1) {
        this.jugadores1.add(jugadores1);
    }

    public void setJugadores2(String jugadores2) {
        this.jugadores2.add(jugadores2);
    }

    public void setpeopleM(String integrantesM) {
        this.peopleM.add(integrantesM);
    }

    public void setpeopleR(String integrantesR) {
        this.peopleR.add(integrantesR);
    }

    public String  getTypeD() {
        return typeD;
    }

    public String getJugadores1() {
        return jugadores1.toString();
    }

    public String getJugadores2() {
        return jugadores2.toString();
    }

    public String getPeopleM() {
        return peopleM.toString();
    }

    public String getPeopleR() {
        return peopleR.toString();
    }

    public void setTypeR(String peopleR) {
        this.peopleR.add(peopleR);
    }

    public static class EventD extends Event {

        public EventD(String id, String title, String description, String dateE, String typeE, double amount, String typeD, String team1, String team2) {
            super(id, title, description, dateE, typeE, amount);
            this.typeD = typeD;
            this.team1 = team1;
            this.team2 = team2;
           jugadores1 = jugadores1;
           jugadores2 = jugadores2;
        }

        public String getTeam1() {
            return super.getTeam1();
        }

        public String getTeam2() {
            return super.getTeam2();
        }

        public void setTypeD(String newValue) {
            super.setTypeD(newValue);
        }

        public void setTeam1(String newValue) {
            super.setTeam1(newValue);
        }

        public void setTeam2(String newValue) {
            super.setTeam2(newValue);
        }

        public void setJugadores1(String newValue) {
            jugadores1.add(newValue);
        }

        public void setJugadores2(String newValue) {
            jugadores2.add(newValue);
        }

        public String toString() {
            return super.toString() + " Deporte=" + typeD + " Nombre equipo 1=" + team1 + " Nombre equipo 2=" + team2 + " Jugadores equipo 1=" + jugadores1.toString() + " Jugadores equipo 2=" + jugadores2.toString();
        }
    }

    public static class EventM extends Event {
        // Atributos


        public EventM(String id, String title, String description, String dateE, String typeE, double amount, String typeM) {
            super(id, title, description, dateE, typeE, amount);
            this.TypeM = typeM;
        }

        public String getTypeM() {
            return super.getTypeM();
        }

        public String toString() {
            return super.toString() + " Tipo de musica=" + TypeM;
        }

        public void setTypeM(String newValue) {
            super.setTypeM(newValue);
        }
    }

    public static class EventR extends Event {

        public EventR(String id, String title, String description, String dateE, String typeE, double amount) {
            super(id, title, description, dateE, typeE, amount);
            peopleR = peopleR;
        }

        public String toString() {
            return super.toString();
        }
    }
}
