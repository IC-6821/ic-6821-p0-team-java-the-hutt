package com.modules.logic;
import java.util.HashMap;
import java.util.Scanner;

public class Game{
    private Board board;
    private HashMap<String, Integer> rowWordMap; //This will help translate words like 'arriba' to a number corresponding to the position on the board.
    private HashMap<String, Integer> columnWordMap; //This will help translate the words that affect columns like "izquierda", "centro" and "derecha".
    private EasyAI easyAI;

    private Graphics graphics;
    public Game(){
        board = new Board();
        rowWordMap = new HashMap<>();
<<<<<<< Updated upstream
        graphics = new Graphics(); //TODO: hotfix changes, implement a real solution asap
=======
        columnWordMap = new HashMap<>();
>>>>>>> Stashed changes

        rowWordMap.put("arriba", 0);
        rowWordMap.put("medio", 1);
        rowWordMap.put("abajo", 2);

        columnWordMap.put("izquierda", 0);
        columnWordMap.put("centro", 1);
        columnWordMap.put("derecha", 2);

        easyAI = new EasyAI(); //Instance of the EasyAI class.
    }

    public boolean readMove(String yPosition, String xPosition, char symbol) {
        if(!rowWordMap.containsKey(yPosition) || !columnWordMap.containsKey(xPosition)) { //checks if the words added were valid.
            return false;
        }

        if(board.canPlace(rowWordMap.get(yPosition), columnWordMap.get(xPosition))) {//checks if the symbol can be placed on the selected position.
            board.setCell(rowWordMap.get(yPosition), columnWordMap.get(xPosition), symbol);
            return true;
        }
        return false;
    }

    public boolean verifiyWin(char symbol) { //verifies if the player or the computer won.
        return board.verifyWin(symbol);
    }

<<<<<<< Updated upstream
    public void displayBoard() {graphics.showBoard();} //changed a wrongful static reference to the Graphic class into a reference to an instance

=======
    public void displayBoard() {
        board.showBoard();
    }
>>>>>>> Stashed changes

    public void playerMove() {
        Scanner input_user = new Scanner(System.in);

        //Asks the user for the row and column where they want to place their symbol.
        System.out.print("Ingrese la fila (arriba, medio, abajo): ");
        System.out.println();
<<<<<<< Updated upstream
        String yPosition = input_usuario.nextLine(); //this is throwing an exception when running with 'gradle run'.
=======
        String yPosition = input_user.nextLine();
>>>>>>> Stashed changes
        System.out.print("Ingrese la columna (izquierda, centro, derecha): ");
        System.out.println();
        String xPosition = input_user.nextLine();

        //If the move is valid, the symbol will be placed on the board.
        if (board.canPlace(rowWordMap.get(yPosition), columnWordMap.get(xPosition))) {
            board.setCell(rowWordMap.get(yPosition), columnWordMap.get(xPosition), 'X');
        }
        else {
            System.out.println("Celda ocupada");
        }
    }

    public void aiMove() {
        int[] move = easyAI.getRandomMove(board);
        board.setCell(move[0], move[1], 'O');
    }
}
