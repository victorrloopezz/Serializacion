package org.example.serializacion.model;

import java.io.Serializable;

public class Session implements Serializable {
    private int capacity;
    private String hour;
    private final Movie movie;
    private final Theater theater;

    public Session (int capacity, String hour, Movie movie, Theater theater) {
        this.capacity = capacity;
        this.hour = hour;
        this.movie = movie;
        this.theater = theater;
    }

    public int getCapacity() {
        return capacity;
    }


    public String getHour() {
        return hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }
}
