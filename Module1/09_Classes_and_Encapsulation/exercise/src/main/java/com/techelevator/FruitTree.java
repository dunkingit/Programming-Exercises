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
    public boolean pickFruit(int numberOfPiecesToRemove){
        if(getPiecesOfFruitLeft() - numberOfPiecesToRemove >= 0){
            this.piecesOfFruitLeft = (getPiecesOfFruitLeft() - numberOfPiecesToRemove);
            return true;
        };
    return false;
    };
}
