package me.nclark.hackathon19;

import java.util.ArrayList;
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
    private Date[] swipeHistory;

    private int[] numSwipesPerDay;
    private Date[] days;

    public User(int ID, String username, String password, int totalSwipes, int currentSwipes, Date[] swipeHistory) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.totalSwipes = totalSwipes;
        this.currentSwipes = currentSwipes;
        this.swipeHistory = swipeHistory;
    }
    public User() {
        this(0, "N/A", "N/A", 0, 0, new Date[0]);
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
        swipeHistory[swipeHistory.length] = new SwipeInstance().getDate();
    }
    public void donateSwipe() { currentSwipes--; }
    public Date[] getSwipeHistory() {
        Date[] newArr = new Date[swipeHistory.length];
        for (int i = 0; i < swipeHistory.length; i++) {
            newArr[i] = swipeHistory[i];
        }
        return newArr;
    }

    public Date[] getDays() {
        ArrayList<Date> days = new ArrayList<>();

        for(Date date : swipeHistory) {
            if(!days.contains(date)) {
                days.add(date);
            }
        }

        Date[] daysArray = new Date[days.size()];
        return days.toArray(daysArray);
    }

    public int[] getNumSwipesPerDay() {

        Date[] dateArr = getDays();

        numSwipesPerDay = new int[dateArr.length];

        for (int i = 0; i < swipeHistory.length; i++) {
            for (int j = 0; j < dateArr.length; j++) {
                if(swipeHistory[i].equals(dateArr[j])) {
                    numSwipesPerDay[j] += 1;
                }
            }
        }

        return numSwipesPerDay;
    }

}
