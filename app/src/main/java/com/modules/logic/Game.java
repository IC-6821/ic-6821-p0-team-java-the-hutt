package com.modules.logic;
import java.util.HashMap;
import java.util.Scanner;



public class Game{
    private Board board;
    private HashMap<String, Integer> rowWordMap; //This will help translate words like 'arriba' to a number corresponding to the position on the board.
    private HashMap<String, Integer> columnWordMap; //This will help translate the words that affect columns like "izquierda", "centro" and "derecha".

    public Game(){
        board = new Board();
        rowWordMap = new HashMap<>();

        rowWordMap.put("arriba", 0);
        rowWordMap.put("medio", 1);
        rowWordMap.put("abajo", 2);

        columnWordMap = new HashMap<>();

        columnWordMap.put("izquierda", 0);
        columnWordMap.put("centro", 1);
        columnWordMap.put("derecha", 2);

        
    }


    public boolean readMove(String yPosition, String xPosition, char symbol){
        if(!rowWordMap.containsKey(yPosition) || !columnWordMap.containsKey(xPosition)){ //checks if the words added were valid.
            return false;
        }

        if(board.canPlace(rowWordMap.get(yPosition), columnWordMap.get(xPosition))){//checks if the symbol can be placed on the selected position.
            board.setCell(rowWordMap.get(yPosition), columnWordMap.get(xPosition), symbol);
            return true;
        }
        return false;
    }

    public boolean verifiyWin(char symbol){ //verifies if the player or the computer won.
        return board.verifyWin(symbol);
    }

    public void displayBoard() {board.showBoard();}








}
