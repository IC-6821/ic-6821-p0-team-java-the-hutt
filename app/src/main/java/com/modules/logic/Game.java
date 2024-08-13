package com.modules.logic;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Board board;
    private HashMap<String, Integer> rowWordMap; //This will help translate words like 'arriba' to a number corresponding to the position on the board.
    private HashMap<String, Integer> columnWordMap; //This will help translate the words that affect columns like "izquierda", "centro" and "derecha".
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

    public boolean readMove(String yPosition, String xPosition, char symbol) {
        if (!rowWordMap.containsKey(yPosition) || !columnWordMap.containsKey(xPosition)) { //Checks if the words added are valid.
            return false;
        }

        if (board.canPlace(rowWordMap.get(yPosition), columnWordMap.get(xPosition))) { //Checks if the symbol can be placed on the selected position.
            board.setCell(rowWordMap.get(yPosition), columnWordMap.get(xPosition), symbol);
            return true;
        }
        return false;
    }

    public boolean verifyWin(char symbol) { //Checks if the player or the AI has won.
        return board.verifyWin(symbol);
    }

    public void displayBoard() {
        graphics.showBoard();
    }

    public void playerMove() {
        Scanner userInput = new Scanner(System.in);
        //Asks the user for the row and column where they want to place their symbol.
        System.out.print("Ingrese la fila (arriba, medio, abajo): ");
        String yPosition = userInput.nextLine(); //TODO: change this behavior so that it asks for the whole move in one line.
        System.out.print("Ingrese la columna (izquierda, centro, derecha): ");
        String xPosition = userInput.nextLine();

        if (board.canPlace(rowWordMap.get(yPosition), columnWordMap.get(xPosition))) {
            board.setCell(rowWordMap.get(yPosition), columnWordMap.get(xPosition), 'X');
        } else {
            System.out.println("Celda ocupada");
        }
    }

    public void aiMove() {
        int[] move = easyAI.getRandomMove(board);
        board.setCell(move[0], move[1], 'O');
    }
}