package me.nclark.hackathon19;

import java.util.Date;

public class User {

    // User's School ID
    private int ID;

    // User's login info
    private String username;
    private String password;

    // User's current meal plan stats
    private int totalSwipes;
    private int currentSwipes;

    // Stores swipes User has made
    private SwipeInstance[] swipeHistory;

    public User(int ID, String username, String password, int totalSwipes, int currentSwipes, SwipeInstance[] swipeHistory) {

        this.ID = ID;
        this.username = username;
        this.password = password;

        this.totalSwipes = totalSwipes;
        this.currentSwipes = currentSwipes;

        this.swipeHistory = swipeHistory;

    }

    public User() {
        this(0, "N/A", "N/A", 0, 0, new SwipeInstance[0]);
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTotalSwipes() {
        return totalSwipes;
    }

    public int getCurrentSwipes() {
        return currentSwipes;
    }

    public void setID(int newID) {
        ID = newID;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public void setTotalSwipes(int newTotalSwipes) {
        totalSwipes = newTotalSwipes;
    }

    public void setCurrentSwipes(int newCurrentSwipes) {
        currentSwipes = newCurrentSwipes;
    }

    public void addSwipe() {
        currentSwipes++;
        swipeHistory[swipeHistory.length] = new SwipeInstance();
    }

    public void donateSwipe() { currentSwipes--; }

    public SwipeInstance[] getSwipeHistory() {
        SwipeInstance[] newArr = new SwipeInstance[swipeHistory.length];
        for (int i = 0; i < swipeHistory.length; i++) {
            newArr[i] = swipeHistory[i];
        }
        return newArr;
    }

}
