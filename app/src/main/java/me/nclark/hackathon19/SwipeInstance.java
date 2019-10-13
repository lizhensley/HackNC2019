package me.nclark.hackathon19;

import java.util.Date;

public class SwipeInstance {

    private Date date;

    public SwipeInstance(Date date) {

        this.date = date;

    }

    public SwipeInstance() {

        this(new java.util.Date());

    }

    public Date getDate() { return date; }

    public void setDate(Date newDate) { date = newDate; }

}
