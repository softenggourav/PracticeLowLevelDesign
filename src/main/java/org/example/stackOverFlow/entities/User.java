package org.example.stackOverFlow.entities;

public class User {
    private final String username;
    private int reputation;

    public User(String username) {
        this.username=username;
        this.reputation=0;
    }

    public String getUsername(){
        return this.username;
    };

    public int getReputation(){
        return this.reputation;
    }

    public void updateReputation(int delta) {
        this.reputation+=delta;
    }
}
