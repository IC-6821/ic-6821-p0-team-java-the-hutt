package com.modules.logic;
import java.util.Random;

public class EasyAI {
    private Random random;

    public EasyAI() {
        random = new Random();
    }

    public int[] getRandomMove(Board board) {
        int[] move = new int[2];
        int row = random.nextInt(3);
        int column = random.nextInt(3);

        while (!board.canPlace(row, column)){
            row = random.nextInt(3);
            column = random.nextInt(3);
        }

        move[0] = row;
        move[1] = column;

        return move;
    }
}