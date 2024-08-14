package com.modules.logic;

public class Board {
    private Cell[][] board;
    private final int MAX_POSITIONS = 9;

    Board() {
        board = new Cell[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
        return board[0][0].getSymbol() == symbol && board[1][0].getSymbol() == symbol && board[2][0].getSymbol() == symbol;
    }

    private boolean midColumnWin(char symbol) {
        return board[0][1].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][1].getSymbol() == symbol;
    }

    private boolean rightColumnWin(char symbol) {
        return board[0][2].getSymbol() == symbol && board[1][2].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }

    private boolean topRowWin(char symbol) {
        return board[0][0].getSymbol() == symbol && board[0][1].getSymbol() == symbol && board[0][2].getSymbol() == symbol;
    }

    private boolean midRowWin(char symbol) {
        return board[1][0].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[1][2].getSymbol() == symbol;
    }

    private boolean bottomRowWin(char symbol) {
        return board[2][0].getSymbol() == symbol && board[2][1].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }

    private boolean mainDiagonalWin(char symbol) {
        return board[0][0].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }

    private boolean secondaryDiagonalWin(char symbol) {
        return board[0][2].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][0].getSymbol() == symbol;
    }

    public boolean verifyWin(char symbol) {
        return leftColumnWin(symbol) || midColumnWin(symbol) || rightColumnWin(symbol) || topRowWin(symbol) || midRowWin(symbol)
                || bottomRowWin(symbol) || mainDiagonalWin(symbol) || secondaryDiagonalWin(symbol);
    }

    private int countBusyCells() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getSymbol() != ' ') count++;
            }
        }
        return count;
    }

    public boolean checkForTie() {
        if (countBusyCells() == MAX_POSITIONS) {
            return true;
        }
        return false;
    }
}