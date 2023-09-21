package com.techelevator;

public class Airplane {

    String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats - this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){

        if(forFirstClass){
            if (getAvailableFirstClassSeats() - totalNumberOfSeats >= 0) {
                this.bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        }else {
            if(getAvailableCoachSeats() - totalNumberOfSeats >= 0) {
                this.bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    };

}
