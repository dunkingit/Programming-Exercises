package com.techelevator;

abstract class Wall {
    private String color;
    private String name;

    public Wall(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public abstract int getArea();
}
