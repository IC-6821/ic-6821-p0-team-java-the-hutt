package com.modules.logic;



class Board{

    private Cell[][] board;



    /**
      * Creates empty board to start new game.
      * Cell constructor is in charge of adding empty spaces on each cell.
      */
    Board(){
        board = new Cell[3][3];
        
        /**
         * Creating the array only allocates memory but doesn't initialize objects, so it has to iterate through every cell of initialize it.
         */
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = new Cell();
            }
        }


    }

    public void setCell(int yCoordinate, int xCoordinate, char symbol){ //changes value of cell in the selected coordinate;
        board[yCoordinate][xCoordinate].setSymbol(symbol);
    }

    public boolean canPlace(int yCoordinate, int xCoordinate){ //verifies if the symbol placement is valid.
        return board[yCoordinate][xCoordinate].getSymbol() == ' ';
    }




    /**
     * This function will determine if the player or the computer has won the game
     */
    

    /**
     * These function will determine if the player won by filling a column.
     * It will do so by checking if each element of one of the columns is the same as symbol, which will receive 'X' or 'O'.
     */

    private boolean leftColumnWin(char symbol){
        return board[0][0].getSymbol() == symbol && board[1][0].getSymbol() == symbol && board[2][0].getSymbol() == symbol;
    }

    private boolean midColumnWin(char symbol){
        return board[0][0].getSymbol() == symbol && board[1][0].getSymbol() == symbol && board[2][0].getSymbol() == symbol;
    }

    private boolean rightColumnWin(char symbol){
        return board[0][2].getSymbol() == symbol && board[1][2].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }




    /**
     * These function will determine if the player won by filling a row with the same symbol.
     */
    private boolean topRowWin(char symbol){
        return board[0][0].getSymbol() == symbol && board[0][1].getSymbol() == symbol && board[0][2].getSymbol() == symbol;
    }
    
    private boolean midRowWin(char symbol){
        return board[1][0].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[1][2].getSymbol() == symbol;
    }

    private boolean bottomRowWin(char symbol){
        return board[2][0].getSymbol() == symbol && board[2][1].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }



    /**
     * These functions will determine if the player won by placing the same symbol diagonally
     */
    
    private boolean mainDiagonalWin(char symbol){
        return board[0][0].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][2].getSymbol() == symbol;
    }

    private boolean secondaryDiagonalWin(char symbol){
        return board[0][2].getSymbol() == symbol && board[1][1].getSymbol() == symbol && board[2][0].getSymbol() == symbol;
    }




    
    /**
     * this function will verify if the player or bot won in any possible way
     */

    public boolean verifyWin(char symbol){
        return leftColumnWin(symbol) || 
                midColumnWin(symbol) ||
                rightColumnWin(symbol) || 
                topRowWin(symbol) ||
                midRowWin(symbol) ||
                bottomRowWin(symbol) ||
                mainDiagonalWin(symbol) ||
                secondaryDiagonalWin(symbol);

    }

    public void showBoard() {
        String separador = "-----------";

        for (int rows = 0; rows < 3; rows++) {

            for (int columns = 0; columns < 3; columns++) {

                System.out.print(" " + board[rows][columns].getSymbol() + " ");

                if (columns < 2) System.out.print("|");}

            System.out.println();

            if (rows < 2) {System.out.println(separador);}
        }
    }






}


