package org.classes;

import interfaces.GameContainer;

public final class GameBoard implements GameContainer {
    private final char[][] board;
    private static final int MAX_POSITION = 9;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    GameBoard() {
        board = new char[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }


    @Override
    public void setGameSlot(int yCoordinate, int xCoordinate, Token currentPlayerToken) {
        board[yCoordinate][xCoordinate] = currentPlayerToken.getSymbol();
    }

    public boolean canPlace(int yCoordinate, int xCoordinate) {
        return board[yCoordinate][xCoordinate] == ' ';
    }


    public char getGameSymbolAtSlot(int yCoordinate, int xCoordinate) {
        return board[yCoordinate][xCoordinate];
    }


    private boolean leftColumnWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[1][0] == playerSymbol && board[2][0] == playerSymbol;
    }

    private boolean midColumnWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[0][1] == playerSymbol  && board[1][1] == playerSymbol && board[2][1] == playerSymbol;
    }

    private boolean rightColumnWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();
        return board[0][2] == playerSymbol  && board[1][2] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean topRowWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[0][1] == playerSymbol && board[0][2] == playerSymbol;
    }

    private boolean midRowWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[1][0] == playerSymbol  && board[1][1] == playerSymbol && board[1][2] == playerSymbol;
    }

    private boolean bottomRowWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[2][0] == playerSymbol  && board[2][1] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean mainDiagonalWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[1][1] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean secondaryDiagonalWin(Token playerToken) {
        char playerSymbol = playerToken.getSymbol();

        return board[2][0] == playerSymbol  && board[1][1] == playerSymbol && board[0][2] == playerSymbol;
    }

    public boolean verifyWin(Token playerToken) {
        return leftColumnWin(playerToken)
                || midColumnWin(playerToken)
                || rightColumnWin(playerToken)
                || topRowWin(playerToken)
                || midRowWin(playerToken)
                || bottomRowWin(playerToken)
                || mainDiagonalWin(playerToken)
                || secondaryDiagonalWin(playerToken);
    }

    private int countBusyCells() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkForTie() {
        return countBusyCells() == MAX_POSITION;
    }
}
