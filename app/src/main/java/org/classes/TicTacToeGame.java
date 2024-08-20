package org.classes;
import interfaces.GameContainer;
import interfaces.GameDifficulty;
import interfaces.UserIO;

import java.util.Map;

public class TicTacToeGame { //TODO: define game interface
    private final GameContainer board;
    private final GameDifficulty gameDifficulty;
    private final UserIO userIO;
    private final Token player1Token;
    private final Token player2Token;


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
    
    public TicTacToeGame(GameContainer TicTacToeBoard, UserIO userInterface) {
        this.board = TicTacToeBoard;
        this.userIO = userInterface;
        this.player1Token = Token.X;
        this.player2Token = Token.O;


        if (userIO.getChosenLevel() == GameLevel.EASY) {
            this.gameDifficulty = new EasyAI(board);
        }
        else this.gameDifficulty = null;
    }

    public void start() {

        boolean gameRunning = true;

        while (gameRunning) {
            //  playerMove(); TODO fix
            if (verifyWin(player1Token)) {         // if the player has won
                System.out.println("Player wins!");
                gameRunning = false;
            } else if (isTied()) {                      // if the game is tied
                System.out.println("TicTacToeGame is tied!");
                gameRunning = false;
            } else {
                //easyAI.makeMove(); TODO
                //showBoard();                            // shows the updated board
                if (verifyWin(player2Token)) {     // if the AI has won
                    System.out.println("AI wins!");
                    gameRunning = false;
                }
            }
        }
    }

    //TODO: change method signature in the interface
    public boolean placeIfValidMove(String yPosition, String xPosition, Token currentPlayerToken) {
        int yKey = rowWordMap.get(yPosition);
        int xKey = columnWordMap.get(xPosition);
        if (board.canPlace(yKey, xKey)) {
            board.setGameSlot(yKey, xKey, currentPlayerToken);
            return true;
        }
        return false;
    }

    public boolean checkChosenPosition(String yPosition, String xPosition) {
        return rowWordMap.containsKey(yPosition) && columnWordMap.containsKey(xPosition);
    }

    public boolean verifyWin(Token currentPlayerToken) {
        boolean winConfirmed = board.verifyWin(currentPlayerToken);
        String winMessage = "Perdiste...";
        if (winConfirmed && currentPlayerToken.getSymbol() == 'X') {
            winMessage = "Ganaste!";
            System.out.println(winMessage);
        }
        if (winConfirmed && currentPlayerToken.getSymbol() == 'O') {
            System.out.println(winMessage);
        }
        return winConfirmed;
    }

    public void aiMove() {
        int[] move = gameDifficulty.generateComputerMove();
        board.setGameSlot(move[0], move[1], player2Token);
    }

    public boolean isTied() {
        //TODO: place this block in the main driver. This shouldn't be part of this class
        if (board.isTied()) {
            userIO.showToPlayer("empate"); //todo remove literals
            return true;
        }
        return false;
    }
}
