package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName){
            this.possibleMarks = possibleMarks;
            this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        //    The total number of correct marks submitter received on the assignment.
        return earnedMarks;
    }

    public int getPossibleMarks() {
//        The number of possible marks on the assignment.
        return possibleMarks;
    }

    public String getSubmitterName() {
//        The submitter's name for the assignment.
        return submitterName;
    }

    public String getLetterGrade() {
//      The letter grade for the assignment.
        String letter = "";
        int min = (int)(Math.min(this.getEarnedMarks(), this.getPossibleMarks()));
        int grade = min;
        if (grade >= 90){
            letter = "A";
        } else if (grade >= 80) {
            letter = "B";
        }
        else if (grade >= 70) {
            letter = "C";
        }else if (grade >= 60) {
            letter = "D";
        }
        else{
            letter = "F";
        };
        this.letterGrade = letter;
        return this.letterGrade;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
}
