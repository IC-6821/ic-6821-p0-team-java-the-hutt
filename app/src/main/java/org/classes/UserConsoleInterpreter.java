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
    private final GameSet game;

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
    }

    private void printGameboardRow(int currentRow, int currentColumn) {
        System.out.print(WHITESPACE + this.board.getGameSymbolAtSlot(currentRow, currentColumn) + WHITESPACE);
        if (currentColumn < 2) System.out.print(horizontalSeparator);
    }

    @Override
    public void showBoard() {
        for (int rows = 0; rows < 3; rows++) {
            for (int columns = 0; columns < 3; columns++) {
                printGameboardRow(rows, columns);
            }
            System.out.println();
            if (rows < 2) System.out.println(verticalSeparator);
        }
    }

    @Override
    public void validateArguments(String[] args) {
        String invalid_arguments = "Argumentos incompatibles. Se esperan 2 para ejecutar el juego. \n Sugerencia: usar -n f";
        String n_argument = "-n";
        String f_argument = "f";
        String unknown_parameter = "Parámetro desconocido, ejecuta el juego nuevamente.";
        String difficulty_not_available = "Esta dificultad aún no está disponible. Utilice -n f para jugar.";
        if (args.length != 2) {
            System.out.println(invalid_arguments);
            return;
        }

        if (!args[0].equals(n_argument)) {
            System.out.println(unknown_parameter);
            return;
        }

        String difficulty = args[1];
        if (!difficulty.equals(f_argument)) {
            System.out.println(difficulty_not_available);
            return;
        }
    }

    @Override
    public BoardPosition interpretPlayerMove() {
        return null;
    }

    @Override
    public void playerMove() {
        Scanner userInput = new Scanner(System.in);
        boolean moveFinished = false;

        while (!moveFinished) {
            System.out.print("Ingrese la fila (arriba, medio, abajo): ");
            String yPosition = userInput.nextLine();
            System.out.print("Ingrese la columna (izquierda, centro, derecha): ");
            String xPosition = userInput.nextLine();

            if (game.checkChosenPosition(yPosition, xPosition)) {
                if (game.placeIfValidMove(yPosition, xPosition, 'X')) {
                    moveFinished = true;
                } else {
                    System.out.println("Celda ocupada. Intente de nuevo.");
                    game.showBoard();
                }
            } else {
                System.out.println("Coordenadas incorrectas. Revise las opciones y redáctelas correctamente.");
                game.showBoard();
            }
        }
    }
}
