package org.classes;

import interfaces.GameContainer;
import interfaces.GameSet;
import interfaces.UserIO;

import java.util.Map;
import java.util.Scanner;

public class UserConsoleInterpreter implements UserIO {
    private final GameContainer board;
    private static final String verticalSeparator = "-----------";
    private static final char horizontalSeparator = '|';
    private static final String WHITESPACE = " ";
    private final GameSet game; //TODO: remove this reference if not used
    private final Scanner userInputSource; // using the interface implemented by Scanner instead of the class

    private static final Map<String, BoardPosition> inputMap = Map.of(
            "top-left", BoardPosition.TOP_LEFT,
            "top-center", BoardPosition.TOP_CENTER,
            "top-right", BoardPosition.TOP_RIGHT,
            "middle-left", BoardPosition.MIDDLE_LEFT,
            "middle-center", BoardPosition.MIDDLE_CENTER,
            "middle-right", BoardPosition.MIDDLE_RIGHT,
            "bottom-left", BoardPosition.BOTTOM_LEFT,
            "bottom-center", BoardPosition.BOTTOM_CENTER,
            "bottom-right", BoardPosition.BOTTOM_RIGHT
    );

    public UserConsoleInterpreter(GameContainer board, GameSet game) {
        this.board = board;
        this.game = game;
        this.userInputSource = new Scanner(System.in);
    }

    private void printGameboardRow(int currentRow, int currentColumn) { //TODO: remove
        System.out.print(WHITESPACE + this.board.getGameSymbolAtSlot(currentRow, currentColumn) + WHITESPACE);
        if (currentColumn < 2) System.out.print(horizontalSeparator);
    }


    public void showToPlayer(String message) {
    System.out.println(message);
    }


    @Override
    public GameLevel processArguments(String[] args) {
        String invalidArguments = "Argumentos incompatibles. Se esperan 2 para ejecutar el juego. \n Sugerencia: usar -n f";
        String nArgument = "-n";
        String fArgument = "f";
        String mArgument = "m";
        String dArgument = "d";
        String unknown_parameter = "Parámetro desconocido, ejecuta el juego nuevamente.";
        String difficulty_not_available = "Esta dificultad aún no está disponible. Utilice -n f para jugar.";
        if (args.length != 2) {
            showToPlayer(invalidArguments);
            return GameLevel.UNAVAILABLE;
        }

        if (!args[0].equals(nArgument)) {
            showToPlayer(unknown_parameter);
            return GameLevel.UNAVAILABLE;
        }

        String difficulty = args[1];

        if (difficulty.equals(fArgument)) {

            return GameLevel.EASY;
        }

        if (difficulty.equals(mArgument)) {
            showToPlayer(difficulty_not_available);
            return GameLevel.MEDIUM;
        }

        if(difficulty.equals(dArgument)) {
            showToPlayer(difficulty_not_available);
            return GameLevel.HARD;
        }
    return GameLevel.UNAVAILABLE;
    }


    public BoardPosition interpretPlayerMove() {
        String move = userInputSource.nextLine();
        return switch (move) {
            case "arriba izquierda" -> BoardPosition.TOP_LEFT;
            case "arriba centro" -> BoardPosition.TOP_CENTER;
            case "arriba derecha" -> BoardPosition.TOP_RIGHT;
            case "medio izquierda" -> BoardPosition.MIDDLE_LEFT;
            case "medio centro" -> BoardPosition.MIDDLE_CENTER;
            case "medio derecha" -> BoardPosition.MIDDLE_RIGHT;
            case "abajo izquierda" -> BoardPosition.BOTTOM_LEFT;
            case "abajo centro" -> BoardPosition.BOTTOM_CENTER;
            case "abajo derecha" -> BoardPosition.BOTTOM_RIGHT;
            default -> null;
        };




    }


}
