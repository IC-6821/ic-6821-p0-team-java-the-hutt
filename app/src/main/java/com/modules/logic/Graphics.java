package com.modules.logic;

public class Graphics {
    


    public void showBoard() {
        String separador = "-----------";

        for (int rows = 0; rows < 3; rows++) {

            for (int columns = 0; columns < 3; columns++) {

                System.out.print(" " + board.getBoardSymbol(rows, columns) + " ");

                if (columns < 2) System.out.print("|");}

            System.out.println();

            if (rows < 2) {System.out.println(separador);}
        }
    }
}
