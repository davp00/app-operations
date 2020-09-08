package com.example.appoperations;

public class User {
    private String userName;
    private String pass;

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public boolean compare(String userName, String pass)
    {
        return this.userName.equalsIgnoreCase(userName) && this.pass.equalsIgnoreCase(pass);
    }

    public boolean isEmpty()
    {
        return this.userName.isEmpty() && this.pass.isEmpty();
    }
}
