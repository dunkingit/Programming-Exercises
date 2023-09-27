package com.techelevator;

public class RectangleWall extends Wall{
    private final int length;

    private final int height;

    public RectangleWall(String color, String name, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }


    @Override
    public int getArea() {
        return this.length * this.height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + length + "x" + height + ") " + "rectangle";
    }
}
