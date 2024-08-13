package com.modules.logic;

public class Graphics {
    private Board board;
    private final String verticalSeparator = "-----------";
    private final char horizontalSeparator = '|';
    private final String WHITESPACE = " "; // added for clarity instead of using literals within the method showBoard.

    public Graphics(Board board) {
        this.board = board;
    }


    private void printGameboardRow(int currentRow, int currentColumn) {
        System.out.print(WHITESPACE + this.board.getBoardSymbol(currentRow, currentColumn) +
                WHITESPACE);
        if (currentColumn < 2) System.out.print(horizontalSeparator);
    }



    public void showBoard() {

        for (int rows = 0; rows < 3; rows++) {
            for (int columns = 0; columns < 3; columns++) {
                printGameboardRow(rows, columns); // extracted this logic to a method
            }

            System.out.println();
            if (rows < 2) System.out.println(verticalSeparator);
        }
    }
}