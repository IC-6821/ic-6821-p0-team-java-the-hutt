package org.classes;

import interfaces.UserIO;

import java.util.Scanner;

 public final class UserConsoleInterpreter implements UserIO {
    private final Scanner userInputSource; // using the interface implemented by Scanner instead of the class
    private GameLevel chosenLevel;

    public UserConsoleInterpreter() {
        this.userInputSource = new Scanner(System.in);
    }


    public void showToPlayer(String message) {
    System.out.println(message);
    }


    @Override
    public void processArguments(String[] args) {
        final String invalidArguments = "Argumentos incompatibles. \n Sugerencia: usar -n f";
        final String nArgument = "-n";
        final String fArgument = "f";
        final String mArgument = "m";
        final String dArgument = "d";
        final String unknownParameter = "Parámetro desconocido, ejecuta el juego nuevamente.";
        final String difficultyNotAvailable = "Esta dificultad aún no está disponible. Utilice -n f para jugar.";

        if (args.length != 2) {
            showToPlayer(invalidArguments);
            this.chosenLevel = GameLevel.UNAVAILABLE;
        }

        if (!args[0].equals(nArgument)) {
            showToPlayer(unknownParameter);
            this.chosenLevel = GameLevel.UNAVAILABLE;
        }

        final String difficulty = args[1];

        if (difficulty.equals(fArgument)) {
            this.chosenLevel = GameLevel.EASY;
        }

        if (difficulty.equals(mArgument)) {
            showToPlayer(difficultyNotAvailable);
            this.chosenLevel = GameLevel.MEDIUM;
        }

        if (difficulty.equals(dArgument)) {
            showToPlayer(difficultyNotAvailable);
            this.chosenLevel =  GameLevel.HARD;
        }

    }


    public BoardPosition interpretPlayerMove() {
        final String move = userInputSource.nextLine();
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


    public GameLevel getChosenLevel() {
        return chosenLevel;
    }
}
