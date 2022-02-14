package com.example.test;

public abstract class Event {

    protected String Id, Title, description, DateE, TypeE;
    protected double amount;

    public Event(String id, String title, String description, String dateE, String typeE, double amount) {
        Id = id;
        Title = title;
        this.description = description;
        DateE = dateE;
        TypeE = typeE;
        this.amount = amount;
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

    public void setTypeE(String typeE) {
        this.TypeE = typeE;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "Event [Id=" + Id + ", Title=" + Title + ", description=" + description + ", Date=" + DateE + ", TypeE=" + TypeE + ", amount=" + amount + "]";
    }


    public static class EventD extends Event {
        // Atributos
        protected String typeD;
        protected String team1;
        protected String team2;

        public EventD(String id, String title, String description, String dateE, String typeE, double amount, String typeD, String team1, String team2) {
            super(id, title, description, dateE, typeE, amount);
            this.typeD = typeD;
            this.team1 = team1;
            this.team2 = team2;
        }

        public String toString() {
            return super.toString() + " Deporte=" + typeD + " Nombre equipo 1=" + team1 + " Nombre equipo 2=" + team2;
        }
    }

    public static class EventM extends Event {
        // Atributos
        protected String TypeM;

        public EventM(String id, String title, String description, String dateE, String typeE, double amount, String typeM) {
            super(id, title, description, dateE, typeE, amount);
            this.TypeM = typeM;
        }

        public String toString() {
            return super.toString() + " Tipo de musica=" + TypeM;
        }
    }

    public class EventR extends Event {

        public EventR(String id, String title, String description, String dateE, String typeE, double amount) {
            super(id, title, description, dateE, typeE, amount);
        }

        public String toString() {
            return super.toString();
        }
    }
}
