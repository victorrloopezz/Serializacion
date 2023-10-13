package org.example.serializacion.model;
import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private int duration;

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
