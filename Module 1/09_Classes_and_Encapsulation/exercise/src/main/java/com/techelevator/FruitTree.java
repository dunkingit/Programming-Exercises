package com.techelevator;

public class FruitTree {
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    };

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

//    public void setPiecesOfFruitLeft(int piecesOfFruitLeft) {
//        this.piecesOfFruitLeft = piecesOfFruitLeft;
//    }


    //    Create a method called pickFruit that accepts an int called numberOfPiecesToRemove and returns a boolean.
    public boolean pickFruit(int numberOfPiecesToRemove){
        if(getPiecesOfFruitLeft() - numberOfPiecesToRemove >= 0){
            this.piecesOfFruitLeft = (getPiecesOfFruitLeft() - numberOfPiecesToRemove);
            return true;
        };
    return false;
    };
}
