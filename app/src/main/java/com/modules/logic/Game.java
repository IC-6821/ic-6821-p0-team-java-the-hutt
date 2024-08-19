package com.modules.logic;
import com.modules.logic.Graphics;
import java.util.HashMap;

public class Game implements DisplayBoard {
    private Board board;
    private HashMap<String, Integer> rowWordMap;
    private HashMap<String, Integer> columnWordMap;
    private EasyAI easyAI;
    private DisplayBoard displayBoard;
    
    public Game() {
        board = new Board();
        rowWordMap = new HashMap<>();
        columnWordMap = new HashMap<>();

        rowWordMap.put("arriba", 0);
        rowWordMap.put("medio", 1);
        rowWordMap.put("abajo", 2);

        columnWordMap.put("izquierda", 0);
        columnWordMap.put("centro", 1);
        columnWordMap.put("derecha", 2);

        easyAI = new EasyAI();
        displayBoard = new Graphics(board, this); // Initialize Graphics
    }

    public void start(String[] args) {
        displayBoard.validateArguments(args);
        showBoard();

        boolean gameRunning = true;

        while (gameRunning) {
            playerMove();
            if (verifyWin('X')) {         // if the player has won
                System.out.println("Player wins!");
                gameRunning = false;
            } else if (isTied()) {                      // if the game is tied
                System.out.println("Game is tied!");
                gameRunning = false;
            } else {
                easyAI.makeMove(); //TODO
                showBoard();                            // shows the updated board
                if (verifyWin('O')) {     // if the AI has won
                    System.out.println("AI wins!");
                    gameRunning = false;
                }
            }
        }
    }

    @Override
    public void showBoard() {
        displayBoard.showBoard(); // Delegate to Graphics
    }

    @Override
    public void playerMove() {
        displayBoard.playerMove(); // Delegate to Graphics
    }

    @Override
    public void validateArguments(String[] args) {
        // No need to implement this here
    }

    public boolean placeIfValidMove(String yPosition, String xPosition, char symbol) {
        int yKey = rowWordMap.get(yPosition);
        int xKey = columnWordMap.get(xPosition);
        if (board.canPlace(yKey, xKey)) {
            board.setCell(yKey, xKey, symbol);
            return true;
        }
        return false;
    }

    public boolean checkChosenPosition(String yPosition, String xPosition) {
        return rowWordMap.containsKey(yPosition) && columnWordMap.containsKey(xPosition);
    }

    public boolean verifyWin(char playingSymbol) {
        boolean winConfirmed = board.verifyWin(playingSymbol);
        String winMessage = "Perdiste...";
        if (winConfirmed && playingSymbol == 'X') {
            winMessage = "Ganaste!";
            showBoard();
            System.out.println(winMessage);
        }
        if (winConfirmed && playingSymbol == 'O') {
            System.out.println(winMessage);
        }
        return winConfirmed;
    }

    public void aiMove() {
        int[] move = easyAI.getRandomMove(board);
        board.setCell(move[0], move[1], 'O');
    }

    public boolean isTied() {
        if (board.checkForTie()) {
            showBoard();
            System.out.println("Empate");
            return true;
        }
        return false;
    }
}
