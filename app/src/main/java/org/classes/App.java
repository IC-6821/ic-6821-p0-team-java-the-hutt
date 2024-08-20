package org.classes;

import interfaces.GameContainer;
import interfaces.UserIO;
import interfaces.Playable;

public final class App {

    // Private constructor to prevent instantiation
    private App() {
        throw new UnsupportedOperationException("App class cannot be instantiated");
    }

    public static void main(String[] args) {
        final GameContainer ticTacToeGameBoard = new GameBoard();
        final UserIO userInterpreter = new UserConsoleInterpreter();
        userInterpreter.processArguments(args); // Creates a defined GameLevel container
        final Playable ticTacToe = new TicTacToeGame(ticTacToeGameBoard, userInterpreter);
        ticTacToe.start();
    }
}
