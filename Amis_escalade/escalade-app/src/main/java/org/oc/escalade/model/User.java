package org.oc.escalade.model;

public class User {
    private Long userId;
    private String name;
    private String username;
    private String password;
    private int nbOfConnections;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNbOfConnections() {
        return nbOfConnections;
    }

    public void setNbOfConnections(int nbOfConnections) {
        this.nbOfConnections = nbOfConnections;
    }
}
