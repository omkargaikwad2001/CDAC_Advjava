package com.example.demo.entities;

// class to hold login response info (SESSION BASED)
public class UserInfoResponse {

    String username;
    String role;

    public UserInfoResponse() {
        super();
    }

    public UserInfoResponse(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
