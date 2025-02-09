package com.example;

import java.util.Date;

public abstract class Shape implements Drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        this.dateCreated = new Date();
    }

    public Shape(String color) {
        this.color = color;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String getName();
}