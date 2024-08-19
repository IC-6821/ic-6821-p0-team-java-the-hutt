package org.classes;

import interfaces.GameBoard;

public final class Board implements GameBoard {
    private Cell[][] board;
    private static final int MAX_POSITION = 9;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    Board() {
        board = new Cell[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void setCell(int yCoordinate, int xCoordinate, char symbol) {
        board[yCoordinate][xCoordinate].setSymbol(symbol);
    }

    public boolean canPlace(int yCoordinate, int xCoordinate) {
        return board[yCoordinate][xCoordinate].getSymbol() == ' ';
    }


    public char getBoardSymbol(int yCoordinate, int xCoordinate) {
        return board[yCoordinate][xCoordinate].getSymbol();
    }

    private boolean leftColumnWin(char symbol) {
        return board[0][0].getSymbol() == symbol 
        && board[1][0].getSymbol() == symbol 
        && board[2][0].getSymbol() == symbol;
    }

    private boolean midColumnWin(char symbol) {
        return board[0][1].getSymbol() == symbol 
        && board[1][1].getSymbol() == symbol 
        && board[2][1].getSymbol() == symbol;
    }

    private boolean rightColumnWin(char symbol) {
        return board[0][2].getSymbol() == symbol 
        && board[1][2].getSymbol() == symbol 
        && board[2][2].getSymbol() == symbol;
    }

    private boolean topRowWin(char symbol) {
        return board[0][0].getSymbol() == symbol 
        && board[0][1].getSymbol() == symbol 
        && board[0][2].getSymbol() == symbol;
    }

    private boolean midRowWin(char symbol) {
        return board[1][0].getSymbol() == symbol 
        && board[1][1].getSymbol() == symbol 
        && board[1][2].getSymbol() == symbol;
    }

    private boolean bottomRowWin(char symbol) {
        return board[2][0].getSymbol() == symbol 
        && board[2][1].getSymbol() == symbol 
        && board[2][2].getSymbol() == symbol;
    }

    private boolean mainDiagonalWin(char symbol) {
        return board[0][0].getSymbol() == symbol 
        && board[1][1].getSymbol() == symbol 
        && board[2][2].getSymbol() == symbol;
    }

    private boolean secondaryDiagonalWin(char symbol) {
        return board[0][2].getSymbol() == symbol 
        && board[1][1].getSymbol() == symbol 
        && board[2][0].getSymbol() == symbol;
    }

    public boolean verifyWin(char symbol) {
        return leftColumnWin(symbol) 
        || midColumnWin(symbol) 
        || rightColumnWin(symbol) 
        || topRowWin(symbol) 
        || midRowWin(symbol) 
        || bottomRowWin(symbol) 
        || mainDiagonalWin(symbol) 
        || secondaryDiagonalWin(symbol);
    }

    private int countBusyCells() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].getSymbol() != ' ') {
                    count++;
                } 
            }
        }
        return count;
    }

    public boolean checkForTie() {
        if (countBusyCells() == MAX_POSITION) {
            return true;
        }
        return false;
    }
}
