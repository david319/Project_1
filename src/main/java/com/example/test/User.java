package com.example.test;

public class User {

    // Attributes
    protected String typeUser;
    protected String nameC;
    protected String username;
    protected String password;
    protected int age;

    public User(String username, String password) {
        nameC = "";
        this.username = username;
        this.password = password;
        age = 0;
        typeUser = "";
    }

    public String getUser() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public void setTipeUser(String tipeUser) {
        this.typeUser = tipeUser;
    }

    public String getTipeUser() {
        return typeUser;
    }

    public void setName(String nameC) {
        this.nameC = nameC;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class UserContents extends User {
        public UserContents(String nameC, String username, String password, int age, String tipeUser) {
            super(username, password);
            this.nameC = nameC;
            this.age = age;
            this.typeUser = tipeUser;
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
        public UserLimited(String nameC, String username, String password, int age, String tipeUser) {
            super(username, password);
            this.nameC = nameC;
            this.age = age;
            this.typeUser = tipeUser;
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

    public String toString() {
        return "User: " + username + " Password: " + password + " Tipe User: " + typeUser + " Name: " + nameC + " Age: " + age;
    }

}

