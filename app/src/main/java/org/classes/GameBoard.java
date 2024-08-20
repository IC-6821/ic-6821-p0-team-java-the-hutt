package org.classes;

import interfaces.GameContainer;

public final class GameBoard implements GameContainer {
    private static final char ENDLINE = '\n';
    private final char[][] board;
    private static final int MAX_POSITION = 9;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final String VERTICAL_SEPARATOR = "-----------";
    private static final char HORIZONTAL_SEPARATOR = '|';
    private static final String WHITESPACE = " ";

    GameBoard() {
        board = new char[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }


    @Override
    public void setGameSlot(int row, int column, Token currentPlayerToken) {
        board[row][column] = currentPlayerToken.getSymbol();
    }

    public boolean canPlace(int row, int column) {
        return board[row][column] == ' ';
    }

    private char getSymbolAt(int row, int column) {
        return board[row][column];
    }


    private boolean leftColumnWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[1][0] == playerSymbol && board[2][0] == playerSymbol;
    }

    private boolean midColumnWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[0][1] == playerSymbol  && board[1][1] == playerSymbol && board[2][1] == playerSymbol;
    }

    private boolean rightColumnWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();
        return board[0][2] == playerSymbol  && board[1][2] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean topRowWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[0][1] == playerSymbol && board[0][2] == playerSymbol;
    }

    private boolean midRowWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[1][0] == playerSymbol  && board[1][1] == playerSymbol && board[1][2] == playerSymbol;
    }

    private boolean bottomRowWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[2][0] == playerSymbol  && board[2][1] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean mainDiagonalWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

        return board[0][0] == playerSymbol  && board[1][1] == playerSymbol && board[2][2] == playerSymbol;
    }

    private boolean secondaryDiagonalWin(Token playerToken) {
        final char playerSymbol = playerToken.getSymbol();

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

    public boolean isTied() {
        return countBusyCells() == MAX_POSITION;
    }


    public String generateDisplayableBoard() {
        final StringBuilder displayableBoard = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                displayableBoard.append(WHITESPACE).append(this.getSymbolAt(i, j)).append(WHITESPACE);
                if (j < COLUMNS - 1) {
                    displayableBoard.append(VERTICAL_SEPARATOR);
                }
            }
            displayableBoard.append(ENDLINE);
            if (i < ROWS - 1) {
                displayableBoard.append(HORIZONTAL_SEPARATOR);
            }
        }
        return displayableBoard.toString();
    }
}
