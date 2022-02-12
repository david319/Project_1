package com.example.test;

public class User {

    // Attributes
    protected String nameC;
    protected String username;
    protected String password;
    protected int yearO;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUser() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public static class UserContents extends User {
        public UserContents(String nameC, String username, String password, int yearO) {
            super(username, password);
            this.nameC = nameC;
            this.yearO = yearO;
        }

        public String getUser() {
            return super.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return super.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class UserLimited extends User {
        public UserLimited(String nameC, String username, String password, int yearO) {
            super(username, password);
            this.nameC = nameC;
            this.yearO = yearO;
        }

        public String getUser() {
            return super.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return super.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}

