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
        System.out.println(this.totalFirstClassSeats);
        System.out.println(this.totalCoachSeats);
        System.out.println("Top of it. \n\n");
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
//        bookedFirstClassSeats from totalFirstClassSeats
//        this.availableFirstClassSeats = getBookedFirstClassSeats() - getTotalFirstClassSeats();
//        return this.availableFirstClassSeats;
//       return getBookedFirstClassSeats() - getTotalFirstClassSeats();
        return this.totalFirstClassSeats - this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
//        subtracting bookedCoachSeats from totalCoachSeats.
//        this.availableCoachSeats = getTotalCoachSeats() - getBookedCoachSeats();
//        return this.availableCoachSeats;
//        return getTotalCoachSeats() - getBookedCoachSeats();
//        return this.totalCoachSeats - this.bookedCoachSeats;
        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
//        If forFirstClass is true, add totalNumberOfSeats to the value for bookedFirstClassSeats.
//If forFirstClass is false, add totalNumberOfSeats to the value for bookedCoachSeats.
//It returns true if there were enough seats to make the reservation, otherwise it returns false and the number of booked seats doesn't change.

        int available = getAvailableCoachSeats() + getAvailableFirstClassSeats();
        System.out.println("Avail: " + available);
        System.out.println("Total Number Of Seats: " + totalNumberOfSeats);
        System.out.println("First Class: " + getAvailableFirstClassSeats());
        System.out.println("Coach Class:  " + getAvailableCoachSeats());
        System.out.println("Both: " + (this.bookedFirstClassSeats + this.bookedCoachSeats));
        System.out.println( available < totalNumberOfSeats);
        if(available < totalNumberOfSeats){
            System.out.println("Triggered");
            return false;
        }
        if(forFirstClass){
            if (getAvailableFirstClassSeats() > 0) {
                System.out.println("First Class: Inner IF " + this.bookedFirstClassSeats);
                this.bookedFirstClassSeats += totalNumberOfSeats;
                System.out.println("First Class: After add " + this.bookedFirstClassSeats);
                return true;
            }
            return false;

        }else {
            if(getAvailableCoachSeats() > 0) {
                System.out.println("Coach Class:  Inner IF " + this.bookedCoachSeats);
                this.bookedCoachSeats += totalNumberOfSeats;
                System.out.println("Coach Class:  After add " + this.bookedCoachSeats);
                return true;
            }
            return false;
        }
//        System.out.println(forFirstClass);
//        System.out.println("First Class: " + this.bookedFirstClassSeats);
//        System.out.println("Coach Class:  " + this.bookedCoachSeats);
//        System.out.println("Both: " + (this.bookedFirstClassSeats + this.bookedCoachSeats));
//        System.out.println("Total Number Of Seats: " + totalNumberOfSeats);
//        System.out.println((this.bookedFirstClassSeats + this.bookedCoachSeats) <= totalNumberOfSeats);
//        System.out.println("\n");
//
//        int both = totalNumberOfSeats - (this.bookedFirstClassSeats + this.bookedCoachSeats);
//        System.out.println("Avail: " + available);
//        System.out.println("Both " + both);
//        System.out.println("Check Both " + (both >= 0));
//        return false;
    };

}
