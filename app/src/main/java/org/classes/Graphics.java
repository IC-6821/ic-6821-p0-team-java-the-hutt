package org.classes;

public final class Graphics {
    private final Board board;
    private static final String VERTICAL_SEPARATOR = "-----------";
    private static final char HORIZONTAL_SEPARATOR = '|';
    private static final String WHITE_SPACE = " "; 
    // added for clarity instead of using literals within the method showBoard.
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public Graphics(final Board board) {
        this.board = board;
    }


    private void printGameboardRow(int currentRow, int currentColumn) {
        System.out.print(WHITE_SPACE + this.board.getBoardSymbol(currentRow, currentColumn) 
            + WHITE_SPACE);
        if (currentColumn < 2) {
            System.out.print(HORIZONTAL_SEPARATOR);
        }
    }



    public void showBoard() {

        for (int rows = 0; rows < ROWS; rows++) {
            for (int columns = 0; columns < COLUMNS; columns++) {
                printGameboardRow(rows, columns); // extracted this logic to a method
            }

            System.out.println();
            if (rows < 2) {
                System.out.println(VERTICAL_SEPARATOR);
            }
        }
    }
}
