package com.modules.logic;

/*
 * Represents a cell in tic-tac-toe.
 * The cell will only receive 'X' and 'O'(capital o) as values, and it will start as a blank space ' '.
 */

class Cell{
    private char symbol;

    //Creates cell with an initial value of ' '.
    Cell(){
        this.symbol = ' ';
    }

    //Returns symbol from cell, will be used later for verification purposes
    public char getSymbol(){
        return this.symbol;
    }

    /*
     * Changes symbol attribute.
     * Will be used to update symbol once the player places an 'X' or the computer places an 'O'.
     */
    public void setSymbol(char figure){
        this.symbol = figure;
    }
}
