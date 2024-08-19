package org.classes;

import interfaces.GameDifficulty;
import interfaces.GameContainer;

import java.util.Random;

public final class EasyAI implements GameDifficulty {

    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final int COORDINATE_LIST_LENGTH = 2;

    private final Random positionGenerator;
    private final GameContainer board;

    public EasyAI(GameContainer board) {
        positionGenerator = new Random();
        this.board = board;
    }

    @Override
    public int[] generateComputerMove() {
        final int[] move = new int[COORDINATE_LIST_LENGTH];
        int row = positionGenerator.nextInt(ROWS);
        int column = positionGenerator.nextInt(COLUMNS);

        while (!board.canPlace(row, column)) {
            row = positionGenerator.nextInt(ROWS);
            column = positionGenerator.nextInt(COLUMNS);
        }

        move[0] = row;
        move[1] = column;

        return move;
    }
}
