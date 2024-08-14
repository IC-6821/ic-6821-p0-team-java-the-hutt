package com.modules.logic;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Board board;
    private HashMap<String, Integer> rowWordMap; //This will help translate the words used for the rows for example 'arriba'
    private HashMap<String, Integer> columnWordMap; //This will translate the words used for the columns 'centro' is an example
    private EasyAI easyAI;
    private Graphics graphics;

    public Game() {
        board = new Board();
        rowWordMap = new HashMap<>();
        columnWordMap = new HashMap<>();
        graphics = new Graphics(board);

        rowWordMap.put("arriba", 0);
        rowWordMap.put("medio", 1);
        rowWordMap.put("abajo", 2);

        columnWordMap.put("izquierda", 0);
        columnWordMap.put("centro", 1);
        columnWordMap.put("derecha", 2);

        easyAI = new EasyAI(); //Instance of the EasyAI class.
    }


    public boolean placeIfValidMove(String yPosition, String xPosition, char symbol) {
        int yKey = rowWordMap.get(yPosition);
        int xKey = columnWordMap.get(xPosition);
        //Creo que este if es redundante
        if (board.canPlace(yKey, xKey)) { //Checks if the symbol can be placed on the desired position
            board.setCell(yKey, xKey, symbol);
            return true;
        }
        return false;
    }


    public boolean checkChosenPosition(String yPosition, String xPosition){
        //Checks if the words for the chosenposition is valid.
        return rowWordMap.containsKey(yPosition) && columnWordMap.containsKey(xPosition);
    }


    public boolean verifyWin(char symbol) { //Checks if the player or the AI has won.
        return board.verifyWin(symbol);
    }

    public void displayBoard() {
        graphics.showBoard();
    }


    public void playerMove() {
        Scanner userInput = new Scanner(System.in);

        boolean moveFinished = false;

        while (!moveFinished) {
            //Asks the user for the positions where they want to place the 'X'.
            System.out.print("Ingrese la fila (arriba, medio, abajo): ");
            String yPosition = userInput.nextLine(); //TODO: change this behavior so that it asks for the whole move in one line.
            System.out.print("Ingrese la columna (izquierda, centro, derecha): ");
            String xPosition = userInput.nextLine();

            // check for proper word input
            if (checkChosenPosition(yPosition, xPosition)) {
                // check for placement
                if (placeIfValidMove(yPosition, xPosition, 'X')) {
                    // we added loops in this method to prevent cases where the input words were wrong or the position already
                    // held a character but the execution still attempted to go on normally even if a rule was being broken.
                    moveFinished = true;
                }
                else {
                    System.out.println("Celda ocupada. Intente de nuevo.");
                }
            }
            else {
                System.out.println("Coordenadas incorrectas. Revise las opciones y redáctelas correctamente.");
            }
        }
    }


    public void aiMove() {
        int[] move = easyAI.getRandomMove(board);
        board.setCell(move[0], move[1], 'O');
    }
}