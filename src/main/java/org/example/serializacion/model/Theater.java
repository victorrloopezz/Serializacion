package org.example.serializacion.model;
import java.io.Serializable;

public class Theater implements Serializable {
    private String name;
    private String location;

    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
