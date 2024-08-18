package org.classes;

import java.util.Random;

public final class EasyAI {

    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final int COORDINATE_LIST_LENGTH = 2;


    private Random positionGenerator;

    public EasyAI() {
        positionGenerator = new Random();
    }

    public int[] getRandomMove(Board board) {
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
