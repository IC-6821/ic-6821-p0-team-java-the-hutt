package com.modules.logic;

class Board {
    private Cell[][] board;

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





    //bound to be deleted, there is no use for it in the code
    public void showBoard() {
        for (int rows = 0; rows < 3; rows++) {
            for (int columns = 0; columns < 3; columns++) {
                System.out.print(" " + board[rows][columns].getSymbol() + " ");
                if (columns < 2) System.out.print("|");
            }
            System.out.println();
            if (rows < 2) {
                System.out.println("-----------");
            }
        }
    }
}