package com.example.bas.Service.Model;
/**
 * Basic POJOs med variabler, contructor, getters, setters og toString metoden.
 */
public class Role {
    private int userRoleId;
    private String username;
    private String role;

    public Role(int userRoleId, String username, String role) {
        this.userRoleId = userRoleId;
        this.username = username;
        this.role = role;
    }

    public Role() {
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
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

    @Override
    public String toString() {
        return "Role{" +
                "userRoleId=" + userRoleId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

