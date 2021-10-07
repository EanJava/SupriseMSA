package com.ms.model;

import java.util.Objects;

public class Surprise {

    private String name;

    public Surprise() {
    }

    public Surprise(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surprise Surprise = (Surprise) o;
        return name.equals(Surprise.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Surprise{" +
                "name='" + name + '\'' +
                '}';
    }
}
