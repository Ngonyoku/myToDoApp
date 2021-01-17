package com.ngonyoku.model;

public class Users {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String location;
    private String gender;


    public Users(String firstName, String lastName, String username, String password, String location, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }
}
