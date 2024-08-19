package org.classes;
import interfaces.GameContainer;
import interfaces.GameDifficulty;
import interfaces.UserIO;

import java.util.Map;

public class Game  { //TODO: define game interface
    private final GameContainer board;
    private final GameDifficulty gameDifficulty;
    private final UserIO userIO;

    private final Map<String, Integer> rowWordMap = Map.of(
            "arriba", 0,
            "medio", 1,
            "abajo", 2
    );

    private final Map<String, Integer> columnWordMap = Map.of(
            "izquierda", 0,
            "centro", 1,
            "derecha", 2
    );
    
    public Game() {
        board = new GameBoard();

        gameDifficulty = new EasyAI(this.board);
        userIO = new UserConsoleInterpreter(board, this); // Initialize UserConsoleInterpreter
    }

    public void start(String[] args) {
        userIO.validateArguments(args);
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
                //easyAI.makeMove(); TODO
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
        userIO.showBoard(); // Delegate to UserConsoleInterpreter
    }

    @Override
    public void playerMove() {
        userIO.playerMove(); // Delegate to UserConsoleInterpreter
    }

    @Override
    public void validateArguments(String[] args) {
        // No need to implement this here
    }

    public boolean placeIfValidMove(String yPosition, String xPosition, char symbol) {
        int yKey = rowWordMap.get(yPosition);
        int xKey = columnWordMap.get(xPosition);
        if (board.canPlace(yKey, xKey)) {
            board.setGameSlot(yKey, xKey, symbol);
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
        int[] move = gameDifficulty.getRandomMove(board);
        board.setGameSlot(move[0], move[1], 'O');
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
