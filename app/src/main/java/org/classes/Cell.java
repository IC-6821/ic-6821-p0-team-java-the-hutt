package org.classes;

import interfaces.GameCell;

class Cell implements GameCell {
    private char symbol;

    //Creates cell with an initial value of ' '.
    Cell() {
        this.symbol = ' ';
    }

    //Returns symbol from cell, will be used later for verification purposes
    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char figure) {
        this.symbol = figure;
    }
}
