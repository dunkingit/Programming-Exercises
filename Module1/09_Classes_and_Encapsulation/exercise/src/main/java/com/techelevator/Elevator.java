package com.techelevator;

public class Elevator {
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen = false;

    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public boolean isDoorOpen() {
        return this.doorOpen;
    }

    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen){
            if(desiredFloor <= numberOfFloors && desiredFloor > currentFloor){
                this.currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen){
            if(desiredFloor <= numberOfFloors && desiredFloor > currentFloor){
                this.currentFloor = desiredFloor;
            }
        }
    }
}
