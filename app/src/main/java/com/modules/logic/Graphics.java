package com.modules.logic;

public class Graphics {
    private Board board;

    public Graphics(Board board) {
        this.board = board;
    }

    public void showBoard() {

        for (int rows = 0; rows < 3; rows++) {
            for (int columns = 0; columns < 3; columns++) {
                System.out.print(" " + board.getBoardSymbol(rows, columns) + " ");
                if (columns < 2) System.out.print("|");
            }
            System.out.println();
            if (rows < 2) {
                System.out.println("-----------");
            }
        }
    }
}