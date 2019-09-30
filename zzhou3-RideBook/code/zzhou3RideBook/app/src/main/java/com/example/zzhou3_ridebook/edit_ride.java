package com.example.zzhou3_ridebook;
import java.io.Serializable;

/**
 * Class edit_ride is to initialize the object which contains the attribute of RideBook
 */

public class edit_ride implements Serializable{
    private String ride;
    private String date;
    private String time;
    private float distance;
    private float average_speed;
    private int acirpm;
    private String comment;

    public edit_ride(String ride, String date, String time, float distance, float average_speed, int acirpm, String comment) {
        this.ride = ride;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.average_speed = average_speed;
        this.acirpm = acirpm;
        this.comment = comment;

    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(int average_speed) {
        this.average_speed = average_speed;
    }

    public int getAcirpm() {
        return acirpm;
    }

    public void setAcirpm(int acirpm) {
        this.acirpm = acirpm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

