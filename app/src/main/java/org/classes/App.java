package org.classes;

import interfaces.GameContainer;
import interfaces.UserIO;
import interfaces.Playable;

public final class App {

    public String getGreeting() {
        return "Bienvenido a ticTacToe!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        final GameContainer ticTacToeGameBoard = new GameBoard();
        final UserIO userInterpreter = new UserConsoleInterpreter();
        userInterpreter.processArguments(args); // Creates a defined GameLevel container
        final Playable ticTacToe = new TicTacToeGame(ticTacToeGameBoard, userInterpreter);
        ticTacToe.start();
    }
}
