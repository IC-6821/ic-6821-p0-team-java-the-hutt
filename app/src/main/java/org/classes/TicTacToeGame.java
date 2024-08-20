package org.classes;

import interfaces.GameContainer;
import interfaces.GameDifficulty;
import interfaces.Playable;
import interfaces.UserIO;

import java.util.Map;

public final class TicTacToeGame implements Playable {
    private final GameContainer board;
    private final GameDifficulty gameDifficulty;
    private final UserIO userIO;
    private final Token player1Token;
    private final Token player2Token;


    public TicTacToeGame(final GameContainer ticTacToeBoard, final UserIO userInterface) {
        this.board = ticTacToeBoard;
        this.userIO = userInterface;
        this.player1Token = Token.X;
        this.player2Token = Token.O;


        if (userIO.getChosenLevel() == GameLevel.EASY) {
            this.gameDifficulty = new EasyAI(board);
        } else {
            this.gameDifficulty = null;
        }
    }

    public void start() {
        final String victoryMessage = "Has ganado!";
        final String lossMessage = "Has perdido!";
        final String tieMessage = "Has empatado!";
        final String retryMessage = "combinación incorrecta de coordenadas. Intente nuevamente.";
        BoardPosition currentSlot;

        boolean gameRunning = true;

        while (gameRunning) {
            currentSlot = userIO.interpretPlayerMove();
            if (currentSlot != null) {
                placeIfValidMove(currentSlot.getRow(), currentSlot.getColumn(), player1Token);
                userIO.interpretPlayerMove();
                if (board.verifyWin(player1Token)) {
                    userIO.showToPlayer(victoryMessage);
                    gameRunning = false;

                } else if (board.isTied()) {
                    userIO.showToPlayer(tieMessage);
                    gameRunning = false;

                } else {
                    aiMove();
                    if (board.verifyWin(player2Token)) {
                        userIO.showToPlayer(lossMessage);
                        gameRunning = false;
                    }
                }
            } else {
                userIO.showToPlayer(retryMessage);
            }
        }
    }

    public void placeIfValidMove(int row, int column, Token currentPlayerToken) {
        if (board.canPlace(row, column)) {
            board.setGameSlot(row, column, currentPlayerToken);
        }
    }

    public void aiMove() {
        final int[] move = gameDifficulty.generateComputerMove();
        board.setGameSlot(move[0], move[1], player2Token);
    }
}
