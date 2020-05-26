package com.example.demoadmin.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
public class User {
    @Id
    private String user_id;
    private String password;

    public User() {}

    public User(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User" + "\t"
                + user_id + "\t"
                + password + "\t";
    }
}
